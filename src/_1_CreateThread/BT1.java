package _1_CreateThread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BT1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT1 frame = new BT1();
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
	public BT1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 597, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter integer number, from");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 229, 28);
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 99, 577, 238);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(242, 11, 86, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("to");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(338, 20, 24, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(366, 11, 86, 28);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Thread thread1 = new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int from = Integer.valueOf(textField.getText());
						int to = Integer.valueOf(textField_1.getText());
						int count = 0;
						for (int i = from; i <= to; i++) {
							if (i % 10 == 7) {
								count++;
							}
						}
						textArea.append("Thread count: from "+from+" to "+ to+" there is "+count +" number end with 7 \n");

					}
				};
				
				Thread thread2 = new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int from = Integer.valueOf(textField.getText());
						int to = Integer.valueOf(textField_1.getText());
						int sum = 0;
						for (int i = from; i <= to; i++) {
							if (i%10 == 7) {
								sum += i;							}
						}
						textArea.append("\nThread sum: "+sum+"\n");
					}
					
				};
	   			thread1.start();
	   			thread2.start();
 			}
 		});
		btnNewButton.setBounds(10, 59, 89, 23);
		panel.add(btnNewButton);
		

	}
}
