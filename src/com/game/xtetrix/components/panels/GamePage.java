package com.game.xtetrix.components.panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.game.xtetrix.PageControllerInterface;
import com.game.xtetrix.gameMechanic.phsyicEngines.StandartPhsyicEngine;
import com.game.xtetrix.gameMechanic.renders.DebugRender;
import com.game.xtetrix.gameMechanic.renders.IGameRender;
import com.game.xtetrix.inputEngine.TInputListener;

import bago.bLogging.Logger;

public class GamePage extends Page implements ActionListener {
	//Variables for game 
	private IGameRender gameRender;
	private StandartPhsyicEngine phsyicEngine;
	private TInputListener inputListener;
	
	private Logger logger;
	private boolean firstCycle = true;
	
	private Timer timer;
	public GamePage(PageControllerInterface pci) {
		super(pci);
		logger = Logger.getLogger(GamePage.class);
			
		inputListener = new TInputListener();
		pci.setKeyListener(inputListener);
		
		gameRender = new DebugRender();
		gameRender.setDrawBounds(50, 50, 360, 720);
		
		phsyicEngine = new StandartPhsyicEngine();
		phsyicEngine.setInputListener(inputListener);		

		logger.info("Game thread started");
		
		timer = new Timer(1000/60, this);
		timer.start();		
		
		logger.trace("Game Page has been created");
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		gameRender.render(arg0, phsyicEngine);
		
		if(firstCycle) {
			firstCycle = false;
			
			Thread gameThread = new Thread(phsyicEngine);
			gameThread.start();
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.repaint();
	}
 
}
