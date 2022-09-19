package app;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindow {
public static void main(String[] args) {
	JFrame frame = new JFrame("My Window");
	frame.setSize(400,400);
	frame.setLayout(new FlowLayout());
	
	JButton button = new JButton("Click Me!!");
	frame.add(button);
	button.addActionListener((e)->{
		System.out.println("Button Clicked!!!");
		JOptionPane.showMessageDialog(null, "Button is clicked bro!!");
	});
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
}
