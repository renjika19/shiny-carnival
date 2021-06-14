package beans.residences;

import beans.pipes.WaterPipes;
import beans.pipes.Wires;

public class HouseWithAutoByType extends Residence {
	
	// Autowiring by type
	// Must have setter or constructor with type of desired bean
	HouseWithAutoByType(WaterPipes wp, Wires w) {
		super(wp, w);
	}
	
	HouseWithAutoByType() {
		super();
	}

}
