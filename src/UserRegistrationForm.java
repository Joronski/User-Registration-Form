/* Project Made by Recio's Group for MIDTERM WEEK 10 HANDS-ON CODING EXERCISE CCS103 COMPUTER PROGRAMMING 2

Group Members:

Joaquin Aaron P. Recio - Lead Programmer
Anne Galzeleigh L. Eliang - Co-Lead Programmer
Kirsten Joi A. Lazarte - Member 
Jaymart G. Impas - Member
John Henrics L. Mateo - Member
Brenda Lazado - Member
Jennelyn N. Magtibay - Member
Marc Alvin P. Quitorio - Member
Kim Francis O. Dela Cruz - Member
Julius L. Natividad - Member

MIDTERM WEEK 10 HANDS-ON CODING EXERCISE (© 2024 RECIO) */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UserRegistrationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldFirstName;
	private JTextField txtFldLastName;
	private JTextField txtFldEmail;
	private JPasswordField pwFldPassword;
	private JPasswordField pwFldConfirmPassword;
	private JLabel lblTitleForm;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JButton btnRegister;
	private JButton btnShowHidePassword1;
	private JButton btnShowHidePassword2;
	private JTextArea txtARegisteredUsers;
	private boolean passwordHidden = true; // Variable to track if password is hidden
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistrationForm frame = new UserRegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserRegistrationForm() {
		setTitle("Recio's Group User Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(23, 156, 82));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitleForm = new JLabel("Recio's Group User Registration Form");
		lblTitleForm.setForeground(new Color(255, 255, 255));
		lblTitleForm.setFont(new Font("Orator Std", Font.BOLD, 13));
		lblTitleForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleForm.setBounds(10, 10, 402, 25);
		contentPane.add(lblTitleForm);
		
		lblFirstName = new JLabel("First Name: ");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setBounds(236, 38, 72, 14);
		contentPane.add(lblFirstName);
		
		txtFldFirstName = new JTextField();
		txtFldFirstName.setBounds(236, 53, 143, 20);
		contentPane.add(txtFldFirstName);
		txtFldFirstName.setColumns(10);
		
		lblLastName = new JLabel("Last Name: ");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setBounds(53, 38, 72, 14);
		contentPane.add(lblLastName);
		
		txtFldLastName = new JTextField();
		txtFldLastName.setBounds(53, 53, 143, 20);
		contentPane.add(txtFldLastName);
		txtFldLastName.setColumns(10);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(53, 80, 46, 14);
		contentPane.add(lblEmail);
		
		txtFldEmail = new JTextField();
		txtFldEmail.setBounds(53, 95, 326, 20);
		contentPane.add(txtFldEmail);
		txtFldEmail.setColumns(10);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(53, 126, 72, 14);
		contentPane.add(lblPassword);
		
		pwFldPassword = new JPasswordField();
		pwFldPassword.setEchoChar('*');
		pwFldPassword.setBounds(53, 141, 231, 20);
		contentPane.add(pwFldPassword);
		
		btnShowHidePassword1 = new JButton("Show");
		btnShowHidePassword1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show password if toggled
				togglePasswordVisibility(pwFldPassword, btnShowHidePassword1);
			}
		});
		btnShowHidePassword1.setBounds(290, 140, 89, 23);
		contentPane.add(btnShowHidePassword1);
		
		lblConfirmPassword = new JLabel("Confirm Password: ");
		lblConfirmPassword.setForeground(new Color(255, 255, 255));
		lblConfirmPassword.setBounds(53, 172, 143, 14);
		contentPane.add(lblConfirmPassword);
		
		pwFldConfirmPassword = new JPasswordField();
		pwFldConfirmPassword.setEchoChar('*');
		pwFldConfirmPassword.setBounds(53, 187, 231, 20);
		contentPane.add(pwFldConfirmPassword);
		
		btnShowHidePassword2 = new JButton("Show");
		btnShowHidePassword2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show confirm password if toggled
				togglePasswordVisibility(pwFldConfirmPassword, btnShowHidePassword2);
			}
		});
		btnShowHidePassword2.setBounds(290, 186, 89, 23);
		contentPane.add(btnShowHidePassword2);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If the user fills out the form and it is valid, it will perform the following
				registerUser();
			}
		});
		btnRegister.setBounds(170, 218, 89, 32);
		contentPane.add(btnRegister);
		
		txtARegisteredUsers = new JTextArea();
		txtARegisteredUsers.setEditable(false);
		txtARegisteredUsers.setBounds(10, 261, 414, 216);
		contentPane.add(txtARegisteredUsers);
		
		scrollPane = new JScrollPane(txtARegisteredUsers);
		scrollPane.setBounds(10, 261, 414, 216);
		contentPane.add(scrollPane);
		
		setLocationRelativeTo(null);	
	}
	
	// Method to toggle password visibility
	private void togglePasswordVisibility(JPasswordField passwordField, JButton toggleButton) {
		if (passwordHidden) {
			passwordField.setEchoChar((char) 0); // Hide Password
			toggleButton.setText("Hide");
		} else {
			passwordField.setEchoChar('*'); // Show Password
			toggleButton.setText("Show");
		}
		
		passwordHidden = !passwordHidden;
	} 
	
	private void registerUser() {
		String firstName = txtFldFirstName.getText().trim();
		String lastName = txtFldLastName.getText().trim();
		String email = txtFldEmail.getText().trim();
		String password = new String(pwFldPassword.getPassword());
		String confirmPassword = new String(pwFldConfirmPassword.getPassword());
		
		// Validation checks
		if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			showError("You must fill in all of the fields.");
			return;
		}
		
		// Email validation
		if (!isValidEmail(email)) {
			showError("Invalid email format.");
			return;
		}
		
		// Password validation
		if (!isValidPassword(password, confirmPassword)) {
			showError("Invalid password.");
			return;
		}
		
		// If all validations pass, show success message and clear fields
		String userDetails = "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "Email: " + email + "\n";
		
		// Once all fields are properly validated, show in a MessageDialog the confirmation of the successful registration together with the complete details entered by the user and after a successful program execution, a user is allowed to register again in the application. 
		JOptionPane.showMessageDialog(this, "Registration Successful!\n" + userDetails, "Success", JOptionPane.INFORMATION_MESSAGE);
		
		txtARegisteredUsers.append(userDetails + "\n");
		clearFields();
	}
	
	// Method to display error message
	private void showError(String message) {
		// Show error message dialog
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	// Method to clear input fields
	private void clearFields() {
		txtFldFirstName.setText("");
		txtFldLastName.setText("");
		txtFldEmail.setText("");
		pwFldPassword.setText("");
		pwFldConfirmPassword.setText("");
	}
	
	// Method to validate email format
	private boolean isValidEmail(String email) {
	    // Regular expression for email validation
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	    // Compiling the regular expression
	    Pattern pattern = Pattern.compile(emailRegex);

	    // If the email matches the pattern
	    return pattern.matcher(email).matches();
	}
	
	// Method to validate password
	private boolean isValidPassword(String password, String confirmPassword) {
		// If the password doesn't match
	    if (!password.equals(confirmPassword)) {
	       showError("Passwords do not match.");
	       return false;
	    }

	    // A Pop-up password must have at least ten characters
	    if (password.length() < 10) {
	        showError("Password must have at least 10 characters.");
	        return false;
	    }

	    int digitCount = 0;
	    for (char c : password.toCharArray()) {
	    	if (Character.isDigit(c)) {
	    		digitCount++;
	        }
	    }

	    // A pop-up message that must contain at least two digits
	    if (digitCount < 2) {
	    	showError("Password must contain at least 2 digits.");
	        return false;
	    }

	    // A pop-up message that must have one uppercase letter 
	    if (!password.matches(".*[ABCDEFGHIJKLMNOPQRSTUVWXYZ].*")) {
	    	showError("Password must contain at least one uppercase letter.");
	        return false;
	    }

	    // A pop-up message that consists of letters, digits and single special character only.
	    if (!password.matches("^[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_+=?<>]+$")) {
	    	showError("Password must consist of letters, digits, and a single special character only.");
	        return false;
	    }

	    // If all checks passed and the password is valid
	    return true;
	}
}
