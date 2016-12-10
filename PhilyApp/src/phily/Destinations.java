package phily;

public abstract class Destinations {
	public int objectID;
	public String name;
	public String address;
	public double rating;
	
	public int getObjectId(){
		return objectID;
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public double getRating(){
		return rating;
	}
	abstract double getX(); 
	
	abstract double getY();
	
	abstract String getZip();
	
	abstract String getPhone();
}
