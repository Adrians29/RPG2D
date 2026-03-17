package entity;

import org.adrianegl.GamePanel;
import org.adrianegl.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));
            center = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 2.png.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/mob front view down 1.png.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyHandler.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyHandler.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyHandler.rightPressed == true) {
            direction = "right";
            x += speed;
        }

        spriteCounter++;
        if(spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gamePanel.titleSize, gamePanel.titleSize);

        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2 || spriteNum == 4) {
                    image = center;
                } else if (spriteNum == 3) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
            }
        }
        g2.drawImage(image, x, y, gamePanel.titleSize, gamePanel.titleSize, null);
    }
}
