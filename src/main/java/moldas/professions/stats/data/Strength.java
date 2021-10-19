package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Strength extends Stats implements Serializable {

    public float harvestSpeedMultiplier = 1;
    public float damageMultiplier = 1;

    @Override
    public void onLvlUp() {
        harvestSpeedMultiplier += 0.015;
        damageMultiplier += 0.015;
    }
}
