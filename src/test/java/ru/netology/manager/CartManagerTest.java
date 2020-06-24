package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import static org.junit.jupiter.api.Assertions.*;


class CartManagerTest {
    CartManager manager = new CartManager(3);
    Film film1 = new Film(1, "Breaking Bad", "Crime drama", "https://www.imdb.com/title/tt0903747/", 2020, "USA");
    Film film2 = new Film(2, "Untouchable", "Comedy Drama", "https://www.imdb.com/title/tt0903750/", 2011, "France");
    Film film3 = new Film(3, "The Godfather", "Crime drama", "https://www.imdb.com/title/tt0903756/", 1972, "USA");
    Film film4 = new Film(4, " The Lord of the Rings", "Crime drama", "https://www.imdb.com/title/tt0903757/", 2003, "USA");

    @Test
    void shouldAdd() {
        Film[] expected = new Film[]{film1};
        manager.add(film1);
        assertArrayEquals(expected, manager.getFilm());
    }

    @Test
        void shouldReturnLessThenMax () {
            Film[] expected = new Film[]{film4, film3, film2};
            manager.add(film1);
            manager.add(film2);
            manager.add(film3);
            manager.add(film4);
            assertArrayEquals(expected, manager.getFilm());
        }
    }

