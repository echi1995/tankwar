package com.echi.tank;

import lombok.Data;

import java.awt.*;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/26 15:15
 */
@Data
public abstract class GameObject {

	int x,y;

	public abstract void paint(Graphics g);

}
