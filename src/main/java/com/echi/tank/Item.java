package com.echi.tank;

import com.echi.tank.fire.FireLevel;
import com.echi.tank.fire.FireLevelFactory;
import lombok.Data;

import java.awt.*;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 16:47
 */
@Data
public class Item extends GameObject {

	Rectangle rect ;

	private int WEIGHT = 20;
	private int HEIGHT = 20;

	public Item(int x, int y) {
		this.x = x;
		this.y = y;
		rect = new Rectangle(x, y, WEIGHT, HEIGHT);
	}

	@Override
	public void paint(Graphics g){
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, WEIGHT, HEIGHT);
		g.setColor(color);
	}

	public void collideWith(Tank tank) {

		if (rect.intersects(tank.rect)){
			GameModel.getInstance().objects.remove(this);
			// tank火力升级
			int level = tank.getFireLevel().getLevel();
			if (level < 3){
				FireLevel fireLevel = FireLevelFactory.getFireLevel(level + 1);
				tank.setFireLevel(fireLevel);
			}
		}
	}
}
