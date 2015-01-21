import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Hello extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected JTextField textIn;
    protected JLabel textOut;
    private final static String newline = "\n";
 
    public Hello() {
        super(new GridBagLayout());
 
        textIn = new JTextField(20);
        textIn.addActionListener(this);
 
        textOut = new JLabel("Hello, Anon.");
 
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textIn, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(textOut, c);
    }
 
    public void actionPerformed(ActionEvent evt) {
        textOut.setText("Hello, " + textIn.getText() + ".");
        textIn.selectAll();
    }
 
    // For thread safety, invoke from the event dispatch thread.
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("EE422C Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.add(new Hello());
 
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
