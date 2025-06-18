package br.dev.guilhermeviana.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		telaGerenciador.setSize(280, 350);
		telaGerenciador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaGerenciador.setLayout(null);
		telaGerenciador.setLocationRelativeTo(null);
		telaGerenciador.setResizable(false);
		
		Container visual = telaGerenciador.getContentPane();
		
		labelTitulo = new JLabel("Bem Vindo");
		labelTitulo.setBounds(40, 10, 200, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);
		
		bntFuncionario = new JButton("Funcionários");
		bntFuncionario.setBounds(10, 150, 100, 100);
		
		bntFuncionario.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				new FuncionarioListaFrame(telaGerenciador);
				
			}
		});
		
		
		bntTarefas = new JButton("Tarefas");
		bntTarefas.setBounds(140, 150, 100, 100);
		
		bntTarefas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TarefasListaFrame(telaGerenciador);
				
			}
		});
		
		visual.add(labelTitulo);
		visual.add(bntFuncionario);
		visual.add(bntTarefas);
		
		telaGerenciador.setVisible(true);
	}
	
}
