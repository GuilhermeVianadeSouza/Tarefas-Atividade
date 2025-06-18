package br.dev.guilhermeviana.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;

import br.dev.guilhermeviana.tarefas.dao.FuncionarioDAO;
import br.dev.guilhermeviana.tarefas.dao.TarefasDAO;
import br.dev.guilhermeviana.tarefas.model.Funcionario;
import br.dev.guilhermeviana.tarefas.model.Tarefa;
import br.dev.guilhermeviana.tarefas.utils.Utils;

public class TarefasFrame {

    private JLabel labelCodigo;
    private JLabel labelNome;
    private JLabel labelDescricao;
    private JLabel labelResponsavel;
    private JLabel labelDataInicio;
    private JLabel labelPrazo;

    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtDescricao;
    private JComboBox<Funcionario> comboResponsavel;
    private JTextField txtDataInicio;
    private JTextField txtPrazo;

    private JButton btnSalvar;
    private JButton btnSair;

    public TarefasFrame(JDialog pai) {
        criarTela(pai);
    }

    private void criarTela(JDialog pai) {
        JDialog telaTarefa = new JDialog(pai, "Cadastro de Tarefa", true);
        telaTarefa.setSize(500, 500);
        telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaTarefa.setLayout(null);
        telaTarefa.setResizable(false);
        telaTarefa.setLocationRelativeTo(null);

        Container painel = telaTarefa.getContentPane();

        // Campos
        labelCodigo = new JLabel("Código");
        labelCodigo.setBounds(10, 20, 150, 30);
        txtCodigo = new JTextField();
        txtCodigo.setBounds(10, 50, 150, 30);
        txtCodigo.setEnabled(false);
        txtCodigo.setText(Utils.gerarUUID8());

        labelNome = new JLabel("Nome da Tarefa");
        labelNome.setBounds(10, 85, 150, 30);
        txtNome = new JTextField();
        txtNome.setBounds(10, 115, 300, 30);

        labelDescricao = new JLabel("Descrição");
        labelDescricao.setBounds(10, 150, 150, 30);
        txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 180, 300, 30);

        labelResponsavel = new JLabel("Responsável");
        labelResponsavel.setBounds(10, 215, 150, 30);
        comboResponsavel = new JComboBox<>();
        comboResponsavel.setBounds(10, 245, 300, 30);

        // Carrega funcionários no ComboBox
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(null);
        for (Funcionario f : funcionarioDAO.getFuncionarios()) {
            comboResponsavel.addItem(f);
        }

        labelDataInicio = new JLabel("Data Início (dd/MM/yyyy)");
        labelDataInicio.setBounds(10, 280, 200, 30);
        txtDataInicio = new JTextField();
        txtDataInicio.setBounds(10, 310, 150, 30);

        labelPrazo = new JLabel("Prazo (dias)");
        labelPrazo.setBounds(10, 345, 150, 30);
        txtPrazo = new JTextField();
        txtPrazo.setBounds(10, 375, 150, 30);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 420, 200, 40);

        btnSair = new JButton("Sair");
        btnSair.setBounds(220, 420, 120, 40);

        painel.add(labelCodigo);
        painel.add(txtCodigo);
        painel.add(labelNome);
        painel.add(txtNome);
        painel.add(labelDescricao);
        painel.add(txtDescricao);
        painel.add(labelResponsavel);
        painel.add(comboResponsavel);
        painel.add(labelDataInicio);
        painel.add(txtDataInicio);
        painel.add(labelPrazo);
        painel.add(txtPrazo);
        painel.add(btnSalvar);
        painel.add(btnSair);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Funcionario responsavelSelecionado = (Funcionario) comboResponsavel.getSelectedItem();
                    if (responsavelSelecionado == null) {
                        JOptionPane.showMessageDialog(telaTarefa, "Selecione um responsável.");
                        return;
                    }

                    Tarefa tarefa = new Tarefa(responsavelSelecionado);
                    tarefa.setCodigo(txtCodigo.getText());
                    tarefa.setNome(txtNome.getText());
                    tarefa.setDescricao(txtDescricao.getText());
                    tarefa.setDataInicio(txtDataInicio.getText());
                    tarefa.setPrazo(Integer.parseInt(txtPrazo.getText()));

                    TarefasDAO dao = new TarefasDAO(tarefa);
                    boolean sucesso = dao.gravar();

                    if (sucesso) {
                        JOptionPane.showMessageDialog(telaTarefa, "Tarefa salva com sucesso!");
                        limparFormulario();
                    } else {
                        JOptionPane.showMessageDialog(telaTarefa, "Erro ao salvar tarefa.");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(telaTarefa, "Erro: " + ex.getMessage());
                }
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaTarefa.dispose();
            }
        });

        telaTarefa.setVisible(true);
    }

    private void limparFormulario() {
        txtCodigo.setText(Utils.gerarUUID8());
        txtNome.setText(null);
        txtDescricao.setText(null);
        comboResponsavel.setSelectedIndex(0);
        txtDataInicio.setText(null);
        txtPrazo.setText(null);
        txtNome.requestFocus();
    }
}
