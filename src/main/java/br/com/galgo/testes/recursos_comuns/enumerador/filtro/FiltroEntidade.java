package br.com.galgo.testes.recursos_comuns.enumerador.filtro;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;


public enum FiltroEntidade {

	TIPO_ENTIDADE(TipoCampo.RADIO), //
	STATUS(TipoCampo.SELECT), //
	PAIS_ORIGEM(TipoCampo.SELECT), //
	RAZAO_SOCIAL(TipoCampo.INPUT), //
	NOME_FANTASIA(TipoCampo.INPUT), //
	CNPJ(TipoCampo.INPUT), //
	EMP_ESTRANGEIRA(TipoCampo.INPUT), //
	TIPO_VINCULO(TipoCampo.SELECT), //
	CATEGORIA(TipoCampo.SELECT);

	private TipoCampo tipoCampo;

	FiltroEntidade(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

}
