package com.game.xtetrix.gameMechanic.phsyicEngines;


import com.game.xtetrix.consts.GameConsts;
import com.game.xtetrix.gameMechanic.shapes.Rectangle;
import com.game.xtetrix.gameMechanic.shapes.Shape;
import com.game.xtetrix.inputEngine.TInputListener;

public class PhsyicEngine implements Runnable{
	protected Shape shape;
	protected Rectangle[] gameMap;
	
	protected int mapWidth;
	protected int mapHeight;
	
	protected int FPS = 30;
	protected int currentFPS = FPS;

	protected TInputListener inputListener;
	public PhsyicEngine() {
		gameMap = new Rectangle[GameConsts.StandartMapWidth*GameConsts.StandartMapHeight];		
		mapWidth = GameConsts.StandartMapWidth;
		mapHeight = GameConsts.StandartMapHeight;
		
		for(int i = 0;i<mapWidth*mapHeight;i++) {
			gameMap[i] = new Rectangle(Math.floorMod(i, mapWidth), i/mapWidth);
		}
	}
	
	public PhsyicEngine(int mapWidth,int mapHeight) {
		gameMap = new Rectangle[mapWidth*mapHeight];
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		
		for(int i = 0;i<mapWidth*mapHeight;i++) {
			gameMap[i] = new Rectangle(Math.floorMod(i, mapWidth), i/mapWidth);
		}
	}

	private boolean isBump(Shape shape) {				
		for(int i = 0;i < shape.getRectangleList().length;i++) {			
			for(int i2 = 0;i2 < gameMap.length;i2++) {
				if(shape.getRectangleList()[i].getX() == gameMap[i2].getX()
						&&shape.getRectangleList()[i].getY() == gameMap[i2].getY()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void moveDown() throws CloneNotSupportedException {
		Shape iShape = (Shape) this.shape.clone();
		iShape.moveD();
		if(!isBump(iShape)) {
			this.shape.moveD();
		}
	}
	@Override
	public void run() {	
		
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Rectangle[]getGameMap() {
		return gameMap;
	}

	public void setGameMap(Rectangle[] gameMap) {
		this.gameMap = gameMap;
	}
	
	
	public int getCurrentFPS() {
		return currentFPS;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}
	
	public void setInputListener(TInputListener inputListener) {
		this.inputListener = inputListener;
	}
	
}
