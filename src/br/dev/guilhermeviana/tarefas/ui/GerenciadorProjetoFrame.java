package br.dev.guilhermeviana.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GerenciadorProjetoFrame {
	
	private JLabel labelTitulo;
	private JButton bntFuncionario;
	private JButton bntTarefas;
	
	public GerenciadorProjetoFrame() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame telaGerenciador = new JFrame ("Gerenciador Tarefas");
		telaGerenciador.setSize(300, 300);
		telaGerenciador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaGerenciador.setLayout(null);
		telaGerenciador.setLocationRelativeTo(null);
		telaGerenciador.setResizable(false);
		
		Container visual = telaGerenciador.getContentPane();
		
		labelTitulo = new JLabel("Bem Vindo");
		labelTitulo.setBounds(60, 10, 200, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);
		
		visual.add(labelTitulo);
		
		telaGerenciador.setVisible(true);
	}
	
}
