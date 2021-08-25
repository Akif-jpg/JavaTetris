package com.game.xtetrix.components.panels;

import java.awt.Font;
import java.awt.Graphics;

import com.game.xtetrix.PageControllerInterface;
import com.game.xtetrix.gameMechanic.phsyicEngines.StandartPhsyicEngine;
import com.game.xtetrix.gameMechanic.renders.DebugRender;
import com.game.xtetrix.gameMechanic.renders.IGameRender;
import com.game.xtetrix.inputEngine.TInputListener;

public class GamePage extends Page {
	IGameRender gameRender;
	StandartPhsyicEngine phsyicEngine;
	TInputListener inputListener;
	
	boolean firstCycle = true;
	public GamePage(PageControllerInterface pci) {
		super(pci);
		
		inputListener = new TInputListener();
		pci.setKeyListener(inputListener);
		
		gameRender = new DebugRender();
		gameRender.setDrawBounds(50, 50, 360, 720);
		
		phsyicEngine = new StandartPhsyicEngine();
		phsyicEngine.setInputListener(inputListener);
		
		Thread gameThread = new Thread(phsyicEngine);
		gameThread.start();

		System.out.println("Entered Game Page");
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		gameRender.render(arg0, phsyicEngine);
	
	}
	

 
}
