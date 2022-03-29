import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {

	JFrame frame;
	JTextField visor;
	JButton[] numeros = new JButton[10];
	JButton[] funcoes = new JButton[9];
	JButton subtr, adic, div, mult, result;
	JButton decimal, delet, clr, negativ;
	JPanel corpo;
	
	Font font = new Font("Times New Roman", Font.BOLD, 30);
	double operador1=0;
	double operador2=0;
	double resultado=0;
	char operador;
	
	public Calculadora() {
		
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		visor = new JTextField();
		visor.setBounds(50, 25, 300, 50);
		visor.setFont(font);
		visor.setEditable(false);
		
		
		adic = new JButton("+");
		subtr = new JButton("-");
		div = new JButton("/");
		mult = new JButton("*");
		result = new JButton("=");
		decimal = new JButton(".");
		delet = new JButton("DEL");
		clr = new JButton("CLR");
		negativ = new JButton("(-)");
		
		funcoes[0] = adic;
		funcoes[1] = subtr;
		funcoes[2] = mult;
		funcoes[3] = div;
		funcoes[4] = decimal;
		funcoes[5] = delet;
		funcoes[6] = result;
		funcoes[7] = clr;
		funcoes[8] = negativ;
		
		negativ.setBounds(50, 430, 100, 50);
		delet.setBounds(150, 430, 100, 50);
		clr.setBounds(250, 430, 100, 50);
		
		for(int i = 0; i<9; i++) {
			funcoes[i].addActionListener(this);
			funcoes[i].setFont(font);
			funcoes[i].setFocusable(false);
		}
		
		for(int i = 0; i<10; i++) {
			numeros[i] = new JButton(String.valueOf(i));
			numeros[i].addActionListener(this);
			numeros[i].setFont(font);
			numeros[i].setFocusable(false);
		}
		
		corpo = new JPanel();
		corpo.setBounds(50, 100, 300, 300);
		corpo.setLayout(new GridLayout(4,4,10,10));
		
		corpo.add(numeros[1]);
		corpo.add(numeros[2]);
		corpo.add(numeros[3]);
		corpo.add(adic);
		corpo.add(numeros[4]);
		corpo.add(numeros[5]);
		corpo.add(numeros[6]);
		corpo.add(subtr);
		corpo.add(numeros[7]);
		corpo.add(numeros[8]);
		corpo.add(numeros[9]);
		corpo.add(mult);
		corpo.add(decimal);
		corpo.add(numeros[0]);
		corpo.add(result);
		corpo.add(div);
		
		frame.add(negativ);
		frame.add(corpo);
		frame.add(delet);
		frame.add(clr);
		frame.add(visor);
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numeros[i]) {
				visor.setText(visor.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decimal) {
			visor.setText(visor.getText().concat("."));
		}
		
		if(e.getSource() == adic) {
			operador1 = Double.parseDouble(visor.getText());
			operador = '+';
			visor.setText("");
		}
		
		if(e.getSource() == subtr) {
			operador1 = Double.parseDouble(visor.getText());
			operador = '-';
			visor.setText("");
		}
		
		if(e.getSource() == div) {
			operador1 = Double.parseDouble(visor.getText());
			operador = '/';
			visor.setText("");
		}
		
		if(e.getSource() == mult) {
			operador1 = Double.parseDouble(visor.getText());
			operador = '*';
			visor.setText("");
		}
		
		if(e.getSource() == negativ) {
			var atual = Double.parseDouble(visor.getText());
			atual *= -1;
			visor.setText(String.valueOf(atual));
		}
		
		if(e.getSource() == clr) {
			visor.setText("");
		}
		
		if(e.getSource() == delet) {
			var atual = visor.getText();
			visor.setText("");
			for(int i = 0; i<atual.length()-1; i++) {
				visor.setText(visor.getText()+atual.charAt(i));
			}
		}
		
		if(e.getSource() == result) {
			operador2 = Double.parseDouble(visor.getText());
			switch(operador) {
				case '+':
					resultado = operador1 + operador2;
					break;
				case '-':
					resultado = operador1 - operador2;
					break;
				case '*':
					resultado = operador1 * operador2;
					break;
				case '/':
					resultado = operador1 / operador2;
					break;
			}
			
			visor.setText(String.valueOf(resultado));
			operador1 = resultado;
		}
	}

}
