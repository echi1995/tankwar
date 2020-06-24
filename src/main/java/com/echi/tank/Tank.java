package com.echi.tank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.rmi.server.RMIClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/23 13:06
 */
@Data
public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED = 5;
	private boolean moving = false;
	private TankFrame tankFrame;
	private boolean living = true;
	private Group group = Group.BAD;

	private Random random = new Random();
	Rectangle rect ;

	public static int WIDTH = ResourceManager.goodTankD.getWidth();
	public static int HEIGHT = ResourceManager.goodTankD.getHeight();

	public Tank(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame = tankFrame;
		this.group = group;
		rect = new Rectangle(x, y, Tank.WIDTH, Tank.HEIGHT);
	}

	public void paint(Graphics g){
		if (!living){
			tankFrame.tanks.remove(this);
			return;
		}
		switch (dir){
			case LEFT:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankL : ResourceManager.badTankL, x,y, null);
				break;
			case UP:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankU : ResourceManager.badTankU, x,y, null);
				break;
			case RIGHT:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankR : ResourceManager.badTankR, x,y, null);
				break;
			case DOWN:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankD : ResourceManager.badTankD, x,y, null);
				break;
			case LEFT_UP:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankLU : ResourceManager.badTankLU, x,y, null);
				break;
			case UP_RIGHT:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankUR : ResourceManager.badTankUR, x,y, null);
				break;
			case RIGHT_DOWN:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankRD : ResourceManager.badTankRD, x,y, null);
				break;
			case DOWN_LEFT:
				g.drawImage(this.group == Group.GOOD? ResourceManager.goodTankDL : ResourceManager.badTankDL, x,y, null);
				break;
			default:break;
		}

		move();
	}

	private void move(){

		// 如果是敌方坦克, 随机修改方向
		if (group == Group.BAD){
			// 50%的几率动
			if (random.nextInt(2) > 0){
				// 10%的几率改变方向
				moving = true;
				if (random.nextInt(10) == 0){
					randomDir();
				}

			}else {
				moving = false;
			}
		}


		if (!moving){
			return ;
		}


		switch (dir){
			case LEFT: x-=SPEED;break;
			case UP: y-=SPEED;break;
			case RIGHT: x+=SPEED;break;
			case DOWN: y+=SPEED;break;
			case LEFT_UP: x-=SPEED;y-=SPEED;break;
			case UP_RIGHT: x+=SPEED;y-=SPEED;break;
			case RIGHT_DOWN: x+=SPEED;y+=SPEED;break;
			case DOWN_LEFT: x-=SPEED;y+=SPEED;break;
			default:break;
		}

		boundCheck();

		rect.x = x;
		rect.y = y;

		// 敌方开火
		if (group == Group.BAD && random.nextInt(10) > 8){
			this.fire();
		}


	}

	public void randomDir(){
		dir = Dir.values()[random.nextInt(8)];
	}

	public void fire(){
		Bullet bullet = new Bullet(x + Tank.WIDTH / 2 - Bullet.WIDTH / 2, y + Tank.HEIGHT/2 - Bullet.HEIGHT/2, dir, tankFrame, group);
		tankFrame.bulletList.add(bullet);
	}

	public void die(){
		living = false;
		tankFrame.explodeList.add(new Explode(x + WIDTH/2 - Explode.WIDTH/2,y+ HEIGHT/2 - Explode.HEIGHT/2, tankFrame));
	}

	public void boundCheck(){

		// 坦克边界检测
		if (x < 0){
			x = 0;
		}
		if (y < 0){
			y = 0;
		}
		if (x > TankFrame.GAME_WIDTH - Tank.WIDTH){
			x = TankFrame.GAME_WIDTH - Tank.WIDTH;
		}
		if (y > TankFrame.GAME_HEIGHT - Tank.WIDTH){
			y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
		}
	}
}
