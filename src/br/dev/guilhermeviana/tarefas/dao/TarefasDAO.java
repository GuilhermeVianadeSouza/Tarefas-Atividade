package br.dev.guilhermeviana.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.guilhermeviana.tarefas.factory.ArquivoTarefasFactory;
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
			bw.write(tarefas.toString());
			bw.flush();
			return true;
		} catch (Exception e) {
			System.out.println();
			return false;
		}

	}
	
	public List<Tarefa> getTarefas() {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			BufferedReader br = aff.getBr();
			
			String linha = "";
			
			while (linha != null) {
				linha = br.readLine();
				if (linha != null ) {
					String[] tarefasVetor = linha.split(",");
					Tarefa tarefa = new Tarefa(null);
					tarefa.setCodigo(tarefasVetor[0]);
					tarefa.setNome(tarefasVetor[1]);
					tarefa.setDescricao(tarefasVetor[2]);
					tarefa.setResponsavel(tarefasVetor[3]);
					tarefa.setDataInicio(tarefasVetor[4]);
					tarefa.setPrazo(tarefasVetor[5]);
					tarefa.setDataEntrega(tarefasVetor[6]);
					tarefa.setStatu
					tarefa.add(funcionario);
				}
			}
			
			return funcionarios;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
	

