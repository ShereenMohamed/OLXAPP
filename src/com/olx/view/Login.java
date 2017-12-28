package com.olx.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.olx.controller.UserService;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frame;
	private JTextField textName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		for(int s = 0 ; s < 3; s++){
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 503, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name: ");
		lblNewLabel.setBounds(30, 58, 105, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(30, 121, 105, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				  String username=textName.getText();
				  String password=passwordField.getText();
				  UserService userService = new UserService();
				  boolean r = userService.login(username, password);
				  String resultMessage =userService.getResult().getMessage();
				  
		
				 if(userService.getResult().isResult()==false) {
					 JOptionPane.showMessageDialog(frame,resultMessage, "error",JOptionPane.ERROR_MESSAGE);
					 
					  
					
					 
				 }
				  
				 else{
					 JOptionPane.showMessageDialog(frame,resultMessage);
					 try {
							Main window = new Main(username);
							window.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				
				 	 }}});
		btnLogin.setBounds(210, 208, 105, 30);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(btnLogin);
		
		textName = new JTextField();
		textName.setBounds(142, 58, 160, 28);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 125, 160, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Register window = new Register();
					window.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRegister.setBounds(343, 208, 111, 30);
		frame.getContentPane().add(btnRegister);
	}
		
}}
