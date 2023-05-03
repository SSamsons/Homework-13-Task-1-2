import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "Bread", 30);
    Product item2 = new Product(2, "Potato", 20);
    Product item3 = new Product(3, "Juice", 80);
    ShopRepository repo = new ShopRepository();

    @Test
    public void shouldRemoveId() {

        repo.add(item1);
        repo.add(item2);

        repo.remove(2);

        Product[] expected = {item1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNotFoundException() {
        repo.add(item1);
        repo.add(item2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(74);
        });
    }

    @Test
    public void shouldAddId() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAlreadyExistsException() {
        repo.add(item1);
        repo.add(item2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item2);
        });
    }
}
