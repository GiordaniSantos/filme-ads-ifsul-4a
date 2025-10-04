package br.ifsul.filme.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping()
	public List<Filme> getListaFilme(){
        return filmeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Filme getFilme(@PathVariable Long id){
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Filme postFilme(@RequestBody Filme filme){
        filme.setId(null);

        return filmeRepository.save(filme);
    }

    @PutMapping("/{id}")
    public Filme putFilme(@PathVariable Long id, @RequestBody Filme filme){
        if(!id.equals(filme.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        Filme filmeEdicao = getFilme(id);

        filmeEdicao.setTitulo(filme.getTitulo());
        filmeEdicao.setDiretor(filme.getDiretor());
        filmeEdicao.setAnoLancamento(filme.getAnoLancamento());

        return filmeRepository.save(filmeEdicao);
    }

    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable Long id){
        if(!filmeRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        filmeRepository.deleteById(id);
    }
}
