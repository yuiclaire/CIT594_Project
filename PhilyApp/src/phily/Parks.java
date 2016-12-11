package phily;

public class Parks extends Destinations {

	public Parks(int objectID, double x, double y, String name, String address, String zip, String phone) {
		this.objectID = objectID;
		this.x = x;
		this.y = y;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.phone = phone;
	}
	
	@Override
	public double getX() {
		
		return x;
	}

	@Override
	public double getY() {
		
		return y;
	}
	
	@Override
	public String getZip() {
		
		return zip;
	}
	
	@Override
	public String getPhone() {
		
		return phone;
	}

	@Override
	public int getObjectId() {
		
		return objectID;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public String getAddress() {
		
		return address;
	}

	@Override
	public double getRating() {
		
		return rating;
	}

}

