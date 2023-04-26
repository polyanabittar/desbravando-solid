package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.epub.impl.GeradorEPUBComEpublib; //ainda fere o DIP

public interface GeradorEPUB {

    static GeradorEPUB cria() {
        return new GeradorEPUBComEpublib();
    }

    void gera(Ebook ebook);
}
