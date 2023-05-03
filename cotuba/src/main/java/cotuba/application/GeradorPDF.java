package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.pdf.impl.GeradorPDFComItext;  //ainda fere o DIP

public interface GeradorPDF {

    static GeradorPDF cria() {
        return new GeradorPDFComItext();
    }

    void gera(Ebook ebook);
}
