package com.jtl.tank;

/**
 * @author jtl
 * @date 2021/7/27 16:30
 */

class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame  =  new TankFrame();
        while (true){
            Thread.sleep(10);
            tankFrame.repaint();
        }
    }
}
