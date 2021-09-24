package moldas.professions;

import java.sql.Struct;
import java.util.HashMap;

public class PlayerData {

    public String playerName;
    public HashMap <String, String> playerProfession = new HashMap<>();

    //TODO Create parameters for characteristics

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

        //playerCharacteristics.put("Athletic", 1);
        //playerCharacteristics.put("Acrobatic", 1);
        //playerCharacteristics.put("Strength", 1);
        //playerCharacteristics.put("Blocking", 1);
        //playerCharacteristics.put("Vitality", 1);
        //playerCharacteristics.put("Stealth", 1);
    }
}
