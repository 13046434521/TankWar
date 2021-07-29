package com.jtl.tank.bean;

import com.jtl.tank.Dir;

/**
 * @author jtl
 * @date 2021/7/27 16:33
 */

public abstract class TankObject implements Action{
    int mPositionX =0;
    int mPositionY = 0;
    int mSpeed = 10;
    int mWidth =50;
    int mHeight =50;
    int mCenterX = 0;
    int mCenterY = 0;
    Dir mDir = Dir.UP;
    boolean isMove;
    boolean isLive = true;

    public void setPositionX(int positionX) {
        mPositionX = positionX;
    }

    public void setPositionY(int positionY) {
        mPositionY = positionY;
    }

    public void setSpeed(int speed) {
        mSpeed = speed;
    }

    public void setDir(Dir dir) {
        mDir = dir;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public int getCenterX() {
        mCenterX = mPositionX+mWidth/2;
        return mCenterX;
    }

    public int getCenterY() {
        mCenterY = mPositionY+mHeight/2;
        return mCenterY;
    }

    public int getPositionX() {
        return mPositionX;
    }

    public int getPositionY() {
        return mPositionY;
    }

    public int getSpeed() {
        return mSpeed;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public Dir getDir() {
        return mDir;
    }

    public boolean isMove() {
        return isMove;
    }

    public boolean isLive() {
        return isLive;
    }
}
