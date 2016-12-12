package kidsapp;
/**
 * The Theaters class
 * This class extends Destinations and implements all the abstract methods of it.
 */
public class Theaters extends Destinations{
        /**
         * Constructor for the Theaters class
         */
	public Theaters(int objectID, double x, double y, String name, String address, String zip, String phone){
		this.objectID = objectID;
		this.x = x;
		this.y = y;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.phone = phone;	
	}
	/**
	 * @return the latitude of Theaters
	 */
	@Override
	public double getX() {
		
		return x;
	}
        /**
	 * @return the longitude of Theaters
	 */
	@Override
	public double getY() {
		
		return y;
	}
	/**
	 * @return the zipcode of Theaters
	 */
	@Override
	public String getZip() {
		
		return zip;
	}
	/**
	 * @return the phoneNumber of Theaters
	 */
	@Override
	public String getPhone() {
		
		return phone;
	}
        /**
	 * @return the objectId of Theaters
	 */
	@Override
	public int getObjectId() {
		
		return objectID;
	}
        /**
	 * @return the name of Theaters
	 */
	@Override
	public String getName() {
		
		return name;
	}
        /**
	 * @return the address of Theaters
	 */
	@Override
	public String getAddress() {
		
		return address;
	}
	/**
	 * 
	 * @return a String containing all information separated by comma
	 */
	@Override
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
