package MA.entity;

public class Books {
	
	private String id;
	private String name;
	private String price;          //原价
	private String currentPrice;  //打折后的价格  现价  =原价price*折扣rebata  
    private String img;
    private String rebate;
    private String auth;
  
    public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", price=" + price
				+ ", currentprice=" + currentPrice + ", img=" + img + "]";
	}
	
}
