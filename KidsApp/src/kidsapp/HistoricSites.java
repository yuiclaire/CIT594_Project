package kidsapp;
/**
 * The HistoricSites class
 * This class extends Destinations and implements all the abstract methods of it.
 */
public class HistoricSites extends Destinations{
        /**
	 * Constructor for class HistoricSites
	 */
	public HistoricSites(int objectID, double x, double y, String name, String address, String zip, String phone){
		this.objectID = objectID;
		this.x = x;
		this.y = y;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.phone = phone;	
	}
	/**
	 * @return the latitude of HistoricSites
	 */
	@Override
	public double getX() {
		
		return x;
	}
	/**
	 * @return the longitude of HistoricSites
	 */
	@Override
	public double getY() {
		
		return y;
	}
	/**
	 * @return the zipcode of HistoricSites
	 */
	@Override
	public String getZip() {
		
		return zip;
	}
	/**
	 * @return the phoneNumber of HistoricSites
	 */
	@Override
	public String getPhone() {
		
		return phone;
	}
        /**
	 * @return the objectID of HistoricSites
	 */
	@Override
	public int getObjectId() {
		
		return objectID;
	}
        /**
	 * @return the name of HistoricSites
	 */
	@Override
	public String getName() {
		
		return name;
	}
        /**
	 * @return the longitude of HistoricSites
	 */
	@Override
	public String getAddress() {
		
		return address;
	}
	@Override
	/**
	 * @return a String containing all information separated by comma
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
