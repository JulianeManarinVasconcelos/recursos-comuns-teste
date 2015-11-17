package br.com.galgo.testes.recursos_comuns.enumerador;

import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;

public enum ArquivoXML {

	CAMINHO_XML_ENVIO_PL_COTA(
			//
			ConstantesTestes.CAMINHO_XML_ENVIO_PL_COTA,
			ConstantesTestes.CAMINHO_XML_ENVIO_PL_COTA_BACKUP), //
	CAMINHO_XML_ENVIO_INFO_ANBIMA(
			ConstantesTestes.CAMINHO_XML_ENVIO_INFO_ANBIMA,
			ConstantesTestes.CAMINHO_XML_ENVIO_INFO_ANBIMA_BACKUP), //
	CAMINHO_XML_REENVIO_PL_COTA(ConstantesTestes.CAMINHO_XML_REENVIO_PL_COTA,
			ConstantesTestes.CAMINHO_XML_REENVIO_PL_COTA_BACKUP), //
	CAMINHO_XML_REENVIO_INFO(ConstantesTestes.CAMINHO_XML_REENVIO_INFO,
			ConstantesTestes.CAMINHO_XML_REENVIO_INFO_BACKUP), //
	CAMINHO_XML_CANCELA_PL_COTA(ConstantesTestes.CAMINHO_XML_CANCELA_PL_COTA,
			ConstantesTestes.CAMINHO_XML_CANCELA_PL_COTA_BACKUP), //
	PATH_ARQUIVO_SALVAR_EXTRATO(ConstantesTestes.PATH_ARQUIVO_SALVAR_EXTRATO,
			ConstantesTestes.PATH_ARQUIVO_SALVAR_EXTRATO_BACKUP), //
	PATH_ARQUIVO_ENVIAR_EXTRATO(ConstantesTestes.PATH_ARQUIVO_ENVIAR_EXTRATO,
			ConstantesTestes.PATH_ARQUIVO_ENVIAR_EXTRATO_BACKUP), //
	PATH_CANCELAMENTO_EXTRATO(ConstantesTestes.PATH_CANCELAMENTO_EXTRATO,
			ConstantesTestes.PATH_CANCELAMENTO_EXTRATO_BACKUP), //
	PATH_ARQUIVO_SALVAR_POSICAO(ConstantesTestes.PATH_ARQUIVO_SALVAR_POSICAO,
			ConstantesTestes.PATH_ARQUIVO_SALVAR_POSICAO_BACKUP), //
	PATH_ARQUIVO_ENVIAR_POSICAO(ConstantesTestes.PATH_ARQUIVO_ENVIAR_POSICAO,
			ConstantesTestes.PATH_ARQUIVO_ENVIAR_POSICAO_BACKUP);

	private String caminho;
	private String backup;

	ArquivoXML(String caminho, String backup) {
		this.caminho = caminho;
		this.backup = backup;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getBackup() {
		return backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public static String fromDesc(String caminho) {
		for (ArquivoXML arquivo : ArquivoXML.values()) {
			if (arquivo.caminho.equalsIgnoreCase(caminho)) {
				return arquivo.getBackup();
			}
		}
		return null;
	}

}
