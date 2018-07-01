package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel {

	private Paddle padO;
	private Paddle padT;
	private Ball ball;

	public Board(){
		setSize(new Dimension(500,500));
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocusInWindow();

		padO = new Paddle(10,215);
		padT = new Paddle(467,215);
		ball = new Ball(246,246);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W){
					padO.setY(padO.getY() - 10);
				}else if(e.getKeyCode() == KeyEvent.VK_S){
					padO.setY(padO.getY() + 10);
				}

				if(e.getKeyCode() == KeyEvent.VK_UP){
					padT.setY(padT.getY() - 10);
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					padT.setY(padT.getY() + 10);
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(padO.getImage(), padO.getX(),padO.getY(), this);
		g.drawImage(padT.getImage(),padT.getX(), padT.getY(),this);
		g.drawImage(ball.getImage(),ball.getX(),ball.getY(),this);
	}
}