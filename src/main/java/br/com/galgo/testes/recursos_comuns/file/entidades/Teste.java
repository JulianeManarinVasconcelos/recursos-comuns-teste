package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.ArrayList;
import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.Canal;
import br.com.galgo.testes.recursos_comuns.enumerador.Grupo;
import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.Servico;
import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;

public class Teste {

	private Ambiente ambiente;
	private Grupo grupo;
	private Servico servico;
	private Operacao operacao;
	private Canal canal;
	private String id;
	private String desc;
	private int qtdReteste;

	public Teste(Ambiente ambiente, Grupo grupo, Servico servico,
			Operacao operacao, Canal canal, String id, String desc,
			int qtdReteste) {
		this.ambiente = ambiente;
		this.grupo = grupo;
		this.servico = servico;
		this.operacao = operacao;
		this.canal = canal;
		this.id = id;
		this.desc = desc;
		this.qtdReteste = qtdReteste;
	}

	public int getQtdReteste() {
		return qtdReteste;
	}

	public void setQtdReteste(int qtdReteste) {
		this.qtdReteste = qtdReteste;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static List<Teste> fromAmbiente(List<Teste> listaTeste,
			Ambiente ambiente) {
		List<Teste> lista = new ArrayList<Teste>();
		for (Teste teste : listaTeste) {
			if (ambiente == teste.getAmbiente()) {
				lista.add(teste);
			}
		}
		return lista;
	}

	public static List<Teste> fromGrupo(List<Teste> listaTeste, Grupo grupo) {
		List<Teste> lista = new ArrayList<Teste>();
		for (Teste teste : listaTeste) {
			if (grupo == teste.getGrupo()) {
				lista.add(teste);
			}
		}
		return lista;
	}

	public static List<Teste> fromServico(List<Teste> listaTeste,
			Servico servico) {
		List<Teste> lista = new ArrayList<Teste>();
		for (Teste teste : listaTeste) {
			if (servico == teste.getServico()) {
				lista.add(teste);
			}
		}
		return lista;
	}

	public static List<Teste> fromOperacao(List<Teste> listaTeste,
			Operacao operacao) {
		List<Teste> lista = new ArrayList<Teste>();
		for (Teste teste : listaTeste) {
			if (operacao == teste.getOperacao()) {
				lista.add(teste);
			}
		}
		return lista;
	}

	public static List<Teste> fromCanal(List<Teste> listaTeste, Canal canal) {
		List<Teste> lista = new ArrayList<Teste>();
		for (Teste teste : listaTeste) {
			if (canal == teste.getCanal()) {
				lista.add(teste);
			}
		}
		return lista;
	}

	public static Teste fromListaTeste(List<Teste> listaTeste,
			Ambiente ambiente, Grupo grupo, Servico servico, Operacao operacao,
			Canal canal) {
		listaTeste = fromAmbiente(listaTeste, ambiente);
		listaTeste = fromGrupo(listaTeste, grupo);
		listaTeste = fromServico(listaTeste, servico);
		listaTeste = fromOperacao(listaTeste, operacao);
		listaTeste = fromCanal(listaTeste, canal);

		return listaTeste.get(0);
	}

}
