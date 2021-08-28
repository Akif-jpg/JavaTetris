package com.game.xtetrix.gameMechanic.phsyicEngines;


import com.game.xtetrix.consts.GameConsts;
import com.game.xtetrix.gameMechanic.shapes.Rectangle;
import com.game.xtetrix.gameMechanic.shapes.Shape;
import com.game.xtetrix.inputEngine.TInputListener;

public class PhsyicEngine implements Runnable{
	protected Shape shape = null;
	protected Rectangle[] gameMap;
	
	protected int mapWidth;
	protected int mapHeight;

	protected TInputListener inputListener;
	
	//Variables for FPS Control
	protected int FPS = 30;
	protected int currentFPS = FPS;
	
	private int counter = 0;	
	private long fpsTime = System.currentTimeMillis();
	private long startTime = 0;
	private long endTime = 0;
	private long cycleTime = 0;
	private long expectedTime = (long) Math.pow(10, 3)/FPS;	
	

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
	
	protected void headerFPSController() {
		startTime = System.currentTimeMillis();
		counter++;
		if(System.currentTimeMillis() - fpsTime>1000) {
			currentFPS = counter;
			counter = 0;
			fpsTime = System.currentTimeMillis();	
		}
	}
	
	protected void footerFPSController() {
		endTime = System.currentTimeMillis();
		cycleTime = endTime-startTime;
		expectedTime = (long) Math.pow(10, 3)/FPS;
		if(expectedTime - cycleTime > 0) {
			try {
				Thread.sleep(expectedTime-cycleTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected boolean isBumpanyShape(Shape shape) {	
		int rectXPosition;
		int rectYPosition;
		int columnNumber;
		for(Rectangle rect:shape.getRectangleList()) {
			rectXPosition = rect.getX()+shape.getDx();
			rectYPosition = rect.getY()+shape.getDy();			
			columnNumber = (rectYPosition)*mapWidth+rectXPosition;
			
			if(columnNumber < gameMap.length&&columnNumber>0) {
				if(gameMap[columnNumber].isThere) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected boolean isBumpBottom(Shape shape) {
		int rectYPosition;
		for(Rectangle rect:shape.getRectangleList()) {
			rectYPosition = rect.getY()+shape.getDy();	
			if(rectYPosition < 1) {
				return true;
			}			
			
		}
		return false;
	}
	
	public void moveDown() throws CloneNotSupportedException {
		Shape instanceShape = (Shape) this.shape.clone();
		instanceShape.moveD();
		if(!isBumpBottom(this.shape)&&!isBumpanyShape(instanceShape)) {
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
