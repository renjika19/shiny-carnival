package beans.residences;

import beans.pipes.WaterPipes;
import beans.pipes.Wires;

public abstract class Residence {
	
	private WaterPipes waterPipes;
	private Wires wires;
	private String name;
	
	Residence(WaterPipes waterPipes, Wires wires) {
		this.waterPipes = waterPipes;
		this.wires = wires;
	}
	
	Residence() {
		
	}
	
	public void printStatus() {
		System.out.println("Here's the state of things in " + name);
		if (waterPipes == null) {
			System.out.println("No water pipes are connected");
		} else if (waterPipes.providesResource()) {
			System.out.println("Water pipes are providing " + waterPipes.getContents());
		} else {
			System.out.println("Water pipes are connected, but empty!");
		}
		if (wires == null) {
			System.out.println("No wires are connected");
		} else if (wires.providesResource()) {
			System.out.println("Wires are providing " + wires.getContents());
		} else {
			System.out.println("Wires are connected, but don't provide anything!");
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

	public Wires getWires() {
		return wires;
	}

	public void setWires(Wires wires) {
		this.wires = wires;
	}
	
	

}
