/**
 * Клас, що представляє бренд одягу (для демонстрації агрегації).
 */
public class Brand {
    private String name;
    private String country;
    public Brand(String name, String country) {
        setName(name);
        setCountry(country);
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва бренду не може бути порожньою");
        }
        this.name = name;
    }
    public String getCountry() { return country; }
    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Країна бренду не може бути порожньою");
        }
        this.country = country;
    }
    public String toString() {
        return name + " (Країна: " + country + ")";
    }
}