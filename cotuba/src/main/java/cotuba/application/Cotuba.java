package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import cotuba.epub.impl.GeradorEPUBImpl;
import cotuba.md.RenderizadorMDParaHTML;
import cotuba.md.impl.RenderizadorMDParaHTMLImpl;
import cotuba.pdf.GeradorPDF;
import cotuba.pdf.impl.GeradorPDFImpl;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void execute(String formato, Path diretorioDosMD, Path arquivoDeSaida){

        RenderizadorMDParaHTML renderizadorMDParaHTML = new RenderizadorMDParaHTMLImpl();
        List<Capitulo> capitulos = renderizadorMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setCapitulos(capitulos);
        ebook.setArquivoDeSaida(arquivoDeSaida);

        if ("pdf".equals(formato)) {
            GeradorPDF geradorPDF = new GeradorPDFImpl();
            geradorPDF.gera(ebook);
        } else if ("epub".equals(formato)) {
            GeradorEPUB geradorEPUB = new GeradorEPUBImpl();
            geradorEPUB.gera(ebook);
        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }
    }
}
