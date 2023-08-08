package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.md.RenderizadorMDParaHTML;

import java.util.List;

public class Cotuba {

    public void execute(ParametrosCotuba parametros) {
        var formato = parametros.getFormato();
        var arquivoDeSaida = parametros.getArquivoDeSaida();
        var diretorioDosMD = parametros.getDiretorioDosMD();
        var renderizadorMDParaHTML = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizadorMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setCapitulos(capitulos);
        ebook.setArquivoDeSaida(arquivoDeSaida);

        GeradorEbook gerador = GeradorEbook.cria(formato);
        gerador.gera(ebook);
    }
}
