package moldas.professions;

import java.util.Date;
import java.util.HashMap;

public class PlayerData {

    public String playerName;
    public HashMap <String, String> playerProfession = new HashMap<>();
    public double speed = 1;
    public double harvestSpeed = 1;
    public double health = 20;
    public double jumpHeight = 1;
    public double fallingDamage = 1;
    public double damage = 1;
    public double armor = 1;
    public double shiftSpeed = 1;

    PlayerData(String _playerName) {
        playerName = _playerName;
    }

}
