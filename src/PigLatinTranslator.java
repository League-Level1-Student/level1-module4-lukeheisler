import javax.swing.SwingUtilities;

public class PigLatinTranslator implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new PigLatinTranslator());
	}
	static String translate(String input) {
		char firstLetter = input.charAt(0);
		if(firstLetter=='a'||firstLetter=='e'||firstLetter=='i'||firstLetter=='o'||firstLetter=='u') {
			input = input+"way";
		}
		else {
			input = input.substring(1)+firstLetter+"ay";
		}
		return input;
	}
	@Override
	public void run() {
		
		
	}
}
