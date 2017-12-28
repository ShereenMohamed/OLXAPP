package com.olx.view;


import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.olx.model.User;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PostProduct extends JFrame {

	private JFrame frame1;
	private JLabel im;
	private JButton btnNewButton;
	private JPanel contentPane;
	String st;
public PostProduct(String stt,String name, String date, double price,String category, String descreption,User user,
		String image,String city,int phone,String address) {
	initialize();
st=stt;
    JLabel username = new JLabel(st);
	username.setBounds(89, 7, 128, 18);
	contentPane.add(username);
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setBounds(22, 36, 46, 14);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Date");
	lblNewLabel_2.setBounds(22, 63, 46, 14);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Price");
	lblNewLabel_3.setBounds(22,88, 46, 14);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_5 = new JLabel("Category");
	lblNewLabel_5.setBounds(22, 113, 62, 20);
	contentPane.add(lblNewLabel_5);

	JLabel lblNewLabel_7 = new JLabel("Descreption");
	lblNewLabel_7.setBounds(24, 266, 75, 14);
	contentPane.add(lblNewLabel_7);
	
	JLabel lblNewLabel_8= new JLabel(name);
	lblNewLabel_8.setBounds(109, 36, 128, 20);
	contentPane.add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel(date);
	lblNewLabel_9.setBounds(109, 63, 128, 15);
	contentPane.add(lblNewLabel_9);
	
	JLabel lblNewLabel_10 = new JLabel(String.valueOf(price));
	lblNewLabel_10.setBounds(109, 85, 148, 20);
	contentPane.add(lblNewLabel_10);
	
	
	JLabel lblNewLabel_11 = new JLabel(descreption);
	lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
	lblNewLabel_11.setBounds(109, 266, 424, 52);
	contentPane.add(lblNewLabel_11);
	

	JLabel lblNewLabel_4 = new JLabel(category);
	lblNewLabel_4.setBounds(108, 114, 109, 18);
	contentPane.add(lblNewLabel_4);
	
	 im = new JLabel(image);
	 im.setBounds(276, 16, 309, 216);
	 contentPane.add(im);
	 im.setIcon(ResizeImage(image));
	 

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(22, 144, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblCity_1 = new JLabel(city);
		lblCity_1.setBounds(109, 143, 84, 14);
		contentPane.add(lblCity_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(22, 169, 55, 14);
		contentPane.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel(address);
		lblAddress_1.setBounds(109, 168, 84, 14);
		contentPane.add(lblAddress_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(22, 194, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblNewLabel = new JLabel(String.valueOf(phone));
		lblNewLabel.setBounds(109, 193, 84, 14);
		contentPane.add(lblNewLabel);
	   
	
	btnNewButton = new JButton("Main");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				Main window = new Main(st);
				window.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

                    }
			
		
	});

	btnNewButton.setBounds(470, 329, 115, 23);
	contentPane.add(btnNewButton);
	

	JButton btnLogout = new JButton("Logout");
	btnLogout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			System.exit(0);
			
		}
	});
	btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnLogout.setBounds(10, 329, 115, 23);
	contentPane.add(btnLogout);
	
	

}
public ImageIcon ResizeImage(String ImagePath)
{
    ImageIcon MyImage = new ImageIcon(ImagePath);
    Image img = MyImage.getImage();

    Image newImg = img.getScaledInstance(im.getWidth(), im.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

	 void initialize() {
			

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 634, 393);
			contentPane = new JPanel();


		String title = "Post Product";
		Border border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
			
			//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		
		
	 }
		
}

