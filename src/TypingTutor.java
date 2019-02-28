import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TypingTutor implements KeyListener, Runnable {
	
	static char currentLetter;
	boolean correct;
	JFrame frame;
	Date timeAtStart = new Date();
	int charsTyped;
	JLabel label;
	JPanel panel;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new TypingTutor());
	}

	static char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyChar());
		if(arg0.getKeyChar()==currentLetter) {
			System.out.println("Correct!");
			correct = true;
			charsTyped++;
		}
		else {
			correct = false;
			charsTyped--;
		}
		currentLetter = generateRandomLetter();
		label.setText(Character.toString(currentLetter));
		if(correct==true) {
			panel.setBackground(Color.GREEN);
		}
		else if(correct==false) {
			panel.setBackground(Color.RED);
		}
		if(charsTyped%10==0&&charsTyped>=1) {
			showTypingSpeed(charsTyped);
		}
	}

	@Override
	public void run() {
		label = new JLabel();
		panel = new JPanel();
		frame = new JFrame();
		frame.add(panel);
		panel.add(label);
		currentLetter = generateRandomLetter();
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText(Character.toString(currentLetter));
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
}
