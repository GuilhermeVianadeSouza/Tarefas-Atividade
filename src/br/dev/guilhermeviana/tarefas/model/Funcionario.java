package br.dev.guilhermeviana.tarefas.model;

import br.dev.guilhermeviana.tarefas.utils.Utils;

public class Funcionario {
	
	private String matricula;
	private String nome;
	private String cargo;
	private String setor;
	private double salario;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Funcionario(String nome) {
		System.out.printf("Criando um funcionário com denominacao nomial %s como %s. ", nome, cargo);
		setNome(nome);
		setMatricula(Utils.gerarUUID8());
	}
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
		this.matricula = Utils.gerarUUID8();
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
	
	@Override
	public String toString() {
		return matricula + ", " + nome + ", " + cargo + ", " + setor + ", " + salario + "\n";
	}

}
