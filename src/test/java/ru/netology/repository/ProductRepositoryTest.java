package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Product first = new Book(1, "Фиеста", 1000, "Хемингуэй");
    Product second = new Book(2, "Три товарища", 1100, "Хемингуэй");


    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);

        int idToRemove = 1;
        repository.removeById(idToRemove);

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveNoExists() {
        repository.removeById(0);

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }
    @Test
    public void wrongInput() {
        Throwable exception = assertThrows(NotFoundException.class,
                () -> {repository.removeById(0);});
    }


}