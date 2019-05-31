import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class IdPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblLab;
	private JLabel lblGender;
	private JLabel lblContactNo;
	private JLabel lblCollege;
	private JButton btnSearch;
	private JButton btnBack;
	
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	
	private JLayeredPane layeredPane;
	private JLayeredPane layeredPane_1;
	private JLayeredPane layeredPane_2;
	private JButton btnBack_1;
	private JLayeredPane layeredPane_3;
	private JLayeredPane layeredPane_4;
	private JLayeredPane layeredPane_5;
	private JLayeredPane layeredPane_6;
	/**
	 * Launch the application.
	 */
	String Name_2 = null;
	String Age_2 = null;
	String Lab_2 = null;
	String Gender_2 = null;
	String Contact_2 = null;
	String College_2 = null;
	
	String Classify = null;
	String Classify_1 = null;
	
	String IDNo_1;
	String Gender_1 = null;
	String Name_1 = null;
	String Age_1 = null;
	String Contact_1 = null;
	String College_1 = null;
	String Lab_1 = null;
	
	String Gender_0 = null;
	String Name_0 = null;
	String Age_0= null;
	String Contact_0 = null;
	String College_0 = null;
	String Lab_0 = null;
	
	private int IDNo;
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdPanel window = new IdPanel();
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
	public IdPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//LAYERED PANE...........................................................................................................................
		
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JButton btnNewEntry = new JButton("New Entry");
		
		btnNewEntry.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 22));
		btnNewEntry.setBounds(221, 82, 210, 62);
		layeredPane.add(btnNewEntry);
		
		JButton btnFindSomeone = new JButton("Find Someone");
		btnFindSomeone.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 22));
		btnFindSomeone.setBounds(225, 157, 206, 62);
		layeredPane.add(btnFindSomeone);
		
		//LAYERED PANE 1.........................................................................................................................
		layeredPane_1 = new JLayeredPane();
		//layeredPane.add(layeredPane_1);
		layeredPane_1.setBounds(0, 0, 632, 353);
		layeredPane_1.setLayout(null);
		
		btnNewEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.getContentPane().add(layeredPane_1);
				layeredPane_1.setVisible(true);
				layeredPane.setVisible(false);
			}
		});
		
		
		textField = new JTextField();
		textField.setBounds(117, 14, 202, 22);
		layeredPane_1.add(textField);
		textField.setColumns(10);
		//Name_1 = textField.getText(); 
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 52, 202, 22);
		layeredPane_1.add(textField_1);
		textField_1.setColumns(10);
		//Age_1 = textField_1.getText();
		
		String Labs[] = {"LASTEC","ISSA","ASEMIT","CFEES","DESIDOC","DIPAS","DIPR","DTRL","INMAS","SAG","SSPL"};
		
		JComboBox comboBox = new JComboBox(Labs);
		comboBox.setBounds(117, 90, 202, 22);
		layeredPane_1.add(comboBox);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 166, 202, 22);
		layeredPane_1.add(textField_2);
		textField_2.setColumns(10);
		//Contact_1 = textField.getText();
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 204, 202, 22);
		layeredPane_1.add(textField_3);
		textField_3.setColumns(10);
		//College_1 = textField_3.getText();
		//int IDNo;
		
		Connection conn = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
			Statement stmt=conn.createStatement(); 
			String selectStuff = "select idno from stdid";
			ResultSet rs=stmt.executeQuery(selectStuff);  
			while(rs.next()) {
				IDNo = rs.getInt("idno");
			} 
			//System.out.println(IDNo);
			
		}
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		
		
		JLabel lblIdNo = new JLabel("ID No. " + ++IDNo);
		lblIdNo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 38));
		lblIdNo.setLabelFor(frame);
		lblIdNo.setBounds(399, 62, 192, 100);
		layeredPane_1.add(lblIdNo);
		
		String gen[] = {"Male","Female","Other"};
		
		ButtonGroup bg = new ButtonGroup();
				
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(117, 127, 62, 25);
		layeredPane_1.add(rdbtnMale);
		rdbtnMale.setActionCommand("Male");
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(183, 127, 71, 25);
		layeredPane_1.add(rdbtnFemale);
		rdbtnFemale.setActionCommand("Female");
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(261, 127, 62, 25);
		layeredPane_1.add(rdbtnOther);
		rdbtnOther.setActionCommand("Other");
		
		bg.add(rdbtnMale);bg.add(rdbtnFemale);bg.add(rdbtnOther);
		//Gender_1 = bg.getSelection().getActionCommand();
		
		lblName = new JLabel("Name : ");
		lblName.setBounds(8, 17, 97, 22);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		layeredPane_1.add(lblName);
		
		lblAge = new JLabel("Age : ");
		lblAge.setBounds(8, 55, 97, 19);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		layeredPane_1.add(lblAge);
		
		lblLab = new JLabel("Lab : ");
		lblLab.setBounds(8, 93, 97, 19);
		lblLab.setFont(new Font("Tahoma", Font.PLAIN, 17));
		layeredPane_1.add(lblLab);
		
		lblGender = new JLabel("Gender :");
		lblGender.setBounds(8, 131, 97, 21);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		layeredPane_1.add(lblGender);
		
		lblContactNo = new JLabel("Contact :");
		lblContactNo.setBounds(8, 169, 97, 19);
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		layeredPane_1.add(lblContactNo);
		
		lblCollege = new JLabel("College : ");
		lblCollege.setBounds(8, 207, 97, 19);
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 17));
		layeredPane_1.add(lblCollege);
		
		JButton btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnSave.setBounds(104, 273, 137, 35);
		layeredPane_1.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.setVisible(true);
				layeredPane_1.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnBack.setBounds(318, 273, 137, 35);
		layeredPane_1.add(btnBack);
		
		
		
		//layeredPane_2..........................................................................................................
		
		layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(0, 0, 632, 353);
		
		String Choices[] = {"idno","name","contact"};
		
		JComboBox comboBox_1 = new JComboBox(Choices);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1.setBounds(85, 90, 96, 33);
		layeredPane_2.add(comboBox_1);
		//frame.getContentPane().add(layeredPane_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(219, 92, 301, 33);
		layeredPane_2.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		btnFindSomeone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.getContentPane().add(layeredPane_2);
				layeredPane_2.setVisible(true);
				layeredPane_1.setVisible(false);
				layeredPane.setVisible(false);
			}
		});
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnSearch.setBounds(159, 200, 135, 38);
		layeredPane_2.add(btnSearch);
		
		btnBack_1 = new JButton("Back");
		btnBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane.setVisible(true);
				layeredPane_2.setVisible(false);
				frame.getContentPane().add(layeredPane);
			}
		});
		btnBack_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnBack_1.setBounds(364, 200, 135, 38);
		layeredPane_2.add(btnBack_1);
		
		
		//layeredPane3............................................................................................................................
		
		layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBounds(0, 0, 632, 353);
		//layeredPane_1.add(layeredPane_3);
		layeredPane_3.setLayout(null);
		
		
		
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Classify = (String)comboBox_1.getSelectedItem();
				Classify_1 = textField_4.getText();
				
				//System.out.println(Classify);
				
				Connection conn = null;
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
					Statement stmt=conn.createStatement(); 
					String selectStuff =  null;
					
					if(Classify == "idno")
					{
						selectStuff = "select * from stdid where idno = '"+Classify_1+"' ";
					}
					
					if(Classify == "name")
					{
						selectStuff = "select * from stdid where name = '"+Classify_1+"' ";
					}
					
					if(Classify == "contact")
					{
						selectStuff = "select * from stdid where contact = '"+Classify_1+"' ";
					}
					
					ResultSet rs=stmt.executeQuery(selectStuff);  
					while(rs.next()) {
						IDNo_1 = Integer.toString(rs.getInt("idno"));
						Name_1 = rs.getString("name");
						Age_1 =  rs.getString("age") ;
						Contact_1 = rs.getString("contact");
						Lab_1 = rs.getString("lab");
						College_1 = rs.getString("college");
						Gender_1 = rs.getString("gender");
					} 
					//System.out.println(Contact_1);
					
				}
				catch(SQLException ex){
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("VendorError: " + ex.getErrorCode());
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				JLabel lblIdNo_1 = new JLabel("ID No. : " + IDNo_1);
				lblIdNo_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblIdNo_1.setBounds(12, 13, 141, 26);
				layeredPane_3.add(lblIdNo_1);
				
				JLabel lblName = new JLabel("Name :" + Name_1);
				lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblName.setBounds(12, 52, 289, 26);
				layeredPane_3.add(lblName);
				
				JLabel lblAge = new JLabel("Age : " + Age_1);
				lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblAge.setBounds(12, 91, 141, 26);
				layeredPane_3.add(lblAge);
				
				JLabel lblGender = new JLabel("Gender : " + Gender_1);
				lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblGender.setBounds(12, 130, 289, 26);
				layeredPane_3.add(lblGender);
				
				JLabel lblLab = new JLabel("Lab : " + Lab_1);
				lblLab.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblLab.setBounds(12, 169, 289, 26);
				layeredPane_3.add(lblLab);
				
				JLabel lblCollege = new JLabel("College : " + College_1);
				lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblCollege.setBounds(12, 208, 508, 26);
				layeredPane_3.add(lblCollege);
				
				JLabel lblContact = new JLabel("Contact : " + Contact_1);
				lblContact.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblContact.setBounds(12, 247, 289, 26);
				layeredPane_3.add(lblContact);
				
				JButton btnEdit = new JButton("EDIT");
				btnEdit.setFont(new Font("Verdana", Font.BOLD, 19));
				btnEdit.setBounds(55, 300, 110, 30);
				layeredPane_3.add(btnEdit);
				
				btnEdit.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						Connection conn = null;
						try{  
							Class.forName("com.mysql.cj.jdbc.Driver");  
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
							Statement stmt=conn.createStatement(); 
							String selectStuff = "delete from stdid where idno = '"+IDNo_1+"' ";
							stmt.executeUpdate(selectStuff);  
							
							
						}
						catch(SQLException ex){
							System.out.println("SQLException: " + ex.getMessage());
							System.out.println("VendorError: " + ex.getErrorCode());
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						
						//layeredPane_6....................................................................................................................
						
						layeredPane_6 = new JLayeredPane();
						//layeredPane.add(layeredPane_1);
						layeredPane_6.setBounds(0, 0, 632, 353);
						layeredPane_6.setLayout(null);
						
						frame.getContentPane().add(layeredPane_6, BorderLayout.CENTER);
						layeredPane_6.setVisible(true);
						layeredPane_3.setVisible(false);
						
						textField_21 = new JTextField();
						textField_21.setBounds(117, 14, 202, 22);
						layeredPane_6.add(textField_21);
						textField_21.setColumns(10);
						
						textField_22 = new JTextField();
						textField_22.setBounds(117, 52, 202, 22);
						layeredPane_6.add(textField_22);
						textField_22.setColumns(10);
						
						String Labs_2[] = {"LASTEC","ISSA","ASEMIT","CFEES","DESIDOC","DIPAS","DIPR","DTRL","INMAS","SAG","SSPL"};
						
						JComboBox comboBox_3 = new JComboBox(Labs_2);
						comboBox_3.setBounds(117, 90, 202, 22);
						layeredPane_6.add(comboBox_3);
						
						textField_23 = new JTextField();
						textField_23.setBounds(117, 166, 202, 22);
						layeredPane_6.add(textField_23);
						textField_23.setColumns(10);
						
						textField_24 = new JTextField();
						textField_24.setBounds(117, 204, 202, 22);
						layeredPane_6.add(textField_24);
						textField_24.setColumns(10);
						
						
						JLabel lblIdNo_2 = new JLabel("ID No. " + IDNo);
						lblIdNo_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 38));
						lblIdNo_2.setLabelFor(frame);
						lblIdNo_2.setBounds(399, 62, 192, 100);
						layeredPane_6.add(lblIdNo_2);
						
						String gen_2[] = {"Male","Female","Other"};
						
						ButtonGroup bg_2 = new ButtonGroup();
								
						JRadioButton rdbtnMale_1 = new JRadioButton("Male");
						rdbtnMale_1.setBounds(117, 127, 62, 25);
						layeredPane_6.add(rdbtnMale_1);
						rdbtnMale_1.setActionCommand("Male");
						
						JRadioButton rdbtnFemale_1 = new JRadioButton("Female");
						rdbtnFemale_1.setBounds(183, 127, 71, 25);
						layeredPane_6.add(rdbtnFemale_1);
						rdbtnFemale_1.setActionCommand("Female");
						
						JRadioButton rdbtnOther_1 = new JRadioButton("Other");
						rdbtnOther_1.setBounds(261, 127, 62, 25);
						layeredPane_6.add(rdbtnOther_1);
						rdbtnOther_1.setActionCommand("Other");
						
						bg_2.add(rdbtnMale_1);bg_2.add(rdbtnFemale_1);bg_2.add(rdbtnOther_1);
						//Gender_1 = bg.getSelection().getActionCommand();
						
						JLabel lblName_1 = new JLabel("Name : ");
						lblName_1.setBounds(8, 17, 97, 22);
						lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_6.add(lblName_1);
						
						JLabel lblAge_1 = new JLabel("Age : ");
						lblAge_1.setBounds(8, 55, 97, 19);
						lblAge_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_6.add(lblAge_1);
						
						JLabel lblLab_1 = new JLabel("Lab : ");
						lblLab_1.setBounds(8, 93, 97, 19);
						lblLab_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_6.add(lblLab_1);
						
						JLabel lblGender_1 = new JLabel("Gender :");
						lblGender_1.setBounds(8, 131, 97, 21);
						lblGender_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_6.add(lblGender_1);
						
						JLabel lblContactNo_1 = new JLabel("Contact :");
						lblContactNo_1.setBounds(8, 169, 97, 19);
						lblContactNo_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_6.add(lblContactNo_1);
						
						JLabel lblCollege_1 = new JLabel("College : ");
						lblCollege_1.setBounds(8, 207, 97, 19);
						lblCollege_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_6.add(lblCollege_1);
						
						JButton btnSave_1 = new JButton("Save");
						
						btnSave_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
						btnSave_1.setBounds(104, 273, 137, 35);
						layeredPane_6.add(btnSave_1);
						
						btnSave_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
							//layeredPane_1.setVisible(false);
							//frame.getContentPane().add(layeredPane_4);
								
								String IDNo_0 = Integer.toString(IDNo);
								
								
								Connection conn = null;
								try{  
									Class.forName("com.mysql.cj.jdbc.Driver");  
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
									Statement stmt=conn.createStatement();
									
									String selectStuff = "insert into stdid(idno,name,age,lab,gender,contact,college) values ( '"+IDNo_0+"' ,'"+textField_21.getText()+"','"+textField_22.getText()+"','"+(String)comboBox_3.getSelectedItem()+"','"+bg_2.getSelection().getActionCommand()+"','"+textField_23.getText()+"','"+textField_24.getText()+"')";
									stmt.executeUpdate(selectStuff);  
								
								
								}
								catch(SQLException ex){
									System.out.println("SQLException: " + ex.getMessage());
									System.out.println("VendorError: " + ex.getErrorCode());
								}
								catch (ClassNotFoundException e) {
									e.printStackTrace();
								}	
								frame.dispose();
							}
						});
						
					}
						
					
				
			});
				
				JButton btnDelete = new JButton("DELETE");
				btnDelete.setFont(new Font("Verdana", Font.BOLD, 19));
				btnDelete.setBounds(190, 300, 141, 30);
				layeredPane_3.add(btnDelete);
				
				btnDelete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						Connection conn = null;
						try{  
							Class.forName("com.mysql.cj.jdbc.Driver");  
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
							Statement stmt=conn.createStatement(); 
							String selectStuff = "delete from stdid where idno = '"+IDNo_1+"' ";
							stmt.executeUpdate(selectStuff);  
							
							
						}
						catch(SQLException ex){
							System.out.println("SQLException: " + ex.getMessage());
							System.out.println("VendorError: " + ex.getErrorCode());
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						//layeredPane.setVisible(true);
						layeredPane_3.setVisible(false);
						//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.dispose();
					}
				});
				
				JButton btnPrint = new JButton("PRINT");
				btnPrint.setFont(new Font("Verdana", Font.BOLD, 19));
				btnPrint.setBounds(361, 300, 135, 30);
				layeredPane_3.add(btnPrint);
				btnPrint.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						frame.dispose();
					}
				});
				
				//System.out.println(Contact_1);
				
				frame.getContentPane().add(layeredPane_3);
				layeredPane_3.setVisible(true);
				layeredPane_2.setVisible(false);
			}
		});
		
		//layeredPane_4............................................................................................................................
		
		layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBounds(0, 0, 632, 353);
		//layeredPane_1.add(layeredPane_3);
		layeredPane_4.setLayout(null);
				
				
		JLabel lblIdNo_2 = new JLabel("ID No. : " + IDNo);
		lblIdNo_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdNo_2.setBounds(12, 13, 141, 26);
		layeredPane_4.add(lblIdNo_2);
				
				
				
		
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				layeredPane_1.setVisible(false);
				frame.getContentPane().add(layeredPane_4);
				
				Connection conn = null;
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
					Statement stmt=conn.createStatement(); 
					String selectStuff = "insert into stdid(idno,name,age,lab,gender,contact,college) values ( '"+Integer.toString(IDNo)+"' ,'"+textField.getText()+"','"+textField_1.getText()+"','"+(String)comboBox.getSelectedItem()+"','"+bg.getSelection().getActionCommand()+"','"+textField_2.getText()+"','"+textField_3.getText()+"')";
					stmt.executeUpdate(selectStuff);  
					
					
				}
				catch(SQLException ex){
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("VendorError: " + ex.getErrorCode());
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}	
				
				Name_2 = textField.getText();
				Age_2 = textField_1.getText();
				Lab_2 = (String)comboBox.getSelectedItem();
				Gender_2 = bg.getSelection().getActionCommand();
				Contact_2 = textField_2.getText();
				College_2 = textField_3.getText();
				
				JLabel lblName_1 = new JLabel("Name :" + Name_2);
				lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblName_1.setBounds(12, 52, 289, 26);
				layeredPane_4.add(lblName_1);
				
				
				JLabel lblAge_1 = new JLabel("Age : " + Age_2);
				lblAge_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblAge_1.setBounds(12, 91, 141, 26);
				layeredPane_4.add(lblAge_1);
				
				
				JLabel lblGender_1 = new JLabel("Gender : " + Gender_2);
				lblGender_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblGender_1.setBounds(12, 130, 289, 26);
				layeredPane_4.add(lblGender_1);
				
				
				JLabel lblLab_1 = new JLabel("Lab : " + Lab_2);
				lblLab_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblLab_1.setBounds(12, 169, 289, 26);
				layeredPane_4.add(lblLab_1);
				
				
				JLabel lblCollege_1 = new JLabel("College : " + College_2);
				lblCollege_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblCollege_1.setBounds(12, 208, 508, 26);
				layeredPane_4.add(lblCollege_1);
				
				JLabel lblContact_1 = new JLabel("Contact : " + Contact_2);
				lblContact_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblContact_1.setBounds(12, 247, 289, 26);
				layeredPane_4.add(lblContact_1);
				
				JButton btnEdit_1 = new JButton("EDIT");
				btnEdit_1.setFont(new Font("Verdana", Font.BOLD, 19));
				btnEdit_1.setBounds(55, 300, 110, 30);
				layeredPane_4.add(btnEdit_1);
				
				btnEdit_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						Connection conn = null;
						try{  
							Class.forName("com.mysql.cj.jdbc.Driver");  
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
							Statement stmt=conn.createStatement(); 
							String selectStuff = "delete from stdid where idno = '"+IDNo+"' ";
							stmt.executeUpdate(selectStuff);  
							
							
						}
						catch(SQLException ex){
							System.out.println("SQLException: " + ex.getMessage());
							System.out.println("VendorError: " + ex.getErrorCode());
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						
						//layeredPane_5....................................................................................................................
						
						layeredPane_5 = new JLayeredPane();
						//layeredPane.add(layeredPane_1);
						layeredPane_5.setBounds(0, 0, 632, 353);
						layeredPane_5.setLayout(null);
						
						frame.getContentPane().add(layeredPane_5, BorderLayout.CENTER);
						layeredPane_5.setVisible(true);
						layeredPane_4.setVisible(false);
						
						textField_11 = new JTextField();
						textField_11.setBounds(117, 14, 202, 22);
						layeredPane_5.add(textField_11);
						textField_11.setColumns(10);
						
						textField_12 = new JTextField();
						textField_12.setBounds(117, 52, 202, 22);
						layeredPane_5.add(textField_12);
						textField_12.setColumns(10);
						
						String Labs_1[] = {"LASTEC","ISSA","ASEMIT","CFEES","DESIDOC","DIPAS","DIPR","DTRL","INMAS","SAG","SSPL"};
						
						JComboBox comboBox_2 = new JComboBox(Labs_1);
						comboBox_2.setBounds(117, 90, 202, 22);
						layeredPane_5.add(comboBox_2);
						
						textField_13 = new JTextField();
						textField_13.setBounds(117, 166, 202, 22);
						layeredPane_5.add(textField_13);
						textField_13.setColumns(10);
						
						textField_14 = new JTextField();
						textField_14.setBounds(117, 204, 202, 22);
						layeredPane_5.add(textField_14);
						textField_14.setColumns(10);
						
						
						JLabel lblIdNo_1 = new JLabel("ID No. " + IDNo);
						lblIdNo_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 38));
						lblIdNo_1.setLabelFor(frame);
						lblIdNo_1.setBounds(399, 62, 192, 100);
						layeredPane_5.add(lblIdNo_1);
						
						String gen_1[] = {"Male","Female","Other"};
						
						ButtonGroup bg_1 = new ButtonGroup();
								
						JRadioButton rdbtnMale_1 = new JRadioButton("Male");
						rdbtnMale_1.setBounds(117, 127, 62, 25);
						layeredPane_5.add(rdbtnMale_1);
						rdbtnMale_1.setActionCommand("Male");
						
						JRadioButton rdbtnFemale_1 = new JRadioButton("Female");
						rdbtnFemale_1.setBounds(183, 127, 71, 25);
						layeredPane_5.add(rdbtnFemale_1);
						rdbtnFemale_1.setActionCommand("Female");
						
						JRadioButton rdbtnOther_1 = new JRadioButton("Other");
						rdbtnOther_1.setBounds(261, 127, 62, 25);
						layeredPane_5.add(rdbtnOther_1);
						rdbtnOther_1.setActionCommand("Other");
						
						bg_1.add(rdbtnMale_1);bg_1.add(rdbtnFemale_1);bg_1.add(rdbtnOther_1);
						//Gender_1 = bg.getSelection().getActionCommand();
						
						JLabel lblName_1 = new JLabel("Name : ");
						lblName_1.setBounds(8, 17, 97, 22);
						lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_5.add(lblName_1);
						
						JLabel lblAge_1 = new JLabel("Age : ");
						lblAge_1.setBounds(8, 55, 97, 19);
						lblAge_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_5.add(lblAge_1);
						
						JLabel lblLab_1 = new JLabel("Lab : ");
						lblLab_1.setBounds(8, 93, 97, 19);
						lblLab_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_5.add(lblLab_1);
						
						JLabel lblGender_1 = new JLabel("Gender :");
						lblGender_1.setBounds(8, 131, 97, 21);
						lblGender_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_5.add(lblGender_1);
						
						JLabel lblContactNo_1 = new JLabel("Contact :");
						lblContactNo_1.setBounds(8, 169, 97, 19);
						lblContactNo_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_5.add(lblContactNo_1);
						
						JLabel lblCollege_1 = new JLabel("College : ");
						lblCollege_1.setBounds(8, 207, 97, 19);
						lblCollege_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						layeredPane_5.add(lblCollege_1);
						
						JButton btnSave_1 = new JButton("Save");
						
						btnSave_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
						btnSave_1.setBounds(104, 273, 137, 35);
						layeredPane_5.add(btnSave_1);
						
						JButton btnBack_1 = new JButton("Back");
						btnBack_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								
								
								
								layeredPane_4.setVisible(true);
								layeredPane_5.setVisible(false);
							}
						});
						
						btnBack_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
						btnBack_1.setBounds(318, 273, 137, 35);
						layeredPane_5.add(btnBack_1);
						
						
						btnSave_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
							//layeredPane_1.setVisible(false);
							//frame.getContentPane().add(layeredPane_4);
							
								Connection conn = null;
								try{  
									Class.forName("com.mysql.cj.jdbc.Driver");  
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
									Statement stmt=conn.createStatement(); 
									String selectStuff = "insert into stdid(idno,name,age,lab,gender,contact,college) values ('"+Integer.toString(IDNo)+"','"+textField_11.getText()+"','"+textField_12.getText()+"','"+(String)comboBox_2.getSelectedItem()+"','"+bg_1.getSelection().getActionCommand()+"','"+textField_13.getText()+"','"+textField_14.getText()+"')";
									stmt.executeUpdate(selectStuff);  
								
								
								}
								catch(SQLException ex){
									System.out.println("SQLException: " + ex.getMessage());
									System.out.println("VendorError: " + ex.getErrorCode());
								}
								catch (ClassNotFoundException e) {
									e.printStackTrace();
								}	
								frame.dispose();
							}
						});
						
					}
						
					
				
			});
				JButton btnDelete_1 = new JButton("DELETE");
				btnDelete_1.setFont(new Font("Verdana", Font.BOLD, 19));
				btnDelete_1.setBounds(190, 300, 141, 30);
				layeredPane_4.add(btnDelete_1);
				
				btnDelete_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						Connection conn = null;
						try{  
							Class.forName("com.mysql.cj.jdbc.Driver");  
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentid","root","aj@iitg1818");    
							Statement stmt=conn.createStatement(); 
							String selectStuff = "delete from stdid where idno = '"+IDNo+"' ";
							stmt.executeUpdate(selectStuff);  
							
							
						}
						catch(SQLException ex){
							System.out.println("SQLException: " + ex.getMessage());
							System.out.println("VendorError: " + ex.getErrorCode());
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						
						frame.dispose();
						
						
					}
				});
				
				JButton btnPrint_1 = new JButton("PRINT");
				btnPrint_1.setFont(new Font("Verdana", Font.BOLD, 19));
				btnPrint_1.setBounds(361, 300, 135, 30);
				layeredPane_4.add(btnPrint_1);
				btnPrint_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						frame.dispose();
					}
				});
				
				layeredPane_4.setVisible(true);
				
			}
			
		});
			
	}	
}
