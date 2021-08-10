package com.jtl.tank.fire;

import com.jtl.tank.bean.Bullet;
import com.jtl.tank.bean.Tank;

/**
 * @author jtl
 * @date 2021/8/10 17:00
 */

public class FastFireStrategy implements FireStrategy{
   private FastFireStrategy(){}

   public static FastFireStrategy getInstance(){
      return FastFireStrategyHolder.FAST_FIRE_STRATEGY;
   }

   @Override
   public void fire(Tank tank) {
      Bullet bullet = new Bullet(tank.getPositionX() + tank.getWidth() / 2, tank.getPositionY() + tank.getHeight() / 2, tank.getWidth()/ 5, tank.getHeight()/ 5, tank.getDir(),tank.getGroup(), tank.getTankFrame());
      bullet.setSpeed(20);
      tank.getBulletList().add(bullet);
   }

   private static class FastFireStrategyHolder{
      private static final FastFireStrategy FAST_FIRE_STRATEGY = new FastFireStrategy();
   }
}
