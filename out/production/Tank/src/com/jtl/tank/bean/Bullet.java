package com.jtl.tank.bean;


import com.jtl.tank.Dir;
import com.jtl.tank.ResourceManager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author jtl
 * @date 2021/7/27 16:31
 */

public class Bullet extends TankObject{
    private BufferedImage mBullet = ResourceManager.tankBullet;
    public Bullet(int positionX,int positionY, Dir dir){
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mDir = dir;
    }
    public Bullet(int positionX,int positionY,int width,int height, Dir dir){
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mWidth = width;
        this.mHeight = height;
        this.mDir = dir;
    }


    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(mBullet,mPositionX,mPositionY,mWidth,mHeight,null);
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


    }
}
