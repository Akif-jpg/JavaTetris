package com.game.xtetrix.gameMechanic.renders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.xtetrix.gameMechanic.phsyicEngines.PhsyicEngine;
import com.game.xtetrix.gameMechanic.shapes.Rectangle;
import com.game.xtetrix.gameMechanic.shapes.Shape;
public class DebugRender implements IGameRender {
	private int resolutionX = 360;
	private int resolutionY = 720;
	
	private BufferedImage gameMap;
	private Graphics mapPencil;

	 private int x;
	 private int y;
	 private int width;
	 private int height;
	 
	public DebugRender() {
		
		gameMap = new BufferedImage(resolutionX, resolutionY,BufferedImage.TYPE_INT_RGB);		
		
		mapPencil = gameMap.createGraphics();
		mapPencil.setFont(new Font("TimesRoman", Font.PLAIN, 16));
		
		 x = 0;
		 y = 0;
		 width = 650;
		 height = 480;
	 }
	private void cleanMap() {
		mapPencil.setColor(Color.WHITE);
		mapPencil.fillRect(0, 0, resolutionX, resolutionY);
	}
	private void drawRows() {
		for(int i = 0;i<11;i++) {
			mapPencil.drawLine(i*resolutionX/10, 0, i*resolutionX/10, resolutionY);
		}
	}
	
	private void drawColumns() {
		for(int i = 0;i<21;i++) {
			mapPencil.drawLine(0, i*resolutionY/20, resolutionX,i*resolutionY/20);
		}
	}
	
	private void drawGame(PhsyicEngine phsyicEngine) {			
			drawGameMap(phsyicEngine);
			drawShape(phsyicEngine);
	}
	
	private void drawShape(PhsyicEngine phsyicEngine) {
			
		mapPencil.setColor(new Color( 0.1f, 0.1f, 0.9f, 0.75f));
		if(phsyicEngine.getShape() != null) {
			Rectangle[] rectangles = phsyicEngine.getShape().getRectangleList();
			Shape shape = phsyicEngine.getShape();
			for (Rectangle rectangle : rectangles) {				
				mapPencil.fillRect((rectangle.getX()+shape.getDx())*resolutionX/10, +resolutionY-resolutionY/20-((rectangle.getY()+shape.getDy())*resolutionY/20),
							resolutionX/10, resolutionY/20);					
						
			}
		}
	}
	
	private void drawGameMap(PhsyicEngine phsyicEngine) {
		mapPencil.setColor(Color.gray);
		if(phsyicEngine != null) {
			Rectangle[] rectangles = phsyicEngine.getGameMap();
			for (Rectangle rectangle : rectangles) {
				if(rectangle.isThere) {
					mapPencil.fillRect(rectangle.getX()*resolutionX/10, +resolutionY-resolutionY/20-(rectangle.getY()*resolutionY/20),
							resolutionX/10, resolutionY/20);					
				}				
			}			
		}
	}
	
	private void drawFPS(Graphics g,PhsyicEngine phsyicEngine) {
		mapPencil.setColor(new Color(0.2f, 0.6f, 0.2f, 0.9f));
		mapPencil.drawString("FPS: " + phsyicEngine.getCurrentFPS(),10,16);
	}
	@Override
	public void render(Graphics g, PhsyicEngine phsyicEngine) {
		// TODO Auto-generated method stub
		cleanMap();
		mapPencil.setColor(Color.BLACK);
		drawColumns();
		drawRows();
		drawGame(phsyicEngine);	
		
		drawFPS(g, phsyicEngine);		
		g.drawImage(gameMap, x, y, width, height, null);		
		
	}

	@Override
	public void setDrawBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void setDrawPosition(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}

	@Override
	public void setDrawSize(int width, int height) {
		// TODO Auto-generated method stub
		this.width = width;
		this.height = height;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return new Dimension(this.width,this.height);
	}
	
	

}
