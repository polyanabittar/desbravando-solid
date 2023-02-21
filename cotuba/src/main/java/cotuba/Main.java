package cotuba;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path diretorioDosMD;
        String formato;
        Path arquivoDeSaida;
        boolean modoVerboso = false;

        try {
            var opcoesCLI = new LeitorOpcoesCLI(args);

            diretorioDosMD = opcoesCLI.getDiretorioDosMD();
            formato = opcoesCLI.getFormato();
            arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
            modoVerboso = opcoesCLI.isModoVerboso();

            if ("pdf".equals(formato)) {
                var geradorPDF = new GeradorPDF();
                var renderizadorMDParaHTML = new RenderizadorMDParaHTML();

                renderizadorMDParaHTML.renderiza(diretorioDosMD);
                geradorPDF.gera(arquivoDeSaida);
            } else if ("epub".equals(formato)) {
                var geradorEPUB = new GeradorEPUB();
                var renderizadorMDParaHTML = new RenderizadorMDParaHTML();

                renderizadorMDParaHTML.renderiza(diretorioDosMD);
                geradorEPUB.gera(arquivoDeSaida);
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
