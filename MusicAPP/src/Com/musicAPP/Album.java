package Com.musicAPP;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String name;
	private String artist;
	private ArrayList<Song>    songs;
	
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
		
	}
	public Album() {

	}

	public Song findSong(String title)
	{
		for(Song checkedSong :  songs)
		{
			if (checkedSong.getTitel().equals(title)) 
				return checkedSong;
		}
		return null;
	}
	 
	public boolean addSong(String title,double duration)
	{
		if (findSong(title)==null) {
			songs.add(new Song(title,duration));
			System.out.println(title+"succsesfuly added list");
			return true;
		}
		else {
			System.out.println("song with name"+title+"already exist in list");
			return false;
		}
		
	}
	
	
	public boolean addToPlaylist(int trackNumber,  LinkedList<Song> playList)
	{
		int index =trackNumber-1;
		if (index  >  0   &&  index <=this.songs.size()) {
			playList.add(this.songs.get(index));
			
			return true;
		}
	System.out.println("this album does't song with Tnum "+trackNumber);
		return false;
		
	}
	
	
	public boolean addToPlayList(String title, LinkedList<Song> playList)
	{
		for(Song checkedSong :  this.songs)
		{
			if (checkedSong.getTitel().equals(title)) {
				playList.add(checkedSong);
				return true;
				
			}
		}
	System.out.println(title+"no such songs in album");
		return false;
	}
	
}
