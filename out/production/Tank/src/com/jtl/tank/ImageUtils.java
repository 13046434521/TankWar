package com.jtl.tank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author jtl
 * @date 2021/7/28 10:54
 */

public enum ImageUtils {
    /**
     * 枚举单例模式
     */
    INSTANCE;

    public BufferedImage loadImage(String path) {
        try {
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            BufferedImage bufferedImage = ImageIO.read(inputStream);

            Assertions.assertNotNull(bufferedImage);

            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public BufferedImage rotateImage(BufferedImage image, int degree) {
        int width = image.getWidth();
        int height = image.getHeight();
        int type = image.getColorModel().getTransparency();
        BufferedImage img = new BufferedImage(width, height, type);
        Graphics2D graphics2D = img.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.rotate(Math.toRadians(degree), width / 2, height / 2);
        graphics2D.drawImage(image, 0, 0, null);
        graphics2D.dispose();
        return img;

    }

}
