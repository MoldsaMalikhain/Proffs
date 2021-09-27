package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.event.Listener;

public class Blacksmith implements Listener {

    PlayerDataHandler players;

    public Blacksmith(PlayerDataHandler _players) { players = _players; }
}
