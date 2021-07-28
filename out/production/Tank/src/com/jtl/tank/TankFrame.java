package com.jtl.tank;

import com.jtl.tank.bean.Tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author jtl
 * @date 2021/7/27 14:44
 */

public class TankFrame extends Frame {
    private int tankX = 400;
    private int tankY = 600;

    private int tankWindowsWidth = 800;
    private int tankWindowsHeight = 600;
    private final int tankSpeed = 5;
    private Dir tankDir = Dir.DOWN;
    private Tank mTank;
    private Tank mEnemy;
    private TankFrame mTankFrame;
    private boolean isMove = false;

    public TankFrame() {
        init();
        mTank = new Tank(tankX, tankY, tankSpeed, tankDir, ResourceManager.tankUp);
        mEnemy = new Tank(0, 0, tankSpeed, tankDir, ResourceManager.enemyTankDown);

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
        if (offScreenImage==null){
            offScreenImage = this.createImage(tankWindowsWidth,tankWindowsHeight);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,tankWindowsWidth,tankWindowsHeight);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println(Thread.currentThread().getName());
        if (mTank==null||mEnemy==null){
            return;
        }
        mTank.setDir(tankDir);
        mTank.setMove(isMove);
        mTank.paint(g);

        mEnemy.setDir(tankDir);
        mEnemy.setMove(isMove);
        mEnemy.paint(g);
    }

    class MyKeyListener implements KeyListener {
        private boolean bU, bD, bL, bR;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("pressed:" + e.getExtendedKeyCode() + "  " + e.getKeyChar());
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    bU = true;
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    //d
                    bR = true;
                    break;
                default:
                    break;
            }

            move();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("released:" + e.getExtendedKeyCode());
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
                    break;
                case KeyEvent.VK_SPACE:
                    mTank.fire();
                    break;
                default:
                    break;
            }
            move();
        }

        private void move() {
            if (!bU && !bD && !bL && !bR){
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
        }
    }
}
