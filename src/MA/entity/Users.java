package MA.entity;

public class Users {
	
	private String id;
	  private String name;
	  private String password;
  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
	

  
}
