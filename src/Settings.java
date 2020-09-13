
public enum Settings {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String state;
	private Settings(String s) {
		state = s;
	}
	
	public String toString() {
		return state;
	}
	

}
