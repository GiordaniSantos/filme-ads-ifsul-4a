package br.ifsul.filme.apiexterna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FilmeStartUp {

    @Autowired
    private FilmeApiExternaService filmeApiExternaService;

    @EventListener(ApplicationReadyEvent.class)
    public void popularFilmesNoBanco() {
        filmeApiExternaService.popularBanco();
    }
}
