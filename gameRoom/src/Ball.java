import java.io.Serializable;

public class Ball extends Toy implements Serializable {
    private static final long serialVersionUID = 1L;

    public Ball(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}
