package br.ifsul.filme.apiexterna;

import br.ifsul.filme.crud.Filme;
import br.ifsul.filme.crud.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FilmeApiExternaService {

    @Value("${api.url}")
    private String API_URL;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FilmeRepository filmeRepository;

    public void popularBanco(){

        for(String filme : filmes){
            String url = API_URL + "&t=" + filme;
            FilmeApiExterna filmeExterno = restTemplate.getForObject(url, FilmeApiExterna.class);

            if (filmeExterno == null) continue;

            Filme novoFilme = new Filme();
            novoFilme.setTitulo(filmeExterno.getTitle());
            novoFilme.setDiretor(filmeExterno.getDirector());
            if(filmeExterno.getYear() != null)
                novoFilme.setAnoLancamento(Integer.parseInt(filmeExterno.getYear()));

            filmeRepository.save(novoFilme);
        }
    }

    List<String> filmes = Arrays.asList(
            "The Godfather",
            "The Dark Knight",
            "Pulp Fiction",
            "The Lord of the Rings: The Return of the King",
            "Forrest Gump",
            "Inception",
            "Fight Club",
            "The Matrix",
            "Goodfellas",
            "Se7en",
            "The Silence of the Lambs",
            "Saving Private Ryan",
            "Interstellar",
            "Parasite",
            "The Green Mile",
            "Gladiator",
            "Whiplash",
            "The Departed",
            "The Prestige",
            "The Lion King",
            "Joker",
            "The Wolf of Wall Street",
            "Django Unchained",
            "Avengers: Endgame",
            "Avengers: Infinity War",
            "Iron Man",
            "Captain America: The Winter Soldier",
            "Guardians of the Galaxy",
            "Doctor Strange",
            "Black Panther",
            "Spider-Man: No Way Home",
            "Thor: Ragnarok",
            "Ant-Man",
            "Shang-Chi and the Legend of the Ten Rings",
            "Eternals",
            "Deadpool",
            "Logan",
            "X-Men: Days of Future Past",
            "Batman Begins",
            "The Dark Knight Rises",
            "Man of Steel",
            "Wonder Woman",
            "Aquaman",
            "Justice League",
            "Suicide Squad",
            "The Batman",
            "Superman",
            "Spider-Man",
            "Spider-Man 2",
            "Spider-Man 3",
            "The Amazing Spider-Man",
            "The Amazing Spider-Man 2",
            "Venom",
            "Venom: Let There Be Carnage",
            "Morbius",
            "Star Wars: A New Hope",
            "Star Wars: The Empire Strikes Back",
            "Star Wars: Return of the Jedi",
            "Star Wars: The Phantom Menace",
            "Star Wars: Attack of the Clones",
            "Star Wars: Revenge of the Sith",
            "Star Wars: The Force Awakens",
            "Star Wars: The Last Jedi",
            "Star Wars: The Rise of Skywalker",
            "Rogue One: A Star Wars Story",
            "Solo: A Star Wars Story",
            "Harry Potter and the Sorcerer's Stone",
            "Harry Potter and the Chamber of Secrets",
            "Harry Potter and the Prisoner of Azkaban",
            "Harry Potter and the Goblet of Fire",
            "Harry Potter and the Order of the Phoenix",
            "Harry Potter and the Half-Blood Prince",
            "Harry Potter and the Deathly Hallows: Part 1",
            "Harry Potter and the Deathly Hallows: Part 2",
            "Fantastic Beasts and Where to Find Them",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "Fantastic Beasts: The Secrets of Dumbledore",
            "The Hobbit: An Unexpected Journey",
            "The Hobbit: The Desolation of Smaug",
            "The Hobbit: The Battle of the Five Armies",
            "The Lord of the Rings: The Fellowship of the Ring",
            "The Lord of the Rings: The Two Towers",
            "The Hunger Games",
            "The Hunger Games: Catching Fire",
            "The Hunger Games: Mockingjay - Part 1",
            "The Hunger Games: Mockingjay - Part 2",
            "Twilight",
            "The Twilight Saga: New Moon",
            "The Twilight Saga: Eclipse",
            "The Twilight Saga: Breaking Dawn - Part 1",
            "The Twilight Saga: Breaking Dawn - Part 2",
            "Frozen",
            "Frozen II",
            "Moana",
            "Zootopia",
            "Inside Out",
            "Toy Story",
            "Toy Story 2",
            "Toy Story 3",
            "Toy Story 4"
    );

}
