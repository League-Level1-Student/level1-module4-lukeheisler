import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….
	public static void main(String[] args) {
		// 2. Make a variable that will hold a random number and put a random number
		// into this variable using "new Random().nextInt(4)"
		Random random = new Random();
		int randInt = random.nextInt(4);
		// 3. Print out this variable
		System.out.println(randInt);
		// 4. Get the user to enter a question for the 8 ball
		JOptionPane.showInputDialog("What is your question?");
		// 5. If the random number is 0
		if(randInt==0) {
			JOptionPane.showMessageDialog(null, "yes");
		}
		// -- tell the user "Yes"

		// 6. If the random number is 1
		else if(randInt==1) {
			JOptionPane.showMessageDialog(null, "no");
		}
		// -- tell the user "No"

		// 7. If the random number is 2
		else if(randInt==2) {
			JOptionPane.showMessageDialog(null, "ask google lol");
		}
		// -- tell the user "Maybe you should ask Google?"

		// 8. If the random number is 3
		else {
			JOptionPane.showMessageDialog(null, "On lunch break. Be back soon. -mgmt");
		}
		// -- write your own answer
	}
}
