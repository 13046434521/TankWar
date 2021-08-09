package com.jtl.tank;

import com.jtl.tank.bean.Group;
import com.jtl.tank.bean.Tank;

/**
 * @author jtl
 * @date 2021/7/27 16:30
 */

class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame  =  new TankFrame();
        int initEnemyCount = PropertyManager.getInstance().getInt("initEnemyCount");
        System.out.println(initEnemyCount);

        for (int i=0;i<initEnemyCount;i++){
            Tank enemy= new Tank(i*200, 10, 1, Dir.DOWN, Group.BAD, ResourceManager.enemyTankDown, tankFrame);
            tankFrame.mTanks.add(enemy);
        }
        while (true){
            Thread.sleep(10);
            tankFrame.repaint();
            Tank tank = tankFrame.getTank();
            if (!tank.isLive()){
                tankFrame.setTank(new Tank(400, 600, 10, Dir.UP, Group.GOOD,ResourceManager.tankUp, tankFrame));
            }
        }
    }
}
