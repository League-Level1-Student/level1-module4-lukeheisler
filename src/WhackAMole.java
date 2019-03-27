import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WhackAMole implements Runnable, MouseListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new WhackAMole());
	}

	@Override
	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(200,300);
		makeButtons();
	}
	
	void makeButtons() {
		Random random = new Random();
		int mole = random.nextInt(24);
		for (int i = 0; i < 24; i++) {
			button = new JButton();
			button.addMouseListener(this);
			panel.add(button);
			if(i==mole) {
				button.setText("^_^");
			}
			else {
				button.setText("       ");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.g) {
			
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
