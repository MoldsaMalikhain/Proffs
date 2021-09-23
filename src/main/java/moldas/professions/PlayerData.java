package moldas.professions;

import java.util.HashMap;

public class PlayerData {

    public String playerName;
    public HashMap <String, String> playerProfession = new HashMap<>();
    public int primaryProfLvl = 0;
    public int secondaryProfLvl = 0;
    public float speed = (float) 0.2;
    public float harvestSpeedMultiplier = 1;
    public float health = 20;
    public float jumpHeightMultiplier = 1;
    public float fallingDamageMultiplier = 1;
    public float damageMultiplier = 1;
    public float armorMultiplier = 1;
    public float shiftSpeedMultiplier = 1;

    PlayerData(String _playerName) {
        playerName = _playerName;
    }
}
