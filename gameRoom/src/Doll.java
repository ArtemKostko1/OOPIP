import java.io.Serializable;

public class Doll extends Toy implements Serializable {
    private static final long serialVersionUID = 1L;

    public Doll(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}
