import java.io.Serializable;

public class Car extends Toy implements Serializable {
    private static final long serialVersionUID = 1L;
    private CarSize size;

    public enum CarSize {
        SMALL("Маленькая"),
        MEDIUM("Средняя"),
        LARGE("Большая");

        private String displayName;

        CarSize(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Car(String name, double price, int ageGroup, CarSize size) {
        super(name, price, ageGroup);
        this.size = size;
    }

    public CarSize getSize() {
        return size;
    }

    public void setSize(CarSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", размер: " + size.getDisplayName();
    }
}
