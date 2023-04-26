package cotuba.epub;

import cotuba.domain.Ebook;
import cotuba.epub.impl.GeradorEPUBImpl;

public interface GeradorEPUB {

    static GeradorEPUB cria() {
        return new GeradorEPUBImpl();
    }

    void gera(Ebook ebook);
}
