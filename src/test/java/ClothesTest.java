import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ClothesTest {
    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Clothes clothes = new Clothes("Футболка", "M", 500.0, "Чорний");
        assertThrows(IllegalArgumentException.class, () -> {
            clothes.setPrice(-50.0);
        });
    }
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("", "L", 200.0, "Білий");
        });
    }
}