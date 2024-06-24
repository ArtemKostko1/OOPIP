import java.io.Serializable;
import java.util.List;

public class GameRoomData implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Toy> toys;
    private double budget;
    private int limitToysNumber;

    public GameRoomData(List<Toy> toys, double budget, int limitToysNumber) {
        this.toys = toys;
        this.budget = budget;
        this.limitToysNumber = limitToysNumber;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public double getBudget() {
        return budget;
    }

    public int getLimitToysNumber() {
        return limitToysNumber;
    }
}
