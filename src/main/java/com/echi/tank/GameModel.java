package com.echi.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/26 15:03
 */
public class GameModel {

	private static GameModel gameModel = new GameModel();

	public static GameModel getInstance(){
		return gameModel;
	}

	Tank myTank = new Tank(200, 400, Dir.UP, Group.GOOD);

	ColliderChain colliderChain = new ColliderChain();

	private GameModel(){
		colliderChain.add(new BulletCollider());
		colliderChain.add(new ItemCollider());
	}

	Random random = new Random();

//	public List<Tank> tanks = new ArrayList<Tank>();
//	public List<Bullet> bulletList = new ArrayList<Bullet>();
//	public List<Explode> explodeList = new ArrayList<Explode>();
//
//	public List<Item> itemList = new ArrayList<Item>();
	public List<GameObject> objects = new ArrayList<GameObject>();

	public void paint(Graphics g){
		Color color = g.getColor();
		g.setColor(Color.white);
//		g.drawString("子弹的数量: " + bulletList.size(), 50, 50);
//		g.drawString("敌方数量: " + tanks.size(), 50, 70);
//		g.drawString("爆炸数量: " + explodeList.size(), 50, 90);
		g.setColor(color);
		myTank.paint(g);
		// 画出炮弹
		for (int i = 0; i < objects.size() ; i++) {
			objects.get(i).paint(g);
		}

		// 炮弹和坦克的碰撞检测
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i+1; j < objects.size(); j++) {
				if (!colliderChain.collideWith(objects.get(i), objects.get(j))){
					break;
				}
			}
		}

		if (random.nextInt(100) > 98){
			objects.add(new Item(random.nextInt(TankFrame.GAME_WIDTH - 20), random.nextInt(TankFrame.GAME_HEIGHT - 20)));
		}
	}

}