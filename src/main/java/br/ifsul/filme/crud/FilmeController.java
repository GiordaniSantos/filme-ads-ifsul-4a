package br.ifsul.filme.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping()
	public Page<Filme> getListaFilme(Pageable pageable){
		return filmeService.getListaFilme(pageable);
	}
	
	@GetMapping("/{id}")
	public Filme getFilme(@PathVariable Long id){
        return filmeService.getFilme(id);
	}

    @PostMapping()
    public Filme postFilme(@RequestBody Filme filme){
        return filmeService.postFilme(filme);
    }

    @PutMapping("/{id}")
    public Filme putFilme(@PathVariable Long id, @RequestBody Filme filme){
        return filmeService.putFilme(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable Long id){
        filmeService.deleteFilme(id);
    }
}
