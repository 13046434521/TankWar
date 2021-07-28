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
    Dir mDir = Dir.UP;
    boolean isMove;

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
}
