package com.oasis.login.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	// create jFrame with radioButton and JButton
	public OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Ques1:  Java is developed by?");
			radioButton[0].setText("James Gosling");
			radioButton[1].setText("Dennis Ritchie");
			radioButton[2].setText("Steve Jobs");
			radioButton[3].setText("Ken Thompson");
		}
		if (current == 1) {
			label.setText("Ques2:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 2) {
			label.setText("Ques3: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (current == 3) {
			label.setText("Ques4: Which is the new method introduced in java 8 to iterate over a collection?");
			radioButton[0].setText("for (String i : StringList)");
			radioButton[1].setText("foreach (String i : StringList)");
			radioButton[2].setText("StringList.forEach()");
			radioButton[3].setText("List.for()");
		}
		if (current == 4) {
			label.setText("Ques5:  Java is: ");
			radioButton[0].setText("Platform Dependent");
			radioButton[1].setText("Platform Indepenedent");
			radioButton[2].setText("None");
			radioButton[3].setText("All of the above");
		}
		if (current == 5) {
			label.setText("Ques6: How to read entire file in one line using java 8?");
			radioButton[0].setText("Files.readAllLines()");
			radioButton[1].setText("Files.read()");
			radioButton[2].setText("Files.readFile()");
			radioButton[3].setText("Files.lines()");
		}
		if (current == 6) {
			label.setText("Ques7:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 7) {
			label.setText("Ques8:  Which of the following is not a core interface of Hibernate?");
			radioButton[0].setText("Configuration");
			radioButton[1].setText("Criteria");
			radioButton[2].setText("SessionManagement");
			radioButton[3].setText("Session");
		}
		if (current == 8) {
			label.setText("Ques9: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (current == 9) {
			label.setText("Ques10: Technical Name of Core Java is knon as:");
			radioButton[0].setText("JSE");
			radioButton[1].setText("JEE");
			radioButton[2].setText("J2EE");
			radioButton[3].setText("J2SE");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

//	public static void main(String s[]) {
//		new OnlineTest("Online Examination Test App");
//	}

}