package sandwich;

public class Sandwich {
	
	public int amount;
	public String name;
	
	public Sandwich(){
		
	}
	
	public Sandwich(int amount, String name){
		setAmount(amount);
		setName(name);
		
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void reduce(){
		if (getAmount() != 0) {			
		setAmount(getAmount() -1);
		}
	}

}
