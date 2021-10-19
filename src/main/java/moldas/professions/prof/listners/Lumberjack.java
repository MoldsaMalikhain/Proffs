package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;

public class Lumberjack implements Listener {

    PlayerDataHandler players;

    public Lumberjack(PlayerDataHandler players) {
        this.players = players;
    }
}