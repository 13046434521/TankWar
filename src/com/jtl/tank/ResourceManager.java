package com.jtl.tank;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author jtl
 * @date 2021/7/28 11:40
 */

public class ResourceManager {
    private final BufferedImage tankDefault;
    private final BufferedImage tankUp;
    private final BufferedImage tankDown;
    private final BufferedImage tankLeft;
    private final BufferedImage tankRight;
    private final BufferedImage[] mainTanks;

    private final BufferedImage tankBullet;
    private final BufferedImage enemyBullet;

    private final BufferedImage enemyTankDefault;
    private final BufferedImage enemyTankUp;
    private final BufferedImage enemyTankDown;
    private final BufferedImage enemyTankLeft;
    private final BufferedImage enemyTankRight;
    private final BufferedImage[] enemyTanks;

    private final BufferedImage enemyBlast0;
    private final BufferedImage enemyBlast1;
    private final BufferedImage enemyBlast2;
    private final BufferedImage enemyBlast3;
    private final BufferedImage enemyBlast4;
    private final BufferedImage enemyBlast5;
    private final BufferedImage enemyBlast6;
    private final BufferedImage enemyBlast7;
    private final ArrayList<BufferedImage> enemyBlastArrayList = new ArrayList<>();

    private final BufferedImage tankBorn0;
    private final BufferedImage tankBorn1;
    private final BufferedImage tankBorn2;
    private final BufferedImage tankBorn3;
    private final ArrayList<BufferedImage> tankBlastArrayList = new ArrayList<>();

    private ResourceManager mResourceManager;

    private ResourceManager(){
        tankDefault = ImageUtils.INSTANCE.loadImage("image/p1tankU.jpg");
        tankUp = ImageUtils.INSTANCE.rotateImage(tankDefault, 0);
        tankDown = ImageUtils.INSTANCE.rotateImage(tankDefault, 180);
        tankLeft = ImageUtils.INSTANCE.rotateImage(tankDefault, 270);
        tankRight = ImageUtils.INSTANCE.rotateImage(tankDefault, 90);
        mainTanks = new BufferedImage[]{tankUp,tankDown,tankLeft,tankRight};

        tankBullet = ImageUtils.INSTANCE.loadImage("image/tankmissile.jpg");
        enemyBullet = ImageUtils.INSTANCE.loadImage("image/enemymissile.jpg");

        enemyTankDefault = ImageUtils.INSTANCE.loadImage("image/enemy1U.jpg");
        enemyTankUp = ImageUtils.INSTANCE.rotateImage(enemyTankDefault, 0);
        enemyTankDown = ImageUtils.INSTANCE.rotateImage(enemyTankDefault, 180);
        enemyTankLeft = ImageUtils.INSTANCE.rotateImage(enemyTankDefault, 270);
        enemyTankRight = ImageUtils.INSTANCE.rotateImage(enemyTankDefault, 90);
        enemyTanks = new BufferedImage[]{enemyTankUp,enemyTankDown,enemyTankLeft,enemyTankRight};

        enemyBlast0 = ImageUtils.INSTANCE.loadImage("image/blast1.jpg");
        enemyBlast1 = ImageUtils.INSTANCE.loadImage("image/blast2.jpg");
        enemyBlast2 = ImageUtils.INSTANCE.loadImage("image/blast3.jpg");
        enemyBlast3 = ImageUtils.INSTANCE.loadImage("image/blast4.jpg");
        enemyBlast4 = ImageUtils.INSTANCE.loadImage("image/blast5.jpg");
        enemyBlast5 = ImageUtils.INSTANCE.loadImage("image/blast6.jpg");
        enemyBlast6 = ImageUtils.INSTANCE.loadImage("image/blast7.jpg");
        enemyBlast7 = ImageUtils.INSTANCE.loadImage("image/blast8.jpg");
        enemyBlastArrayList.add(0, enemyBlast0);
        enemyBlastArrayList.add(1, enemyBlast1);
        enemyBlastArrayList.add(2, enemyBlast2);
        enemyBlastArrayList.add(3, enemyBlast3);
        enemyBlastArrayList.add(4, enemyBlast4);
        enemyBlastArrayList.add(5, enemyBlast5);
        enemyBlastArrayList.add(6, enemyBlast6);
        enemyBlastArrayList.add(7, enemyBlast7);


        tankBorn0 = ImageUtils.INSTANCE.loadImage("image/born1.jpg");
        tankBorn1 = ImageUtils.INSTANCE.loadImage("image/born2.jpg");
        tankBorn2 = ImageUtils.INSTANCE.loadImage("image/born3.jpg");
        tankBorn3 = ImageUtils.INSTANCE.loadImage("image/born4.jpg");
        tankBlastArrayList.add(tankBorn0);
        tankBlastArrayList.add(tankBorn1);
        tankBlastArrayList.add(tankBorn2);
        tankBlastArrayList.add(tankBorn3);
    }

    public ArrayList<BufferedImage> getEnemyBlastArrayList() {
        return enemyBlastArrayList;
    }

    public ArrayList<BufferedImage> getTankBlastArrayList() {
        return tankBlastArrayList;
    }

    public static ResourceManager getInstance(){
        return ResourceManagerHolder.RESOURCE_MANAGER;
    }

    private static class ResourceManagerHolder{
        private static final ResourceManager RESOURCE_MANAGER = new ResourceManager();
    }
}
