package com.echi.tank;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/26 18:08
 */
public class ColliderChain implements Collider {

	private List<Collider> colliders = new ArrayList<Collider>();

	public void add(Collider collider){
		colliders.add(collider);
	}


	public boolean collideWith(GameObject o1, GameObject o2) {
		for (int i = 0; i < colliders.size(); i++) {
			if (!colliders.get(i).collideWith(o1, o2)){
				return false;
			}
		}
		return true;
	}
}
