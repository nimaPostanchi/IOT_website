package sandwich;

public class SandwichRepository {
	
	public int sandwich = 10;
	
	public SandwichRepository(){
		
	}
	
	public int getSandwich() {
		return sandwich;
	}

	public void setSandwich(int sandwich) {
		this.sandwich = sandwich;
	}
	
	public void reduce(){
		setSandwich(sandwich -1);
	}

}