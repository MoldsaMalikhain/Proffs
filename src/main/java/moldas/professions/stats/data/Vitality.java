package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Vitality extends Stats implements Serializable {

    public float health = 20;

    @Override
    public void onLvlUp() {
        health += 1;
    }
}
