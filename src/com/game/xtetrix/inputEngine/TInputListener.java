package com.game.xtetrix.inputEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TInputListener implements KeyListener{
	
	private boolean moveRight;
	private boolean moveLeft;
	private boolean moveDown;
	private boolean turnRight;
	private boolean turnLeft;
	private boolean pressEscape = false;
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_LEFT:{
				moveLeft= true;	
				break;
				}
			case KeyEvent.VK_DOWN:{
				moveDown= true;
				break;
			}
			case KeyEvent.VK_RIGHT:{
				moveRight= true;
				break;
			}
			case KeyEvent.VK_S:{
				turnLeft= true;
				break;
			}
			case KeyEvent.VK_D:{
				turnRight= true;
				break;
			}
			case KeyEvent.VK_ESCAPE:{
				if(pressEscape) {
					pressEscape = false;
				}else {
					pressEscape = true;
				}
				break;
			}
		}	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_LEFT:{
				moveLeft= false;
				break;
			}
			case KeyEvent.VK_DOWN:{
				moveDown= false;
				break;
			}
			case KeyEvent.VK_RIGHT:{
				moveRight= false;
				break;
			}
			case KeyEvent.VK_S:{
				turnLeft= false;
				break;
			}
			case KeyEvent.VK_D:{
				turnRight= false;
				break;
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}
	
	public boolean isTurnRight() {
		return turnRight;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public boolean isTurnLeft() {
		return turnLeft;
	}
	
	public boolean isPressEscape() {
		return pressEscape;
	}


}
