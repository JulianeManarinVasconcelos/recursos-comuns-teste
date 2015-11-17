package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.AplicacaoAutomatica;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.BaseDuracaoFundo;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.CategoriaAnbid;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.ClassificacaoCVM;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Composicao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.CreditoPrivado;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.FocoAtuacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.InvestimentoExterior;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PeriodicidadeDivulgacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PlanoPrevidencia;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PublicoAlvo;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.RestricaoInvestimento;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.TipoAnbid;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.TributacaoPerseguida;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.UnidadeDuracaoFundo;

public class PerfilFundo {

	private ClassificacaoCVM classificacaoCVM;
	private String dataInicioVigClassificCVM;
	private CategoriaAnbid categoriaAnbid;
	private String dataInicioVigCategoriaAnbid;
	private TipoAnbid tipoAnbid;
	private String dataInicioVigTipoAnbid;
	private PlanoPrevidencia planoPrevidencia;
	private String dataInicioVigPlanoPrev;
	private AplicacaoAutomatica aplicacaoAutomatica;
	private String dataInicioVigAplcAuto;
	private FocoAtuacao focoAtuacao;
	private String dataInicioVigFocoAtuacao;
	private String calculaCota;
	private String dataInicioVigCalculoCotas;
	private String horarioCompromPlCota;
	private String horarioCompromPosicao;
	private PeriodicidadeDivulgacao periodicidadeDivulgacao;
	private boolean abertoEstaturiamente;
	private String duracaoFundo;
	private UnidadeDuracaoFundo unidadeDuracaoFundo;
	private String prazoDuracaoFundo;
	private BaseDuracaoFundo baseDuracaoFundo;
	private Composicao composicao;
	private String dataInicioVigComposicao;
	private boolean investidorQualificado;
	private String dataInicioVigInvestidorQualificado;
	private boolean alavancado;
	private String dataInicioVigAlavancado;
	private boolean previdenciario;
	private String dataInicioVigPrevidenciario;
	private CreditoPrivado creditoPrivado;
	private String dataInicioVigCreditoPriv;
	private InvestimentoExterior investimentoExterior;
	private String dataInicioVigInvestExt;
	private RestricaoInvestimento restricaoInvestimento;
	private String dataInicioVigRestricaoInvestimentot;
	private List<PublicoAlvo> publicoAlvo;
	private String dataInicioVigPublicoAlvo;
	private boolean divulgacaoImprensa;
	private boolean respeitaLimitesEmissosAtivo;
	private String dataInicioVigRespeitaLimites;
	private TributacaoPerseguida tributacaoPerseguida;
	private String dataInicioVigTributacaoPerseguida;
	private boolean possuiPorspecto;

	public PerfilFundo(ClassificacaoCVM classificacaoCVM,//
			CategoriaAnbid categoriaAnbid,//
			TipoAnbid tipoAnbid,//
			PlanoPrevidencia planoPrevidencia,//
			AplicacaoAutomatica aplicacaoAutomatica,//
			FocoAtuacao focoAtuacao,//
			String calculaCota,//
			String horarioCompromPlCota,//
			String horarioCompromPosicao,//
			PeriodicidadeDivulgacao periodicidadeDivulgacao,//
			boolean abertoEstaturiamente,//
			String duracaoFundo,//
			UnidadeDuracaoFundo unidadeDuracaoFundo,//
			String prazoDuracaoFundo,//
			BaseDuracaoFundo baseDuracaoFundo,//
			Composicao composicao,//
			boolean investidorQualificado,//
			boolean alavancado,//
			boolean previdenciario,//
			CreditoPrivado creditoPrivado,//
			InvestimentoExterior investimentoExterior,//
			RestricaoInvestimento restricaoInvestimento,//
			List<PublicoAlvo> publicoAlvo,//
			boolean divulgacaoImprensa,//
			boolean respeitaLimitesEmissosAtivo,//
			TributacaoPerseguida tributacaoPerseguida,//
			boolean possuiPorspecto) {
		super();
		this.classificacaoCVM = classificacaoCVM;
		this.categoriaAnbid = categoriaAnbid;
		this.tipoAnbid = tipoAnbid;
		this.planoPrevidencia = planoPrevidencia;
		this.aplicacaoAutomatica = aplicacaoAutomatica;
		this.focoAtuacao = focoAtuacao;
		this.calculaCota = calculaCota;
		this.horarioCompromPlCota = horarioCompromPlCota;
		this.horarioCompromPosicao = horarioCompromPosicao;
		this.periodicidadeDivulgacao = periodicidadeDivulgacao;
		this.abertoEstaturiamente = abertoEstaturiamente;
		this.duracaoFundo = duracaoFundo;
		this.unidadeDuracaoFundo = unidadeDuracaoFundo;
		this.prazoDuracaoFundo = prazoDuracaoFundo;
		this.baseDuracaoFundo = baseDuracaoFundo;
		this.composicao = composicao;
		this.investidorQualificado = investidorQualificado;
		this.alavancado = alavancado;
		this.previdenciario = previdenciario;
		this.creditoPrivado = creditoPrivado;
		this.investimentoExterior = investimentoExterior;
		this.restricaoInvestimento = restricaoInvestimento;
		this.publicoAlvo = publicoAlvo;
		this.divulgacaoImprensa = divulgacaoImprensa;
		this.respeitaLimitesEmissosAtivo = respeitaLimitesEmissosAtivo;
		this.tributacaoPerseguida = tributacaoPerseguida;
		this.possuiPorspecto = possuiPorspecto;
	}

	public PerfilFundo(ClassificacaoCVM classificacaoCVM,
			String dataInicioVigClassificCVM, CategoriaAnbid categoriaAnbid,
			String dataInicioVigCategoriaAnbid, TipoAnbid tipoAnbid,
			String dataInicioVigTipoAnbid, PlanoPrevidencia planoPrevidencia,
			String dataInicioVigPlanoPrev,
			AplicacaoAutomatica aplicacaoAutomatica,
			String dataInicioVigAplcAuto, FocoAtuacao focoAtuacao,
			String dataInicioVigFocoAtuacao, String calculaCota,
			String dataInicioVigCalculoCotas, String horarioCompromPlCota,
			String horarioCompromPosicao,
			PeriodicidadeDivulgacao periodicidadeDivulgacao,
			boolean abertoEstaturiamente, String duracaoFundo,
			UnidadeDuracaoFundo unidadeDuracaoFundo, String prazoDuracaoFundo,
			BaseDuracaoFundo baseDuracaoFundo, Composicao composicao,
			String dataInicioVigComposicao, boolean investidorQualificado,
			String dataInicioVigInvestidorQualificado, boolean alavancado,
			String dataInicioVigAlavancado, boolean previdenciario,
			String dataInicioVigPrevidenciario, CreditoPrivado creditoPrivado,
			String dataInicioVigCreditoPriv,
			InvestimentoExterior investimentoExterior,
			String dataInicioVigInvestExt,
			RestricaoInvestimento restricaoInvestimento,
			String dataInicioVigRestricaoInvestimentot,
			List<PublicoAlvo> publicoAlvo, String dataInicioVigPublicoAlvo,
			boolean divulgacaoImprensa, boolean respeitaLimitesEmissosAtivo,
			String dataInicioVigRespeitaLimites,
			TributacaoPerseguida tributacaoPerseguida,
			String dataInicioVigTributacaoPerseguida, boolean possuiPorspecto) {
		super();
		this.classificacaoCVM = classificacaoCVM;
		this.dataInicioVigClassificCVM = dataInicioVigClassificCVM;
		this.categoriaAnbid = categoriaAnbid;
		this.dataInicioVigCategoriaAnbid = dataInicioVigCategoriaAnbid;
		this.tipoAnbid = tipoAnbid;
		this.dataInicioVigTipoAnbid = dataInicioVigTipoAnbid;
		this.planoPrevidencia = planoPrevidencia;
		this.dataInicioVigPlanoPrev = dataInicioVigPlanoPrev;
		this.aplicacaoAutomatica = aplicacaoAutomatica;
		this.dataInicioVigAplcAuto = dataInicioVigAplcAuto;
		this.focoAtuacao = focoAtuacao;
		this.dataInicioVigFocoAtuacao = dataInicioVigFocoAtuacao;
		this.calculaCota = calculaCota;
		this.dataInicioVigCalculoCotas = dataInicioVigCalculoCotas;
		this.horarioCompromPlCota = horarioCompromPlCota;
		this.horarioCompromPosicao = horarioCompromPosicao;
		this.periodicidadeDivulgacao = periodicidadeDivulgacao;
		this.abertoEstaturiamente = abertoEstaturiamente;
		this.duracaoFundo = duracaoFundo;
		this.unidadeDuracaoFundo = unidadeDuracaoFundo;
		this.prazoDuracaoFundo = prazoDuracaoFundo;
		this.baseDuracaoFundo = baseDuracaoFundo;
		this.composicao = composicao;
		this.dataInicioVigComposicao = dataInicioVigComposicao;
		this.investidorQualificado = investidorQualificado;
		this.dataInicioVigInvestidorQualificado = dataInicioVigInvestidorQualificado;
		this.alavancado = alavancado;
		this.dataInicioVigAlavancado = dataInicioVigAlavancado;
		this.previdenciario = previdenciario;
		this.dataInicioVigPrevidenciario = dataInicioVigPrevidenciario;
		this.creditoPrivado = creditoPrivado;
		this.dataInicioVigCreditoPriv = dataInicioVigCreditoPriv;
		this.investimentoExterior = investimentoExterior;
		this.dataInicioVigInvestExt = dataInicioVigInvestExt;
		this.restricaoInvestimento = restricaoInvestimento;
		this.dataInicioVigRestricaoInvestimentot = dataInicioVigRestricaoInvestimentot;
		this.publicoAlvo = publicoAlvo;
		this.dataInicioVigPublicoAlvo = dataInicioVigPublicoAlvo;
		this.divulgacaoImprensa = divulgacaoImprensa;
		this.respeitaLimitesEmissosAtivo = respeitaLimitesEmissosAtivo;
		this.dataInicioVigRespeitaLimites = dataInicioVigRespeitaLimites;
		this.tributacaoPerseguida = tributacaoPerseguida;
		this.dataInicioVigTributacaoPerseguida = dataInicioVigTributacaoPerseguida;
		this.possuiPorspecto = possuiPorspecto;
	}

	public ClassificacaoCVM getClassificacaoCVM() {
		return classificacaoCVM;
	}

	public void setClassificacaoCVM(ClassificacaoCVM classificacaoCVM) {
		this.classificacaoCVM = classificacaoCVM;
	}

	public CategoriaAnbid getCategoriaAnbid() {
		return categoriaAnbid;
	}

	public void setCategoriaAnbid(CategoriaAnbid categoriaAnbid) {
		this.categoriaAnbid = categoriaAnbid;
	}

	public TipoAnbid getTipoAnbid() {
		return tipoAnbid;
	}

	public void setTipoAnbid(TipoAnbid tipoAnbid) {
		this.tipoAnbid = tipoAnbid;
	}

	public PlanoPrevidencia getPlanoPrevidencia() {
		return planoPrevidencia;
	}

	public void setPlanoPrevidencia(PlanoPrevidencia planoPrevidencia) {
		this.planoPrevidencia = planoPrevidencia;
	}

	public AplicacaoAutomatica getAplicacaoAutomatica() {
		return aplicacaoAutomatica;
	}

	public void setAplicacaoAutomatica(AplicacaoAutomatica aplicacaoAutomatica) {
		this.aplicacaoAutomatica = aplicacaoAutomatica;
	}

	public FocoAtuacao getFocoAtuacao() {
		return focoAtuacao;
	}

	public void setFocoAtuacao(FocoAtuacao focoAtuacao) {
		this.focoAtuacao = focoAtuacao;
	}

	public String getCalculaCota() {
		return calculaCota;
	}

	public void setCalculaCota(String calculaCota) {
		this.calculaCota = calculaCota;
	}

	public String getHorarioCompromPlCota() {
		return horarioCompromPlCota;
	}

	public void setHorarioCompromPlCota(String horarioCompromPlCota) {
		this.horarioCompromPlCota = horarioCompromPlCota;
	}

	public String getHorarioCompromPosicao() {
		return horarioCompromPosicao;
	}

	public void setHorarioCompromPosicao(String horarioCompromPosicao) {
		this.horarioCompromPosicao = horarioCompromPosicao;
	}

	public PeriodicidadeDivulgacao getPeriodicidadeDivulgacao() {
		return periodicidadeDivulgacao;
	}

	public void setPeriodicidadeDivulgacao(
			PeriodicidadeDivulgacao periodicidadeDivulgacao) {
		this.periodicidadeDivulgacao = periodicidadeDivulgacao;
	}

	public boolean isAbertoEstaturiamente() {
		return abertoEstaturiamente;
	}

	public void setAbertoEstaturiamente(boolean abertoEstaturiamente) {
		this.abertoEstaturiamente = abertoEstaturiamente;
	}

	public String getDuracaoFundo() {
		return duracaoFundo;
	}

	public void setDuracaoFundo(String duracaoFundo) {
		this.duracaoFundo = duracaoFundo;
	}

	public UnidadeDuracaoFundo getUnidadeDuracaoFundo() {
		return unidadeDuracaoFundo;
	}

	public void setUnidadeDuracaoFundo(UnidadeDuracaoFundo unidadeDuracaoFundo) {
		this.unidadeDuracaoFundo = unidadeDuracaoFundo;
	}

	public String getPrazoDuracaoFundo() {
		return prazoDuracaoFundo;
	}

	public void setPrazoDuracaoFundo(String prazoDuracaoFundo) {
		this.prazoDuracaoFundo = prazoDuracaoFundo;
	}

	public BaseDuracaoFundo getBaseDuracaoFundo() {
		return baseDuracaoFundo;
	}

	public void setBaseDuracaoFundo(BaseDuracaoFundo baseDuracaoFundo) {
		this.baseDuracaoFundo = baseDuracaoFundo;
	}

	public Composicao getComposicao() {
		return composicao;
	}

	public void setComposicao(Composicao composicao) {
		this.composicao = composicao;
	}

	public boolean isInvestidorQualificado() {
		return investidorQualificado;
	}

	public void setInvestidorQualificado(boolean investidorQualificado) {
		this.investidorQualificado = investidorQualificado;
	}

	public boolean isAlavancado() {
		return alavancado;
	}

	public void setAlavancado(boolean alavancado) {
		this.alavancado = alavancado;
	}

	public boolean isPrevidenciario() {
		return previdenciario;
	}

	public void setPrevidenciario(boolean previdenciario) {
		this.previdenciario = previdenciario;
	}

	public CreditoPrivado getCreditoPrivado() {
		return creditoPrivado;
	}

	public void setCreditoPrivado(CreditoPrivado creditoPrivado) {
		this.creditoPrivado = creditoPrivado;
	}

	public InvestimentoExterior getInvestimentoExterior() {
		return investimentoExterior;
	}

	public void setInvestimentoExterior(
			InvestimentoExterior investimentoExterior) {
		this.investimentoExterior = investimentoExterior;
	}

	public RestricaoInvestimento getRestricaoInvestimento() {
		return restricaoInvestimento;
	}

	public void setRestricaoInvestimento(
			RestricaoInvestimento restricaoInvestimento) {
		this.restricaoInvestimento = restricaoInvestimento;
	}

	public List<PublicoAlvo> getPublicoAlvo() {
		return publicoAlvo;
	}

	public void setPublicoAlvo(List<PublicoAlvo> publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public boolean isDivulgacaoImprensa() {
		return divulgacaoImprensa;
	}

	public void setDivulgacaoImprensa(boolean divulgacaoImprensa) {
		this.divulgacaoImprensa = divulgacaoImprensa;
	}

	public boolean isRespeitaLimitesEmissosAtivo() {
		return respeitaLimitesEmissosAtivo;
	}

	public void setRespeitaLimitesEmissosAtivo(
			boolean respeitaLimitesEmissosAtivo) {
		this.respeitaLimitesEmissosAtivo = respeitaLimitesEmissosAtivo;
	}

	public TributacaoPerseguida getTributacaoPerseguida() {
		return tributacaoPerseguida;
	}

	public void setTributacaoPerseguida(
			TributacaoPerseguida tributacaoPerseguida) {
		this.tributacaoPerseguida = tributacaoPerseguida;
	}

	public boolean isPossuiPorspecto() {
		return possuiPorspecto;
	}

	public void setPossuiPorspecto(boolean possuiPorspecto) {
		this.possuiPorspecto = possuiPorspecto;
	}

	public String getDataInicioVigClassificCVM() {
		return dataInicioVigClassificCVM;
	}

	public void setDataInicioVigClassificCVM(String dataInicioVigClassificCVM) {
		this.dataInicioVigClassificCVM = dataInicioVigClassificCVM;
	}

	public String getDataInicioVigCategoriaAnbid() {
		return dataInicioVigCategoriaAnbid;
	}

	public void setDataInicioVigCategoriaAnbid(
			String dataInicioVigCategoriaAnbid) {
		this.dataInicioVigCategoriaAnbid = dataInicioVigCategoriaAnbid;
	}

	public String getDataInicioVigTipoAnbid() {
		return dataInicioVigTipoAnbid;
	}

	public void setDataInicioVigTipoAnbid(String dataInicioVigTipoAnbid) {
		this.dataInicioVigTipoAnbid = dataInicioVigTipoAnbid;
	}

	public String getDataInicioVigPlanoPrev() {
		return dataInicioVigPlanoPrev;
	}

	public void setDataInicioVigPlanoPrev(String dataInicioVigPlanoPrev) {
		this.dataInicioVigPlanoPrev = dataInicioVigPlanoPrev;
	}

	public String getDataInicioVigAplcAuto() {
		return dataInicioVigAplcAuto;
	}

	public void setDataInicioVigAplcAuto(String dataInicioVigAplcAuto) {
		this.dataInicioVigAplcAuto = dataInicioVigAplcAuto;
	}

	public String getDataInicioVigFocoAtuacao() {
		return dataInicioVigFocoAtuacao;
	}

	public void setDataInicioVigFocoAtuacao(String dataInicioVigFocoAtuacao) {
		this.dataInicioVigFocoAtuacao = dataInicioVigFocoAtuacao;
	}

	public String getDataInicioVigCalculoCotas() {
		return dataInicioVigCalculoCotas;
	}

	public void setDataInicioVigCalculoCotas(String dataInicioVigCalculoCotas) {
		this.dataInicioVigCalculoCotas = dataInicioVigCalculoCotas;
	}

	public String getDataInicioVigComposicao() {
		return dataInicioVigComposicao;
	}

	public void setDataInicioVigComposicao(String dataInicioVigComposicao) {
		this.dataInicioVigComposicao = dataInicioVigComposicao;
	}

	public String getDataInicioVigInvestidorQualificado() {
		return dataInicioVigInvestidorQualificado;
	}

	public void setDataInicioVigInvestidorQualificado(
			String dataInicioVigInvestidorQualificado) {
		this.dataInicioVigInvestidorQualificado = dataInicioVigInvestidorQualificado;
	}

	public String getDataInicioVigAlavancado() {
		return dataInicioVigAlavancado;
	}

	public void setDataInicioVigAlavancado(String dataInicioVigAlavancado) {
		this.dataInicioVigAlavancado = dataInicioVigAlavancado;
	}

	public String getDataInicioVigPrevidenciario() {
		return dataInicioVigPrevidenciario;
	}

	public void setDataInicioVigPrevidenciario(
			String dataInicioVigPrevidenciario) {
		this.dataInicioVigPrevidenciario = dataInicioVigPrevidenciario;
	}

	public String getDataInicioVigCreditoPriv() {
		return dataInicioVigCreditoPriv;
	}

	public void setDataInicioVigCreditoPriv(String dataInicioVigCreditoPriv) {
		this.dataInicioVigCreditoPriv = dataInicioVigCreditoPriv;
	}

	public String getDataInicioVigInvestExt() {
		return dataInicioVigInvestExt;
	}

	public void setDataInicioVigInvestExt(String dataInicioVigInvestExt) {
		this.dataInicioVigInvestExt = dataInicioVigInvestExt;
	}

	public String getDataInicioVigPublicoAlvo() {
		return dataInicioVigPublicoAlvo;
	}

	public void setDataInicioVigPublicoAlvo(String dataInicioVigPublicoAlvo) {
		this.dataInicioVigPublicoAlvo = dataInicioVigPublicoAlvo;
	}

	public String getDataInicioVigRespeitaLimites() {
		return dataInicioVigRespeitaLimites;
	}

	public void setDataInicioVigRespeitaLimites(
			String dataInicioVigRespeitaLimites) {
		this.dataInicioVigRespeitaLimites = dataInicioVigRespeitaLimites;
	}

	public String getDataInicioVigTributacaoPerseguida() {
		return dataInicioVigTributacaoPerseguida;
	}

	public void setDataInicioVigTributacaoPerseguida(
			String dataInicioVigTributacaoPerseguida) {
		this.dataInicioVigTributacaoPerseguida = dataInicioVigTributacaoPerseguida;
	}

	public String getDataInicioVigRestricaoInvestimentot() {
		return dataInicioVigRestricaoInvestimentot;
	}

	public void setDataInicioVigRestricaoInvestimentot(
			String dataInicioVigRestricaoInvestimentot) {
		this.dataInicioVigRestricaoInvestimentot = dataInicioVigRestricaoInvestimentot;
	}

}
