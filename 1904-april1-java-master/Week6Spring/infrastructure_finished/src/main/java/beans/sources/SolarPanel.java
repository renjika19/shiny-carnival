package beans.sources;

public class SolarPanel extends Source {
	
	SolarPanel(String resource) {
		this.setResource(resource);
	}
	
	public void ourInit() {
		System.out.println("Installing a solar panel..");
	}

}
