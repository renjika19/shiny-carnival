package beans;

public abstract class Pipes {

	// These pipes transport a resource from a source to a residence
	
	protected Source source;
	
	public boolean providesResource() {
		return source.hasResource();
	}
	
	public String getContents() {
		return source.getResource();
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
	
}
