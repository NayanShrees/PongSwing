package com.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ball{

	private BufferedImage image;
	private double x;
	private double y;
	private double angle;

	public Ball(){
		this.x = 296;
		this.y = 296;

		try{
			image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("com/resources/Ball.png"));
		}catch(IOException e){
			System.out.println("Failed to get image \n" + e.getMessage());
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}