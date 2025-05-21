package br.dev.guilhermeviana.tarefas.model;

public class Funcionario {

	private String nome;
	private String cargo;
	private String setor;
	
	public Funcionario() {
		System.out.println("Criando um funcionário.");
	}
	
	public Funcionario(String nome) {
		System.out.printf("Criando um funcionário com denominacao nomial %s como %s. ", nome, cargo);
		setNome(nome);
	}
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCarg(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
