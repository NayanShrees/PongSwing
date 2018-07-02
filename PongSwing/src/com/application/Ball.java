package com.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Ball implements Runnable{
	private BufferedImage image;
	private double x;
	private double y;
	private double angle;
	private int scoreO;
	private int scoreT;

	public Ball(){
		this.x = 296;
		this.y = 296;
		scoreO = 0;
		scoreT = 0;

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

	public int getScoreO() {
		return scoreO;
	}

	public void setScoreO(int scoreO) {
		this.scoreO = scoreO;
	}

	public int getScoreT() {
		return scoreT;
	}

	public void setScoreT(int scoreT) {
		this.scoreT = scoreT;
	}

	@Override
	public void run() {
		randomAngle();
		while(true) {
			try {
				bound();
				setY(getY() - Math.cos(Math.toRadians(angle)));
				setX(getX() + Math.sin(Math.toRadians(angle)));
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.getMessage();
				System.exit(0);
			}
		}
	}

	public void randomAngle(){
		Random random = new Random();
		this.angle = 0;
		while(angle == 0 || angle == 90 || angle == 180 || angle == 270 || angle == 360){
			angle = random.nextInt(360 + 1);
		}
	}

	private void bound(){
		if(((int) getY() == 0 || (int) getY() == 591)){
			angle = 180 - angle;
		}
		if((int) getX() == 0 || (int) getX() == 591){
			if((int) getX() == 0){
				setScoreO(getScoreO() + 1);
			}else{
				setScoreT(getScoreT() + 1);
			}
			setX(296);
			setY(296);
			randomAngle();
		}
	}
}