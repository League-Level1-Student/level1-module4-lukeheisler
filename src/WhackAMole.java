import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WhackAMole implements Runnable, MouseListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Date date;
	int score = 0;
	//JButton button;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new WhackAMole());
	}

	@Override
	public void run() {
		date = new Date();
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(200,300);
		makeButtons();
	}
	
	void makeButtons() {
		Random random = new Random();
		int mole = random.nextInt(24);
		for (int i = 0; i < 24; i++) {
			JButton button = new JButton();
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
	public void mouseClicked(MouseEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("^_^")) {
			panel.removeAll();
			makeButtons();
			score++;
			System.out.println(score);
		}
		else {
			speak("That's not it :(");
		}
		
		if(score==10) {
			endGame(date, score);
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
	
	void speak(String words) {
		/*
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	     */
		System.out.println(words);
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " seconds per mole.");
	}
}
