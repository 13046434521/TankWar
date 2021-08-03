package com.jtl.tank.bean;

import java.awt.Graphics;

/**
 * @author jtl
 * @date 2021/7/27 16:31
 */

interface Action {
    /**
     * 渲染方法
     * @param graphics
     */
    void paint(Graphics graphics);

    /**
     * 死亡方法
     */
    void die();
}
