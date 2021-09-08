package com.game.xtetrix.gameMechanic.phsyicEngines;

import com.game.xtetrix.gameMechanic.shapes.Rectangle;

public class MapEngine {

	public static Rectangle[] getColumn(Rectangle[] gameMap ,int mapWidth,int columnNumber) {
		Rectangle[] columnRects = new Rectangle[mapWidth];
		for(int i = 0;i < mapWidth;i++) {
			columnRects[i] = gameMap[i+columnNumber*mapWidth];			
		}
		return columnRects;
	}
	public static void destroyColumns(Rectangle[] gameMap ,int mapWidth, int mapHeight) {				
		for(int i = 0;i < mapHeight;i++) {
			Rectangle[] column = getColumn(gameMap, mapWidth, i);
			for(int i2 = 0; i2 < mapWidth;i2++) {
				if(!column[i2].isThere) {					
					break;
				}
				
				if(i2 == mapWidth-1) {
					destroyColumn(gameMap, mapWidth, i);
					dropOneStepShapes(gameMap,mapWidth,mapHeight,i);
					i--;
				}
			}					
		}
	}
	
	public static void dropOneStepShapes(Rectangle[] gameMap,int mapWdith,int mapHeight,int column) {
		Rectangle[] columnRects;
		for(int i = column+1;i < mapHeight;i++) {
			columnRects = getColumn(gameMap, mapWdith, i);
			for(Rectangle rect: columnRects) {
				if(rect.isThere) {
					rect.isThere = false;
					gameMap[rect.getX()+(rect.getY()-1)*mapWdith].isThere = true;
				}
			}
		}
		
	}
	
	public static void destroyColumn(Rectangle[] gameMap ,int mapWidth,int columnNumber) {
		for(int i = 0;i < mapWidth;i++) {
			gameMap[i+columnNumber*mapWidth].isThere = false;
		}
	}

}
