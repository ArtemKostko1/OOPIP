import java.util.Objects;

public abstract class Toy {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Toy toy = (Toy) obj;
        return ageGroup == toy.ageGroup && Double.compare(toy.price, price) == 0 && Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, ageGroup);
    }
}