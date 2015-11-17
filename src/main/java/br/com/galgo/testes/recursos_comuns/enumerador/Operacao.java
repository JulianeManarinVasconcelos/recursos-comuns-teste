package br.com.galgo.testes.recursos_comuns.enumerador;

public enum Operacao {

	COMPROMISSO("Compromisso", "Compromisso", null), //
	ENVIO_INFORMES("Enviar", "EnvioInformes", "1"), //
	CONSULTA_TRANSFERENCIA("Consultar", "ConsultaTransf", null), //
	CANCELA_INFORMES("Cancelar", "CancelaInformes", "3"), //
	REENVIO_INFORMES("Reenviar", "ReenvioInformes", "2"), //
	INCLUSAO_FUNDO("Inclusão de Fundo de Investimento", "InclusaoFundos", null), //
	INCLUSAO_CARTEIRA("Inclusão de Carteira Administrada", "InclusaoCarteiras",
			null), //
	VALIDACAO_FUNDO("Validação de Inclusão de Fundo", null, null), //
	ALTERACAO_FUNDO("Alteração de Fundo de Investimento", "AlteracaoFundos",
			null), //
	ALTERACAO_CARTEIRA("Alteração de Carteira Administrada",
			"AlteracaoCarteiras", null), //
	ALTERACAO_ADMIN("Alteração de Administrador", "AlteracaoAdmin", null), //
	INCORPORACAO("Incorporação", "Incorporacao", null) //
	;

	private String valor;
	private String descAba;
	private String tipoOperXML;

	Operacao(String valor, String desc, String tipoOperXML) {
		this.valor = valor;
		this.descAba = desc;
		this.tipoOperXML = tipoOperXML;
	}

	public String getTipoOperXML() {
		return tipoOperXML;
	}

	public String getValor() {
		return valor;
	}

	public String getDescAba() {
		return descAba;
	}

	public static Operacao fromValor(String valor) {
		for (Operacao oper : Operacao.values()) {
			if (valor.contains(oper.getValor())) {
				return oper;
			}
		}
		return null;
	}

}
