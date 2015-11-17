package br.com.galgo.testes.recursos_comuns.enumerador.usuario;

import java.util.ArrayList;
import java.util.List;

public enum Papel {

	ADM_SISTEMA, //
	AUTO_REGULADOR, //
	ADMINISTRADOR, //
	ADMINISTRADOR_FIDUCIARIO, //
	AGENCIA_RISCO, //
	AGENCIA_AUTONOMO, //
	AGENTE_COMPESACAO, //
	AGENTE_CUSTODIA, //
	AGENTE_LIQUIDACAO, //
	AUDITORIA, //
	CONSULTORIA, //
	CONSUMIDOR, //
	CONTABILIDADE, //
	CONTROLADOR_ATIVO, //
	CONTROLADOR_PASSIVO, //
	COORDENADOR, //
	CORRETORA, //
	CUSTODIANTE, //
	DISTRIBUIDOR, //
	EMPRESA_RISCO, //
	EMISSOR_ATIVOS, //
	ESCRITURADOR_COSTAS, //
	GESTOR, //
	INFORMANTE_PL_COTA, //
	INFORMANTE_POSICAO_ATIVOS;

	public static List<Papel> getList(Papel... papeis) {
		List<Papel> lista = new ArrayList<Papel>();
		for (Papel papel : papeis) {
			lista.add(papel);
		}
		return lista;
	}

}
