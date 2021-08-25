package com.game.xtetrix.components.panels;

import javax.swing.JPanel;

import com.game.xtetrix.PageControllerInterface;

public class Page extends JPanel {
	PageControllerInterface pci;
	public Page(PageControllerInterface pci) {
		this.pci = pci;
	}
}
