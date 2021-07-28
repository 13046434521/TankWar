package com.jtl.tank.bean;

import com.jtl.tank.Dir;
import com.jtl.tank.TankFrame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author jtl
 * @date 2021/7/27 14:22
 */

public class Tank extends TankObject {
    private final int tankWidth =50;
    private final int tankHeight=50;
    private final BufferedImage mTankImage;
    private final ArrayList<Bullet> mBulletList = new ArrayList<Bullet>();
    private final TankFrame mTankFrame;
    public Tank(int positionX,int positionY, int speed,Dir dir,BufferedImage bufferedImage,TankFrame tankFrame){
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mDir = dir;
        this.mSpeed = speed;
        this.mTankImage = bufferedImage;
        mTankFrame = tankFrame;
    }



    @Override
    public void paint(Graphics graphics) {
        for (int i=0;i<mBulletList.size();i++){
            Bullet bullet = mBulletList.get(i);
            bullet.paint(graphics);
            if (!bullet.isLive){
                mBulletList.remove(bullet);
            }
        }
        graphics.drawImage(mTankImage,mPositionX,mPositionY,tankWidth,tankHeight,null);
        if (!isMove){
            return;
        }
        switch (mDir){
            case UP:
                //w
                mPositionY-=mSpeed;
                if (mPositionY<=0){
                    mPositionY=0;
                }
                break;
            case DOWN:
                //s
                mPositionY+=mSpeed;
                break;
            case LEFT:
                //a
                mPositionX-=mSpeed;
                if (mPositionX<=0){
                    mPositionX=0;
                }
                break;
            case RIGHT:
                //d
                mPositionX+=mSpeed;
                break;
            default:
                break;
        }
    }

    public void fire(){
        Bullet bullet = new Bullet(mPositionX+tankWidth/2,mPositionY+tankHeight/2,tankWidth/5,tankHeight/5,mDir,this.mTankFrame);
        mBulletList.add(bullet);
    }
}
