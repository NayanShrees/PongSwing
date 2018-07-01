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
		ball = new Ball();

		addKeyListener(this);
		new Thread(this).start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W: padO.setUp(true); break;
			case KeyEvent.VK_S: padO.setDown(true); break;
		}
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: padT.setUp(true); break;
			case KeyEvent.VK_DOWN: padT.setDown(true); break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W: padO.setUp(false); break;
			case KeyEvent.VK_S: padO.setDown(false); break;
		}
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: padT.setUp(false); break;
			case KeyEvent.VK_DOWN: padT.setDown(false); break;
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(padO.isUp() == true && padO.getY() > 0){
					padO.setY(padO.getY() - 15);
				}else if(padO.isDown() == true && padO.getY() < 441){
					padO.setY(padO.getY() + 15);
				}

				if(padT.isUp() == true && padT.getY() > 0){
					padT.setY(padT.getY() - 15);
				}else if(padT.isDown() == true && padT.getY() < 441){
					padT.setY(padT.getY() + 15);
				}
				repaint();
				Thread.sleep(100);
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
		g.drawImage(ball.getImage(),ball.getX(),ball.getY(),this);
	}
}