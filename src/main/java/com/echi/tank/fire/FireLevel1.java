package com.echi.tank.fire;

import com.echi.tank.*;
import lombok.Data;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 16:58
 */
@Data
public class FireLevel1 implements FireLevel {

	private static final int LEVEL = 1;

	public void fire(Tank tank) {
		Bullet bullet = new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2, tank.getDir(), tank.getGroup());
		GameModel.getInstance().objects.add(bullet);
	}

	public int getLevel() {
		return LEVEL;
	}
}
