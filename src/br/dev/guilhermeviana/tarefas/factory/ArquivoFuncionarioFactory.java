package br.dev.guilhermeviana.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoFuncionarioFactory {

	private String caminho = "/Users/25132756/projetoTarefas/funcionarios.csv";
	private FileWriter fw;
	private BufferedWriter bw;

	public BufferedWriter getBw() throws IOException{
		
		fw = new FileWriter(caminho, true);
		bw = new BufferedWriter(fw);
		
		
		return bw;
	}

}
