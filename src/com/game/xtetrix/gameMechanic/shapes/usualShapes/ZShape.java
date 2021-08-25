package com.game.xtetrix.gameMechanic.shapes.usualShapes;


import com.game.xtetrix.gameMechanic.shapes.Rectangle;
import com.game.xtetrix.gameMechanic.shapes.Shape;

public class ZShape extends Shape{
	public ZShape() {
		rectangleList = new Rectangle[4];
		rectangleList[0] = new Rectangle(0, 1);
		rectangleList[1] = new Rectangle(1, 1);
		rectangleList[2] = new Rectangle(1, 0);
		rectangleList[3] = new Rectangle(2, 0);
	}

}
