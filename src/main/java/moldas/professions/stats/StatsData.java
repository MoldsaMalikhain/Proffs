package moldas.professions.stats;

import java.io.Serializable;

public class StatsData implements Serializable {
    public float speed = (float) 0.2;
    public float harvestSpeedMultiplier = 1;
    public float health = 20;
    public float jumpHeightMultiplier = 1;
    public float fallingDamageMultiplier = 1;
    public float damageMultiplier = 1;
    public float armorMultiplier = 1;
    public float shiftSpeedMultiplier = 1;

    public int athletic = 1;
    public int acrobatic = 1;
    public int strength = 1;
    public int blocking = 1;
    public int vitality = 1;
    public int stealth = 1;
}
