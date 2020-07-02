package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

@NoArgsConstructor
@AllArgsConstructor
public class FilmManager {
    private FilmRepository repository;
    private int filmsToReturn = 10;

    public FilmManager(int filmsToReturn) {
        this.filmsToReturn = filmsToReturn;
    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getFilm() {
        Film[] filmsFromRepository = repository.findAll();
        int arrayLength = filmsToReturn;
        if (filmsFromRepository.length < arrayLength) {
            arrayLength = filmsFromRepository.length;
        }
        Film[] result = new Film[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = filmsFromRepository.length - i - 1;
            result[i] = filmsFromRepository[index];
        }
        return result;
    }
}

