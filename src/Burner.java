/**
 * Burner class. 
 *  
 * @author Mohammed Alnasser
 * @author Alex Kim
 * 
 * Purpose: Simulate a burner
 */

public class Burner {
	
	private final int TIME_DURATION = 2;
	private Temperature temperature;
	private Settings settings;
	private int timer;
	

	/**
	 * store the temperature of the burner
	 */
	private enum Temperature {
		COLD, WARM, HOT, BLAZING;
		
		/**
		 * get the next temperature and stay on the same temperature if it is the highest
		 */
		public Temperature getNext() {
			if(ordinal()==values().length-1) {
				return values()[ordinal()];
			}
			return values()[(ordinal()+1)];
		}
		
		/**
		 * get the previous temperature and stay on the same temperature if it is the lowest
		 */
		public Temperature getPrevious() {
			if(ordinal()==0) {
				return values()[ordinal()];
			}
			return values()[(ordinal()-1)];
		}
	}
	
	/**
	 * constructor for burner
	 */
	public Burner() {
		super();
		temperature = Temperature.COLD;
		settings = Settings.OFF;
		timer = 0;
	}

	/**
	 * increase settings of the burner
	 */
	public void plusButton() {
		// timer will only be reset if there was no timer
		if(timer==0) {
			timer = TIME_DURATION;
		}
		
		// settings = settings.getNext(); // We think this code looks better but the requirements said use switch()
		
		switch(settings) {
		case HIGH:
			break;
		case MEDIUM:
			settings = Settings.HIGH;
			break;
		case LOW:
			settings = Settings.MEDIUM;
			break;
		case OFF:
			settings = Settings.LOW;
			break;
		}

	}

	/**
	 * decrease settings of the burner
	 */
	public void minusButton() {
		
		// timer will only be reset if there was no timer
		if(timer==0) {
			timer = TIME_DURATION;
		}
		
		// settings = settings.getPrevious(); // We think this code looks better but the requirements said use switch()
		
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
		case OFF:
			break;
		
		}
	}

	/**
	 * update the temperature of the burner
	 */
	public void updateTemperature() {
		
		// check if enough time has passed to update the temperature of the burner
		timer--;
		if(timer>0) {
			return;
		}
		timer = 0;
		
		// increase or decrease the temperature based on the settings
		if(settings.ordinal()>temperature.ordinal()) {
			temperature = temperature.getNext();
		} else if(settings.ordinal()<temperature.ordinal()) {
			temperature = temperature.getPrevious();
		}
		
		// if the temperature does not match the settings then reset the timer
		if(settings.ordinal()!=temperature.ordinal() ) {
			timer = TIME_DURATION;
		}

	}

	/**
	 * display the current state of the burner
	 */
	public void display() {
		System.out.print("[" + settings + "].....");
		switch(temperature) {
		
		case BLAZING:
			System.out.println("VERY HOT! DON'T TOUCH");
			break;
		case HOT:
			System.out.println("CAREFUL");
			break;
		case WARM:
			System.out.println("warm");
			break;
		case COLD:
			System.out.println("coool");
			break;
			
		}
	}

	/**
	 * return whether the burner is blazing
	 */
	public boolean isBlazing() {
		return temperature==Temperature.BLAZING;
	}
	
	/**
	 * Getter for temperature 
	 */
	public Temperature getTemperature() {
		return temperature;
	}
	
	

}
