package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;

public class Alchemist implements Listener {

    PlayerDataHandler players;

    public Alchemist(PlayerDataHandler players) {
        this.players = players;
    }
}