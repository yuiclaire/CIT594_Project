package phily;

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

	abstract double getX();

	abstract double getY();

	abstract String getZip();

	abstract String getPhone();
}

