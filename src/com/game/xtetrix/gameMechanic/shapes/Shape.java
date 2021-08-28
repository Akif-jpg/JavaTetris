package com.game.xtetrix.gameMechanic.shapes;

import java.util.Arrays;

public abstract class Shape implements Cloneable{
	protected Rectangle[] rectangleList;
	protected int dX;
	protected int dY;
	
	public Shape () {
		
		this.dX = 0;
		this.dY = 0;
	}
	
	public void turnR() {
		int length = rectangleList.length;
		int[] yArray = new int[length];
		int[] xArray = new int[length];
		
		int[] yTArray = new int[length];
		int[] xTArray = new int[length];
		for (int i = 0; i < length; i++) {
			yArray[i] = (int) rectangleList[i].getY();
			xArray[i] = (int) rectangleList[i].getX();
			
			rectangleList[i] = new Rectangle(rectangleList[i].y, -rectangleList[i].x);
			
			xTArray[i] = rectangleList[i].getX();
			yTArray[i] = rectangleList[i].getY();
		}

		Arrays.sort(yArray);
		Arrays.sort(yTArray);
		
		int deltaY = yTArray[0] - yArray[0];
		
		this.dY -= deltaY;		
		
		int tMass = 0;
		for(int i:xTArray) {
			tMass += i; 
		}
		double tCenterMass = ((double) tMass)/ ((double) length);
		int Mass = 0;
		for(int i:xArray) {
			Mass += i; 
		}
		double CenterMass = ((double) Mass)/ ((double) length);
		
		double deltaCenterMass = tCenterMass - CenterMass;
		
		this.dX -= Math.round(deltaCenterMass);
	}
	
	public void turnL() {
		int length = rectangleList.length;
		int[] yArray = new int[length];
		int[] xArray = new int[length];
		
		int[] yTArray = new int[length];
		int[] xTArray = new int[length];
		for (int i = 0; i < length; i++) {
			yArray[i] = (int) rectangleList[i].getY();
			xArray[i] = (int) rectangleList[i].getX();
			
			rectangleList[i] = new Rectangle(-rectangleList[i].y, rectangleList[i].x);
			
			xTArray[i] = rectangleList[i].getX();
			yTArray[i] = rectangleList[i].getY();
		}
		
		Arrays.sort(yArray);
		Arrays.sort(yTArray);
		
		int deltaY = yTArray[0] - yArray[0];
		
		this.dY -= deltaY;	
		
		int tMass = 0;
		for(int i:xTArray) {
			tMass += i; 
		}
		double tCenterMass = ((double) tMass)/ ((double) length);
		System.out.println("tCenterMass: " + tCenterMass);
		int Mass = 0;
		for(int i:xArray) {
			Mass += i; 
		}
		double CenterMass = ((double) Mass)/ ((double) length);
		System.out.println("CenterMass: " + CenterMass);
		
		double deltaCenterMass = tCenterMass - CenterMass;
		System.out.println("deltaCenterMass: " + Math.round(deltaCenterMass));
		
		this.dX -= Math.round(deltaCenterMass);
		

	}
	
	public int getShapeWidth() {
		int rectXPosition[] = new int[rectangleList.length];
		for (int i = 0; i < rectXPosition.length; i++) {
			try {
				rectXPosition[i] = ((Rectangle) rectangleList[i].clone()).getX();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Arrays.sort(rectXPosition);
		return Math.abs(rectXPosition[rectXPosition.length-1]-rectXPosition[0])+1;
	}
	public void moveR() {
		this.dX += 1;
	}

	public void moveL() {
		this.dX -= 1;
	}
	
	public void moveD() {
		this.dY -= 1;
		
	}
	
	public void moveShape(int x,int y) {
		this.dX = x;
		this.dY = y;
	}
	
	public Rectangle[] getRectangleList() {
		return rectangleList;
	}
		
	public int getDx() {
		return this.dX;
	}
	
	public int getDy() {
		return this.dY;
	}

	public void setRectangleList(Rectangle[] rectangleList) {
		this.rectangleList = rectangleList;
	}

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
