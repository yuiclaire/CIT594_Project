package phily;

public class Parks extends Destinations{
	public int objectID;
	public String name;
	public String address;
	public double x;
	public double y;
	public String zip;
	public String phone;
	public Parks(int objectID, double x, double y, String name, String address, String zip, String phone){
		this.objectID = objectID;
		this.x = x;
		this.y = y;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.phone = phone;	
	}	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public String getZip(){
		return zip;
	}
	
	public String getPhone(){
		return phone;
	}

}
