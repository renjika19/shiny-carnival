package beans.residences;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beans.pipes.WaterPipes;
import beans.pipes.Wires;

@Component
@Scope("prototype")
public class ComponentScannedCabin extends Residence {

//	@Autowired
//	ComponentScannedCabin(@Qualifier("wellWaterPipes") WaterPipes waterPipes, @Qualifier("solarWires") Wires wires) {
//		super(waterPipes, wires);
//	}
	
	// JSR 330 version of the above:
	
	@Inject
	ComponentScannedCabin(@Named("wellWaterPipes") WaterPipes waterPipes, @Named("solarWires") Wires wires) {
		super(waterPipes, wires);
	}

}
