package googlemap;

public class Parks {
	public int objectID;
	public double x;
	public double y;
	public String name;
	public String address;
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
	
}
