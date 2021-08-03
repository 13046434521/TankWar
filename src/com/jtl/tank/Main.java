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
        while (true){
            Thread.sleep(10);
            tankFrame.repaint();
            Tank tank = tankFrame.getTank();
            if (!tank.isLive()){
                tankFrame.setTank( new Tank(400, 600, 10, Dir.UP, Group.GOOD,ResourceManager.tankUp, tankFrame));
            }
        }
    }
}
