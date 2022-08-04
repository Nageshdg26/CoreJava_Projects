package Com.musicAPP;

public class Song {

	String titel;
	double duration;
	public Song(String titel, double duration) {  //Comstrunctor
		super();
		this.titel = titel;
		this.duration = duration;
	}
	public Song() {   //Empty Constructor
		
	}
	public String getTitel() {
		return titel;
	}
	public double getDuration() {
		return duration;
	}
	@Override
	public String toString() {
		return "Song {" +"titel='" + titel +  ", duration=" + duration + '}';
				
	}
	
	
	
	
	
}
