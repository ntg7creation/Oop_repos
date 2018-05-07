package test_and_samples;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Convertor extends JFrame implements ActionListener {
    private static double DOLLAR_RATE = 3.943;
    private JButton convertButton;
    private JButton resetButton;
    private JLabel resultLabel;
    private JTextField valueInput;
    private double value;


    public Convertor(){
        super("Convertor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        value = 0;
        
        // Initiate label and text field.
        valueInput = new JTextField();
        valueInput.setColumns(20);
        valueInput.setText(String.valueOf(value));
        resultLabel = new JLabel(value + " $ is "+ convert() + " Shekel");


        // Create buttons
        convertButton = new JButton("Convert");
        resetButton = new JButton("Reset");
        // Add action listeners
        convertButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add all objects to Content Pane
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(resetButton);
        getContentPane().add(valueInput);
        getContentPane().add(convertButton);
        getContentPane().add(resultLabel);


        pack();
        setVisible(true);
    }
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(convertButton))
	        updateValue();
	    if (e.getSource().equals(resetButton))
	        setValue(0);
	    updateView();
	}

	private void setValue(double v) {
	    this.value = v;
	}

	private double convert() {
	    return value*DOLLAR_RATE;
	}

	private void updateValue(){
	    this.value = Double.parseDouble(valueInput.getText());
	}

	private void updateView(){
	    resultLabel.setText(value +" $ is " + convert() + " Shekel " );
	    valueInput.setText(String.valueOf(value));
	    pack();
	}
	
	public static void main(String[] args) {
		new Convertor();
	}
}