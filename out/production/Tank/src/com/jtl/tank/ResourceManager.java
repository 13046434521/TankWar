package com.jtl.tank;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

    public static BufferedImage tankBullet;
    public static BufferedImage enemyBullet;

    public static BufferedImage enemyTankDefault;
    public static BufferedImage enemyTankUp;
    public static BufferedImage enemyTankDown;
    public static BufferedImage enemyTankLeft;
    public static BufferedImage enemyTankRight;

    public static BufferedImage enemyBlast0;
    public static BufferedImage enemyBlast1;
    public static BufferedImage enemyBlast2;
    public static BufferedImage enemyBlast3;
    public static BufferedImage enemyBlast4;
    public static BufferedImage enemyBlast5;
    public static BufferedImage enemyBlast6;
    public static BufferedImage enemyBlast7;
    public static ArrayList<BufferedImage> enemyBlastArrayList = new ArrayList<>();

    static {
        tankDefault = ImageUtils.INSTANCE.loadImage("image/p1tankU.jpg");
        tankUp = ImageUtils.INSTANCE.rotateImage(tankDefault,0);
        tankDown = ImageUtils.INSTANCE.rotateImage(tankDefault,180);
        tankLeft = ImageUtils.INSTANCE.rotateImage(tankDefault,270);
        tankRight = ImageUtils.INSTANCE.rotateImage(tankDefault,90);

        tankBullet = ImageUtils.INSTANCE.loadImage("image/tankmissile.jpg");
        enemyBullet=ImageUtils.INSTANCE.loadImage("image/enemymissile.jpg");

        enemyTankDefault = ImageUtils.INSTANCE.loadImage("image/enemy1U.jpg");
        enemyTankUp = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,0);
        enemyTankDown = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,180);
        enemyTankLeft = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,270);
        enemyTankRight = ImageUtils.INSTANCE.rotateImage(enemyTankDefault,90);

        enemyBlast0 = ImageUtils.INSTANCE.loadImage("image/blast1.jpg");
        enemyBlast1 = ImageUtils.INSTANCE.loadImage("image/blast2.jpg");
        enemyBlast2 = ImageUtils.INSTANCE.loadImage("image/blast3.jpg");
        enemyBlast3 = ImageUtils.INSTANCE.loadImage("image/blast4.jpg");
        enemyBlast4 = ImageUtils.INSTANCE.loadImage("image/blast5.jpg");
        enemyBlast5 = ImageUtils.INSTANCE.loadImage("image/blast6.jpg");
        enemyBlast6 = ImageUtils.INSTANCE.loadImage("image/blast7.jpg");
        enemyBlast7 = ImageUtils.INSTANCE.loadImage("image/blast8.jpg");
        enemyBlastArrayList.add(0,enemyBlast0);
        enemyBlastArrayList.add(1,enemyBlast1);
        enemyBlastArrayList.add(2,enemyBlast2);
        enemyBlastArrayList.add(3,enemyBlast3);
        enemyBlastArrayList.add(4,enemyBlast4);
        enemyBlastArrayList.add(5,enemyBlast5);
        enemyBlastArrayList.add(6,enemyBlast6);
        enemyBlastArrayList.add(7,enemyBlast7);
    }
}
