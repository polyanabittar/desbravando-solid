package cotuba.epub;

import cotuba.domain.Ebook;
import cotuba.epub.impl.GeradorEPUBComEpublib;

public interface GeradorEPUB {

    static GeradorEPUB cria() {
        return new GeradorEPUBComEpublib();
    }

    void gera(Ebook ebook);
}
