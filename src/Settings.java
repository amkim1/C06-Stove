/**
 * Settings enum. 
 *  
 * @author Mohammed Alnasser
 * @author Alex Kim
 * 
 * Purpose: Store settings
 */

public enum Settings {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String state;
	
	/**
	 * constructor for settings
	 */
	private Settings(String s) {
		state = s;
	}
	
	/**
	 * get the next setting and stay on the same setting if it is the highest
	 */
	public Settings getNext() {
		if(ordinal()==values().length-1) {
			return values()[ordinal()];
		}
		return values()[(ordinal()+1)];
	}
	
	/**
	 * get the previous setting and stay on the same setting if it is the lowest
	 */
	public Settings getPrevious() {
		if(ordinal()==0) {
			return values()[ordinal()];
		}
		return values()[(ordinal()-1)];
	}
	
	/**
	 * toString for settings
	 */
	public String toString() {
		return state;
	}

}
