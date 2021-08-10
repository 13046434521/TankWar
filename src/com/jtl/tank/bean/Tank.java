package com.jtl.tank.bean;

import com.jtl.tank.Dir;
import com.jtl.tank.ResourceManager;
import com.jtl.tank.TankFrame;
import com.jtl.tank.fire.DefaultFireStrategy;
import com.jtl.tank.fire.FireStrategy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author jtl
 * @date 2021/7/27 14:22
 */

public class Tank extends TankObject {
    private final int tankWidth = 50;
    private final int tankHeight = 50;
    private BufferedImage mTankImage;
    private final ArrayList<Bullet> mBulletList = new ArrayList<>();
    private final TankFrame mTankFrame;
    private final Random mRandom = new Random();
    private Explode mExplode ;
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
        // 是否存活
        if (!isLive) {
            if (mExplode==null){
                mExplode = new Explode(mPositionX,mPositionY,tankWidth,tankHeight,mGroup);
            }
            mExplode.paint(graphics);

            if (!mExplode.isLive){
                mTankFrame.getTanks().remove(this);
            }

            return;
        }

        // 敌军坦克 自动开火
        if (Group.BAD.equals(mGroup)&&mRandom.nextInt(100)>98){
            fire(DefaultFireStrategy.getInstance());
        }
        // 敌军坦克 转换方向
        if (Group.BAD.equals(mGroup)&&mRandom.nextInt(100)>98){
            randomDir();
        }

        graphics.drawImage(mTankImage, mPositionX, mPositionY, tankWidth, tankHeight, null);

        if (!isMove) {
            return;
        }
        switch (mDir) {
            case UP:
                //w
                mPositionY -= mSpeed;
                break;
            case DOWN:
                //s
                mPositionY += mSpeed;

                break;
            case LEFT:
                //a
                mPositionX -= mSpeed;
                break;
            case RIGHT:
                //d
                mPositionX += mSpeed;
                break;
            default:
                break;
        }

        // 移动时边界检测
        checkBounds();
    }

    @Override
    public void die() {
         isLive = false;
    }

    public void setTankImage(BufferedImage tankImage) {
        mTankImage = tankImage;
    }

    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

    public void randomDir(){
        int random = mRandom.nextInt(4);
        this.mDir = Dir.values()[random];
        BufferedImage[] tanks = Group.GOOD.equals(this.mGroup)?ResourceManager.getInstance().getMainTanks():ResourceManager.getInstance().getEnemyTanks();
        this.mTankImage =tanks[random];
    }


    public ArrayList<Bullet> getBulletList() {
        return mBulletList;
    }

    private void checkBounds(){
        if (mPositionY <= 0) {
            mPositionY = 0;
        }
        if (mPositionY>mTankFrame.getHeight()-this.tankHeight){
            mPositionY=mTankFrame.getHeight()-this.tankHeight;
        }
        if (mPositionX <= 0) {
            mPositionX = 0;
        }
        if (mPositionX>mTankFrame.getWidth()-this.tankWidth){
            mPositionX=mTankFrame.getWidth()-this.tankWidth;
        }
    }

    public TankFrame getTankFrame() {
        return mTankFrame;
    }


}
