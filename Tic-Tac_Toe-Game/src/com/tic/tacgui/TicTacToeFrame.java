package com.tic.tacgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeFrame extends JFrame implements ActionListener {

	Random rand = new Random();

	JPanel titlepanel = new JPanel();
	JPanel buttonpanel = new JPanel();
	JLabel text = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1turn;

	public TicTacToeFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(800, 800);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(50, 50, 50));
		setVisible(true);

		// text
		text.setBackground(new Color(25, 25, 25));
		text.setForeground(new Color(25, 255, 0));
		text.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Tic-Tac-Toe");
		text.setOpaque(true);

		// panel in north for title of game
		titlepanel.setLayout(new BorderLayout());
		titlepanel.setBounds(0, 0, 800, 100);

		// button panel for buttons of x & o

		buttonpanel.setLayout(new GridLayout(3, 3)); // like calculator
		buttonpanel.setBackground(new Color(150, 150, 150));

		// buttons array

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();

			buttonpanel.add(buttons[i]);
			buttons[i].setFont(new Font("Times Roman", Font.BOLD, 120));
			buttons[i].setFocusable(false);

			buttons[i].addActionListener(this);

		}

		titlepanel.add(text);
		super.add(titlepanel, BorderLayout.NORTH);
		super.add(buttonpanel);

		// first turn method

		firstturn();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 9; i++) {

			if (e.getSource() == buttons[i]) {
				if (player1turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1turn = false;
						text.setText("O Turn");
					}
				} else {

					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1turn = true;
						text.setText("X Turn");

						check();
					}

				}
			}

		}

	}

//
	// hose turn method
//	

	public void firstturn() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// first turn logic

		if (rand.nextInt(2) == 0) {
			player1turn = true;
			text.setText("X Turn");
		} else {
			player1turn = false;
			text.setText("O Turn");
		}

	}

//
	// winning condition
//	

	public void check() {

		// check x cond

		if ((buttons[0].getText() == "X") && buttons[1].getText() == "X" && buttons[2].getText() == "X") {

			xWins(0, 1, 2);

		}
		if ((buttons[3].getText() == "X") && buttons[4].getText() == "X" && buttons[5].getText() == "X") {

			xWins(3, 4, 5);

		}

		if ((buttons[6].getText() == "X") && buttons[7].getText() == "X" && buttons[8].getText() == "X") {

			xWins(6, 7, 8);

		}
		if ((buttons[0].getText() == "X") && buttons[3].getText() == "X" && buttons[6].getText() == "X") {

			xWins(0, 3, 6);

		}
		if ((buttons[1].getText() == "X") && buttons[4].getText() == "X" && buttons[7].getText() == "X") {

			xWins(1, 4, 7);

		}

		if ((buttons[2].getText() == "X") && buttons[5].getText() == "X" && buttons[8].getText() == "X") {

			xWins(2, 5, 8);

		}

		if ((buttons[0].getText() == "X") && buttons[4].getText() == "X" && buttons[8].getText() == "X") {

			xWins(0, 4, 8);

		}
		if ((buttons[2].getText() == "X") && buttons[4].getText() == "X" && buttons[6].getText() == "X") {

			xWins(2, 4, 6);

		}

//check o cond

		if ((buttons[0].getText() == "O") && buttons[1].getText() == "O" && buttons[2].getText() == "O") {

			oWins(0, 1, 2);

		}
		if ((buttons[3].getText() == "O") && buttons[4].getText() == "O" && buttons[5].getText() == "O") {

			oWins(3, 4, 5);

		}

		if ((buttons[6].getText() == "O") && buttons[7].getText() == "O" && buttons[8].getText() == "O") {

			oWins(6, 7, 8);

		}
		if ((buttons[0].getText() == "O") && buttons[3].getText() == "O" && buttons[6].getText() == "O") {

			oWins(0, 3, 6);

		}
		if ((buttons[1].getText() == "O") && buttons[4].getText() == "O" && buttons[7].getText() == "O") {

			oWins(1, 4, 7);

		}

		if ((buttons[2].getText() == "O") && buttons[5].getText() == "O" && buttons[8].getText() == "O") {

			oWins(2, 5, 8);

		}

		if ((buttons[0].getText() == "O") && buttons[4].getText() == "O" && buttons[8].getText() == "O") {

			oWins(0, 4, 8);

		}
		if ((buttons[2].getText() == "O") && buttons[4].getText() == "O" && buttons[6].getText() == "O") {

			oWins(2, 4, 6);

		}

	}
//
	// x winning logic
//	

	public void xWins(int a, int b, int c) {

		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);

		}

		text.setText("X Wins :) ");

	}
//
	// o winning logic
//	

	public void oWins(int a, int b, int c) {

		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);

		}

		text.setText("O Wins :( ");

	}

}
