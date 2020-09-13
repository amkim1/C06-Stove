
public class Burner {
	private enum Temperature {HOT, WARM, COLD}
	private Temperature temperature;
	private Settings settings;
	private int timer;
	private final int TIME_DURATION = 2;

	public Burner() {
		super();
		temperature = Temperature.COLD;
		settings = Settings.OFF;
		timer = 0;
	}
	
	public void plusButton() {
		switch(settings) {
		case OFF:
			settings = Settings.LOW;
			break;
		case LOW:
			settings = Settings.MEDIUM;
			break;
		case MEDIUM:
			settings = Settings.HIGH;
			break;
		}
		
		
		
	}

	

	public void minusButton() {
		switch(settings) {
		case HIGH:
			settings = Settings.MEDIUM;
			break;
		case MEDIUM:
			settings = Settings.LOW;
			break;
		case LOW:
			settings = Settings.OFF;
			break;
		}
		
	}

	public void updateTemperature() {
		// TODO Auto-generated method stub
		
	};
	
	
	
}
