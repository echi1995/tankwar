package com.echi.tank;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/23 13:41
 */
@Data
public class Bullet extends GameObject {

	private static final int SPEED = 10;
	private Dir dir;
	public static int WIDTH = ResourceManager.bulletD.getWidth();
	public static int HEIGHT = ResourceManager.bulletD.getHeight();
	private boolean living = true;
	private Group group;

	Rectangle rect;


	public Bullet(int x, int y, Dir dir, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		rect = new Rectangle(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void paint(Graphics g){
		if (!isAlive()){
			living = false;
		}

		if (!living){
			GameModel.getInstance().objects.remove(this);
			return;
		}
		switch (dir){
			case UP:
				g.drawImage(ResourceManager.bulletU, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceManager.bulletR, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceManager.bulletD, x, y, null);
				break;
			case LEFT:
				g.drawImage(ResourceManager.bulletL, x, y, null);
				break;
			case LEFT_UP:
				g.drawImage(ResourceManager.bulletLU, x, y, null);
				break;
			case UP_RIGHT:
				g.drawImage(ResourceManager.bulletUR, x, y, null);
				break;
			case RIGHT_DOWN:
				g.drawImage(ResourceManager.bulletRD, x, y, null);
				break;
			case DOWN_LEFT:
				g.drawImage(ResourceManager.bulletDL, x, y, null);
				break;
			default:break;
		}
		move();
	}

	private void move(){

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
		rect.x = x;
		rect.y = y;
	}

	public boolean isAlive(){
		if(x > TankFrame.GAME_WIDTH || x < 0 || y < 0 || y > TankFrame.GAME_HEIGHT){
			living = false;
		}
		return living;
	}


	public void die(){
		living = false;
		GameModel.getInstance().objects.remove(this);
	}
}
