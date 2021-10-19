package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Stealth extends Stats implements Serializable {

    public float shiftSpeedMultiplier = (float) 0.23;

    @Override
    public void onLvlUp() {
        shiftSpeedMultiplier += 0.01;
    }
}
