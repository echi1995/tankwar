package com.echi.tank.fire;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 17:13
 */
public class FireLevelFactory {

	private static volatile FireLevel fireLevel1 = new FireLevel1();
	private static volatile FireLevel fireLevel2 = new FireLevel2();
	private static volatile FireLevel fireLevel3 = new FireLevel3();

	public static FireLevel getFireLevel(int level){
		switch (level){
			case 1: return fireLevel1;
			case 2: return fireLevel2;
			case 3: return fireLevel3;
			default:return null;
		}
	}
}
