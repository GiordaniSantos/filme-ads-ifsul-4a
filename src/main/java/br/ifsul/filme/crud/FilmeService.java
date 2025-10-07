package br.ifsul.filme.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Page<Filme> getListaFilme(Pageable pageable){
        return filmeRepository.findAll(pageable);
    }

    public Filme getFilme(Long id){
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Filme postFilme(Filme filme){
        filme.setId(null);

        return filmeRepository.save(filme);
    }

    @Transactional
    public Filme putFilme(Long id,  Filme filme){
        if(!id.equals(filme.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        Filme filmeEdicao = getFilme(id);

        filmeEdicao.setTitulo(filme.getTitulo());
        filmeEdicao.setDiretor(filme.getDiretor());
        filmeEdicao.setAnoLancamento(filme.getAnoLancamento());

        return filmeRepository.save(filmeEdicao);
    }

    @Transactional
    public void deleteFilme(Long id){
        if(!filmeRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        filmeRepository.deleteById(id);
    }
}
