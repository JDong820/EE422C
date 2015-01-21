import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hello {

	public static void main(String[] args) {
	    JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Hello World.");
		JLabel label = new JLabel("Hello, Anon.");
		JLabel label = new JLabel("Hello World");
	    frame.getContentPane().add(label);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}
}