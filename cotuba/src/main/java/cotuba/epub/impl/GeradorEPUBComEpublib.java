package cotuba.epub.impl;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeradorEPUBComEpublib implements GeradorEPUB {

    @Override
    public void gera(Ebook ebook) {
        var epub = new Book();
        var epubWriter = new EpubWriter();
        Path arquivoDeSaida = ebook.getArquivoDeSaida();

        for (Capitulo capitulo : ebook.getCapitulos()) {
            String html = capitulo.getConteudoHTML();
            String tituloDoCapitulo = capitulo.getTitulo();
            epub.addSection(tituloDoCapitulo, new Resource(html.getBytes(), MediatypeService.XHTML));
        }

        try {
            epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
        } catch (IOException ex) {
            throw new IllegalStateException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
        }
    }
}