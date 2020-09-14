
public class Burner {
	private enum Temperature {
		COLD, WARM, HOT, BLAZING;
		public Temperature getNext() {
			if(ordinal()==values().length-1) {
				return values()[ordinal()];
			}
			return values()[(ordinal()+1)];
		}
		public Temperature getPrevious() {
			if(ordinal()==0) {
				return values()[ordinal()];
			}
			return values()[(ordinal()-1)];
		}
	}
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
		timer = TIME_DURATION;
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
		timer = TIME_DURATION;
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
		if(timer!=0) {
			timer--;
			return;
		}
		if(settings.ordinal()>temperature.ordinal()) {
			temperature = temperature.getNext();
		} else if(settings.ordinal()<temperature.ordinal()) {
			temperature = temperature.getPrevious();
		}

	};



}
