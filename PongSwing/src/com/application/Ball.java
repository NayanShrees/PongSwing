package com.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Ball implements Runnable{
	private BufferedImage image;
	private int x;
	private int y;
	private double angle;

	public Ball(){
		this.x = 296;
		this.y = 296;
		dx = 0;
		dy = 0;
		try{
			image = ImageIO.read(new File("./src/com/resources/Ball.png"));
		}catch(IOException e){
			System.out.println("Failed to get image \n" + e.getMessage());
		}
		new Thread(this).start();
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void run() {
		Random random = new Random();
		while(angle == 0 || angle == 90 || angle == 180 || angle == 270 || angle == 360){
			angle = random.nextInt(360 + 1);
		}
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.getMessage();
				System.exit(0);
			}
		}
	}
}