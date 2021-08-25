package com.game.xtetrix;

import java.awt.event.KeyListener;

import com.game.xtetrix.components.TetrixFrame;
import com.game.xtetrix.components.panels.GamePage;
import com.game.xtetrix.consts.ComponentConsts;
import com.game.xtetrix.inputEngine.TInputListener;

public class PageManager implements PageControllerInterface{

	//GUI Window for this game
	private TetrixFrame tetrixFrame;
	
	private GamePage gamePage;
	
	public PageManager() {
		
	}
	
	public void intializer() {
		tetrixFrame = new TetrixFrame(ComponentConsts.title);
		tetrixFrame.setBounds(ComponentConsts.frameX, ComponentConsts.frameY, 
				ComponentConsts.width, ComponentConsts.height);
		tetrixFrame.setVisible(true);
		
			
		gamePage = new GamePage(this);
		tetrixFrame.add(gamePage);
	}

	@Override
	public void passGamePage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passInitializePage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKeyListener(KeyListener keyListener) {
		// TODO Auto-generated method stub
		if(tetrixFrame.getKeyListeners().length > 0)
			tetrixFrame.removeKeyListener(tetrixFrame.getKeyListeners()[0]);
		
		tetrixFrame.addKeyListener(keyListener);
	}

}
