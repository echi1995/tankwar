package com.echi.tank.fire;

import com.echi.tank.Bullet;
import com.echi.tank.Dir;
import com.echi.tank.GameModel;
import com.echi.tank.Tank;
import lombok.Data;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 16:58
 */
@Data
public class FireLevel3 implements FireLevel {

	private static final int LEVEL = 3;
	
	public void fire(Tank tank) {
		Bullet bulletL = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.LEFT, tank.getGroup());
		Bullet bulletU = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.UP, tank.getGroup());
		Bullet bulletR = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.RIGHT, tank.getGroup());
		Bullet bulletD = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.DOWN, tank.getGroup());

		Bullet bulletLU = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.LEFT_UP, tank.getGroup());
		Bullet bulletUR = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.UP_RIGHT, tank.getGroup());
		Bullet bulletRD = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.RIGHT_DOWN, tank.getGroup());
		Bullet bulletDL = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.DOWN_LEFT, tank.getGroup());

		GameModel.getInstance().objects.add(bulletL);
		GameModel.getInstance().objects.add(bulletU);
		GameModel.getInstance().objects.add(bulletR);
		GameModel.getInstance().objects.add(bulletD);

		GameModel.getInstance().objects.add(bulletLU);
		GameModel.getInstance().objects.add(bulletUR);
		GameModel.getInstance().objects.add(bulletRD);
		GameModel.getInstance().objects.add(bulletDL);
	}

	public int getLevel() {
		return LEVEL;
	}
}
