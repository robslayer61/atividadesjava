import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jokenpo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jokenpo frame = new Jokenpo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int jogador = 0;
	private JLabel lblComputador;

	/**
	 * Create the frame.
	 */
	public Jokenpo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jokenpo.class.getResource("/br/com/icones/papel.png")));
		setTitle("JOKENPO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPedra = new JButton("");
		btnPedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogador = 1;
				jogo();
			}
		});
		btnPedra.setIcon(new ImageIcon(Jokenpo.class.getResource("/br/com/icones/pedra.png")));
		btnPedra.setBounds(32, 42, 64, 64);
		contentPane.add(btnPedra);
		
		JButton btnPapel = new JButton("");
		btnPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogador = 2;
				jogo();
			}
		});
		btnPapel.setIcon(new ImageIcon(Jokenpo.class.getResource("/br/com/icones/papel.png")));
		btnPapel.setBounds(32, 152, 64, 64);
		contentPane.add(btnPapel);
		
		JButton btnTesoura = new JButton("");
		btnTesoura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogador = 3;
				jogo();
			}
		});
		btnTesoura.setIcon(new ImageIcon(Jokenpo.class.getResource("/br/com/icones/tesoura.png")));
		btnTesoura.setBounds(32, 258, 64, 64);
		contentPane.add(btnTesoura);
		
		lblComputador = new JLabel("");
		lblComputador.setBounds(132, 227, 292, 152);
		contentPane.add(lblComputador);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(195, 97, 89, 19);
		contentPane.add(lblResultado);
	}
	//lógica do jokenpo
	private void jogo() {
	//estrutura switch case admite apenas tipo int e char
		
	//lógica do computador
	//a linha abaixo gera números aleatórios entre 0 e 2
	//(int converte para o tipo inteiro (casting)
	// +1 soma 1 ao resultado (1 ou 2 ou 3)
	int computador = (int)(Math.random() * 3 + 1);
	switch (computador) {
	case 1:
		System.out.println("Computador escolheu PEDRA");
		lblComputador.setIcon(new ImageIcon(Jokenpo.class.getResource("/br/com/icones/pcpedra.png")));
		break;
	case 2:
		System.out.println("Computador escolheu PAPEL");
		lblComputador.setIcon(new ImageIcon(Jokenpo.class.getResource("/br/com/icones/pcpapel.png")));

		break;
	case 3:
		System.out.println("Computador escolheu TESOURA");
		lblComputador.setIcon(new ImageIcon(Jokenpo.class.getResource("/br/com/icones/pctesoura.png")));

		break;
	
	}
	//lógica para determinar o vencedor ou empate
	if (jogador == computador) {
		System.out.println("EMPATE");
		JOptionPane.showMessageDialog(null,"EMPATE!!");

	}else {
		if ((jogador == 1 && computador == 3) || (jogador == 2 && computador == 1) || (jogador == 3 && computador == 2)){
			//System.out.println("JOGADOR VENCEU!!");
			JOptionPane.showMessageDialog(null,"JOGADOR VENCEU!!");

		} else {
			System.out.println("COMPUTADOR VENCEU!!");
			JOptionPane.showMessageDialog(null,"COMPUTADOR VENCEU!!");


		}
		
	
	}
	
	}
}
