package com.olx.view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.olx.controller.CategoryDao;
import com.olx.controller.CategoryService;
import com.olx.controller.ProductService;
import com.olx.controller.Datee;
import com.olx.controller.UserDao;
import com.olx.controller.UserService;
import com.olx.model.Category;
import com.olx.model.CategoryDtoRes;
import com.olx.model.Product;
import com.olx.model.User;
import com.olx.model.UserDtoRes;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AddProduct extends JFrame {
	JFrame frame1;
	private JTextField Name;
	private JTextField Price;
	private JLabel im;
	private JTextField datee;
	private JTextArea Descreption;
	private JButton btnNewButton;
	private JTable table;
	private String path;
	private Category category;
	private String selectedData = null;
	private User user;
	 String usr;
	 private JPanel contentPane;
	
	public AddProduct() {

	}
	
	



		
		
		
	public AddProduct ( String st) {
		
		 
		 	usr=st;
			

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 676, 483);
			contentPane = new JPanel();


		String title = "AddProduct";
		Border border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
			
			//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			

			JButton btnChoosefile = new JButton("ChooseFile");
			   
			btnChoosefile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 JFileChooser file = new JFileChooser();
			          file.setCurrentDirectory(new File(System.getProperty("user.home")));
			          //filter the files
			          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
			          file.addChoosableFileFilter(filter);
			          int result = file.showSaveDialog(null);
			           //if the user click on save in Jfilechooser
			          if(result == JFileChooser.APPROVE_OPTION){
			              File selectedFile = file.getSelectedFile();
			               path = selectedFile.getAbsolutePath();
			               im.setIcon(ResizeImage(path));
			          }
			           //if the user  dont click on save in Jfilechooser


			          else if(result == JFileChooser.CANCEL_OPTION){
			              System.out.println("No File Select");
			          }
				}
			});
			


			btnChoosefile.setBounds(341, 7, 115, 34);
			contentPane.add(btnChoosefile);
		 
			JLabel username = new JLabel(usr);
			username.setBounds(89, 7, 128, 18);
			contentPane.add(username);
			
			JLabel lblNewLabel_1 = new JLabel("Name");
			lblNewLabel_1.setBounds(22, 36, 46, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Date");
			lblNewLabel_2.setBounds(22, 61, 46, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Price");
			lblNewLabel_3.setBounds(22, 86, 46, 14);
			contentPane.add(lblNewLabel_3);
			
		    JLabel lblNewLabel_5 = new JLabel("Descreption");
			lblNewLabel_5.setBounds(22, 103, 88, 20);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_7 = new JLabel("Category");
			lblNewLabel_7.setBounds(22, 269, 57, 14);
			contentPane.add(lblNewLabel_7);
			
			Name = new JTextField();
			Name.setBounds(89, 33, 128, 20);
			contentPane.add(Name);
			Name.setColumns(10);
			
			Price = new JTextField();
			Price.setBounds(89, 83, 128, 20);
			contentPane.add(Price);
			Price.setColumns(10);
			
			
			String dat=Datee.currentDate();
			datee = new JTextField(dat);
			datee.setBounds(89, 58, 128, 20);
			contentPane.add(datee);
			datee.setColumns(10);
			datee.setEnabled(false);
			


			 
		  

				 Descreption = new JTextArea(3,3);
				  
		        JScrollPane scrollableTextArea = new JScrollPane(Descreption);  
		        scrollableTextArea.setBounds(89, 127, 128, 112);
		        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		  
		        contentPane.add(scrollableTextArea);  
			 
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(89, 245, 121, 81);
			contentPane.add(scrollPane);
			
			Set<Category> categories = new HashSet<Category>();
			CategoryService categoryService = new CategoryService();
			categories=categoryService.ListOfCategories();
			 Vector data = new Vector();
		     Vector row = null;
		     table = new JTable(new DefaultTableModel(
		    			new Object[][] {
		    			},
		    			new String[] {
		    			"Category Name"
		    			}
		    		));
		     table.setCellSelectionEnabled(true);
		     for(Category categ : categories){
		    	 row = new Vector(2);
		       
		         row.add(categ.getName());
		         ((DefaultTableModel)table.getModel()).addRow(row);
		     }
		  
		     ListSelectionModel cellSelectionModel = table.getSelectionModel();
		     cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		     cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		    
		    	 	public void valueChanged(ListSelectionEvent e) {
		    	 		selectedData = table.getValueAt(table.getSelectedRow(), 0).toString();
		    	 		
		    	 	    
		    	 	}
					     });
					scrollPane.setViewportView(table);
		      
					btnNewButton = new JButton("PostProduct");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
					  String name=Name.getText();				  
					  double price= Double.parseDouble(Price.getText());
					  String image=im.getText();
					  String date = datee.getText();
					  String descreption= Descreption.getText();
					  
			    	   CategoryDao cat =new CategoryDao();
			    	   CategoryDtoRes catt =cat.find(selectedData);
			    	   category = catt.getCategory();
			    
					   UserDao userr =new UserDao();
					   UserDtoRes u = userr.find(usr);
					   user = u.getUser();
					
						  ProductService productservice = new ProductService();
						  
						  Product product = new Product(name,date,price,category,descreption,user,image);
						  boolean r = productservice.AddProduct(product);
						  String resultMessage =productservice.getResult().getMessage();
						 if(productservice.getResult().isResult()==false) 
							 JOptionPane.showMessageDialog(frame1,resultMessage, "error",JOptionPane.ERROR_MESSAGE);
						 else{
							 JOptionPane.showMessageDialog(frame1,resultMessage);
							 try {
		        					PostProduct window = new PostProduct(usr,name,date,price,selectedData,descreption,user,path,user.getCity(),user.getPhone(),user.getAddress());
									window.setVisible(true);
								} catch (Exception ex) {
									ex.printStackTrace();
								}
						 }
					}
					   
				});

			btnNewButton.setBounds(441, 376, 109, 34);
			contentPane.add(btnNewButton);
			
			 im = new JLabel("");
			 im.setBounds(310, 52, 240, 247);
			 contentPane.add(im);
			

			JButton btnNewButton_1 = new JButton("Main");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					try {
						Main window = new Main(usr);
						window.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
				}
			});
			btnNewButton_1.setBounds(303, 376, 109, 34);
			contentPane.add(btnNewButton_1);
			

			JButton btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					System.exit(0);
					
				}
			});
			btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnLogout.setBounds(10, 376, 109, 34);
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


		
	}

