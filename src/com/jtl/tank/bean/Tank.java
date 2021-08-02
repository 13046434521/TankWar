package com.jtl.tank.bean;

import com.jtl.tank.Dir;
import com.jtl.tank.ResourceManager;
import com.jtl.tank.TankFrame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jtl
 * @date 2021/7/27 14:22
 */

public class Tank extends TankObject {
    private final int tankWidth = 50;
    private final int tankHeight = 50;
    private BufferedImage mTankImage;
    private ArrayList<Bullet> mBulletList = new ArrayList<Bullet>();
    private final TankFrame mTankFrame;
    private Random mRandom = new Random();
    public Tank(int positionX, int positionY, int speed, Dir dir, Group group,BufferedImage bufferedImage, TankFrame tankFrame) {
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mDir = dir;
        this.mSpeed = speed;
        this.mTankImage = bufferedImage;
        this.mGroup = group;
        mTankFrame = tankFrame;
    }


    @Override
    public void paint(Graphics graphics) {
        if (!isLive) {
            if (mAtomicInteger.get() < ResourceManager.enemyBlastArrayList.size()) {
                graphics.drawImage(ResourceManager.enemyBlastArrayList.get(mAtomicInteger.getAndIncrement()), mPositionX, mPositionY, tankWidth, tankHeight, null);
            }

            mTankFrame.getTanks().remove(this);
        }

        if (mRandom.nextInt(10)>8){
            fire();
        }
        graphics.drawImage(mTankImage, mPositionX, mPositionY, tankWidth, tankHeight, null);

        if (!isMove) {
            return;
        }
        switch (mDir) {
            case UP:
                //w
                mPositionY -= mSpeed;
                if (mPositionY <= 0) {
                    mPositionY = 0;
                }
                break;
            case DOWN:
                //s
                mPositionY += mSpeed;
                break;
            case LEFT:
                //a
                mPositionX -= mSpeed;
                if (mPositionX <= 0) {
                    mPositionX = 0;
                }
                break;
            case RIGHT:
                //d
                mPositionX += mSpeed;
                break;
            default:
                break;
        }
    }

    @Override
    public void die() {
         isLive = false;
    }

    public void setTankImage(BufferedImage tankImage) {
        mTankImage = tankImage;
    }

    public void fire() {
        Bullet bullet = new Bullet(mPositionX + tankWidth / 2, mPositionY + tankHeight / 2, tankWidth / 5, tankHeight / 5, mDir,this.mGroup, this.mTankFrame);
        mBulletList.add(bullet);
    }

    private AtomicInteger mAtomicInteger = new AtomicInteger(0);


    public ArrayList<Bullet> getBulletList() {
        return mBulletList;
    }
}
