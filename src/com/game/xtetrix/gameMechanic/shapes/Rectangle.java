package com.game.xtetrix.gameMechanic.shapes;

public class Rectangle implements Cloneable{
	int x,y;
	public boolean isThere = false;
	public Rectangle() {
		x = 0;
		y = 0;
	}
	public Rectangle(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

}
