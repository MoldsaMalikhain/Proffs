package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Acrobatic extends Stats implements Serializable {

    public float jumpHeightMultiplier = 1;
    public float fallingDamageMultiplier = 1;

    @Override
    public void onLvlUp() {
        jumpHeightMultiplier += 0.1;
        fallingDamageMultiplier -= 0.1;
    }
}
