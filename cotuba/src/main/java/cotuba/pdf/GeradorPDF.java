package cotuba.pdf;

import cotuba.domain.Ebook;
import cotuba.pdf.impl.GeradorPDFImpl;

public interface GeradorPDF {

    static GeradorPDF cria() {
        return new GeradorPDFImpl();
    }

    void gera(Ebook ebook);
}
