package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Athletic extends Stats implements Serializable {

    public float speed = (float) 0.2;

    @Override
    public void onLvlUp() {
        // ...
        // Add stats here on level up
    }
}
