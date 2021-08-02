package com.jtl.tank;

import com.jtl.tank.bean.Bullet;
import com.jtl.tank.bean.Tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * @author jtl
 * @date 2021/7/27 14:44
 */

public class TankFrame extends Frame {
    private final int tankX = 400;
    private final int tankY = 600;

    private final int tankWindowsWidth = 800;
    private final int tankWindowsHeight = 600;
    private final int tankSpeed = 5;
    private Dir tankDir = Dir.DOWN;
    private final Tank mTank;
    private final Tank mEnemy;
    private final TankFrame mTankFrame;
    private boolean isMove = false;
    private ArrayList<Tank> mTanks = new ArrayList<>();
    public TankFrame() {
        init();
        mTank = new Tank(tankX, tankY, tankSpeed, tankDir, ResourceManager.tankUp, this);
        mEnemy = new Tank(400, 100, tankSpeed, tankDir, ResourceManager.enemyTankDown, this);
        Tank mEnemy1= new Tank(100, 300, tankSpeed, tankDir, ResourceManager.enemyTankDown, this);
        Tank mEnemy2= new Tank(200, 100, tankSpeed, tankDir, ResourceManager.enemyTankDown, this);
        Tank mEnemy3= new Tank(300, 100, tankSpeed, tankDir, ResourceManager.enemyTankDown, this);
        Tank mEnemy4= new Tank(500, 500, tankSpeed, tankDir, ResourceManager.enemyTankLeft, this);

        mTanks.add(mEnemy);
        mTanks.add(mEnemy1);
        mTanks.add(mEnemy2);
        mTanks.add(mEnemy3);
        mTanks.add(mEnemy4);
        mTankFrame = this;
    }

    private void init() {
        this.setResizable(false);
        this.setTitle("TankWar");
        this.setSize(tankWindowsWidth, tankWindowsHeight);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());
    }

    private Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(tankWindowsWidth, tankWindowsHeight);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, tankWindowsWidth, tankWindowsHeight);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("子弹数量:"+mTank.getBulletList().size(),0,50);
        g.drawString("坦克数量:"+mTanks.size(),0,100);


        ArrayList<Bullet> tankBulletList = mTank.getBulletList();

        for (int i = 0; i < tankBulletList.size(); i++) {
            Bullet bullet = tankBulletList.get(i);
            bullet.paint(g);
            bullet.bound();
            if (!bullet.isLive()){
                tankBulletList.remove(bullet);
            }
        }
        for (int k=0;k<mTanks.size();k++){
            Tank enemy = mTanks.get(k);
            enemy.setDir(tankDir);
            enemy.setMove(false);
            enemy.paint(g);
        }

        for (int k=0;k<mTanks.size();k++){
            Tank enemy = mTanks.get(k);
            for (int i=0;i<tankBulletList.size();i++){
                Bullet bullet = tankBulletList.get(i);
                bullet.collideWith(enemy);
            }
        }

        mTank.setDir(tankDir);
        mTank.setMove(isMove);
        mTank.paint(g);
    }

    class MyKeyListener implements KeyListener {
        private boolean bU, bD, bL, bR;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("pressed:" + e.getExtendedKeyCode() + "  " + e.getKeyChar());
            //方向变量归位

            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    bU = true;
                    bD = bL = bR = false;
                    mTank.setTankImage(ResourceManager.tankUp);
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    bD = true;
                    bU = bL = bR = false;
                    mTank.setTankImage(ResourceManager.tankDown);
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    bL = true;
                    bU = bD = bR = false;
                    mTank.setTankImage(ResourceManager.tankLeft);
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    bU = bD = bL =  false;
                    mTank.setTankImage(ResourceManager.tankRight);
                    break;
                default:
                    break;
            }

            move();
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println("released:" + e.getExtendedKeyCode());
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    bU = false;
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    bU = bD = bL =  false;
                    break;
                case KeyEvent.VK_SPACE:
                    mTank.fire();
//                    mEnemy.born();
                    break;
                default:
                    break;
            }
            move();
        }

        private void move() {
//            System.out.println(bU + " " + bD + " " + bL + " " + bR);
            if (!bU && !bD && !bL && !bR) {
                isMove = false;
            }
            if (bU && !bD && !bL && !bR) {
                tankDir = Dir.UP;
                isMove = true;
            }
            if (!bU && bD && !bL && !bR) {
                tankDir = Dir.DOWN;
                isMove = true;
            }
            if (!bU && !bD && bL && !bR) {
                tankDir = Dir.LEFT;
                isMove = true;
            }
            if (!bU && !bD && !bL && bR) {
                tankDir = Dir.RIGHT;
                isMove = true;
            }

            System.out.println(tankDir.name());
        }
    }

    public Tank getTank() {
        return mTank;
    }

    public ArrayList<Tank> getTanks() {
        return mTanks;
    }
}
