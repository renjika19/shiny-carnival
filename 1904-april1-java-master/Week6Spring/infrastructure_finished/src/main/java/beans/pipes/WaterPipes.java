package beans.pipes;

import beans.sources.Source;

public class WaterPipes extends Pipes {
	
	WaterPipes() {
		
	}
	
	WaterPipes(Source source) {
		this.setSource(source);
	}
	
	public void ourInit() {
		System.out.println("Piping some pipes..");
	}
}
