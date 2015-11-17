package br.com.galgo.testes.recursos_comuns.utils;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;

public class ConstantesFundos {

	public static final String ABA_CASOS_TESTE_FUNDOS_HOMOL = "5. Casos de Teste - HOMOLOG";
	public static final String ABA_CASOS_TESTE_FUNDOS_PROD_NEW = "5. Casos de Teste - PROD";

	public static String getAbaTeste(Ambiente ambiente) {
		String abaTeste = "";

		if (ambiente == Ambiente.HOMOLOGACAO) {
			abaTeste = ConstantesFundos.ABA_CASOS_TESTE_FUNDOS_HOMOL;
		} else {
			abaTeste = ConstantesFundos.ABA_CASOS_TESTE_FUNDOS_PROD_NEW;
		}
		return abaTeste;
	}

	public static final int QTD_COLUNAS_INCLUSAO_FUNDOS = 128;
	public static final int LINHA_INICIAL_TESTE_FUNDOS = 8;
	public static final int COLUNA_GRUPO_FUNDOS = 1;
	public static final int COLUNA_CANAL_FUNDOS = 3;
	public static final int COLUNA_SERVICO_FUNDOS = 0;
	public static final int COLUNA_ID_FUNDOS = 4;
	public static final int COLUNA_OPERACAO_FUNDOS = 6;
	public static final int COLUNA_DESCRICAO_FUNDOS = 6;
	public static final int COLUNA_RETESTE_FUNDOS = 0;

	// Inclusao
	// IdentificaoFundo
	public static final int COLUNA_CNPJ = 0;
	public static final int COLUNA_RAZAO_SOCIAL = 1;
	public static final int COLUNA_NOME_FANTASIA = 2;
	public static final int COLUNA_NOME_FANTASIA_IMPRENSA = 3;
	public static final int COLUNA_SIGLA = 4;
	public static final int COLUNA_MNEMONICO_CETIP = 5;
	public static final int COLUNA_ISIN = 6;
	public static final int COLUNA_CUSIP = 7;
	public static final int COLUNA_DIVULGACAO_ANBID = 8;

	// Evento
	public static final int COLUNA_FUNDO_INICIALIZA_ENVENTO_CORP = 9;
	public static final int COLUNA_EVENTO = 10;
	public static final int COLUNA_FUNDO_ORIGEM = 11;

	// Perfil
	public static final int COLUNA_CLASSIF_CVM = 12;
	public static final int COLUNA_CATEGORIA_ANBID = 13;
	public static final int COLUNA_TIPO_ANBID = 14;
	public static final int COLUNA_PLANO_PREVIDENCIA = 15;
	public static final int COLUNA_APLICACAO_AUTOMATICA = 16;
	public static final int COLUNA_FOCO_ATUACAO = 17;
	public static final int COLUNA_CALCULO_COTAS = 18;
	public static final int COLUNA_HORARIO_PL_COTA = 19;
	public static final int COLUNA_HORARIO_POSICAO = 20;
	public static final int COLUNA_PERIODICIDADE_DIVULGACAO = 21;
	public static final int COLUNA_ABERTO_ESTATURIAMENTE = 22;
	public static final int COLUNA_DURACAO_FUNDO = 23;
	public static final int COLUNA_UNIDADE_DURACAO = 24;
	public static final int COLUNA_PRAZO_DURACAO_FUNDO = 25;
	public static final int COLUNA_BASE_DURACAO_FUNDO = 26;
	public static final int COLUNA_COMPOSICAO = 27;
	public static final int COLUNA_INVESTIDOR_QUALIFICADO = 28;
	public static final int COLUNA_ALAVANCADO = 29;
	public static final int COLUNA_PREVIDENCIARIO = 30;
	public static final int COLUNA_CREDITO_PRIVADO = 31;
	public static final int COLUNA_INVESTIMENTO_EXTERIOR = 32;
	public static final int COLUNA_RESTRICAO_INVESTIMENTO = 33;
	public static final int COLUNA_PUBLICO_ALVO = 34;
	public static final int COLUNA_DIVULGA_IMPRENSA = 35;
	public static final int COLUNA_RESPEITA_LIMITES_EMISSAO_ATIVO = 36;
	public static final int COLUNA_TRIBUTACAO_PERSEGUIDA = 37;
	public static final int COLUNA_POSSUI_PROSPECTO = 38;

	// DatasFundos
	public static final int COLUNA_FASE_PRE_OPERACIONAL = 39;
	public static final int COLUNA_DATA_INICIO_ATIVIDADE = 40;

	// PrestadoresServico
	public static final int COLUNA_ADMINISTRADOR = 41;
	public static final int COLUNA_AGENCIA_CLASSIF_RISCO = 42;
	public static final int COLUNA_AUDITORIA = 43;
	public static final int COLUNA_CONSULTORIA = 44;
	public static final int COLUNA_CONTABILIDADE = 45;
	public static final int COLUNA_CONTROLADOR_ATIVOS = 46;
	public static final int COLUNA_CONTROLADOR_PASSIVOS = 47;
	public static final int COLUNA_COORDENADOR_DISTRIBUIDOR_LIDER = 48;
	public static final int COLUNA_CUSTODIANTES_UNICO = 49;
	public static final int COLUNA_CUSTODIANTE_COTAS = 50;
	public static final int COLUNA_CUSTODIANTE_DERIVATIVOS = 51;
	public static final int COLUNA_CUSTODIANTES_RENDA_FIXA = 52;
	public static final int COLUNA_CUSTODIANTE_RENDA_VARIAVEL = 53;
	public static final int COLUNA_DISTRIBUIDOR_AGENTE_AUTONOMO = 54;
	public static final int COLUNA_EMPRESA_AVALIACAO_RISCO = 55;
	public static final int COLUNA_ESCRITURADOR_COTAS = 56;
	public static final int COLUNA_GESTOR_UNICO = 57;
	public static final int COLUNA_GESTOR_COTAS = 58;
	public static final int COLUNA_GESTOR_DERIVATIVOS = 59;
	public static final int COLUNA_GESTOR_RENDA_FIXA = 60;
	public static final int COLUNA_GESTOR_RENDA_VARIAVEL = 61;

	// TaxasFundos
	public static final int COLUNA_PERFIL_TAXA_ADMIN = 62;
	public static final int COLUNA_UNIDADE_TAXA_ADMIN = 63;
	public static final int COLUNA_VALOR_TAXA_ADMIN = 64;
	public static final int COLUNA_PL_BASE_CALCULO_TAXA = 65;
	public static final int COLUNA_VALOR_PISO = 66;
	public static final int COLUNA_INDICE_CORRECAO = 67;
	public static final int COLUNA_PERIODO_CORRECAO = 68;
	public static final int COLUNA_APLICAO_OUTROS_FUNDOS = 69;
	public static final int COLUNA_TAXA_MAXIMA = 70;
	public static final int COLUNA_VALOR_INICIAL_PL = 71;
	public static final int COLUNA_VALOR_FINAL_PL = 72;
	public static final int COLUNA_UNIDADE_TAXA = 73;
	public static final int COLUNA_TAXA = 74;
	public static final int COLUNA_PERIODO_COBR_TAXA_ADMIN = 75;
	public static final int COLUNA_INFO_ADICIONAL_TAXA_NAO_PADRONIZADA = 76;
	public static final int COLUNA_COBRA_TAXA_PERFORM = 77;
	public static final int COLUNA_INDICADOR_TAXA_COMPOSTA = 78;
	public static final int COLUNA_PERCENTUAL = 79;
	public static final int COLUNA_PORCENT_INDICE_REFERENCIA = 80;
	public static final int COLUNA_INDICE_REFERENCIA = 81;
	public static final int COLUNA_CUPOM_TAXA_PERFORM = 82;
	public static final int COLUNA_PERIOD_COBRANC_TAXA_PERFORM = 83;
	public static final int COLUNA_PL_BASE_CALCULO_TAXA_PERFORM = 84;
	public static final int COLUNA_DIA_UTIL_CALCULO_TAXA_PERFORM = 85;
	public static final int COLUNA_LINHA_DAGUA = 86;
	public static final int COLUNA_ZERAMENTO_PERFORMANCE = 87;
	public static final int COLUNA_BASE_CALCULO_TAXA_PERFORM = 88;
	public static final int COLUNA_AJUSTE_PERFORM_COTISTA = 89;
	public static final int COLUNA_INFO_ADICIONAIS_TAXA_PERFORM = 90;
	public static final int COLUNA_TIPO_TAXA_ENTRADA = 91;
	public static final int COLUNA_VALOR_TAXA_ENTRADA = 92;
	public static final int COLUNA_INFO_ADICIONAL_TAXA_ENTRADA = 93;
	public static final int COLUNA_TIPO_TAXA_SAIDA = 94;
	public static final int COLUNA_VALOR_TAXA_SAIDA = 95;
	public static final int COLUNA_INFO_ADICIONAL_TAXA_SAIDA = 96;

	// ParametrosMovimentacao
	public static final int COLUNA_IND_PRAZO_CONVERSAO_COTAS = 97;
	public static final int COLUNA_PRAZO_CONVERSAO_APLICACAO = 98;
	public static final int COLUNA_ESTABELECE_VALORES_MINIMOS_MOV = 99;
	public static final int COLUNA_APLICACAO_INICIAL = 100;
	public static final int COLUNA_APLICACAO_ADICIONAL = 101;
	public static final int COLUNA_INDICADOR_PRAZO_CONVERSAO_RESG = 102;
	public static final int COLUNA_PRAZO_CONVERSAO_RESG = 103;
	public static final int COLUNA_IND_PRAZO_PAGTO_RESG = 104;
	public static final int COLUNA_PRAZO_PAGTO_RESG = 105;
	public static final int COLUNA_POSSUI_PAGTO_RESG = 106;
	public static final int COLUNA_REGRA_PAGTO_RESG = 107;
	public static final int COLUNA_CARENCIA_INICIAL = 108;
	public static final int COLUNA_CARENCIA_CICLICA = 109;
	public static final int COLUNA_RESGATE = 110;
	public static final int COLUNA_SALDO_MINIMO = 111;
	public static final int COLUNA_ABERTO_CAPTACAO = 112;
	public static final int COLUNA_DATA_ABERTURA_CAPTACAO = 113;

	// Amortizacao
	public static final int COLUNA_POSSUI_MECANISMO_AMORTIZACAO = 114;
	public static final int COLUNA_DATA_PRIMEIRA_AMORTIZACAO = 115;
	public static final int COLUNA_PERIODICIDADE_AMORTIZACAO = 116;
	public static final int COLUNA_DATA_BASE_AMORTIZACAO = 117;
	public static final int COLUNA_DIA_UTIL_AMORTIZACAO = 118;
	public static final int COLUNA_OBSERVACOES_AMORTIZACAO = 119;

	// Contas
	public static final int COLUNA_BANCO_CONSTA_CORRENTE_APLIC = 120;
	public static final int COLUNA_AGENCIA_CONTA_CORRENTE_APLIC = 121;
	public static final int COLUNA_CONSTA_CORRENTE_APLIC = 122;
	public static final int COLUNA_COD_SUSEP = 123;

	// DoctosAnexados
	public static final int COLUNA_ATA_ASSEMBLEIA = 124;
	public static final int COLUNA_IDIOMA_ATA_ASSEMBLEIA = 125;
	public static final int COLUNA_CARTA_ISENCAO = 126;
	public static final int COLUNA_IDIOMA_CARTA_ISENCAO = 127;
	public static final int COLUNA_PROSPECTO = 128;
	public static final int COLUNA_IDIOMA_PROSPECTO = 129;
	public static final int COLUNA_REGULAMENTO = 130;
	public static final int COLUNA_IDIOMA_REGULAMENTO = 131;
	public static final int COLUNA_OUTROS_DOCTOS = 132;
	public static final int COLUNA_IDIOMA_OUTROS_DOCTOS = 133;

	// Alteracao
	// IdentificaoFundo
	public static final int COLUNA_CNPJ_ALTERACAO = 0;
	public static final int COLUNA_RAZAO_SOCIAL_ALTERACAO = 1;
	public static final int COLUNA_DATA_INI_VIG_RAZAO_SOCIAL = 2;
	public static final int COLUNA_NOME_FANTASIA_ALTERACAO = 3;
	public static final int COLUNA_DATA_INI_VIG_NOME_FANTASIA = 4;
	public static final int COLUNA_NOME_FANTASIA_IMPRENSA_ALTERACAO = 5;
	public static final int COLUNA_SIGLA_ALTERACAO = 6;
	public static final int COLUNA_MNEMONICO_CETIP_ALTERACAO = 7;
	public static final int COLUNA_ISIN_ALTERACAO = 8;
	public static final int COLUNA_CUSIP_ALTERACAO = 9;
	public static final int COLUNA_DIVULGACAO_ANBID_ALTERACAO = 10;
	public static final int COLUNA_ALTERACAO_INPLICA_ANALISE = 11;

	// Evento
	public static final int COLUNA_FUNDO_INICIALIZA_ENVENTO_CORP_ALTERACAO = 12;
	public static final int COLUNA_EVENTO_ALTERACAO = 13;
	public static final int COLUNA_FUNDO_ORIGEM_ALTERACAO = 14;

	// Perfil

	public static final int COLUNA_CLASSIF_CVM_ALTERACAO = 15;
	public static final int COLUNA_DATA_INI_VIG_CLASSIF_CVM = 16;
	public static final int COLUNA_CATEGORIA_ANBID_ALTERACAO = 17;
	public static final int COLUNA_DATA_INI_VIG_CATEGORIA_ANBID = 18;
	public static final int COLUNA_TIPO_ANBID_ALTERACAO = 19;
	public static final int COLUNA_DATA_INI_VIG_TIPO_ANBID = 20;
	public static final int COLUNA_PLANO_PREVIDENCIA_ALTERACAO = 21;
	public static final int COLUNA_DATA_INI_VIG_PLANO_PREVIDENCIA = 22;
	public static final int COLUNA_APLICACAO_AUTOMATICA_ALTERACAO = 23;
	public static final int COLUNA_DATA_INI_VIG_APLICACAO_AUTOMATICA = 24;
	public static final int COLUNA_FOCO_ATUACAO_ALTERACAO = 25;
	public static final int COLUNA_DATA_INI_VIG_FOCO_ATUACAO = 26;
	public static final int COLUNA_CALCULO_COTAS_ALTERACAO = 27;
	public static final int COLUNA_DATA_INI_VIG_CALCULO_COTAS = 28;
	public static final int COLUNA_HORARIO_PL_COTA_ALTERACAO = 29;
	public static final int COLUNA_HORARIO_POSICAO_ALTERACAO = 30;
	public static final int COLUNA_PERIODICIDADE_DIVULGACAO_ALTERACAO = 31;
	public static final int COLUNA_ABERTO_ESTATURIAMENTE_ALTERACAO = 32;
	public static final int COLUNA_DURACAO_FUNDO_ALTERACAO = 33;
	public static final int COLUNA_UNIDADE_DURACAO_ALTERACAO = 34;
	public static final int COLUNA_PRAZO_DURACAO_FUNDO_ALTERACAO = 35;
	public static final int COLUNA_BASE_DURACAO_FUNDO_ALTERACAO = 36;
	public static final int COLUNA_COMPOSICAO_ALTERACAO = 37;
	public static final int COLUNA_DATA_INI_VIG_COMPOSICAO = 38;
	public static final int COLUNA_INVESTIDOR_QUALIFICADO_ALTERACAO = 39;
	public static final int COLUNA_DATA_INI_VIG_INVESTIDOR_QUALIFICADO = 40;
	public static final int COLUNA_ALAVANCADO_ALTERACAO = 41;
	public static final int COLUNA_DATA_INI_VIG_ALAVANCADO = 42;
	public static final int COLUNA_PREVIDENCIARIO_ALTERACAO = 43;
	public static final int COLUNA_DATA_INI_VIG__PREVIDENCIARIO = 44;
	public static final int COLUNA_CREDITO_PRIVADO_ALTERACAO = 45;
	public static final int COLUNA_DATA_INI_VIG_CREDITO_PRIVADO = 46;
	public static final int COLUNA_INVESTIMENTO_EXTERIOR_ALTERACAO = 47;
	public static final int COLUNA_DATA_INI_VIG_INVESTIMENTO_EXTERIOR = 48;
	public static final int COLUNA_RESTRICAO_INVESTIMENTO_ALTERACAO = 49;
	public static final int COLUNA_DATA_INI_VIG_RESTRICAO_INVESTIMENTO = 50;
	public static final int COLUNA_PUBLICO_ALVO_ALTERACAO = 51;
	public static final int COLUNA_DATA_INI_VIG_PUBLICO_ALVO = 52;
	public static final int COLUNA_DIVULGA_IMPRENSA_ALTERACAO = 53;
	public static final int COLUNA_RESPEITA_LIMITES_EMISSAO_ATIVO_ALTERACAO = 54;
	public static final int COLUNA_DATA_INI_VIG_RESPEITA_LIMITES_EMISSAO_ATIVO = 55;
	public static final int COLUNA_TRIBUTACAO_PERSEGUIDA_ALTERACAO = 56;
	public static final int COLUNA_DATA_INI_VIG_TRIBUTACAO_PERSEGUIDA = 57;
	public static final int COLUNA_POSSUI_PROSPECTO_ALTERACAO = 58;

	// DatasFundos
	public static final int COLUNA_FASE_PRE_OPERACIONAL_ALTERACAO = 59;
	public static final int COLUNA_DATA_INICIO_ATIVIDADE_ALTERACAO = 60;
	public static final int COLUNA_DATA_PUBLIC_INICIO_OFERTA = 61;
	public static final int COLUNA_DATA_VINCULACAO_ANBID = 62;
	public static final int COLUNA_DATA_DESVINCULACAO_ANBID = 63;
	public static final int COLUNA_DATA_ASSEMBLEIA = 64;
	public static final int COLUNA_DATA_PROTOCOLO_CVM = 65;
	public static final int COLUNA_DATA_INICIO_VALIDADE_ALTERACAO = 66;

	// PrestadoresServico
	public static final int COLUNA_ADMINISTRADOR_ALTERACAO = 67;
	public static final int COLUNA_DATA_INI_VIG_ADMINISTRADOR = 68;
	public static final int COLUNA_AGENCIA_CLASSIF_RISCO_ALTERACAO = 69;
	public static final int COLUNA_AUDITORIA_ALTERACAO = 70;
	public static final int COLUNA_DATA_INI_VIG_AUDITORIA = 71;
	public static final int COLUNA_CONSULTORIA_ALTERACAO = 72;
	public static final int COLUNA_CONTABILIDADE_ALTERACAO = 73;
	public static final int COLUNA_CONTROLADOR_ATIVOS_ALTERACAO = 74;
	public static final int COLUNA_DATA_INI_VIG_CONTROLADOR_ATIVOS = 75;
	public static final int COLUNA_CONTROLADOR_PASSIVOS_ALTERACAO = 76;
	public static final int COLUNA_DATA_INI_VIG_CONTROLADOR_PASSIVOS = 77;
	public static final int COLUNA_COORDENADOR_DISTRIBUIDOR_LIDER_ALTERACAO = 78;
	public static final int COLUNA_CUSTODIANTES_UNICO_ALTERACAO = 79;
	public static final int COLUNA_DATA_INI_VIG_CUSTODIANTES_UNICO = 80;
	public static final int COLUNA_CUSTODIANTE_COTAS_ALTERACAO = 81;
	public static final int COLUNA_DATA_INI_VIG_CUSTODIANTE_COTAS = 82;
	public static final int COLUNA_CUSTODIANTE_DERIVATIVOS_ALTERACAO = 83;
	public static final int COLUNA_DATA_INI_VIG_CUSTODIANTE_DERIVATIVOS = 84;
	public static final int COLUNA_CUSTODIANTES_RENDA_FIXA_ALTERACAO = 85;
	public static final int COLUNA_DATA_INI_VIG_CUSTODIANTES_RENDA_FIXA = 86;
	public static final int COLUNA_CUSTODIANTE_RENDA_VARIAVEL_ALTERACAO = 87;
	public static final int COLUNA_DATA_INI_VIG_CUSTODIANTE_RENDA_VARIAVEL = 88;
	public static final int COLUNA_DISTRIBUIDOR_AGENTE_AUTONOMO_ALTERACAO = 89;
	public static final int COLUNA_EMPRESA_AVALIACAO_RISCO_ALTERACAO = 90;
	public static final int COLUNA_ESCRITURADOR_COTAS_ALTERACAO = 91;
	public static final int COLUNA_GESTOR_UNICO_ALTERACAO = 92;
	public static final int COLUNA_DATA_INI_VIG_GESTOR_UNICO = 93;
	public static final int COLUNA_GESTOR_COTAS_ALTERACAO = 94;
	public static final int COLUNA_DATA_INI_VIG_GESTOR_COTAS = 95;
	public static final int COLUNA_GESTOR_DERIVATIVOS_ALTERACAO = 96;
	public static final int COLUNA_DATA_INI_VIG_GESTOR_DERIVATIVOS = 97;
	public static final int COLUNA_GESTOR_RENDA_FIXA_ALTERACAO = 98;
	public static final int COLUNA_DATA_INI_VIG_GESTOR_RENDA_FIXA = 99;
	public static final int COLUNA_GESTOR_RENDA_VARIAVEL_ALTERACAO = 100;
	public static final int COLUNA_DATA_INI_VIG_GESTOR_RENDA_VARIAVEL = 101;

	// TaxasFundos
	public static final int COLUNA_DATA_INI_VIG_TAXA_ADMIN = 102;
	public static final int COLUNA_PERFIL_TAXA_ADMIN_ALTERACAO = 103;
	public static final int COLUNA_UNIDADE_TAXA_ADMIN_ALTERACAO = 104;
	public static final int COLUNA_VALOR_TAXA_ADMIN_ALTERACAO = 105;
	public static final int COLUNA_PL_BASE_CALCULO_TAXA_ALTERACAO = 106;
	public static final int COLUNA_VALOR_PISO_ALTERACAO = 107;
	public static final int COLUNA_INDICE_CORRECAO_ALTERACAO = 108;
	public static final int COLUNA_PERIODO_CORRECAO_ALTERACAO = 109;
	public static final int COLUNA_APLICAO_OUTROS_FUNDOS_ALTERACAO = 110;
	public static final int COLUNA_TAXA_MAXIMA_ALTERACAO = 111;
	public static final int COLUNA_VALOR_INICIAL_PL_ALTERACAO = 112;
	public static final int COLUNA_VALOR_FINAL_PL_ALTERACAO = 113;
	public static final int COLUNA_UNIDADE_TAXA_ALTERACAO = 114;
	public static final int COLUNA_TAXA_ALTERACAO = 115;
	public static final int COLUNA_PERIODO_COBR_TAXA_ADMIN_ALTERACAO = 116;
	public static final int COLUNA_INFO_ADICIONAL_TAXA_NAO_PADRONIZADA_ALTERACAO = 117;
	public static final int COLUNA_DATA_INI_VIG_TAXA_PERFORM = 118;
	public static final int COLUNA_COBRA_TAXA_PERFORM_ALTERACAO = 119;
	public static final int COLUNA_INDICADOR_TAXA_COMPOSTA_ALTERACAO = 120;
	public static final int COLUNA_PERCENTUAL_ALTERACAO = 121;
	public static final int COLUNA_PORCENT_INDICE_REFERENCIA_ALTERACAO = 122;
	public static final int COLUNA_INDICE_REFERENCIA_ALTERACAO = 123;
	public static final int COLUNA_CUPOM_TAXA_PERFORM_ALTERACAO = 124;
	public static final int COLUNA_PERIOD_COBRANC_TAXA_PERFORM_ALTERACAO = 125;
	public static final int COLUNA_PL_BASE_CALCULO_TAXA_PERFORM_ALTERACAO = 126;
	public static final int COLUNA_DIA_UTIL_CALCULO_TAXA_PERFORM_ALTERACAO = 127;
	public static final int COLUNA_LINHA_DAGUA_ALTERACAO = 128;
	public static final int COLUNA_ZERAMENTO_PERFORMANCE_ALTERACAO = 129;
	public static final int COLUNA_BASE_CALCULO_TAXA_PERFORM_ALTERACAO = 130;
	public static final int COLUNA_AJUSTE_PERFORM_COTISTA_ALTERACAO = 131;
	public static final int COLUNA_INFO_ADICIONAIS_TAXA_PERFORM_ALTERACAO = 132;
	public static final int COLUNA_DATA_INI_VIG_TAXA_ENTRADA = 133;
	public static final int COLUNA_TIPO_TAXA_ENTRADA_ALTERACAO = 134;
	public static final int COLUNA_VALOR_TAXA_ENTRADA_ALTERACAO = 135;
	public static final int COLUNA_INFO_ADICIONAL_TAXA_ENTRADA_ALTERACAO = 136;
	public static final int COLUNA_DATA_INI_VIG_TAXA_SAIDA = 137;
	public static final int COLUNA_TIPO_TAXA_SAIDA_ALTERACAO = 138;
	public static final int COLUNA_VALOR_TAXA_SAIDA_ALTERACAO = 139;
	public static final int COLUNA_INFO_ADICIONAL_TAXA_SAIDA_ALTERACAO = 140;

	// ParametrosMovimentacao
	public static final int COLUNA_IND_PRAZO_CONVERSAO_COTAS_ALTERACAO = 141;
	public static final int COLUNA_PRAZO_CONVERSAO_APLICACAO_ALTERACAO = 142;
	public static final int COLUNA_DATA_INI_VIG_PRAZO_CONVERSAO_APLICACAO = 143;
	public static final int COLUNA_ESTABELECE_VALORES_MINIMOS_MOV_ALTERACAO = 144;
	public static final int COLUNA_APLICACAO_INICIAL_ALTERACAO = 145;
	public static final int COLUNA_APLICACAO_ADICIONAL_ALTERACAO = 146;
	public static final int COLUNA_INDICADOR_PRAZO_CONVERSAO_RESG_ALTERACAO = 147;
	public static final int COLUNA_PRAZO_CONVERSAO_RESG_ALTERACAO = 148;
	public static final int COLUNA_DATA_INI_VIG_PRAZO_CONVERSAO_RESG = 149;
	public static final int COLUNA_IND_PRAZO_PAGTO_RESG_ALTERACAO = 150;
	public static final int COLUNA_PRAZO_PAGTO_RESG_ALTERACAO = 151;
	public static final int COLUNA_DATA_INI_VIG_PRAZO_PAGTO_RESG = 152;
	public static final int COLUNA_POSSUI_PAGTO_RESG_ALTERACAO = 153;
	public static final int COLUNA_DATA_INI_VIG_POSSUI_PAGTO_RESG = 154;
	public static final int COLUNA_REGRA_PAGTO_RESG_ALTERACAO = 155;
	public static final int COLUNA_DATA_INI_VIG_REGRA_PAGTO_RESG = 156;
	public static final int COLUNA_CARENCIA_INICIAL_ALTERACAO = 157;
	public static final int COLUNA_CARENCIA_CICLICA_ALTERACAO = 158;
	public static final int COLUNA_RESGATE_ALTERACAO = 159;
	public static final int COLUNA_SALDO_MINIMO_ALTERACAO = 160;
	public static final int COLUNA_ABERTO_CAPTACAO_ALTERACAO = 161;
	public static final int COLUNA_DATA_ABERTURA_CAPTACAO_ALTERACAO = 162;
	public static final int COLUNA_DATA_FECHAMENTO_CAPTACAO_ALTERACAO = 163;

	// Amortizacao
	public static final int COLUNA_POSSUI_MECANISMO_AMORTIZACAO_ALTERACAO = 164;
	public static final int COLUNA_DATA_PRIMEIRA_AMORTIZACAO_ALTERACAO = 165;
	public static final int COLUNA_PERIODICIDADE_AMORTIZACAO_ALTERACAO = 166;
	public static final int COLUNA_DATA_BASE_AMORTIZACAO_ALTERACAO = 167;
	public static final int COLUNA_DIA_UTIL_AMORTIZACAO_ALTERACAO = 168;
	public static final int COLUNA_OBSERVACOES_AMORTIZACAO_ALTERACAO = 169;

	// Contas
	public static final int COLUNA_BANCO_CONSTA_CORRENTE_APLIC_ALTERACAO = 170;
	public static final int COLUNA_AGENCIA_CONTA_CORRENTE_APLIC_ALTERACAO = 171;
	public static final int COLUNA_CONSTA_CORRENTE_APLIC_ALTERACAO = 172;
	public static final int COLUNA_COD_SUSEP_ALTERACAO = 173;

	// DoctosAnexados
	public static final int COLUNA_ALTERACAO_IMPACTA_BD_ANBID = 174;
	public static final int COLUNA_ATA_ASSEMBLEIA_ALTERACAO = 175;
	public static final int COLUNA_IDIOMA_ATA_ASSEMBLEIA_ALTERACAO = 176;
	public static final int COLUNA_VERSAO_ANTERIOR_VALIDA_ATA = 177;
	public static final int COLUNA_CARTA_ISENCAO_ALTERACAO = 178;
	public static final int COLUNA_IDIOMA_CARTA_ISENCAO_ALTERACAO = 179;
	public static final int COLUNA_VERSAO_ANTERIOR_VALIDA_CARTA = 180;
	public static final int COLUNA_PROSPECTO_ALTERACAO = 181;
	public static final int COLUNA_IDIOMA_PROSPECTO_ALTERACAO = 182;
	public static final int COLUNA_VERSAO_ANTERIOR_VALIDA_PROSPECTO = 183;
	public static final int COLUNA_REGULAMENTO_ALTERACAO = 184;
	public static final int COLUNA_IDIOMA_REGULAMENTO_ALTERACAO = 185;
	public static final int COLUNA_VERSAO_ANTERIOR_VALIDA_REGULAMENTO = 186;
	public static final int COLUNA_OUTROS_DOCTOS_ALTERACAO = 187;
	public static final int COLUNA_IDIOMA_OUTROS_DOCTOS_ALTERACAO = 188;
	public static final int COLUNA_VERSAO_ANTERIOR_VALIDA_OUTROS_DOCTOS = 189;

	// EventosCorporativos
	public static final int COLUNA_CNPJ_ALTERACAO_ADMIN = 0;
	public static final int COLUNA_NOVO_ADMIN = 1;
	public static final int COLUNA_DATA_EVENTO_TROCA_ADMIN = 2;

	// Incorporacao
	public static final int COLUNA_CNPJ_ORIGEM = 0;
	public static final int COLUNA_NOVO_DESTINO = 1;
	public static final int COLUNA_DATA_EVENTO_INCORP = 2;

}
