package com.game.xtetrix.gameMechanic.phsyicEngines;

import java.util.Random;

import com.game.xtetrix.gameMechanic.shapes.Shape;
import com.game.xtetrix.gameMechanic.shapes.usualShapes.*;
import com.game.xtetrix.inputEngine.TInputListener;

import bago.bLogging.Logger;
import bago.exception.NotFoundInputListener;

public class StandartPhsyicEngine extends PhsyicEngine {

	Logger logger;
	
	public StandartPhsyicEngine() {
		super();
		logger = Logger.getLogger(StandartPhsyicEngine.class);
		this.FPS = 90;
		
		logger.trace("Standart Phsyic engine has been created");
	}
	
	private void calculateShapePositon(Shape shape) {
		Random random = new Random();
		int shapeXPosition = 0;
		int shapeRotatePosition = random.nextInt(3);
		int shapeWidth = 3;
		
		for (int i = 0; i < shapeRotatePosition; i++) {
			this.shape.turnR();				
		}
		shapeWidth = shape.getShapeWidth();
		shapeXPosition = (int) (random.nextInt(mapWidth - Math.round(1.5f*shapeWidth))+Math.round(((float) shapeWidth)/2.f));
		System.out.println("shape width: %d \t shapeXPosition: %d".formatted(shapeWidth,shapeXPosition));
		shape.moveShape(shapeXPosition, mapHeight);
	}
	
	private void createRandomShape() {
		Random random = new Random();
		int shapType = random.nextInt(7);

		switch (shapType) {
		case 0:
			this.shape = new ArrowShape();
			calculateShapePositon(this.shape);
			logger.info("ArrowShape has been created");
			
			break;
		case 1:
			this.shape = new JShape();
			calculateShapePositon(this.shape);
			logger.info("JShape has been created");
			break;
		case 2:
			this.shape = new LShape();
			calculateShapePositon(this.shape);
			logger.info("LShape has been created");
			break;
		case 3:
			this.shape = new RectShape();
			calculateShapePositon(this.shape);
			logger.info("RectShape has been created");

			break;
		case 4:
			this.shape = new SShape();
			calculateShapePositon(this.shape);
			logger.info("SShape has been created");
			break;
		case 5:
			this.shape = new StickShape();
			calculateShapePositon(this.shape);
			logger.info("StickShape has been created");

			break;
		case 6:
			this.shape = new ZShape();
			calculateShapePositon(this.shape);
			logger.info("ZShape has been created");
			break;		
		}
	}
	private void shapeToGameMap(Shape shape) {
		for (int i = 0; i < shape.getRectangleList().length; i++) {
			int columnNumber = (shape.getRectangleList()[i].getY()+shape.getDy())*mapWidth
			+(shape.getRectangleList()[i].getX()+shape.getDx());
			if(columnNumber<gameMap.length&&columnNumber >= 0) {
				gameMap[columnNumber].isThere = true;
			}
		}
		
	}
	@Override
	public void run() {		
	   int loopCounter = 0;
	   int eachLoop = 20;
	   
		int loopCounter_1 = 0;
		int eachLoop_1 = 10;
		createRandomShape();
		while(true) {
			this.headerFPSController();
			loopCounter++;
			loopCounter_1++;
			
			if(this.inputListener == null) {
				throw new NotFoundInputListener("input listener is null");
			}
			if(loopCounter > eachLoop) {
				loopCounter = 0;
	
		  		try {
					moveDown();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			  		

			}	
			
			if(loopCounter_1 > eachLoop_1) {
				loopCounter_1 = 0;
				
				if(inputListener.isMoveRight()) {				
					this.shape.moveR();
				}else if(inputListener.isMoveLeft()) {
					this.shape.moveL();
				}else {
					Shape instanceShape;
					try {
						instanceShape = (Shape) this.shape.clone();
						instanceShape.moveD();
						if(isBumpBottom(this.shape)||isBumpanyShape(instanceShape)) {
							//shapeToGameMap(this.shape);
							createRandomShape();
						}
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
			

			
			this.footerFPSController();			
		}
		
	}

}
