package com.echi.tank.fire;

import com.echi.tank.Tank;
import lombok.Data;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 17:00
 */
public interface FireLevel {

	void fire(Tank tank);
	int getLevel();
}
