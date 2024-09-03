package jdbc.com.student;

public class StudentPojo {
 
	private int id;
	private String name;
	private int age;
	private String city;
	private long pincode;
	
	public StudentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPojo(int id, String name, int age, String city, long pincode) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.pincode = pincode;
	}
	
	public StudentPojo(String name, int age, String city, long pincode) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "StudentPojo [name=" + name + ", age=" + age + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
}
