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
public class FireLevel2 implements FireLevel {


	private static final int LEVEL = 2;

	public void fire(Tank tank) {
		if (tank.getDir() != Dir.LEFT){
			Bullet bulletL = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.LEFT, tank.getGroup());
			GameModel.getInstance().objects.add(bulletL);
		}
		if (tank.getDir() != Dir.UP) {
			Bullet bulletU = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.UP, tank.getGroup());
			GameModel.getInstance().objects.add(bulletU);
		}
		if (tank.getDir() != Dir.RIGHT) {
			Bullet bulletR = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.RIGHT, tank.getGroup());
			GameModel.getInstance().objects.add(bulletR);
		}
		if (tank.getDir() != Dir.DOWN) {
			Bullet bulletD = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, Dir.DOWN, tank.getGroup());
			GameModel.getInstance().objects.add(bulletD);
		}

		Bullet bullet = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, tank.getDir(),  tank.getGroup());
		GameModel.getInstance().objects.add(bullet);
	}

	public int getLevel() {
		return LEVEL;
	}
}
