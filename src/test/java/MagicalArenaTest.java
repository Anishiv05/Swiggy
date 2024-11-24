import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class MagicalArenaTest {
    @Test
    public void testPlayerTakeDamage() {
        Player player = new Player(50, 5, 10);
        player.takeDamage(20);
        assertEquals(30, player.getHealth());
        player.takeDamage(40);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testMatchSimulation() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Match match = new Match(playerA, playerB);

        match.startMatch();
        assertEquals(true, playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }

    @Test
    public void testRollDie() {
        Match match = new Match(new Player(50, 5, 10), new Player(100, 10, 5));
        for (int i = 0; i < 100; i++) {
            int roll = match.rollDie();
            assertEquals(true, roll >= 1 && roll <= 6);
        }
    }
}
