package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;


public class Farmer implements Listener {

    PlayerDataHandler players;

    public Farmer(PlayerDataHandler players) {
        this.players = players;
    }
}
