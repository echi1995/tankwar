package com.echi.tank;

import java.awt.*;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/26 17:57
 */
public class BulletCollider implements Collider {



	public boolean collideWith(GameObject o1, GameObject o2) {
		if (o1 instanceof Bullet && o2 instanceof Tank){
			Bullet bullet = (Bullet) o1;
			Tank tank = (Tank) o2;


			if (bullet.getGroup() == tank.getGroup()){
				return true;
			}

			if (bullet.getRect().intersects(tank.rect)){
				tank.die();
				bullet.die();
			}
			return false;
		}else if (o1 instanceof Tank && o2 instanceof Bullet){
			return collideWith(o2, o1);
		}else {
			return true;
		}
	}
}
