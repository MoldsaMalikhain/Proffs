package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Acrobatic extends Stats implements Serializable {

    public float jumpHeightMultiplier = 1;
    public float fallingDamageMultiplier = 1;

    @Override
    public void onLvlUp() {
        jumpHeightMultiplier += 0.02;
        fallingDamageMultiplier -= 0.01;
    }
}
