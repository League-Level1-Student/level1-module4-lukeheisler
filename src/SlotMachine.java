import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SlotMachine implements Runnable, MouseListener {

	JFrame frame;
	JPanel imagePanel;
	JLabel messageLabel;
	JButton button;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SlotMachine());

	}

	@Override
	public void run() {
		frame = new JFrame();
		button = new JButton();
		messageLabel = new JLabel();
		frame.setSize(800, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel messagePanel = new JPanel();
		imagePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		frame.add(messagePanel, BorderLayout.NORTH);
		frame.add(imagePanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		messageLabel.setText("Click the spin button to start.");
		button.setText("Spin!");
		messagePanel.add(messageLabel);
		buttonPanel.add(button);
		button.addMouseListener(this);
	}
	
	private void spinReels() {
		//clear reels panel
		imagePanel.removeAll();
		//call SpinReel for each reel
		spinReel();
		//check for win
		
		//re-validate the reels panel
		
	}
	
	private int spinReel() {
		//get random value 0-2
		Random random = new Random();
		int randInt = random.nextInt(2);
		//load image based on random number
		if(randInt==0) {
			imagePanel.add(createLabelImage("Roblox.png"));
		}
		else if(randInt==1) {
			
		}
		else if(randInt==2) {
			
		}
		//add label to reels panel
		
		//return random number
		return(randInt);
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
    

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource().equals(button)) {
			System.out.println("Clicked!");
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
