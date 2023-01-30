package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingDemo implements ActionListener{
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3, b4;

	SwingDemo() {
		JFrame frame = new JFrame("MyApp");
		frame.setVisible(true);
		frame.setSize(700, 500);
		frame.setLayout(null);

		l1 = new JLabel("Id : ");
		l1.setBounds(100, 100, 120, 20);
		frame.add(l1);
		l2 = new JLabel("Name : ");
		l2.setBounds(100, 130, 120, 20);
		frame.add(l2);
		l3 = new JLabel("Contact : ");
		l3.setBounds(100, 160, 120, 20);
		frame.add(l3);
		l4 = new JLabel("Email : ");
		l4.setBounds(100, 190, 120, 20);
		frame.add(l4);
		l5 = new JLabel("Address : ");
		l5.setBounds(100, 220, 120, 20);
		frame.add(l5);

		t1 = new JTextField();
		t1.setBounds(200, 100, 120, 20);
		frame.add(t1);
		t2 = new JTextField();
		t2.setBounds(200, 130, 120, 20);
		frame.add(t2);
		t3 = new JTextField();
		t3.setBounds(200, 160, 120, 20);
		frame.add(t3);
		t4 = new JTextField();
		t4.setBounds(200, 190, 120, 20);
		frame.add(t4);
		t5 = new JTextField();
		t5.setBounds(200, 220, 120, 20);
		frame.add(t5);
		
		b1 = new JButton("INSERT");
		b1.setBounds(100, 300, 120, 20);
		frame.add(b1);
		b2 = new JButton("SEARCH");
		b2.setBounds(250, 300, 120, 20);
		frame.add(b2);
		b3 = new JButton("UPDATE");
		b3.setBounds(100, 330, 120, 20);
		frame.add(b3);
		b4 = new JButton("DELETE");
		b4.setBounds(250, 330, 120, 20);
		frame.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new SwingDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			System.out.println("insert button clicked");
		}
		else if(e.getSource()==b2) {
			System.out.println("search button clicked");
		}
		else if(e.getSource()==b3) {
			System.out.println("update button clicked");
		}
		else if(e.getSource()==b4) {
			System.out.println("delete button clicked");
		}
	}
}
