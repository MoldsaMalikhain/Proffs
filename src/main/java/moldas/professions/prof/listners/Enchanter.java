package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;

public class Enchanter implements Listener {

    PlayerDataHandler players;

    public Enchanter(PlayerDataHandler players) {
        this.players = players;
    }
}