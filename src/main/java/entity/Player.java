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
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gamePanel.titleSize, gamePanel.titleSize);

        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                image = up1;
            }
            case "down" -> {
                image = down1;
            }
            case "left" -> {
                image = left1;
            }
            case "right" -> {
                image = right1;
            }
        }
        g2.drawImage(image, x, y, gamePanel.titleSize, gamePanel.titleSize, null);
    }
}
