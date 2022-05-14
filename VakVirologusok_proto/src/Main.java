public class Main {

    public static void main(String[] args) {
        View vi = new View();
        Game g = new Game();
        // TODO plyercount bekérése itt (Game:nPlayers)
        g.StartGame();
        g.SetFields();
        System.out.println("The Game is On");
    }
}
