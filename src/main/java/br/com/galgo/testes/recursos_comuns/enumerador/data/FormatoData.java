package br.com.galgo.testes.recursos_comuns.enumerador.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum FormatoData {

	DDMMYYYYHHMMSS("dd_MM_yyyy_hh_mm_ss"), DDMMYYYYHH("dd_MM_yyyy_hh"), DD_MM_YYYY(
			"dd/MM/yyyy"), HH_MM("HH:mm"), HH("HH"), MM("mm");

	private String formato;

	FormatoData(String formato) {
		this.formato = formato;
	}

	public String formata(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat(formato);
		return formatador.format(data);
	}

	public Date getData(String data) throws ParseException {
		SimpleDateFormat formatador = new SimpleDateFormat(formato);
		return formatador.parse(data);
	}

}
