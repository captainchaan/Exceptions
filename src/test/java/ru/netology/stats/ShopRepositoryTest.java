package ru.netology.stats;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test
    public void RemoveProductTest1() {
        ShopRepository repo = new ShopRepository();

        Product product = new Product(10, "Хлеб", 100);
        Product product1 = new Product(20, "Молоко", 200);
        Product product2 = new Product(40, "Кола", 400);

        repo.add(product);
        repo.add(product1);
        repo.add(product2);

        repo.removeById(40);

        Product[] expected = {product, product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void RemoveProductTest2() {
        ShopRepository repo = new ShopRepository();

        Product product = new Product(10, "Хлеб", 100);
        Product product1 = new Product(20, "Молоко", 200);
        Product product2 = new Product(40, "Кола", 400);

        repo.add(product);
        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(50);
        });
    }

    @Test
    public void FindAllProductTest1() {
        ShopRepository repo = new ShopRepository();

        Product product = new Product(10, "Хлеб", 100);
        Product product1 = new Product(20, "Молоко", 200);
        Product product2 = new Product(40, "Кола", 400);

        repo.add(product);
        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product, product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void FindAllProductTest2() {
        ShopRepository repo = new ShopRepository();

        Product product = new Product(10, "Хлеб", 100);
        Product product1 = new Product(20, "Молоко", 200);
        Product product2 = new Product(40, "Кола", 400);
        Product product3 = new Product(40, "Мел", 50);

        repo.add(product);
        repo.add(product1);
        repo.add(product2);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product3);
        });


    }
}
