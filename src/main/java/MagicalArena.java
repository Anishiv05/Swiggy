public class MagicalArena {
    public static void main(String[] args) {
        Player playerA = new Player(50, 1, 2);
        Player playerB = new Player(10, 2, 4);

        Match match = new Match(playerA, playerB);
        match.startMatch();
    }
}
