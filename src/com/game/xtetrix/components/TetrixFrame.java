package com.game.xtetrix.components;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class TetrixFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TetrixFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public TetrixFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public TetrixFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public TetrixFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
