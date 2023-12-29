import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculatorni implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[12];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equaButton, delButton, clrButton, doubleZeroButton, negButton;
    JPanel panel;

    Font myyFont = new Font("Digital-7", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    calculatorni() {
        frame = new JFrame("Calculator ni Guibao");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 500);
        frame.setLayout(null);
       	frame.getContentPane().setBackground(Color.BLACK);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myyFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equaButton = new JButton("=");
        delButton = new JButton("D");
        clrButton = new JButton("C");
        doubleZeroButton = new JButton("00");
        negButton = new JButton("(-)");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equaButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = doubleZeroButton;
        functionButtons[9] = negButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myyFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 12; i++) {
            numberButtons[i] = new JButton(i < 10 ? String.valueOf(i) : "");
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myyFont);
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 305, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equaButton);
        panel.add(divButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(doubleZeroButton);
        panel.add(negButton);
        panel.setBackground(Color.BLACK);

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] Strawhat) {
        calculatorni calc = new calculatorni();
    }

	public void actionPerformed(ActionEvent e){
		for(int i=0; i<10; i++){
			if(e.getSource()== numberButtons[i]){
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()== decButton){
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()== addButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()== subButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()== mulButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()== divButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()== equaButton){
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator){
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case '*':
				result=num1*num2;
				break;
			case '/':
				result=num1/num2;
				break;
			}
			 textfield.setText(String.format("%.5f", result));
       		 num1=result;
		}
		if(e.getSource()==clrButton){
			textfield.setText("");
		}
		if(e.getSource()==delButton){
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0; i<string.length()-1; i++){
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		 if (e.getSource() == doubleZeroButton) {
        textfield.setText(textfield.getText().concat("00"));
    }
    if (e.getSource() == negButton) {
        double currentValue = Double.parseDouble(textfield.getText());
        textfield.setText(String.valueOf(-currentValue));
    }



	}
}