package com.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball {
	private BufferedImage image;
	private int x;
	private int y;


	public Ball(int x, int y){
		this.x = x;
		this.y = y;

		try{
			image = ImageIO.read(new File("./src/com/resources/Ball.png"));
		}catch(IOException e){
			System.out.println("Failed to get image \n" + e.getMessage());
		}
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
}