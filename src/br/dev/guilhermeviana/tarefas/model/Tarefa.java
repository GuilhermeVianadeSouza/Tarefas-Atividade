package br.dev.guilhermeviana.tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.dev.guilhermeviana.tarefas.utils.Utils;


public class Tarefa {
	
	private String codigo;
	private String nome;
	private String descricao;
	private Funcionario responsavel;
	private LocalDate dataInicio;
	private int prazo;
	private LocalDate dataEntrega;
	private Status status;
	private String dataString;
	
	public Tarefa(Funcionario funcionario) { //Construtor que recebe um objeto Funcionario e atribui ao responsável (responsavel) da tarefa. Também gera um código único para a tarefa.
		setCodigo(Utils.gerarUUID8());
		setResponsavel(funcionario);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataTexto) {//Aqui pegamos a variavel String e convertemos para uma Local date. Essa Local date será utilizada depois novamente para ser transformada em uma String para ser visualizada depois em uma tela gráfica
		this.dataInicio = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		dataString = dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevistaEntrega() {
		LocalDate dataPrazo = dataInicio.plusDays(prazo); //Criamos uma variavel local date dataprazo e utilizando do método, calculamos a data inicio utilizando o argumento prazo e com pluysday não excedemos os valores de dia e mês e ano padrão.
		return dataPrazo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataTexto) {
	    this.dataEntrega = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public Status getStatus() {
		if (status == null || !status.equals(Status.CONCLUIDO)) {
			calcularStatusAtual();
		}
		return status;
	}
	
	private void calcularStatusAtual() {
		LocalDate dataPrazo = getDataPrevistaEntrega();
		LocalDate hoje = LocalDate.now();
		if (hoje.isBefore(dataInicio)) {
			setStatus(Status.NAO_INICIADO);
		}
		else if (hoje.isBefore(dataPrazo)) {
			setStatus(Status.EM_ANDAMENTO);
		} else if (hoje.isAfter(dataPrazo)) {
			setStatus(Status.EM_ATRASO);
		}
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setStatus(String status) {
		if(status.equals("CONCLUIDO")) {
			this.status = Status.CONCLUIDO;
		}
	}
	
	@Override
	public String toString() {
		String matricula = responsavel.getMatricula();
		String responsavelNome = responsavel.getNome();
		return
				codigo+","+nome+","+descricao+","+responsavel+","+dataInicio+","+prazo+","+dataEntrega+","+status+".";
	}
}
