package com.echi.tank;

import java.awt.*;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 10:28
 */
public class Explode extends GameObject {

	public static int WIDTH = ResourceManager.explodes[0].getWidth();
	public static int HEIGHT = ResourceManager.explodes[0].getHeight();
	private int step = 0;


	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
		new Audio("audio/explode.wav").play();
	}

	@Override
	public void paint(Graphics g){
		g.drawImage(ResourceManager.explodes[step++], x, y, null);

		if (step >= ResourceManager.explodes.length){
			GameModel.getInstance().objects.remove(this);
		}
	}



}
