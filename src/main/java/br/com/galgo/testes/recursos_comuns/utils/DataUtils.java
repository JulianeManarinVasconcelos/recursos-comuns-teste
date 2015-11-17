package br.com.galgo.testes.recursos_comuns.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.objectlab.kit.datecalc.common.DateCalculator;
import net.objectlab.kit.datecalc.common.DefaultHolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayHandlerType;
import net.objectlab.kit.datecalc.joda.LocalDateKitCalculatorsFactory;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;

import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;
import de.jollyday.Holiday;
import de.jollyday.HolidayManager;

public class DataUtils {

	public static Date subtrairMinutos(int minutos, Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(data.getTime());
		calendar.add(Calendar.MINUTE, -minutos);
		return calendar.getTime();
	}

	public static LocalDate getDataBaseAnterior(Date dataBase)
			throws ParseException {
		Date dataBaseAnterior = DataUtils.subtrairDias(1, dataBase);
		LocalDate data = new LocalDate(dataBaseAnterior);

		return DataUtils.getPrimeiroDiaUtil(data);
	}

	public static Date subtrairDias(int dias, Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(data.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, -dias);
		return calendar.getTime();
	}

	public static LocalDate getPrimeiroDiaUtil(LocalDate data) {
		DateCalculator<LocalDate> calendario = montaCalendario();
		return ehDiaUtilNoCalendario(data, calendario);
	}

	private static LocalDate ehDiaUtilNoCalendario(LocalDate data,
			DateCalculator<LocalDate> calendario) {
		while (calendario.isNonWorkingDay(data)) {
			data = data.minusDays(1);
		}
		return data;
	}

	private static DateCalculator<LocalDate> montaCalendario() {
		HolidayCalendar<LocalDate> calendarioDeFeriados = montalistaDeFeriadosBrasileiros();

		LocalDateKitCalculatorsFactory.getDefaultInstance().registerHolidays(
				"BR", calendarioDeFeriados);

		DateCalculator<LocalDate> calendario = LocalDateKitCalculatorsFactory
				.getDefaultInstance().getDateCalculator("BR",
						HolidayHandlerType.FORWARD);
		return calendario;
	}

	private static HolidayCalendar<LocalDate> montalistaDeFeriadosBrasileiros() {
		HolidayManager gerenciadorDeFeriados = HolidayManager
				.getInstance(de.jollyday.HolidayCalendar.BRAZIL);
		Set<Holiday> feriados = gerenciadorDeFeriados
				.getHolidays(new DateTime().getYear());
		Set<LocalDate> dataDosFeriados = new HashSet<LocalDate>();
		for (Holiday h : feriados) {
			if (ehFeriadoFixo(h)) {
				dataDosFeriados.add(new LocalDate(h.getDate(), ISOChronology
						.getInstance()));
			}
		}

		// popula com os feriados brasileiros
		HolidayCalendar<LocalDate> calendarioDeFeriados = new DefaultHolidayCalendar<LocalDate>(
				dataDosFeriados);

		return calendarioDeFeriados;
	}

	private static boolean ehFeriadoFixo(Holiday h) {
		return !h.getDescription().equalsIgnoreCase("Carnaval")
				&& !h.getDescription().equalsIgnoreCase("Sexta-feira Santa")
				&& !h.getDescription().equalsIgnoreCase("Corpo de Deus");
	}

	public static String getDataBaseAnterior(String dataBase)
			throws ParseException {
		DateTime dt = new DateTime(FormatoData.DD_MM_YYYY.getData(dataBase));
		LocalDate dataBaseAnterior = dt.toLocalDate();
		dataBaseAnterior = DataUtils.getDataBaseAnterior(dataBaseAnterior
				.toDate());
		return dataBaseAnterior.toString();
	}

	public static String getDataBaseXML(String dataFiltro) {
		dataFiltro = dataFiltro.substring(6, 10) + "-"
				+ dataFiltro.substring(3, 5) + "-" + dataFiltro.substring(0, 2);
		return dataFiltro;
	}

	public static String getDataBase(Date dataBase) {
		String dataFiltro = FormatoData.DD_MM_YYYY.formata(dataBase);
		dataFiltro = dataFiltro.substring(6, 10) + "-"
				+ dataFiltro.substring(3, 5) + "-" + dataFiltro.substring(0, 2);
		return dataFiltro;
	}

	public static String getDataBase(String dataBase) {
		String dataBaseSt = dataBase.substring(8) + "/"
				+ dataBase.substring(5, 7) + "/" + dataBase.substring(0, 4);

		return dataBaseSt;
	}

}
