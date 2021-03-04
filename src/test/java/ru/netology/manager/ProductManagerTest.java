package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Фиеста", 1000, "Хемингуэй");
    Product second = new Book(2, "Три товарища", 1100, "Хемингуэй");
    Product third = new Book(3, "Кавказ", 900, "Мармедов");
    Product fourth = new TShirt(4, "Айфон", 400, "Эпл");
    Product fifth = new TShirt(5, "Икспериа", 300, "Сони");


    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }
    @Test
    public void addProduct() {
        manager.add(first);
        assertArrayEquals(new Product[]{first}, repository.findAll());
    }

    @Test
    void searchByName() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Кавказ");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Три товарища");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Мармедов");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Сони");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Айфон");
        assertArrayEquals(expected, actual);
    }

    //    поиск всех книг одного автора
    @Test
    void searchAllByAuthor() {
        setUp();

        Product[] expected = new Product[]{ first, second};
        Product[] actual = manager.searchBy("Хемингуэй");
        assertArrayEquals(expected, actual);
    }
    //    Запрос, на который нет ответа
    @Test
    void searchAll() {
        setUp();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

}
