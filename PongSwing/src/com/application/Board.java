package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements KeyListener, Runnable{

	private Paddle padO;
	private Paddle padT;
	private Ball ball;

	public Board(){
		setPreferredSize(new Dimension(500, 500));
		setMaximumSize(getPreferredSize());
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocusInWindow();

		padO = new Paddle(15,221);
		padT = new Paddle(478,221);
		ball = new Ball(246,246);

		addKeyListener(this);
		new Thread(this).start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	public void run() {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W && padO.getY() > 0){
			padO.setY(padO.getY() - 15);
		}else if(e.getKeyCode() == KeyEvent.VK_S && padO.getY() < 441){
			padO.setY(padO.getY() + 15);
		}

		if(e.getKeyCode() == KeyEvent.VK_UP && padT.getY() > 0){
			padT.setY(padT.getY() - 15);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN && padT.getY() < 441){
			padT.setY(padT.getY() + 15);
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//leave
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(padO.getImage(), padO.getX(),padO.getY(), this);
		g.drawImage(padT.getImage(),padT.getX(), padT.getY(),this);
		g.drawImage(ball.getImage(),ball.getX(),ball.getY(),this);
	}
}