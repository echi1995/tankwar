package com.echi.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/23 20:41
 */
public class ResourceManager {

	public static BufferedImage badTankL, badTankU, badTankR, badTankD, badTankLU, badTankUR, badTankRD, badTankDL;
	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD, goodTankLU, goodTankUR, goodTankRD, goodTankDL;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD, bulletLU, bulletUR, bulletRD, bulletDL;
	public static BufferedImage[] explodes = new BufferedImage[16];

	static {
		try {
			goodTankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/GoodTank1.png"));
			goodTankD = ImageUtil.rotateImage(goodTankU, 180);
			goodTankL = ImageUtil.rotateImage(goodTankU, -90);
			goodTankR = ImageUtil.rotateImage(goodTankU, 90);
			goodTankLU = ImageUtil.rotateImage(goodTankU, -45);
			goodTankUR = ImageUtil.rotateImage(goodTankU, 45);
			goodTankRD = ImageUtil.rotateImage(goodTankU, 135);
			goodTankDL = ImageUtil.rotateImage(goodTankU, -135);

			badTankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/BadTank1.png"));
			badTankD = ImageUtil.rotateImage(badTankU, 180);
			badTankL = ImageUtil.rotateImage(badTankU, -90);
			badTankR = ImageUtil.rotateImage(badTankU, 90);
			badTankLU = ImageUtil.rotateImage(badTankU, -45);
			badTankUR = ImageUtil.rotateImage(badTankU, 45);
			badTankRD = ImageUtil.rotateImage(badTankU, 135);
			badTankDL = ImageUtil.rotateImage(badTankU, -135);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);

			bulletLU = ImageUtil.rotateImage(bulletU, -45);
			bulletUR = ImageUtil.rotateImage(bulletU, 45);
			bulletRD = ImageUtil.rotateImage(bulletU, 135);
			bulletDL = ImageUtil.rotateImage(bulletU, -135);

		}catch (IOException e){
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < 16; i++) {
				explodes[i] = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/e"+(i+1)+".gif"));
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
