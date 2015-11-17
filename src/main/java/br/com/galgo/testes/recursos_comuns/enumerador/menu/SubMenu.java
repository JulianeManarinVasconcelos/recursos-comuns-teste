package br.com.galgo.testes.recursos_comuns.enumerador.menu;

import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_ENTIDADE;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_ENTIDADE_NEGOCIO;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_ENTIDADE_SEGURANCA;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_PAPEL;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_PAPEL_NEGOCIO;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_PAPEL_SEGURANCA;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.MASTER_STI;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.USUARIO_FINAL;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.USUARIO_FINAL_STI;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.USUARIO_SEGURANCA;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria.USUARIO_SISTEMA_EXTERNO;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel.ADMINISTRADOR;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel.ADM_SISTEMA;
import static br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel.AUTO_REGULADOR;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel;
import br.com.galgo.testes.recursos_comuns.pageObject.Tela;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.cancelamento.TelaCancelamentoExtrato;
import br.com.galgo.testes.recursos_comuns.pageObject.cancelamento.TelaCancelamentoPlCota;
import br.com.galgo.testes.recursos_comuns.pageObject.cancelamento.TelaCancelamentoPosicao;
import br.com.galgo.testes.recursos_comuns.pageObject.compromisso.TelaCompromissos;
import br.com.galgo.testes.recursos_comuns.pageObject.compromisso.TelaPainelCompromissos;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaCarteiras;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaEntidade;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaExtrato;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaFundo;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaLog;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaPLCota;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaPosicao;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioExtrato;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPlCota;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPosicaoArquivo;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaAlteracaoCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaAlteracaoFundo;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaEventosCorporativos;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaInclusaoCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaInclusaoFundo;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaValidacaoAlteracaoFundos;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaValidacaoInclusaoCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.fundo.TelaValidacaoInclusaoFundos;
import br.com.galgo.testes.recursos_comuns.permissionamento.PapelXCategoria;

public enum SubMenu {

	INTRODUCAO(Menu.INICIO, //
			"Introdução",//
			new TelaPrincipal(),//
			new PapelXCategoria(Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //

	APROVACAO(Menu.AJUDA_ON_LINE,//
			"Aprovação",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(ADM_SISTEMA),//
					Categoria.getList(USUARIO_FINAL))), //

	CADASTRO_AJUDA_ONLINE(Menu.AJUDA_ON_LINE,//
			"Cadastro",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(ADM_SISTEMA),//
					Categoria.getList(USUARIO_FINAL))), //

	CADASTRO_ENTIDADES(Menu.ENTIDADES,//
			"Cadastro",//
			new TelaConsultaEntidade(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI,//
							MASTER_ENTIDADE_NEGOCIO,//
							MASTER_ENTIDADE))), //

	CADASTROS_BASICOS(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Cadastros Básicos",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI))), //

	PARAMETROS_ALERTAS(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Parâmetros de Alertas",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI))), //

	PARAMETROS_COMPROMISSOS(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Parâmetros de Compromissos",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI))), //

	PARAMETROS_CONTROLE_ACESSO(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Parâmetros de Controle de Acesso",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI))), //

	PARAMETROS_REGISTRO_FUNDOS(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Parâmetros de Registro de Fundos",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI,//
							MASTER_ENTIDADE_NEGOCIO,//
							MASTER_ENTIDADE,//
							MASTER_PAPEL,//
							MASTER_ENTIDADE_NEGOCIO,//
							USUARIO_FINAL))), //

	PARAMETROS_GERAIS(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Parâmetros Gerais",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI))), //

	PARAMETROS_TARIFAS(Menu.CADASTROS_BASICOS_PARAMETROS,//
			"Parâmetros de Tarifas",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI,//
							USUARIO_FINAL_STI))), //

	CADASTRO_COMPROMISSO(Menu.COMPROMISSOS,//
			"Cadastro",//
			new TelaCompromissos(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CONSULTA_COMPROMISSO(Menu.COMPROMISSOS,//
			"Consulta",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //

	PAINEL_COMPROMISSO(Menu.COMPROMISSOS,//
			"Painel de Compromissos",//
			new TelaPainelCompromissos(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //

	RELATORIOS_COMPROMISSOS(Menu.COMPROMISSOS,//
			"Relatórios",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	ALERTAS(Menu.COMUNICADOS,//
			"Alertas",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA, //
							USUARIO_FINAL))), //

	FATOS_RELEVANTES(Menu.COMUNICADOS,//
			"Fatos Relevantes",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_FINAL))), //

	RELATORIOS_FATOS_RELEVANTES(Menu.COMUNICADOS,//
			"Relatórios", //
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	INCLUSAO_CARTEIRAS_ADMINISTRADAS(Menu.CARTEIRAS_ADMINISTRADAS,//
			"Inclusão",//
			new TelaInclusaoCarteira(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //
	ALTERACAO_CARTEIRAS_ADMINISTRADAS(Menu.CARTEIRAS_ADMINISTRADAS,//
			"Alteração",//
			new TelaAlteracaoCarteira(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //

	VALIDACAO_ALTERACAO_CARTEIRAS(Menu.CARTEIRAS_ADMINISTRADAS,//
			"Validação de Alteração",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(AUTO_REGULADOR),//
					Categoria.getList(USUARIO_FINAL))), //

	VALIDACAO_INCLUSAO_CARTEIRAS(Menu.CARTEIRAS_ADMINISTRADAS,//
			"Validação de Inclusão",//
			new TelaValidacaoInclusaoCarteira(), //
			new PapelXCategoria(//
					Papel.getList(AUTO_REGULADOR),//
					Categoria.getList(USUARIO_FINAL))), //

	RELATORIOS_CARTEIRAS_ADMINISTRADAS(Menu.CARTEIRAS_ADMINISTRADAS,//
			"Relatórios",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CONSULTA_FUNDOS_INVESTIMENTO(Menu.FUNDOS,//
			"Consulta",//
			new TelaConsultaFundo(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //

	CONSULTA_CARTEIRAS_ADMINISTRADAS(Menu.CARTEIRAS_ADMINISTRADAS,//
			"Consulta",//
			new TelaConsultaCarteiras(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values()))), //

	INCLUSAO_FUNDOS_INVESTIMENTO(Menu.FUNDOS,//
			"Inclusão",//
			new TelaInclusaoFundo(), //
			new PapelXCategoria(//
					Papel.getList(Papel.ADM_SISTEMA),//
					Categoria.getList(Categoria.USUARIO_FINAL))), //

	ALTERACAO_FUNDOS_INVESTIMENTO(Menu.FUNDOS,//
			"Alteração",//
			new TelaAlteracaoFundo(), //
			new PapelXCategoria(//
					Papel.getList(Papel.ADM_SISTEMA),//
					Categoria.getList(Categoria.USUARIO_FINAL))), //

	EVENTOS_CORPORATIVOS(Menu.FUNDOS,//
			"Eventos Corporativos",//
			new TelaEventosCorporativos(),//
			new PapelXCategoria(Papel.getList(ADMINISTRADOR, AUTO_REGULADOR),//
					Categoria.getList(USUARIO_FINAL,//
							MASTER_STI, MASTER_ENTIDADE))), //

	RELATORIOS_FUNDOS_INVESTIMENTO(Menu.FUNDOS,//
			"Relatórios",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	VALIDACAO_ALTERACAO_FUNDOS(Menu.FUNDOS,//
			"Validação de Alteração",//
			new TelaValidacaoAlteracaoFundos(), //
			new PapelXCategoria(//
					Papel.getList(AUTO_REGULADOR),//
					Categoria.getList(USUARIO_FINAL))), //

	VALIDACAO_INCLUSAO_FUNDOS(Menu.FUNDOS,//
			"Validação de Inclusão",//
			new TelaValidacaoInclusaoFundos(), //
			new PapelXCategoria(//
					Papel.getList(AUTO_REGULADOR),//
					Categoria.getList(USUARIO_FINAL))), //

	CONSULTA_PL_COTA(Menu.PL_COTA,//
			"Consulta",//
			new TelaConsultaPLCota(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	ENVIA_PL_COTA(Menu.PL_COTA,//
			"Envio",//
			new TelaEnvioPlCota(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CANCELAMENTO_PL_COTA(Menu.PL_COTA,//
			"Cancelamento",//
			new TelaCancelamentoPlCota(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	ENVIA_POSICAO(Menu.POSICAO_ATIVOS,//
			"Envio",//
			new TelaEnvioPosicaoArquivo(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CONSULTA_POSICAO(Menu.POSICAO_ATIVOS,//
			"Consulta",//
			new TelaConsultaPosicao(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CANCELAMENTO_POSICAO(Menu.POSICAO_ATIVOS,//
			"Cancelamento",//
			new TelaCancelamentoPosicao(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CONSULTA_EXTRATO(Menu.EXTRATO,//
			"Consulta",//
			new TelaConsultaExtrato(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	CANCELAMENTO_EXTRATO(Menu.EXTRATO,//
			"Cancelamento",//
			new TelaCancelamentoExtrato(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	ENVIA_EXTRATO(Menu.EXTRATO,//
			"Envio",//
			new TelaEnvioExtrato(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	RELATORIOS_PL_COTA(Menu.PL_COTA,//
			"Relatórios",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	ALTERACAO_SENHA(Menu.SEGURANCA,//
			"Alteração de Senha",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA, //
							USUARIO_FINAL))), //

	CONSULTA_DE_LOG(Menu.SEGURANCA,//
			"Consulta de Log",//
			new TelaConsultaLog(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA, //
							USUARIO_FINAL))), //

	CONSULTA_DE_TRILHA(Menu.SEGURANCA,//
			"Consulta de Trilha",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA, //
							USUARIO_FINAL))), //

	GRUPO_DE_FUNDO_DE_CARTEIRAS(Menu.SEGURANCA,//
			"Grupo de Fundos e Carteiras",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA))), //

	GRUPO_DE_USUARIOS(Menu.SEGURANCA,//
			"Grupo de Usuários",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA))), //

	RELATORIOS_SEGURANCA(Menu.SEGURANCA,//
			"Relatórios",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(USUARIO_FINAL))), //

	USUARIOS(Menu.SEGURANCA,//
			"Usuários",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_SEGURANCA, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_SEGURANCA, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_SEGURANCA))), //

	CADASTRO_DE_TABELAS(Menu.TARIFAS,//
			"Cadastro de Tabelas",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI))), //

	CADASTRO_DE_TABELAS_ASSOSSIADAS(Menu.TARIFAS,//
			"Consulta de Tabelas Associadas",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI))), //

	DEMONSTRATIVO_CALCULOS(Menu.TARIFAS,//
			"Demonstrativo de Cálculo",//
			new TelaPrincipal(), //
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(MASTER_STI, //
							USUARIO_FINAL_STI, //
							MASTER_ENTIDADE, //
							MASTER_ENTIDADE_NEGOCIO, //
							MASTER_PAPEL, //
							MASTER_PAPEL_NEGOCIO, //
							USUARIO_FINAL, USUARIO_SISTEMA_EXTERNO))), //

	CONSULTA_ARQUIVO_FATURAMENTO(Menu.TARIFAS,//
			"Consulta de Arquivo de Faturamento",//
			new TelaPrincipal(),//
			new PapelXCategoria(//
					Papel.getList(Papel.values()),//
					Categoria.getList(Categoria.values())));

	private Menu menuPai;
	private String linkSubMenu;
	private Tela telaDoSubMenu;
	private PapelXCategoria papelXCategoria;

	public PapelXCategoria getPapelXCategoria() {
		return papelXCategoria;
	}

	SubMenu(Menu menuPai, String link, Tela tela,
			PapelXCategoria papelXCategoria) {
		this.menuPai = menuPai;
		this.linkSubMenu = link;
		this.telaDoSubMenu = tela;
		this.papelXCategoria = papelXCategoria;
	}

	public Menu getMenuPai() {
		return menuPai;
	}

	public String getLinkSubMenu() {
		return linkSubMenu;
	}

	public Tela getTelaDoSubMenu() {
		return telaDoSubMenu;
	}

}
