public class Clothes {
    private String name;
    private Size size;
    private double price;
    private String color;
    private Brand brand; // Додано 4 атрибута
    private static int objectCount = 0;
    public Clothes(String name, Size size, double price, String color, Brand brand) {
        setName(name);
        setSize(size);
        setPrice(price);
        setColor(color);
        setBrand(brand);
        objectCount++;
    }
    public Clothes(Clothes other) {
        if (other == null) {
            throw new IllegalArgumentException("Об'єкт для копіювання не може бути null");
        }
        this.name = other.name;
        this.size = other.size;
        this.price = other.price;
        this.color = other.color;
        this.brand = new Brand(other.brand.getName(), other.brand.getCountry());
        objectCount++;
    }
    public static int getObjectCount() {
        return objectCount;
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою.");
        }
        this.name = name;
    }
    public Size getSize() { return size; }
    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("Розмір не може бути порожнім.");
        }
        this.size = size;
    }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна повинна бути більшою за нуль");
        }
        this.price = price;
    }
    public String getColor() { return color; }
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Колір не може бути порожнім");
        }
        this.color = color;
    }
    public Brand getBrand() { return brand; }
public void setBrand(Brand brand) {
    if (brand == null) {
        throw new IllegalArgumentException("Бренд не може бути null.");
    }
    this.brand = brand;
}
    public String toString() {
        return "Clothes [name=" + name + ", size=" + size + ", price=" + price + ", color=" + color + ", brand=" + brand.toString() + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothes clothes = (Clothes) obj;
        if (Double.compare(clothes.price, price) != 0) return false;
        if (!name.equals(clothes.name)) return false;
        if (size != clothes.size) return false;
        if (!color.equals(clothes.color)) return false;
        return brand.getName().equals(clothes.brand.getName()) && brand.getCountry().equals(clothes.brand.getCountry());
    }
}