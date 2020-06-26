package com.echi.tank;

import lombok.Data;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/22 20:01
 */
public class TankFrame extends Frame {

	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

	public TankFrame(){
		// 设置窗口课件
		this.setVisible(true);
		// 设置窗口大小
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		// 设置窗口不可改变大小
		this.setResizable(false);
		// 设置窗口标题
		this.setTitle("tank war");

		// 设置窗口关闭事件
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(new MyKeyListener());

	}

	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null){
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.black);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0,0,null);
	}

	/**
	 * 窗口重绘时调用的方法
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		GameModel.getInstance().paint(g);
	}

	class MyKeyListener extends KeyAdapter{

		boolean bL = false;
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			// 获取键的代码
			int key = e.getKeyCode();
			switch (key){
				case KeyEvent.VK_LEFT: bL = true;break;
				case KeyEvent.VK_RIGHT: bR = true;break;
				case KeyEvent.VK_UP: bU = true;break;
				case KeyEvent.VK_DOWN: bD = true;break;
				default: break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// 获取键的代码
			int key = e.getKeyCode();
			switch (key){
				case KeyEvent.VK_LEFT: bL = false;break;
				case KeyEvent.VK_RIGHT: bR = false;break;
				case KeyEvent.VK_UP: bU = false;break;
				case KeyEvent.VK_DOWN: bD = false;break;
				case KeyEvent.VK_CONTROL:
					GameModel.getInstance().myTank.fire();
					break;
				default: break;
			}
			setMainTankDir();
		}

		private void setMainTankDir(){

			if (!bL && !bU && !bR && !bD){
				GameModel.getInstance().myTank.setMoving(false);
			}else {

				GameModel.getInstance().myTank.setMoving(true);
				if (bL && bU){
					GameModel.getInstance().myTank.setDir(Dir.LEFT_UP);
				}else if (bU && bR){
					GameModel.getInstance().myTank.setDir(Dir.UP_RIGHT);
				}else if (bR && bD){
					GameModel.getInstance().myTank.setDir(Dir.RIGHT_DOWN);
				}else if (bD && bL){
					GameModel.getInstance().myTank.setDir(Dir.DOWN_LEFT);
				}else {
					if (bL){
						GameModel.getInstance().myTank.setDir(Dir.LEFT);
					}else if (bU){
						GameModel.getInstance().myTank.setDir(Dir.UP);
					}else if (bR){
						GameModel.getInstance().myTank.setDir(Dir.RIGHT);
					}else if (bD){
						GameModel.getInstance().myTank.setDir(Dir.DOWN);
					}else {
					}
				}
			}
		}
	}
}
