package br.dev.guilhermeviana.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import br.dev.guilhermeviana.tarefas.dao.FuncionarioDAO;
import br.dev.guilhermeviana.tarefas.model.Funcionario;
import br.dev.guilhermeviana.tarefas.model.Status;
import br.dev.guilhermeviana.tarefas.model.Tarefa;
import br.dev.guilhermeviana.tarefas.ui.FuncionarioFrame;
import br.dev.guilhermeviana.tarefas.ui.FuncionarioListaFrame;
import br.dev.guilhermeviana.tarefas.utils.Utils;

public class Main {

	public static void main(String[] args) {
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		dao.getFuncionarios();
		
		new FuncionarioListaFrame();
//		new FuncionarioFrame();
		
//		Funcionario funcionario = new Funcionario("Ana braga", "RHA");
//		funcionario.setSetor("Tecnologia da informação.");
//		funcionario.setSalario(12000.98);
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
		
//		System.out.println(funcionario.toString());
//		
//		Tarefa tarefa = new Tarefa(funcionario);
//		tarefa.setNome("Lavar a Louça");
//		tarefa.setDescricao("Lavar a louça antes de eu chegar");
//		tarefa.setDataInicio(LocalDate.of(2025, 5, 21));
//		tarefa.setPrazo(1);
//		tarefa.getDataPrevistaEntrega();
//		//tarefa.setStatus(Status.EM_ANDAMENTO);
//		
//		System.out.println(Utils.gerarUUID8());
//		
//		//testarLeituraEscritaArquivo();
//		
	}

	private static void testarLeituraEscritaArquivo() {
		String so = System.getProperty("os.name");
		System.out.println(so);
		
		//Caminho para o arquivo, que vai receber o caminho do arquivo
		String caminho = "/Users/25132756/projetoTarefas/Tarefas";
		
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			//Trás o arquivo, famoso... TRÁS PARA DENTRO (Pega o arquivo de que foi direcionado para ser usado)
			fr = new FileReader(caminho);
			//Aqui ler o arquivo: LER PRA DENTRO. (Ler o arquivo, precisa ter o direcionamento.)
			br = new BufferedReader(fr);
			
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			bw.append("Guilherme, o traidor dos traidores\n");
			bw.flush();
			
			String linha = br.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não encontrado!");
		} catch (IOException erro) {
			System.out.println("O arquivo está protegido pela leitura!");
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
