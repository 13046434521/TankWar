package com.jtl.tank;

import java.awt.image.BufferedImage;

/**
 * @author jtl
 * @date 2021/7/28 11:40
 */

public class ResourceManager {
    public static BufferedImage tankDefault;
    public static BufferedImage tankUp;
    public static BufferedImage tankDown;
    public static BufferedImage tankLeft;
    public static BufferedImage tankRight;

    public static BufferedImage enemyTankDefault;
    public static BufferedImage enemyTankUp;
    public static BufferedImage enemyTankDown;
    public static BufferedImage enemyTankLeft;
    public static BufferedImage enemyTankRight;

    public static BufferedImage tankBullet;

    static {
        tankDefault = ImageUtils.INSTANCE.loadImage("image/p1tankU.jpg");
        tankUp = ImageUtils.INSTANCE.rotateImage(tankDefault,0);
        tankDown = ImageUtils.INSTANCE.rotateImage(tankDefault,180);
        tankLeft = ImageUtils.INSTANCE.rotateImage(tankDefault,270);
        tankRight = ImageUtils.INSTANCE.rotateImage(tankDefault,90);

        tankBullet = ImageUtils.INSTANCE.loadImage("image/tankmissile.jpg");

        enemyTankDefault = ImageUtils.INSTANCE.loadImage("image/enemy1U.jpg");
        enemyTankUp = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,0);
        enemyTankDown = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,180);
        enemyTankLeft = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,270);
        enemyTankRight = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,90);
    }
}
