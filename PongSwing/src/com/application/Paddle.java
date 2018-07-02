package com.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Paddle {

	private BufferedImage image;
	private int x;
	private int y;
	private boolean up;
	private boolean down;
	private int score;

	public Paddle(int x, int y){
		this.x = x;
		this.y = y;
		up = false;
		down = false;
		score = 0;
		try{
			image = ImageIO.read(new File("./src/com/resources/Pad.png"));
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

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}