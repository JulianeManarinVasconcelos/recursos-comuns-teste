package br.com.galgo.testes.recursos_comuns.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.io.FileUtils;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Text;
import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;

public class DocUtils {

	public static void gerarRelatorioCumprirEventosHomologacao(
			String templatePath, String relatorioPath,
			int qtdDeEventosPendentesPre, int qtdDeEventosPendentesPos,
			int porcentagem, String pathAntes, String pathDepois) {
		try {

			relatorioPath = ConfiguracaoSistema.getPathArquivo(relatorioPath,
					true);

			templatePath = ConfiguracaoSistema.getPathArquivo(templatePath,
					false);

			final File templateFile = new File(templatePath);
			final File relatorioFile = new File(relatorioPath);

			if (relatorioFile.exists()) {
				FileUtils.forceDelete(relatorioFile);
			}
			FileUtils.copyFile(templateFile, relatorioFile);

			WordprocessingMLPackage relatorio = WordprocessingMLPackage
					.load(relatorioFile);

			final List<Object> paragrafosRelatorio = getAllElementFromObject(
					relatorio.getMainDocumentPart(), P.class);

			for (Object relatorioPar : paragrafosRelatorio) {
				P relatorioP = (P) relatorioPar;
				List<Object> relatorioTexts = getAllElementFromObject(
						relatorioP, Text.class);
				for (Object text : relatorioTexts) {
					Text t = (Text) text;

					substituir(t, "<QTD_EVENTOS>",
							String.valueOf(qtdDeEventosPendentesPre), false,
							"", 0, relatorio);
					substituir(t, "<PORCENTAGEM>", String.valueOf(porcentagem),
							false, "", 0, relatorio);
					substituir(t, "<QTD_EVENTOS_DEPOIS>",
							String.valueOf(qtdDeEventosPendentesPos), false,
							"", 0, relatorio);
					substituir(t, "<HOJE>",
							FormatoData.DD_MM_YYYY.formata(new Date()), false,
							"", 0, relatorio);

					String caminhoAntes = ConfiguracaoSistema.getPathArquivo(
							pathAntes, true);
					String caminhoDepois = ConfiguracaoSistema.getPathArquivo(
							pathDepois, true);

					substituir(t, "<ANTES>", "", true, caminhoAntes, 7,
							relatorio);
					substituir(t, "<DEPOIS>", "", true, caminhoDepois, 11,
							relatorio);

					relatorio.save(relatorioFile);
				}
			}
		} catch (Exception e) {
			Assert.fail("Ocorreu um erro ao gerar relatório" + e.getMessage());
		}

	}

	public static List<Object> getAllElementFromObject(Object obj,
			Class<?> toSearch) {
		List<Object> result = new ArrayList<Object>();
		if (obj instanceof JAXBElement)
			obj = ((JAXBElement<?>) obj).getValue();

		if (obj.getClass().equals(toSearch))
			result.add(obj);
		else if (obj instanceof ContentAccessor) {
			List<?> children = ((ContentAccessor) obj).getContent();
			for (Object child : children) {
				result.addAll(getAllElementFromObject(child, toSearch));
			}
		}
		return result;
	}

	public static void substituir(Text t, String toFind, String replacer,
			boolean ehImagem, String localImagem, int indexContent,
			WordprocessingMLPackage doc) throws Exception {
		final String value = t.getValue();
		if (value.contains(toFind)) {
			if (ehImagem) {
				final File imagemFile = new File(localImagem);
				addImageToPackage(doc, imagemFile, indexContent);
			} else {
				t.setValue(value.replace(toFind, replacer));
			}
		}
	}

	private static void addImageToPackage(
			WordprocessingMLPackage wordMLPackage, File imagemFile,
			int indexContent) throws Exception {
		BinaryPartAbstractImage imagePart = BinaryPartAbstractImage
				.createImagePart(wordMLPackage, imagemFile);

		Inline inline = imagePart.createImageInline("", "", 0, 0, false);

		P paragraph = addImagemNoParagrafo(inline);

		final MainDocumentPart mainDocumentPart = wordMLPackage
				.getMainDocumentPart();
		final List<Object> content = mainDocumentPart.getContent();
		content.set(indexContent, paragraph);

	}

	private static P addImagemNoParagrafo(Inline inline) {
		ObjectFactory factory = new ObjectFactory();
		P paragraph = factory.createP();
		R run = factory.createR();
		paragraph.getContent().add(run);
		Drawing drawing = factory.createDrawing();
		run.getContent().add(drawing);
		drawing.getAnchorOrInline().add(inline);
		return paragraph;
	}

	public static void teste(WordprocessingMLPackage wordMLPackage)
			throws Docx4JException {
		wordMLPackage = WordprocessingMLPackage.createPackage();
		// alterStyleSheet();

		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title",
				"Hello World! This title is now in Arial.");
		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText(
				"Subtitle", "Subtitle, this subtitle is now Arial too");
		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText(
				"Heading1", "As is Heading1");
		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText(
				"Heading2",
				"Heading2 is now Arial, no longer bold and has an underline "
						+ "and fontsize 12");
		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText(
				"Heading3", "Heading3 is now Arial");
		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Normal",
				"And normal text has changed to Arial and fontsize 10");

		wordMLPackage.save(new java.io.File("src/main/files/HelloWord12.docx"));
	}

}
