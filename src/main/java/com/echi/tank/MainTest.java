package com.echi.tank;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/22 20:31
 */
public class MainTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		TankFrame tankFrame = new TankFrame();

		Integer initTankCount = Integer.valueOf(PropertyManager.get("initTankCount"));
		for (int i = 0; i < initTankCount; i++) {
			tankFrame.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tankFrame, Group.BAD));
		}

		while (true){
			Thread.sleep(50);
			tankFrame.repaint();
		}
	}
}
