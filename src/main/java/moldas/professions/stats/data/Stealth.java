package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Stealth extends Stats implements Serializable {

    public float shiftSpeedMultiplier = 1;

    @Override
    public void onLvlUp() {
        // ...
        // Add stats here on level up
    }
}
