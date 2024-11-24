import java.util.Random;

public class Match {
    private Player playerA;
    private Player playerB;

    private Random dice;

    public Match(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Random();
    }

    // Roll a 6-sided die
    public int rollDie() {
        return dice.nextInt(6) + 1;
    }

    // Perform one turn of attack and defense
    private void performTurn(Player attacker, Player defender, String attackerName, String defenderName) {
        int attackRoll = rollDie();
        int defenseRoll = rollDie();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;

        int netDamage = Math.max(attackDamage - defenseStrength, 0);
        defender.takeDamage(netDamage);

        System.out.println(attackerName + " attacks! Rolls: " + attackRoll +
                ". " + defenderName + " defends! Rolls: " + defenseRoll +
                ". Net Damage: " + netDamage +
                ". " + defenderName + " Health: " + defender.getHealth());
    }

    // Start the match and handle turn-based attacks
    public void startMatch() {
        System.out.println("Match Start!");
        System.out.println("Player A: " + playerA);
        System.out.println("Player B: " + playerB);

        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() <= playerB.getHealth()) {
                performTurn(playerA, playerB, "Player A", "Player B");
                if (!playerB.isAlive()) break;
                performTurn(playerB, playerA, "Player B", "Player A");
            } else {
                performTurn(playerB, playerA, "Player B", "Player A");
                if (!playerA.isAlive()) break;
                performTurn(playerA, playerB, "Player A", "Player B");
            }
        }

        System.out.println("Match Over!");
        if (playerA.isAlive()) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }
}
