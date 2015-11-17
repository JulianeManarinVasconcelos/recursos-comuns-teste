package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.Date;

public class HistoricoEventos {

	private Date dataHistorico;
	private String qtdEventosConsolidadoPre;
	private String qtdEventosNaoConsolidadaPre;
	private String qtdEventosConsolidadoPos;
	private String qtdEventosNaoConsolidadoPos;

	public HistoricoEventos(Date dataHistorico,
			String qtdEventosConsolidadoPre,
			String qtdEventosNaoConsolidadaPre,
			String qtdEventosConsolidadoPos, String qtdEventosNaoConsolidadoPos) {
		super();
		this.dataHistorico = dataHistorico;
		this.qtdEventosConsolidadoPre = qtdEventosConsolidadoPre;
		this.qtdEventosNaoConsolidadaPre = qtdEventosNaoConsolidadaPre;
		this.qtdEventosConsolidadoPos = qtdEventosConsolidadoPos;
		this.qtdEventosNaoConsolidadoPos = qtdEventosNaoConsolidadoPos;
	}

	public Date getDataHistorico() {
		return dataHistorico;
	}

	public void setDataHistorico(Date dataHistorico) {
		this.dataHistorico = dataHistorico;
	}

	public String getQtdEventosConsolidadoPre() {
		return qtdEventosConsolidadoPre;
	}

	public void setQtdEventosConsolidadoPre(String qtdEventosConsolidadoPre) {
		this.qtdEventosConsolidadoPre = qtdEventosConsolidadoPre;
	}

	public String getQtdEventosNaoConsolidadaPre() {
		return qtdEventosNaoConsolidadaPre;
	}

	public void setQtdEventosNaoConsolidadaPre(
			String qtdEventosNaoConsolidadaPre) {
		this.qtdEventosNaoConsolidadaPre = qtdEventosNaoConsolidadaPre;
	}

	public String getQtdEventosConsolidadoPos() {
		return qtdEventosConsolidadoPos;
	}

	public void setQtdEventosConsolidadoPos(String qtdEventosConsolidadoPos) {
		this.qtdEventosConsolidadoPos = qtdEventosConsolidadoPos;
	}

	public String getQtdEventosNaoConsolidadoPos() {
		return qtdEventosNaoConsolidadoPos;
	}

	public void setQtdEventosNaoConsolidadoPos(
			String qtdEventosNaoConsolidadoPos) {
		this.qtdEventosNaoConsolidadoPos = qtdEventosNaoConsolidadoPos;
	}

}
