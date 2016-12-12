package kidsapp;
/**
 * The Destinations abstract class
 * This class contains all the abstract methods for a subclass to extend.
 */
public abstract class Destinations {
	public int objectID;
	public String name;
	public String address;
	public double x;
	public double y;
	public String zip;
	public String phone;
/**
 * The Destinations abstract method
 * Get the objectID of destination(1,2,3......)
 */	
	public abstract int getObjectId();
/**
 * The Destinations abstract method
 * Get the name of destination
 */
	public abstract String getName();
/**
 * The Destinations abstract method
 * Get the address of destination
 */
	public abstract String getAddress();
/**
 * The Destinations abstract method
 * Get the latitude of destination in GoogleMap
 */
	public abstract double getX();
/**
 * The Destinations abstract method
 * Get the longitude of destination in GoogleMap
 */
	public abstract double getY();
/**
 * The Destinations abstract method
 * Get the zipcode of destination
 */
	public abstract String getZip();
/**
 * The Destinations abstract method
 * Get the phoneNumber of destination
 */
	public abstract String getPhone();
/**
 * The Destinations abstract method
 * @return a String containing all information separated by comma
 */	
	public abstract String toString();
}
