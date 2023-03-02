import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class U2A1 extends JFrame {

	private JPanel contentPane;
	private DB database;

	/**
	 * Launch the application here.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
						U2A1 frame = new U2A1();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	/**
	 * Create the frame GUI components.
	 */
	public U2A1() {
		
		//Setup the JFrame GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Connection label
		JLabel lblConnect = new JLabel("Connect");
		lblConnect.setBounds(14, 52, 57, 20);
		
		//Add to the GUI
		contentPane.add(lblConnect);
		
		//Connection button
		JButton btnConnect = new JButton("Connect to DB");
		btnConnect.setBounds(117, 49, 387, 26);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
					String dbURL =
			                		"jdbc:sqlserver://NB69004BOB\\SQLEXPRESS;"
			                        + "database=Northwind;"
			                        + "user=sa;"
			                        + "password=123456;"
			                        + "encrypt=false;"
			                        + "trustServerCertificate=false;"
			                        + "loginTimeout=30;";
				
						
						database = new DB(dbURL);
						
						JOptionPane.showMessageDialog(null, "Connection string set");			
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}//end try/catch
	
			}//end actionPerformed
		});//end actionListener

		//Add to the GUI
		contentPane.add(btnConnect);
		
		
		//Count label
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(14, 122, 57, 20);
		
		//Add to the GUI
		contentPane.add(lblCount);
		
		//Count query
		JButton btnCount = new JButton("Customer Count");
		btnCount.setBounds(117, 119, 387, 26);
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
						String returnedValue = database.getCustomerCount();
						
						JOptionPane.showMessageDialog(null, "The customer count is: " + returnedValue);
														
				} catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());	
				}//end try/catch

			}//end actionPerformed
		});//end actionListener

		//Add to the GUI
		contentPane.add(btnCount);
	
		
		//Company names label
		JLabel lblNames = new JLabel("Names");
				lblNames.setBounds(14, 192, 57, 20);
				
		//Add to the GUI
		contentPane.add(lblNames);
				
		//Company names query
		JButton btnNames = new JButton("Get Company Names");
		btnNames.setBounds(117, 189, 387, 26);
		btnNames.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
							
							String returnedValue = database.getCompanyNames();
								
							JOptionPane.showMessageDialog(null, "Customer names: " + returnedValue);
																
					} catch(Exception e){
							JOptionPane.showMessageDialog(null, e.getMessage());	
					}//end try/catch

				}//end actionPerformed
			});//end actionListener

		//Add to the GUI
		contentPane.add(btnNames);
		
		/**
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(14, 262, 57, 20);
		contentPane.add(lblUser);
		
        JTextField tfUser = new JTextField(20);
        tfUser.setBounds(117, 259, 387, 26);
        //lblUser.setLabelFor(tfUser);
        contentPane.add(tfUser);
        
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(14, 332, 57, 20);
        contentPane.add(lblPassword);
        
        final JPasswordField pfPassword = new JPasswordField(20);
        pfPassword.setBounds(117, 329, 387, 26);
        //lblPassword.setLabelFor(pfPassword);
        contentPane.add(pfPassword);
 
        JButton btnGet = new JButton("Login");
        btnGet.setBounds(14, 402, 157, 20);
        btnGet.addActionListener(
                new ActionListener() {
 
                    public void actionPerformed(ActionEvent e) {
                        String password = new String(pfPassword.getPassword());
                        JOptionPane.showMessageDialog(null,
                                "Password is " + password);
                    }
                });
 
        contentPane.add(btnGet);
        
        **/
       
	
				
	}//end U2A1

}//end class
