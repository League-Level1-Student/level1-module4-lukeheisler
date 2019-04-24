import java.awt.BorderLayout;
import java.awt.Color;
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
		int reel1 = spinReel();
		int reel2 = spinReel();
		int reel3 = spinReel();
		//check for win
		if(reel1==reel2&&reel2==reel3) {
			System.out.println("YEEEEEEEEEEE HAWWWWWWWWWWWWW! - that's a dollar and a penny");
		}
		else if(reel1==0&&reel2==0) {
			System.out.println("yee haw!! - that's a dollar");
		}
		else if(reel1==0) {
			System.out.println("yee haw - that's a penny");
		}
		//re-validate the reels panel
		imagePanel.revalidate();
		frame.revalidate();
	}
	
	private int spinReel() {
		//get random value 0-2
		Random random = new Random();
		int randInt = random.nextInt(100);
		int returnInt = -1;
		//load image based on random number
		if(randInt>=0&&randInt<=49) {
			try {
				imagePanel.add(createLabelImage("Roblox.png"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			returnInt = 0;
		}
		else if(randInt>=50&&randInt<=74) {
			try {
				imagePanel.add(createLabelImage("Pokeball.PNG"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			returnInt = 1;
		}
		else if(randInt>=75&&randInt<=99) {
			try {
				imagePanel.add(createLabelImage("PiggyWig.png"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			returnInt = 2;
		}
		//add label to reels panel
		
		//return random number
		return(returnInt);
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
			spinReels();
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
