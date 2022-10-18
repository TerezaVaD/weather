package cs.vsb.tereza.dto;

public class WeatherstackDto {

	public Request requestObject;
	public Location locationObject;
	public Current currentObject;
	
	public Request getRequest() {
		return requestObject;
	}
	
	public Location getLocation() {
		return locationObject;
	}
	
	public Current getCurrent() {
		return currentObject;
	}
	
	public void setRequest(Request requestObject) {
		this.requestObject = requestObject;
	}
	
	public void setLocation(Location locationObject) {
		this.locationObject = locationObject;
	}
	
	public void setCurrent(Current currentObject) {
		this.currentObject = currentObject;
	}
}
