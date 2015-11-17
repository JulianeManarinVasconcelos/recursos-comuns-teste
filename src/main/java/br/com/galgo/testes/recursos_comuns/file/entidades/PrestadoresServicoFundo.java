package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Administrador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.AgenciaClassificacaoRisco;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Auditoria;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Consultoria;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Contabilidade;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Controlador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Custodiante;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Distribuidor;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.EmpresaAvaliacaoRisco;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.EscrituradorCotas;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Gestor;

public class PrestadoresServicoFundo {

	private Administrador administrador;
	private String dataInicioVigAdmin;
	private AgenciaClassificacaoRisco agenciaClassificacaoRisco;
	private Auditoria auditoria;
	private String dataInicioVigAuditoria;
	private Consultoria consultoria;
	private Contabilidade contabilidade;
	private Controlador controladorAtivo;
	private String dataInicioVigControladorAtivos;
	private Controlador controladorPassivo;
	private String dataInicioVigControladorPassivos;
	private String coordenadorDistribuidorLider;
	private Custodiante custodianteUnico;
	private String dataInicioVigCustodianteUnico;
	private Custodiante custodianteCotas;
	private String dataInicioVigCustodianteCotas;
	private Custodiante custodianteDerivativos;
	private String dataInicioVigCustodianteDerivativos;
	private Custodiante custodiantesRendaFixa;
	private String dataInicioVigCustodianteRendaFixa;
	private Custodiante custodianteRendaVariavel;
	private String dataInicioVigCustodianteRendaVariavel;
	private List<Distribuidor> distribuidorAgenteAutonomo;
	private EmpresaAvaliacaoRisco empresaAvalicaoRisco;
	private EscrituradorCotas escrituradorCotas;
	private Gestor gestorUnico;
	private String dataInicioVigGestorUnico;
	private Gestor gestorCotas;
	private String dataInicioVigGestorCotas;
	private Gestor gestorDerivativos;
	private String dataInicioVigGestorDerivativos;
	private Gestor gestorRendaFixa;
	private String dataInicioVigGestorRendaFixa;
	private Gestor gestorRendaVariavel;
	private String dataInicioVigGestorRendaVariavel;

	public PrestadoresServicoFundo(Administrador administrador,
			AgenciaClassificacaoRisco agenciaClassificacaoRisco,
			Auditoria auditoria,//
			Consultoria consultoria,//
			Contabilidade contabilidade,//
			Controlador controladorAtivo,//
			Controlador controladorPassivo,//
			String coordenadorDistribuidorLider,//
			Custodiante custodianteUnico, //
			Custodiante custdianteCotas,//
			Custodiante custpdianteDerivativos,//
			Custodiante custodiantesRendaFixa,//
			Custodiante custodianteRendaVariavel,//
			List<Distribuidor> distribuidorArgenteAutonomo,//
			EmpresaAvaliacaoRisco empresaAvalicaoRisco,//
			EscrituradorCotas escrituradorCotas,//
			Gestor gestorUnico,//
			Gestor gestorCotas,//
			Gestor gestorDerivativos,//
			Gestor gestorRendaFixa,//
			Gestor gestorRendaVariavel) {
		super();
		this.administrador = administrador;
		this.agenciaClassificacaoRisco = agenciaClassificacaoRisco;
		this.auditoria = auditoria;
		this.consultoria = consultoria;
		this.contabilidade = contabilidade;
		this.controladorAtivo = controladorAtivo;
		this.controladorPassivo = controladorPassivo;
		this.coordenadorDistribuidorLider = coordenadorDistribuidorLider;
		this.custodianteUnico = custodianteUnico;
		this.custodianteCotas = custdianteCotas;
		this.custodianteDerivativos = custpdianteDerivativos;
		this.custodiantesRendaFixa = custodiantesRendaFixa;
		this.custodianteRendaVariavel = custodianteRendaVariavel;
		this.distribuidorAgenteAutonomo = distribuidorArgenteAutonomo;
		this.empresaAvalicaoRisco = empresaAvalicaoRisco;
		this.escrituradorCotas = escrituradorCotas;
		this.gestorUnico = gestorUnico;
		this.gestorCotas = gestorCotas;
		this.gestorDerivativos = gestorDerivativos;
		this.gestorRendaFixa = gestorRendaFixa;
		this.gestorRendaVariavel = gestorRendaVariavel;
	}

	public PrestadoresServicoFundo(Administrador administrador,
			String dataInicioVigAdmin,
			AgenciaClassificacaoRisco agenciaClassificacaoRisco,
			Auditoria auditoria, String dataInicioVigAuditoria,
			Consultoria consultoria, Contabilidade contabilidade,
			Controlador controladorAtivo,
			String dataInicioVigControladorAtivos,
			Controlador controladorPassivo,
			String dataInicioVigControladorPassivos,
			String coordenadorDistribuidorLider, Custodiante custodianteUnico,
			String dataInicioVigCustodianteUnico, Custodiante custodianteCotas,
			String dataInicioVigCustodianteCotas,
			Custodiante custodianteDerivativos,
			String dataInicioVigCustodianteDerivativos,
			Custodiante custodiantesRendaFixa,
			String dataInicioVigCustodianteRendaFixa,
			Custodiante custodianteRendaVariavel,
			String dataInicioVigCustodianteRendaVariavel,
			List<Distribuidor> distribuidorAgenteAutonomo,
			EmpresaAvaliacaoRisco empresaAvalicaoRisco,
			EscrituradorCotas escrituradorCotas, Gestor gestorUnico,
			String dataInicioVigGestorUnico, Gestor gestorCotas,
			String dataInicioVigGestorCotas, Gestor gestorDerivativos,
			String dataInicioVigGestorDerivativos, Gestor gestorRendaFixa,
			String dataInicioVigGestorRendaFixa, Gestor gestorRendaVariavel,
			String dataInicioVigGestorRendaVariavel) {
		super();
		this.administrador = administrador;
		this.dataInicioVigAdmin = dataInicioVigAdmin;
		this.agenciaClassificacaoRisco = agenciaClassificacaoRisco;
		this.auditoria = auditoria;
		this.dataInicioVigAuditoria = dataInicioVigAuditoria;
		this.consultoria = consultoria;
		this.contabilidade = contabilidade;
		this.controladorAtivo = controladorAtivo;
		this.dataInicioVigControladorAtivos = dataInicioVigControladorAtivos;
		this.controladorPassivo = controladorPassivo;
		this.dataInicioVigControladorPassivos = dataInicioVigControladorPassivos;
		this.coordenadorDistribuidorLider = coordenadorDistribuidorLider;
		this.custodianteUnico = custodianteUnico;
		this.dataInicioVigCustodianteUnico = dataInicioVigCustodianteUnico;
		this.custodianteCotas = custodianteCotas;
		this.dataInicioVigCustodianteCotas = dataInicioVigCustodianteCotas;
		this.custodianteDerivativos = custodianteDerivativos;
		this.dataInicioVigCustodianteDerivativos = dataInicioVigCustodianteDerivativos;
		this.custodiantesRendaFixa = custodiantesRendaFixa;
		this.dataInicioVigCustodianteRendaFixa = dataInicioVigCustodianteRendaFixa;
		this.custodianteRendaVariavel = custodianteRendaVariavel;
		this.dataInicioVigCustodianteRendaVariavel = dataInicioVigCustodianteRendaVariavel;
		this.distribuidorAgenteAutonomo = distribuidorAgenteAutonomo;
		this.empresaAvalicaoRisco = empresaAvalicaoRisco;
		this.escrituradorCotas = escrituradorCotas;
		this.gestorUnico = gestorUnico;
		this.dataInicioVigGestorUnico = dataInicioVigGestorUnico;
		this.gestorCotas = gestorCotas;
		this.dataInicioVigGestorCotas = dataInicioVigGestorCotas;
		this.gestorDerivativos = gestorDerivativos;
		this.dataInicioVigGestorDerivativos = dataInicioVigGestorDerivativos;
		this.gestorRendaFixa = gestorRendaFixa;
		this.dataInicioVigGestorRendaFixa = dataInicioVigGestorRendaFixa;
		this.gestorRendaVariavel = gestorRendaVariavel;
		this.dataInicioVigGestorRendaVariavel = dataInicioVigGestorRendaVariavel;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AgenciaClassificacaoRisco getAgenciaClassificacaoRisco() {
		return agenciaClassificacaoRisco;
	}

	public void setAgenciaClassificacaoRisco(
			AgenciaClassificacaoRisco agenciaClassificacaoRisco) {
		this.agenciaClassificacaoRisco = agenciaClassificacaoRisco;
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Consultoria getConsultoria() {
		return consultoria;
	}

	public void setConsultoria(Consultoria consultoria) {
		this.consultoria = consultoria;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	public Controlador getControladorAtivo() {
		return controladorAtivo;
	}

	public void setControladorAtivo(Controlador controladorAtivo) {
		this.controladorAtivo = controladorAtivo;
	}

	public Controlador getControladorPassivo() {
		return controladorPassivo;
	}

	public void setControladorPassivo(Controlador controladorPassivo) {
		this.controladorPassivo = controladorPassivo;
	}

	public String getCoordenadorDistribuidorLider() {
		return coordenadorDistribuidorLider;
	}

	public void setCoordenadorDistribuidorLider(
			String coordenadorDistribuidorLider) {
		this.coordenadorDistribuidorLider = coordenadorDistribuidorLider;
	}

	public Custodiante getCustodianteUnico() {
		return custodianteUnico;
	}

	public void setCustodianteUnico(Custodiante custodianteUnico) {
		this.custodianteUnico = custodianteUnico;
	}

	public Custodiante getCustodianteCotas() {
		return custodianteCotas;
	}

	public void setCustodianteCotas(Custodiante custodianteCotas) {
		this.custodianteCotas = custodianteCotas;
	}

	public Custodiante getCustodianteDerivativos() {
		return custodianteDerivativos;
	}

	public void setCustodianteDerivativos(Custodiante custodianteDerivativos) {
		this.custodianteDerivativos = custodianteDerivativos;
	}

	public Custodiante getCustodiantesRendaFixa() {
		return custodiantesRendaFixa;
	}

	public void setCustodiantesRendaFixa(Custodiante custodiantesRendaFixa) {
		this.custodiantesRendaFixa = custodiantesRendaFixa;
	}

	public Custodiante getCustodianteRendaVariavel() {
		return custodianteRendaVariavel;
	}

	public void setCustodianteRendaVariavel(Custodiante custodianteRendaVariavel) {
		this.custodianteRendaVariavel = custodianteRendaVariavel;
	}

	public List<Distribuidor> getDistribuidorAgenteAutonomo() {
		return distribuidorAgenteAutonomo;
	}

	public void setDistribuidorAgenteAutonomo(
			List<Distribuidor> distribuidorAgenteAutonomo) {
		this.distribuidorAgenteAutonomo = distribuidorAgenteAutonomo;
	}

	public EmpresaAvaliacaoRisco getEmpresaAvalicaoRisco() {
		return empresaAvalicaoRisco;
	}

	public void setEmpresaAvalicaoRisco(
			EmpresaAvaliacaoRisco empresaAvalicaoRisco) {
		this.empresaAvalicaoRisco = empresaAvalicaoRisco;
	}

	public EscrituradorCotas getEscrituradorCotas() {
		return escrituradorCotas;
	}

	public void setEscrituradorCotas(EscrituradorCotas escrituradorCotas) {
		this.escrituradorCotas = escrituradorCotas;
	}

	public Gestor getGestorUnico() {
		return gestorUnico;
	}

	public void setGestorUnico(Gestor gestorUnico) {
		this.gestorUnico = gestorUnico;
	}

	public Gestor getGestorCotas() {
		return gestorCotas;
	}

	public void setGestorCotas(Gestor gestorCotas) {
		this.gestorCotas = gestorCotas;
	}

	public Gestor getGestorDerivativos() {
		return gestorDerivativos;
	}

	public void setGestorDerivativos(Gestor gestorDerivativos) {
		this.gestorDerivativos = gestorDerivativos;
	}

	public Gestor getGestorRendaFixa() {
		return gestorRendaFixa;
	}

	public void setGestorRendaFixa(Gestor gestorRendaFixa) {
		this.gestorRendaFixa = gestorRendaFixa;
	}

	public Gestor getGestorRendaVariavel() {
		return gestorRendaVariavel;
	}

	public void setGestorRendaVariavel(Gestor gestorRendaVariavel) {
		this.gestorRendaVariavel = gestorRendaVariavel;
	}

	public String getDataInicioVigAdmin() {
		return dataInicioVigAdmin;
	}

	public void setDataInicioVigAdmin(String dataInicioVigAdmin) {
		this.dataInicioVigAdmin = dataInicioVigAdmin;
	}

	public String getDataInicioVigAuditoria() {
		return dataInicioVigAuditoria;
	}

	public void setDataInicioVigAuditoria(String dataInicioVigAuditoria) {
		this.dataInicioVigAuditoria = dataInicioVigAuditoria;
	}

	public String getDataInicioVigControladorAtivos() {
		return dataInicioVigControladorAtivos;
	}

	public void setDataInicioVigControladorAtivos(
			String dataInicioVigControladorAtivos) {
		this.dataInicioVigControladorAtivos = dataInicioVigControladorAtivos;
	}

	public String getDataInicioVigControladorPassivos() {
		return dataInicioVigControladorPassivos;
	}

	public void setDataInicioVigControladorPassivos(
			String dataInicioVigControladorPassivos) {
		this.dataInicioVigControladorPassivos = dataInicioVigControladorPassivos;
	}

	public String getDataInicioVigCustodianteUnico() {
		return dataInicioVigCustodianteUnico;
	}

	public void setDataInicioVigCustodianteUnico(
			String dataInicioVigCustodianteUnico) {
		this.dataInicioVigCustodianteUnico = dataInicioVigCustodianteUnico;
	}

	public String getDataInicioVigCustodianteCotas() {
		return dataInicioVigCustodianteCotas;
	}

	public void setDataInicioVigCustodianteCotas(
			String dataInicioVigCustodianteCotas) {
		this.dataInicioVigCustodianteCotas = dataInicioVigCustodianteCotas;
	}

	public String getDataInicioVigCustodianteDerivativos() {
		return dataInicioVigCustodianteDerivativos;
	}

	public void setDataInicioVigCustodianteDerivativos(
			String dataInicioVigCustodianteDerivativos) {
		this.dataInicioVigCustodianteDerivativos = dataInicioVigCustodianteDerivativos;
	}

	public String getDataInicioVigCustodianteRendaFixa() {
		return dataInicioVigCustodianteRendaFixa;
	}

	public void setDataInicioVigCustodianteRendaFixa(
			String dataInicioVigCustodianteRendaFixa) {
		this.dataInicioVigCustodianteRendaFixa = dataInicioVigCustodianteRendaFixa;
	}

	public String getDataInicioVigCustodianteRendaVariavel() {
		return dataInicioVigCustodianteRendaVariavel;
	}

	public void setDataInicioVigCustodianteRendaVariavel(
			String dataInicioVigCustodianteRendaVariavel) {
		this.dataInicioVigCustodianteRendaVariavel = dataInicioVigCustodianteRendaVariavel;
	}

	public String getDataInicioVigGestorUnico() {
		return dataInicioVigGestorUnico;
	}

	public void setDataInicioVigGestorUnico(String dataInicioVigGestorUnico) {
		this.dataInicioVigGestorUnico = dataInicioVigGestorUnico;
	}

	public String getDataInicioVigGestorCotas() {
		return dataInicioVigGestorCotas;
	}

	public void setDataInicioVigGestorCotas(String dataInicioVigGestorCotas) {
		this.dataInicioVigGestorCotas = dataInicioVigGestorCotas;
	}

	public String getDataInicioVigGestorDerivativos() {
		return dataInicioVigGestorDerivativos;
	}

	public void setDataInicioVigGestorDerivativos(
			String dataInicioVigGestorDerivativos) {
		this.dataInicioVigGestorDerivativos = dataInicioVigGestorDerivativos;
	}

	public String getDataInicioVigGestorRendaFixa() {
		return dataInicioVigGestorRendaFixa;
	}

	public void setDataInicioVigGestorRendaFixa(
			String dataInicioVigGestorRendaFixa) {
		this.dataInicioVigGestorRendaFixa = dataInicioVigGestorRendaFixa;
	}

	public String getDataInicioVigGestorRendaVariavel() {
		return dataInicioVigGestorRendaVariavel;
	}

	public void setDataInicioVigGestorRendaVariavel(
			String dataInicioVigGestorRendaVariavel) {
		this.dataInicioVigGestorRendaVariavel = dataInicioVigGestorRendaVariavel;
	}

}
