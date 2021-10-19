package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;

public class Archer implements Listener {

    PlayerDataHandler players;

    public Archer(PlayerDataHandler players) {
        this.players = players;
    }
}