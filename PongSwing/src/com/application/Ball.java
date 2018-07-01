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
	private int dx;
	private int dy;

	public Ball(){
		this.x = 246;
		this.y = 246;
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
		dx = 0; dy = 0;
		while(dx == 0 || dy ==0){
			dx = random.nextInt(20 + 1 + 20) - 20;
			dy = random.nextInt(20 + 1 + 20) - 20;
			System.out.println(dx + " " + dy);
		}
		System.out.println();
		while(true) {
			try {
				bounce();
				setX(getX() + dx);
				setY(getY() + dy);
				System.out.println(dx + " " + dy);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.getMessage();
				System.exit(0);
			}
		}
	}

	public void bounce(){
		int temp = 0;
		if(getY() == 0 || getY() == 491){
			temp = dx;
			dx = dy;
			dy = temp;
		}
		if(getX() == 0 || getX() == 491){
			temp = dx;
			dx = dy;
			dy = temp;
		}
	}
}