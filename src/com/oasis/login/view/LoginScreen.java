package com.oasis.login.view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.oasis.login.test.OnlineTest;



public class LoginScreen{

	public JFrame userViewFrame;
	public JTextField usernameField;
	private JPasswordField passwordField;
	public JButton loginButton;
	public JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		LoginScreen window = new LoginScreen();
		window.userViewFrame.setVisible(true);
	}
	
	public boolean validateLogin(String username, String password) {
      return username.equals("user111") && password.equals("password");
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userViewFrame = new JFrame();
		userViewFrame.setBackground(new Color(255, 255, 255));
		userViewFrame.setResizable(false);
		userViewFrame.setTitle("Online Test");
		userViewFrame.getContentPane().setBackground(new Color(240, 248, 255));
		userViewFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblNewLabel.setBounds(110, 32, 209, 44);
		userViewFrame.getContentPane().add(lblNewLabel);
		
		JLabel userIdlbl = new JLabel("UserId :");
		userIdlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		userIdlbl.setFont(new Font("PT Sans", Font.BOLD, 16));
		userIdlbl.setBounds(40, 58, 83, 56);
		userViewFrame.getContentPane().add(userIdlbl);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("PT Sans", Font.BOLD, 16));
		lblPassword.setBounds(40, 177, 83, 16);
		userViewFrame.getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("Enter your username here..");
		usernameField.setName("");
		usernameField.setActionCommand("");
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		usernameField.setColumns(10);
		usernameField.setBorder(new LineBorder(Color.BLACK, 1, true));
		usernameField.setBounds(147, 60, 227, 49);
		userViewFrame.getContentPane().add(usernameField);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
		          String password = new String(passwordField.getPassword());
		
		          if (validateLogin(username, password)) {
		        	  OnlineTest onlineTest = new OnlineTest("Online Examination Test App");
						onlineTest.setVisible(true);
		        	  userViewFrame.setVisible(false);
		        	  userViewFrame.dispose();
		          	
		          } else {
		              JOptionPane.showMessageDialog(null, "Invalid login credentials. Exiting...");
		          }
			}
		});
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		loginButton.setBounds(91, 245, 125, 35);
		userViewFrame.getContentPane().add(loginButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cancelButton.setBounds(232, 245, 125, 35);
		userViewFrame.getContentPane().add(cancelButton);

		
		JLabel userlbl = new JLabel("");
		userlbl.setHorizontalAlignment(SwingConstants.CENTER);
		userlbl.setBounds(456, 27, 250, 275);
		userViewFrame.getContentPane().add(userlbl);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your PassKey");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		passwordField.setBounds(147, 160, 227, 49);
		userViewFrame.getContentPane().add(passwordField);
		userViewFrame.setBounds(100, 100, 473, 360);
		userViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
