package com.game.xtetrix.gameMechanic.renders;

import java.awt.Dimension;
import java.awt.Graphics;

import com.game.xtetrix.gameMechanic.phsyicEngines.PhsyicEngine;

public interface IGameRender {

 
 public void setDrawBounds(int x,int y,int width,int height);
 
 public void setDrawPosition(int x,int y);
 
 public void setDrawSize(int width,int height);
 
 public int getX();
 
 public int getY();
 
 public Dimension getSize();
 
 public void render(Graphics g,PhsyicEngine gameEngine);
}
