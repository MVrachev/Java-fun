package bg.uni.sofia.fmi.mjt.shopping;

public class Product implements  Item {

	 private String name;
	 private String description;
	 private double price;
	 
	 Product(String name, String description, double price){
		 this.name = name;
		 this.description = description;
		 this.price = price;
	 }
	 
	 public String getName() {
		 return name;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public double getPrice() {
		 return price;
	 }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Product other = (Product) obj;
	
		if(!name.equals(other.name)) {
			return false;
		}
		if(!description.equals(other.getName())) {
			return false;
		}
		if(this.price == other.price) {
			return false;
		}
		
		return true;
		
	}
	 
	 
}
