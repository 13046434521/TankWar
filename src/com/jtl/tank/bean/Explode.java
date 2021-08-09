package com.jtl.tank.bean;

import com.jtl.tank.ResourceManager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author jtl
 * @date 2021/8/3 10:34
 */

public class Explode extends TankObject{
    private int step=0;
    private final ArrayList<BufferedImage> explodeList ;
    public Explode(int x,int y,int width,int height,Group group){
        this.mPositionX = x;
        this.mPositionY = y;
        this.mHeight = height;
        this.mWidth = width;
        this.mGroup = group;
        this.explodeList = mGroup.equals(Group.GOOD)?ResourceManager.getInstance().getTankBlastArrayList():ResourceManager.getInstance().getEnemyBlastArrayList();
    }
    @Override
    public void paint(Graphics graphics) {
        if (step<explodeList.size()){
            graphics.drawImage(explodeList.get(step),mPositionX,mPositionY,mWidth,mHeight,null);
            step++;
        }else{
            die();
        }
    }

    @Override
    public void die() {
        isLive = false;
    }
}
