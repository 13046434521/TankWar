package com.jtl.tank.bean;

import com.jtl.tank.Dir;
import com.jtl.tank.ImageUtils;
import com.jtl.tank.TankFrame;
import com.jtl.tank.bean.Action;
import com.sun.imageio.plugins.common.ImageUtil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author jtl
 * @date 2021/7/27 14:22
 */

public class Tank extends TankObject {
    private int tankWidth =50;
    private int tankHeight=50;
    private BufferedImage mTankImage;
    private ArrayList<Bullet> mBulletList = new ArrayList<Bullet>();
    public Tank(int positionX,int positionY, int speed,Dir dir,BufferedImage bufferedImage){
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mDir = dir;
        this.mSpeed = speed;
        this.mTankImage = bufferedImage;
    }



    @Override
    public void paint(Graphics graphics) {
        for (Bullet bullet:mBulletList){
            bullet.paint(graphics);
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
        Bullet bullet = new Bullet(mPositionX+tankWidth/2,mPositionY+tankHeight/2,tankWidth/5,tankHeight/5,mDir);
        mBulletList.add(bullet);
    }
}
