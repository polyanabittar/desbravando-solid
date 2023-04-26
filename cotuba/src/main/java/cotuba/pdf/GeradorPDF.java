package cotuba.pdf;

import cotuba.domain.Ebook;
import cotuba.pdf.impl.GeradorPDFComItext;

public interface GeradorPDF {

    static GeradorPDF cria() {
        return new GeradorPDFComItext();
    }

    void gera(Ebook ebook);
}
