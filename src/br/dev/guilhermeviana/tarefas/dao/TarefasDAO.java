package br.dev.guilhermeviana.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.guilhermeviana.tarefas.factory.ArquivoTarefasFactory;
import br.dev.guilhermeviana.tarefas.model.Funcionario;
import br.dev.guilhermeviana.tarefas.model.Status;
import br.dev.guilhermeviana.tarefas.model.Tarefa;

public class TarefasDAO {
	
	private Tarefa tarefas;
	private ArquivoTarefasFactory aff = new ArquivoTarefasFactory();


	    public TarefasDAO(Tarefa tarefas) {
	        this.tarefas = tarefas;
	    }

	    public boolean gravar() {
	        try {
	            BufferedWriter bw = aff.getBw();
	            // Exemplo simples de formatação para gravação
	            bw.write(tarefas.getCodigo() + "," +
	                     tarefas.getNome() + "," +
	                     tarefas.getDescricao() + "," +
	                     tarefas.getResponsavel().getMatricula() + "," +
	                     tarefas.getDataInicio() + "," +
	                     tarefas.getPrazo() + "," +
	                     tarefas.getDataEntrega() + "," +
	                     tarefas.getStatus().name());

	            bw.newLine();
	            bw.flush();
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public List<Tarefa> getTarefas() {
	        List<Tarefa> tarefas = new ArrayList<>();

	        try (BufferedReader br = aff.getBr()) {
	            String linha;

	            while ((linha = br.readLine()) != null) {
	                String[] partes = linha.split(",");

	                Tarefa tarefa = new Tarefa(null);
	                tarefa.setCodigo(partes[0]);
	                tarefa.setNome(partes[1]);
	                tarefa.setDescricao(partes[2]);

	                Funcionario responsavel = new Funcionario(null);
	                responsavel.setMatricula(partes[3]);
	                tarefa.setResponsavel(responsavel);

	                tarefa.setDataInicio(partes[4]);
	                tarefa.setPrazo(Integer.parseInt(partes[5]));
	                tarefa.setDataEntrega(partes[6]);
	                tarefa.setStatus(Status.valueOf(partes[7]));

	                tarefas.add(tarefa);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	            }
	        return tarefas;
	    }
	}
