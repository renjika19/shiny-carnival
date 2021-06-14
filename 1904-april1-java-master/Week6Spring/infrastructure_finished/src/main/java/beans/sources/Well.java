package beans.sources;

public class Well extends Source {
	
	Well(String resource) {
		this.setResource(resource);
	}
	
	public void ourInit() {
		System.out.println("Digging a well..");
	}

}
