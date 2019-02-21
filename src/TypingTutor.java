import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TypingTutor implements KeyListener, Runnable {
	
	static char currentLetter;
	boolean correct;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new TypingTutor());
	}
	
	public void UI() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		frame.add(label);
		currentLetter = generateRandomLetter();
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText(Character.toString(currentLetter));
		if(correct==true) {
			frame.setBackground();
		}
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
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
		}
		else {
			correct = false;
		}
		UI();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		UI();
	}
}
