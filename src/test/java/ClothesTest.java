import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClothesTest {
    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Brand brand1 = new Brand("Nike", "США");
        Clothes clothes = new Clothes("Футболка", Size.M, 500.0, "Чорний", brand1);;
        assertThrows(IllegalArgumentException.class, () -> {
            clothes.setPrice(-50.0);
        });
    }
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Brand brand2 = new Brand("Adidas", "Німеччина");
            new Clothes("", Size.L, 200.0, "Білий", brand2);
        });
    }
}