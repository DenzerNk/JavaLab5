public class Clothes {
    private String name;
    private String size;
    private double price;
    private String color; // Додано 4 атрибута
    public Clothes(String name, String size, double price, String color) {
        setName(name);
        setSize(size);
        setPrice(price);
        setColor(color);
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою.");
        }
        this.name = name;
    }
    public String getSize() { return size; }
    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Розмір не може бути порожнім.");
        }
        this.size = size;
    }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна повинна бути більшою за нуль.");
        }
        this.price = price;
    }
    public String getColor() { return color; }
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Колір не може бути порожнім.");
        }
        this.color = color;
    }
    public String toString() {
        return "Clothes [name=" + name + ", size=" + size + ", price=" + price + ", color=" + color + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothes clothes = (Clothes) obj;
        if (Double.compare(clothes.price, price) != 0) return false;
        if (!name.equals(clothes.name)) return false;
        if (!size.equals(clothes.size)) return false;
        return color.equals(clothes.color);
    }
}