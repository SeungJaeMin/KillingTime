package View;

public class LMain {
	private LMainframe mainframe;
	
	// Constructor
	public LMain() {
		this.mainframe = new LMainframe();
	}

	// Main
	public static void main(String[] args) {
		LMain main = new LMain();
		main.initialize();
		

	}
	
	// Initialize
	public void initialize() {
		this.mainframe.initialize();
	}
	
	
	

}
