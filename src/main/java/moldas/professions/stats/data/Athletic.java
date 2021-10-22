package moldas.professions.stats.data;

import moldas.professions.stats.Stats;

import java.io.Serializable;

public class Athletic extends Stats implements Serializable {

    public float speed = (float) 0.23;

    @Override
    public void onLvlUp() {
        speed += 0.0015;
    }
}
