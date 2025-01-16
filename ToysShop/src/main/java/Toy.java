import java.io.Serializable;

public class Toy implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double price;
    private String size;
    private String category;

    public Toy(int id, String name, double price, String size,  String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return  id + ": " + name + ", цена: " + price + ", размер: " + size + ", категория: " + category;
    }
}