import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Toy> toys = FileService.loadToys();

        GameRoom gameRoom;
        if (toys == null) {
            gameRoom = new GameRoom();
        } else {
            gameRoom = new GameRoom(toys);
        }

        GameRoomMenu menu = new GameRoomMenu(gameRoom);
        menu.showMenu();

        FileService.saveToys(gameRoom.getToys());
    }
}