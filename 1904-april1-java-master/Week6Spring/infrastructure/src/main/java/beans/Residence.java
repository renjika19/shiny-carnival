package beans;

public abstract class Residence {
	
	private WaterPipes waterPipes;
	private String name;
	
	public void printStatus() {
		System.out.println("Here's the state of things in " + name);
		if (waterPipes == null) {
			System.out.println("No water pipes are connected");
		} else if (waterPipes.providesResource()) {
			System.out.println("Water pipes are providing " + waterPipes.getContents());
		} else {
			System.out.println("Water pipes are connected, but empty!");
		}
	}
	
	public WaterPipes getWaterPipes() {
		return waterPipes;
	}
	public void setWaterPipes(WaterPipes waterPipes) {
		this.waterPipes = waterPipes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
