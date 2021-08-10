package com.jtl.tank.fire;

import com.jtl.tank.bean.Bullet;
import com.jtl.tank.bean.Tank;

/**
 * @author jtl
 * @date 2021/8/10 16:50
 */

public class DefaultFireStrategy implements FireStrategy {
    private DefaultFireStrategy (){
    }

    public static DefaultFireStrategy getInstance(){
        return DefaultFireStrategyHolder.DEFAULT_FIRE_STRATEGY;
    }
    @Override
    public void fire(Tank tank) {
        Bullet bullet = new Bullet(tank.getPositionX() + tank.getWidth() / 2, tank.getPositionY() + tank.getHeight() / 2, tank.getWidth()/ 5, tank.getHeight()/ 5, tank.getDir(),tank.getGroup(), tank.getTankFrame());
        tank.getBulletList().add(bullet);
    }

    private static class DefaultFireStrategyHolder{
        private static final DefaultFireStrategy DEFAULT_FIRE_STRATEGY = new DefaultFireStrategy();
    }
}
