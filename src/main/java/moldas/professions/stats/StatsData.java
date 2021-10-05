package moldas.professions.stats;

import moldas.professions.stats.data.*;

import java.io.Serializable;

public class StatsData implements Serializable {

    //TODO: Lvl up logic for this stats

    public Acrobatic acrobatic = new Acrobatic();
    public Athletic athletic = new Athletic();
    public Blocking blocking = new Blocking();
    public Stealth stealth = new Stealth();
    public Strength strength = new Strength();
    public Vitality vitality = new Vitality();
}
