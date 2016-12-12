package kidsapp;
/**
 * The Libraries class
 * This class extends Destinations and implements all the abstract methods of it.
 */
public class Libraries extends Destinations{

	public Libraries(int objectID, double x, double y, String name, String address, String zip, String phone){
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
	
	@Override
	/**
	 * 
	 * @return Return a String containing all information separated by comma
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(x);
		sb.append(",");
		sb.append(y);
		sb.append(",");
		sb.append(name);
		sb.append(",");
		sb.append(address);
		sb.append(",");
		sb.append(zip);
		sb.append(",");
		sb.append(phone);
		return sb.toString();
	}
}
