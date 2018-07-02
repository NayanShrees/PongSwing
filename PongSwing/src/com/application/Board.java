package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements KeyListener, Runnable{

	private Paddle padO;
	private Paddle padT;
	private Ball ball;
	private JLabel playerO;
	private JLabel playerT;

	public Board(){
		setPreferredSize(new Dimension(600, 600));
		setMaximumSize(getPreferredSize());
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocusInWindow();

		padO = new Paddle(15,271);
		padT = new Paddle(578,271);
		ball = new Ball();
		playerO = new JLabel("<html><font color='#FF0000'>Player 1: " + padO.getScore() + "</font></html>");
		playerT = new JLabel("<html><font color='#FF0000'>Player 2: " + padO.getScore() + "</font></html>");
		add(playerO);
		add(playerT);
		addKeyListener(this);
		new Thread(this).start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//leave empty
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W: padO.setUp(true);
				break;
			case KeyEvent.VK_S: padO.setDown(true);
				break;
		}
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: padT.setUp(true);
				break;
			case KeyEvent.VK_DOWN: padT.setDown(true);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W: padO.setUp(false);
				break;
			case KeyEvent.VK_S: padO.setDown(false);
				break;
		}
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: padT.setUp(false);
				break;
			case KeyEvent.VK_DOWN: padT.setDown(false);
				break;
		}
	}

	@Override
	public void run() {
		while(true) {
			score();
			try {
				if(padO.isUp() == true && padO.getY() > 0){
					padO.setY(padO.getY() - 1);
				}else if(padO.isDown() == true && padO.getY() < 541){
					padO.setY(padO.getY() + 1);
				}

				if(padT.isUp() == true && padT.getY() > 0){
					padT.setY(padT.getY() - 1);
				}else if(padT.isDown() == true && padT.getY() < 541){
					padT.setY(padT.getY() + 1);
				}
				repaint();
				Thread.sleep(1);
			} catch(InterruptedException e) {
				e.getMessage();
				System.exit(0);
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(padO.getImage(), padO.getX(),padO.getY(), this);
		g.drawImage(padT.getImage(),padT.getX(), padT.getY(),this);
		g.drawImage(ball.getImage(), (int) ball.getX(),(int)ball.getY(),this);
	}

	private void score(){
		if((int) ball.getX() == 0 || (int) ball.getX() == 591){
			System.out.println(padO.getScore() + " " + padT.getScore());
			padO.setScore((int) ball.getX() == 0 ? padO.getScore() + 1 : padO.getScore());
			padT.setScore((int) ball.getX() == 591 ? padT.getScore() + 1 : padT.getScore());
			ball.setX(296);
			ball.setY(296);
			ball.randomAngle();
			playerO.setText("<html><font color='#FF0000'>Player 1: " + padO.getScore() + "</font></html>");
			playerT.setText("<html><font color='#FF0000'>Player 2: " + padT.getScore() + "</font></html>");
			add(playerO);
			add(playerT);
		}
	}
}