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

import br.dev.guilhermeviana.tarefas.dao.TarefasDAO;
import br.dev.guilhermeviana.tarefas.model.Tarefa;

public class TarefasListaFrame {

    private JLabel labelTitulo;
    private JButton btnNova;
    private JButton btnSair;
    private DefaultTableModel model; 
    private JTable tabelaTarefas; 
    private JScrollPane scrollTarefas; 
    private String[] colunas = { "CÓDIGO", "NOME TAREFA", "RESPONSÁVEL", "DATA INÍCIO", "DATA ENTREGA", "STATUS" };

    public TarefasListaFrame(JFrame avo) {
        criarTela(avo);
    }

    private void criarTela(JFrame avo) {
        JDialog telaTarefaLista = new JDialog(avo, "Lista de Tarefas", true);
        telaTarefaLista.setSize(800, 500);
        telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaTarefaLista.setLayout(null);
        telaTarefaLista.setLocationRelativeTo(null);
        telaTarefaLista.setResizable(false);

        Container painel = telaTarefaLista.getContentPane();

        labelTitulo = new JLabel("Lista de Tarefas");
        labelTitulo.setBounds(10, 10, 600, 40);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        labelTitulo.setForeground(Color.BLUE);

        model = new DefaultTableModel(colunas, 0);
        tabelaTarefas = new JTable(model);
        scrollTarefas = new JScrollPane(tabelaTarefas);
        scrollTarefas.setBounds(10, 70, 770, 300);

        btnNova = new JButton("Cadastrar nova tarefa");
        btnNova.setBounds(10, 400, 250, 50);

        btnSair = new JButton("Retornar");
        btnSair.setBounds(300, 400, 200, 50);

        // Eventos
        btnNova.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TarefasFrame(telaTarefaLista);
                carregarDadosTabela();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(telaTarefaLista, "Deseja retornar à tela inicial?", "Atenção", JOptionPane.YES_NO_OPTION);

                if (resposta == 0) {
                    telaTarefaLista.dispose();
                }
            }
        });

        carregarDadosTabela();

        painel.add(labelTitulo);
        painel.add(scrollTarefas);
        painel.add(btnNova);
        painel.add(btnSair);

        telaTarefaLista.setVisible(true);
    }

    private void carregarDadosTabela() {
        List<Tarefa> tarefas = new ArrayList<>();
        TarefasDAO dao = new TarefasDAO(null);
        tarefas = dao.getTarefas();

        Object[][] dados = new Object[tarefas.size()][6];

        int i = 0;
        for (Tarefa t : tarefas) {
            dados[i][0] = t.getCodigo();
            dados[i][1] = t.getNome();
            dados[i][2] = t.getResponsavel().getNome();
            dados[i][3] = t.getDataInicio();
            dados[i][4] = t.getDataPrevistaEntregaTxt();
            dados[i][5] = t.getStatus();
            i++;
        }

        model.setDataVector(dados, colunas);
    }
}
