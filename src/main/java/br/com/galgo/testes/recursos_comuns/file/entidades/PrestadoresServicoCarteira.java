package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.carteira.AvaliadorRisco;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Administrador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Controlador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Custodiante;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Gestor;

public class PrestadoresServicoCarteira {

	private Administrador administrador;
	private AvaliadorRisco avaliadorRisco;
	private Controlador controladorAtivo;
	private Custodiante custodianteUnico;
	private Custodiante custodianteCotas;
	private Custodiante custodianteDerivativos;
	private Custodiante custodiantesRendaFixa;
	private Custodiante custodianteRendaVariavel;
	private Gestor gestorUnico;
	private Gestor gestorCotas;
	private Gestor gestorDerivativos;
	private Gestor gestorRendaFixa;
	private Gestor gestorRendaVariavel;

	public PrestadoresServicoCarteira(Administrador administrador,
			AvaliadorRisco avaliadorRisco, Controlador controladorAtivo,
			Custodiante custodianteUnico, Custodiante custodianteCotas,
			Custodiante custodianteDerivativos,
			Custodiante custodiantesRendaFixa,
			Custodiante custodianteRendaVariavel, Gestor gestorUnico,
			Gestor gestorCotas, Gestor gestorDerivativos,
			Gestor gestorRendaFixa, Gestor gestorRendaVariavel) {
		super();
		this.administrador = administrador;
		this.avaliadorRisco = avaliadorRisco;
		this.controladorAtivo = controladorAtivo;
		this.custodianteUnico = custodianteUnico;
		this.custodianteCotas = custodianteCotas;
		this.custodianteDerivativos = custodianteDerivativos;
		this.custodiantesRendaFixa = custodiantesRendaFixa;
		this.custodianteRendaVariavel = custodianteRendaVariavel;
		this.gestorUnico = gestorUnico;
		this.gestorCotas = gestorCotas;
		this.gestorDerivativos = gestorDerivativos;
		this.gestorRendaFixa = gestorRendaFixa;
		this.gestorRendaVariavel = gestorRendaVariavel;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AvaliadorRisco getAvaliadorRisco() {
		return avaliadorRisco;
	}

	public void setAvaliadorRisco(AvaliadorRisco avaliadorRisco) {
		this.avaliadorRisco = avaliadorRisco;
	}

	public Controlador getControladorAtivo() {
		return controladorAtivo;
	}

	public void setControladorAtivo(Controlador controladorAtivo) {
		this.controladorAtivo = controladorAtivo;
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

}
