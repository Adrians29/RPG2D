package entity;

import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public BufferedImage down1, center, down2, up1, up, up2, left1, left, left2, right1, right, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
