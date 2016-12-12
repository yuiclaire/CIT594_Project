package kidsapp;
/**
 * The Destinations abstract class
 * This class contains all the abstract methods for a subclass to extend.
 */
public abstract class Destinations {
	public int objectID;
	public String name;
	public String address;
	public double rating;
	public double x;
	public double y;
	public String zip;
	public String phone;
	
	public abstract int getObjectId();

	public abstract String getName();

	public abstract String getAddress();

	public abstract double getRating();

	public abstract double getX();

	public abstract double getY();

	public abstract String getZip();

	public abstract String getPhone();
	
	public abstract String toString();
}
