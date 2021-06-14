package beans.pipes;

import beans.sources.Source;

public class Wires extends Pipes {
	
	Wires() {
		
	}
	
	Wires(Source source) {
		this.setSource(source);
	}
	
	public void ourInit() {
		System.out.println("Wiring some wires..");
	}
}
