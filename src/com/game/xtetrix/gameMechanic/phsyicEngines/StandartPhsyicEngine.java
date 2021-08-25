package com.game.xtetrix.gameMechanic.phsyicEngines;

import com.game.xtetrix.gameMechanic.shapes.usualShapes.*;
import com.game.xtetrix.inputEngine.TInputListener;

public class StandartPhsyicEngine extends PhsyicEngine {

	
	public StandartPhsyicEngine() {
		super();
		shape = new RectShape();
		shape.moveShape(5, 5);	
		shape.turnR();
	}
	

	@Override
	public void run() {			
		int counter = 0;
		
		long fpsTime = System.currentTimeMillis();
		long startTime = 0;
		long endTime = 0;
		long cycleTime = 0;
		long expectedTime = (long) Math.pow(10, 3)/FPS;
		while(true) {
			//Döngü başlangıç zamanı hesaplandı
			startTime = System.currentTimeMillis();
			//İşlemler
			counter++;
			if(System.currentTimeMillis() - fpsTime>1000) {
				currentFPS = counter;
				counter = 0;
				fpsTime = System.currentTimeMillis();	
			}
			
					
			
			//Gecikme ver
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
		
	}

}
