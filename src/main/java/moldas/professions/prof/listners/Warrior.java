package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;

public class Warrior implements Listener {

    PlayerDataHandler players;

    public Warrior(PlayerDataHandler players) {
        this.players = players;
    }
}