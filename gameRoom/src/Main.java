import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameRoomData data = FileService.loadGameRoomData();

        GameRoom gameRoom;
        if (data == null) {
            gameRoom = new GameRoom();
        } else {
            gameRoom = new GameRoom(data);
        }

        GameRoomMenu menu = new GameRoomMenu(gameRoom);
        menu.showMenu();

        FileService.saveGameRoomData(gameRoom.getGameRoomData());
    }
}