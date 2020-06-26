package com.echi.tank;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/26 18:05
 */
public class ItemCollider implements Collider {
	public boolean collideWith(GameObject o1, GameObject o2) {

		if (o1 instanceof Item && o2 instanceof Tank){
			Item item = (Item) o1;
			Tank tank = (Tank) o2;
			// todo 判断敌我
			item.collideWith(tank);
		}else if (o1 instanceof Tank && o2 instanceof Item){
			collideWith(o2, o1);
		}
		return true;
	}
}
