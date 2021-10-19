package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Blocking extends Stats implements Serializable {

    public float armorMultiplier = 1;

    @Override
    public void onLvlUp() {
        armorMultiplier += 0.01;
    }
}
