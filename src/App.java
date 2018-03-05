import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class App implements ActionListener, AncestorListener{

	String s = String.join(  System.getProperty("line.separator"), "5 3",  "1 1 E", "RFRFRFRF", "3 2 N", "FRRFLLFFRRFLL", "0 3 W",  "LLFFFLFLFL",  "5 3 N", "FFFF" );
	JTextArea textArea; 
	JTextArea inputedText;
	JButton submitButton = new JButton("Submit");


	public App(){
		JFrame frame = new JFrame("Input and Output");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 560));


		// Create fields for I/O
		textArea = new JTextArea(20, 25);
		inputedText = new JTextArea(10,  25);
		inputedText.setEditable(false);

		// Add labelled input fields to display
		JPanel inFieldPane = new JPanel();
		//inFieldPane.setLayout(new GridLayout(2,2));
		inFieldPane.add(new JLabel("Text to run"));
		inFieldPane.add(textArea);
		textArea.addAncestorListener(this);
		frame.add(inFieldPane,BorderLayout.NORTH);

		// Add submission button
		JPanel submitPane = new JPanel();
		submitPane.setLayout(new FlowLayout());
		submitPane.add(new JLabel("Press Button to Submit"));
		submitButton.addActionListener(this);
		submitPane.add(submitButton);
		frame.add(submitPane,BorderLayout.CENTER);

		// Add Output field
		JPanel outFieldPane = new JPanel();
		//outFieldPane.setLayout(new GridLayout(2,2));
		outFieldPane.add(new JLabel("Results"));
		outFieldPane.add(inputedText);
		frame.add(outFieldPane,BorderLayout.SOUTH);

		// Display the final product
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed (ActionEvent e)
	{
		// Display if and only if button was pushed
		if (e.getSource() == submitButton)
		{
			// Setup the program
			Setup exe = new Setup();
			String fullString = exe.start(textArea.getText().trim());
			inputedText.setText(fullString);
		}
	}




	public static void main(String[] args) {		
		@SuppressWarnings("unused")
		App text1 =   new App();	

	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// TODO Auto-generated method stub

	}
}


