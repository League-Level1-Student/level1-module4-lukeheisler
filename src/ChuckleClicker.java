import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ChuckleClicker implements MouseListener, Runnable {

	JButton button1;
	JButton button2;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ChuckleClicker());
	}

	public void mainButtons() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		button1.setText("Joke");
		button1.addMouseListener(this);
		button2.setText("Punchline");
		button2.addMouseListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(button1)) {
			JOptionPane.showMessageDialog(null, "I'm tired.");
		}
		else if(arg0.getSource().equals(button2)) {
			JOptionPane.showMessageDialog(null, "Hi tired, I'm dad!");
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mainButtons();
	}

}
