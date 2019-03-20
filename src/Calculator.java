import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculator implements Runnable, MouseListener {
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JFrame frame = new JFrame();
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton mul = new JButton();
	JButton div = new JButton();
	JTextField one;
	JTextField two;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Calculator());
	} 
	
	public int add(String s1, String s2) {
		int arg1 = Integer.parseInt(s1);
		int arg2 = Integer.parseInt(s2);
		return arg1+arg2;
	}
	
	public int subtract(String s1, String s2) {
		int arg1 = Integer.parseInt(s1);
		int arg2 = Integer.parseInt(s2);
		return arg1-arg2;
	}
	
	public int multiply(String s1, String s2) {
		int arg1 = Integer.parseInt(s1);
		int arg2 = Integer.parseInt(s2);
		return arg1*arg2;
	}
	
	public int divide(String s1, String s2) {
		int arg1 = Integer.parseInt(s1);
		int arg2 = Integer.parseInt(s2);
		return arg1/arg2;
	}

	@Override
	public void run() {
		one = new JTextField(5);
		two = new JTextField(5);
		frame.setVisible(true);
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		add.setText("+");
		add.addMouseListener(this);
		sub.setText("-");
		sub.addMouseListener(this);
		mul.setText("x");
		mul.addMouseListener(this);
		div.setText("/");
		div.addMouseListener(this);
		panel1.add(one);
		panel1.add(two);
		panel2.add(add);
		panel2.add(sub);
		panel2.add(mul);
		panel2.add(div);
		frame.pack();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource().equals(add)) {
			JOptionPane.showMessageDialog(null, add(one.getText(),two.getText()));
		}
		else if(arg0.getSource().equals(sub)) {
			JOptionPane.showMessageDialog(null, subtract(one.getText(),two.getText()));
		}
		else if(arg0.getSource().equals(mul)) {
			JOptionPane.showMessageDialog(null, multiply(one.getText(),two.getText()));
		}
		else if(arg0.getSource().equals(div)) {
			JOptionPane.showMessageDialog(null, divide(one.getText(),two.getText()));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
