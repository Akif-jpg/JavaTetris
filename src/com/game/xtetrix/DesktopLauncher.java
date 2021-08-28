package com.game.xtetrix;

import bago.bLogging.Logger;

public class DesktopLauncher{
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(DesktopLauncher.class);
		logger.trace("Desktop Launcher main method launched");
		PageManager pageManager = new PageManager();	
		pageManager.intializer();    
	}
}
