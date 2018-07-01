package com.application;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	public static void main(String[] args) {
		new Main().run();
	}

	public void run(){
		setSize(new Dimension(500,500));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Pong");
		add(new Board());
		pack();
		setVisible(true);
	}
}
