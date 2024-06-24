import java.io.Serializable;

public abstract class Toy implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private int ageGroup;

    public Toy(String name, double price, int ageGroup) {
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public String toString() {
        return "Игрушка: " + name + ", цена: " + price + ", возрастная группа: " + ageGroup;
    }
}