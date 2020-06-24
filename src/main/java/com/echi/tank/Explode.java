package com.echi.tank;

import java.awt.*;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 10:28
 */
public class Explode {

	private int x, y;
	public static int WIDTH = ResourceManager.explodes[0].getWidth();
	public static int HEIGHT = ResourceManager.explodes[0].getHeight();
	private boolean living = true;
	private TankFrame tankFrame;
	private int step = 0;


	public Explode(int x, int y, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.tankFrame = tankFrame;
		//new Audio("audio/explode.wav").play();
	}

	public void paint(Graphics g){
		g.drawImage(ResourceManager.explodes[step++], x, y, null);

		if (step >= ResourceManager.explodes.length){
			tankFrame.explodeList.remove(this);
		}
	}



}
