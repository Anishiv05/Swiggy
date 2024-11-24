public class MagicalArena {
    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 2);

        Match match = new Match(playerA, playerB);
        match.startMatch();
    }
}
