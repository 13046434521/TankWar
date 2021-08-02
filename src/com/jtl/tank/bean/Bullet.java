package com.jtl.tank.bean;


import com.jtl.tank.Dir;
import com.jtl.tank.ResourceManager;
import com.jtl.tank.TankFrame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author jtl
 * @date 2021/7/27 16:31
 */

public class Bullet extends TankObject implements Action{
    private final BufferedImage mTankBullet = ResourceManager.tankBullet;
    private final BufferedImage mEnemyBullet = ResourceManager.enemyBullet;
    private final TankFrame mTankFrame ;

    public Bullet(int positionX, int positionY, int width, int height, Dir dir,Group group, TankFrame tankFrame){
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mWidth = width;
        this.mHeight = height;
        this.mDir = dir;
        this.mGroup = group;
        this.mTankFrame = tankFrame;
    }


    @Override
    public void paint(Graphics graphics) {
        if (!isLive){
            mTankFrame.getTank().getBulletList().remove(this);
        }

        graphics.drawImage(this.mGroup.equals(Group.GOOD)?mTankBullet:mEnemyBullet,mPositionX-mWidth/2,mPositionY-mHeight/2,mWidth,mHeight,null);

        if (Dir.UP==mDir){
            mPositionY-=mSpeed;
        }
        if (Dir.DOWN==mDir){
            mPositionY+=mSpeed;
        }
        if (Dir.LEFT==mDir){
            mPositionX-=mSpeed;
        }
        if (Dir.RIGHT==mDir){
            mPositionX+=mSpeed;
        }

        if (mPositionX<0||mPositionY<0||mPositionX>mTankFrame.getWidth()||mPositionY>mTankFrame.getHeight()){
            isLive = false;
        }
    }

    @Override
    public void die() {
        isLive = false;
    }

    /**
     * 判断子弹和窗口边界关系
     */
    public void bound() {
        if (getCenterX()>mTankFrame.getWidth()||getCenterX()<0||getCenterY()<0||getCenterY()>mTankFrame.getHeight()){
            this.die();
            System.out.println("子弹:"+this.hashCode()+"  撞击边界！");
        }
    }

    /**
     * 子弹碰撞方法
     * @param tank 坦克对象
     */
    public void collideWith(Tank tank){
        // TODO: 2021/8/2 这里貌似没必要
        if (mGroup.equals(tank.mGroup)){
            return;
        }
        if (this.intersects(tank)) {
            tank.die();
            this.die();
            System.out.println("坦克:"+tank.mGroup.name()+":"+tank.hashCode()+" 被子弹:"+this.mGroup+":"+this.hashCode()+"  摧毁！");
        }
    }
}
