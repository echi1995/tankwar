package com.echi.tank;

import lombok.Data;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/22 20:01
 */
public class TankFrame extends Frame {

	Tank myTank = new Tank(200, 400, Dir.UP, this, Group.GOOD);

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

	public List<Tank> tanks = new ArrayList<Tank>();
	public List<Bullet> bulletList = new ArrayList<Bullet>();
	public List<Explode> explodeList = new ArrayList<Explode>();

	Explode explode = new Explode(200, 300, this);

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
		Color color = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹的数量: " + bulletList.size(), 50, 50);
		g.drawString("敌方数量: " + tanks.size(), 50, 70);
		g.drawString("爆炸数量: " + explodeList.size(), 50, 90);
		g.setColor(color);
		myTank.paint(g);
		// 画出炮弹
		for (int i = 0; i < bulletList.size() ; i++) {
			Bullet bullet = bulletList.get(i);
			if (bullet.isAlive()){
				bullet.paint(g);
			}else {
				bulletList.remove(bullet);
			}
		}

		// 画出坦克
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}


		// 炮弹和坦克的碰撞检测
		for (int i = 0; i < bulletList.size(); i++) {
			for (int j = 0; j < tanks.size(); j++) {
				bulletList.get(i).collideWith(tanks.get(j));
			}
		}

		for (int i = 0; i < explodeList.size(); i++) {
			explodeList.get(i).paint(g);
		}
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
					myTank.fire();
					break;
				default: break;
			}
			setMainTankDir();
		}

		private void setMainTankDir(){

			if (!bL && !bU && !bR && !bD){
				myTank.setMoving(false);
			}else {

				myTank.setMoving(true);
				if (bL && bU){
					myTank.setDir(Dir.LEFT_UP);
				}else if (bU && bR){
					myTank.setDir(Dir.UP_RIGHT);
				}else if (bR && bD){
					myTank.setDir(Dir.RIGHT_DOWN);
				}else if (bD && bL){
					myTank.setDir(Dir.DOWN_LEFT);
				}else {
					if (bL){
						myTank.setDir(Dir.LEFT);
					}else if (bU){
						myTank.setDir(Dir.UP);
					}else if (bR){
						myTank.setDir(Dir.RIGHT);
					}else if (bD){
						myTank.setDir(Dir.DOWN);
					}else {
					}
				}
			}
		}
	}
}
