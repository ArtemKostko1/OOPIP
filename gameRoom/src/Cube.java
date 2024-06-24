import java.io.Serializable;

public class Cube extends Toy implements Serializable {
    private static final long serialVersionUID = 1L;

    public Cube(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}
