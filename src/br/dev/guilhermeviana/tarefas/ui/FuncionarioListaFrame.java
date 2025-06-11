package br.dev.guilhermeviana.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.guilhermeviana.tarefas.dao.FuncionarioDAO;
import br.dev.guilhermeviana.tarefas.model.Funcionario;



public class FuncionarioListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnSair;
	private DefaultTableModel model; //dados da tabela
	private JTable tabelaFuncionarios; //Desenho da tabela/Visual da tabela
	private JScrollPane scrollFuncionarios; //Container da Table
	private String[] colunas = {"CÓDIGO", "NOME FUNCIONÁRIO", "CARGO"};
	
	public FuncionarioListaFrame(JFrame avo) {
		criarTela(avo);
	}
	
	private void criarTela(JFrame avo) {
		JDialog telaFuncionarioLista = new JDialog(avo, "Lista de Funcionários", true);
		telaFuncionarioLista.setSize(700, 500);
		telaFuncionarioLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaFuncionarioLista.setLayout(null);
		telaFuncionarioLista.setLocationRelativeTo(null);
		telaFuncionarioLista.setResizable(false);
		
		Container painel = telaFuncionarioLista.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.red);
		
		//Criar a tabela (importante).
		

		model = new DefaultTableModel(colunas, 100);
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);
		
		btnNovo = new JButton("Cadastrar novo funcionários");
		btnNovo.setBounds(10, 400, 250, 50);
		
		btnNovo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(telaFuncionarioLista);
				carregarDadosTabela();
			}
		});
		
		btnSair = new JButton("Retornar");
		btnSair.setBounds(300, 400, 200, 50);
		
		btnSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaFuncionarioLista, "Deseja retornar a tela inicial", "Atenção", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
					telaFuncionarioLista.dispose();
				}
			}
		});
		
		carregarDadosTabela();
		
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		telaFuncionarioLista.setVisible(true);
		
		
	}
	
	private void carregarDadosTabela() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();
		
		int i = 0;
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		for(Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
			}
		
		model.setDataVector(dados, colunas);
		
	}
	
}
