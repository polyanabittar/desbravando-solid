package cotuba;

import java.nio.file.Path;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Path diretorioDosMD;
        String formato;
        Path arquivoDeSaida;
        boolean modoVerboso = false;
        Ebook ebook = new Ebook();
        GeradorPDF geradorPDF = new GeradorPDF();
        GeradorEPUB geradorEPUB = new GeradorEPUB();

        try {
            var opcoesCLI = new LeitorOpcoesCLI(args);
            var renderizadorMDParaHTML = new RenderizadorMDParaHTML();

            diretorioDosMD = opcoesCLI.getDiretorioDosMD();
            formato = opcoesCLI.getFormato();
            arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
            modoVerboso = opcoesCLI.isModoVerboso();

            var capitulos = renderizadorMDParaHTML.renderiza(diretorioDosMD);

            ebook.setFormato(formato);
            ebook.setCapitulos(capitulos);
            ebook.setArquivoDeSaida(arquivoDeSaida);

            if ("pdf".equals(formato)) {
                geradorPDF.gera(ebook);
            } else if ("epub".equals(formato)) {
                geradorEPUB.gera(ebook);
            } else {
                throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
            }

            System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
        } catch (
                Exception ex) {
            System.err.println(ex.getMessage());
            if (modoVerboso) {
                ex.printStackTrace();
            }
            System.exit(1);
        }
    }

}
