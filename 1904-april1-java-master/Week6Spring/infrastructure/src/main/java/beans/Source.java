package beans;

public abstract class Source {

//	This is the source of a resource
	private String resource;
	
	public boolean hasResource() {
		if (resource != null) {
			return (resource.length()>0);
		} else {
			return false;
		}
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
