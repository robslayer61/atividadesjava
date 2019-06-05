import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculoImc extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtImc;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoImc frame = new CalculoImc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculoImc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Peso");
		lblNewLabel.setBounds(42, 11, 67, 14);
		contentPane.add(lblNewLabel);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(119, 6, 55, 25);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setBounds(42, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(119, 42, 55, 25);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Seu IMC");
		lblNewLabel_2.setBounds(42, 89, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCalcular = new JButton("New button");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setIcon(new ImageIcon(CalculoImc.class.getResource("/IMC/imc.png")));
		btnCalcular.setBounds(231, 66, 66, 60);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("New button");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CalculoImc.class.getResource("/IMC/limpar.png")));
		btnLimpar.setBounds(334, 66, 61, 60);
		contentPane.add(btnLimpar);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(CalculoImc.class.getResource("/IMC/tabela_imc.jpg")));
		lblStatus.setBounds(20, 150, 414, 218);
		contentPane.add(lblStatus);
		
		txtImc = new JTextField();
		txtImc.setBounds(30, 114, 86, 31);
		contentPane.add(txtImc);
		txtImc.setColumns(10);
	}
	//método para calcular o IMC
	private void calcular() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		double peso, altura, imc;
		peso = Double.parseDouble(txtPeso.getText().replace(",", "."));
		altura = Double.parseDouble(txtAltura.getText().replace(",", "."));
		imc = peso / (altura * altura);
		txtImc.setText(formatador.format(imc));
		System.out.println("IMC: " + formatador.format(imc));
		//para criar um intervalo usamos o operador AND (&&)
		if (imc <18.5) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMC/tabela_imc_abaixo.jpg")));
			}else if (imc >=18.5 && imc <25) {
				lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMC/tabela_imc_normal.jpg")));

		}else if (imc >=25 && imc < 30) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMC/tabela_imc_acima.jpg")));

		

		}
		else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMC/tabela_imc_obeso.jpg")));

	}
		
	
	}
	
	
	//limpar campos
	private void limpar() {
			txtPeso.setText(null);
			txtAltura.setText(null);
			txtImc.setText(null);
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMC/tabela_imc.jpg")));

		

		
		
		
		

		
		
	}
}
