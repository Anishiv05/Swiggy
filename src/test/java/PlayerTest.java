import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player(100, 10, 5);
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(5, player.getAttack());
    }

    @Test
    public void testTakeDamage() {
        Player player = new Player(100, 10, 5);
        player.takeDamage(30);
        assertEquals(70, player.getHealth());
    }

    @Test
    public void testTakeDamageExceedingHealth() {
        Player player = new Player(50, 10, 5);
        player.takeDamage(60);
        assertEquals(0, player.getHealth()); // Health should not go below 0
    }

    @Test
    public void testIsAlive() {
        Player player = new Player(50, 10, 5);
        assertTrue(player.isAlive());
        player.takeDamage(50);
        assertFalse(player.isAlive());
    }
}
