package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.util.List;

public class Cotuba {

    public void execute(ParametrosCotuba parametros) {
        var formato = parametros.getFormato();
        var arquivoDeSaida = parametros.getArquivoDeSaida();
        var diretorioDosMD = parametros.getDiretorioDosMD();

        RenderizadorMDParaHTML renderizadorMDParaHTML = RenderizadorMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setCapitulos(capitulos);
        ebook.setArquivoDeSaida(arquivoDeSaida);

        if ("pdf".equals(formato)) {
            GeradorPDF geradorPDF = GeradorPDF.cria();
            geradorPDF.gera(ebook);
        } else if ("epub".equals(formato)) {
            GeradorEPUB geradorEPUB = GeradorEPUB.cria();
            geradorEPUB.gera(ebook);
        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }
    }
}
