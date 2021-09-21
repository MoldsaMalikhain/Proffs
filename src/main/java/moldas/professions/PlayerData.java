package moldas.professions;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PlayerData {

    public String playerName;
    public HashMap <String, Integer> playerProfession = new HashMap<>();
    public double speed = 1;
    public double harvestSpeed = 1;
    public double health = 20;
    public double jumpHeight = 1;
    public double fallingDamage = 1;
    public double damage = 1;
    public double armor = 1;
    public double shiftSpeed = 1;
    public Date createdAt = new Date();

}
