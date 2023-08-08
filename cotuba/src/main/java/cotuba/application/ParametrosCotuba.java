package cotuba.application;

import cotuba.domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {
    Path getArquivoDeSaida();
    FormatoEbook getFormato();
    Path getDiretorioDosMD();
}
