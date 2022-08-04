package Com.musicAPP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums=new ArrayList<>();
	public static void main(String[] args) {

	Album album= new Album("album1",  " ac/dc");
		album.addSong("tnt", 4.5);
		album.addSong("highway to hell", 4.0);
		album.addSong("thunderstruck", 2.5);
		album.addSong(" struck", 5.1);
		
		albums.add(album);
		
		album=new Album("album2","dg");
		album.addSong("rap god", 4.5);
		album.addSong("savi savi", 2.5);
		album.addSong("nenegalaa", 5.0);
		album.addSong("yenagali munde sagu", 5.5);
		albums.add(album);
		
		LinkedList<Song>   playlist_1=new LinkedList<>();
		
		albums.get(0).addToPlayList("tnt", playlist_1);
		albums.get(0).addToPlayList("highway to hell", playlist_1);
		albums.get(1).addToPlayList("savi savi", playlist_1);
		albums.get(1).addToPlayList("yenagali munde sagu", playlist_1);
		play(playlist_1);
			
	}
	
	
	private static void play(LinkedList<Song> playList) {

		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator=playList.listIterator();
		
		if (playList.size()==0) {
			
			System.out.println("this playlist no songs");
		} 
		else {
			System.out.println("now playing   "+   listIterator.next().toString());
			printMenu();

		}
		
		while(!quit)
		{
			int action=sc.nextInt();
			sc.nextLine();
			switch (action)
			{
			case 0 :System.out.println("playlist complete");
						quit=true;
						break;
						
			case 1 : if (!forward) {
				        if (listIterator.hasNext()) 
				        {
				        	listIterator.next();
						}
				        forward=true;
			}
			if (listIterator.hasNext()) {
				
				System.out.println("now playing"+listIterator.next().toString());
			}
			else {
				System.out.println("no songs here");
				forward=false;
			}
			break;
			
			case 2 :
							if (forward) {
								 if (listIterator.hasPrevious()) {
									listIterator.previous();
								}
								 forward=false;
							}
							if (listIterator.hasPrevious()) {
								System.out.println("now playing"+listIterator.previous().toString());
								
							} else {
								System.out.println("we are first song");
								forward=false;
							}
							break;
			case 3 :
						 if (forward) {
							 if (listIterator.hasPrevious()) {
								System.out.println("now playing"+listIterator.previous().toString());
								forward=false;
							} 
							 else {
								System.out.println("we are the start of the list");

							}
						}
						 else {
							if (listIterator.hasNext()) {
								System.out.println("now playing"+listIterator.next().toString());
								forward=true;
							}
							else {
								System.out.println("we have list");

							}

						}
						 break;
			case 4 :
						 printList(playList);
						 break;
						 
			case 5 :
						 printMenu();
						 break;
						 
			case 6 :
						if (playList.size() >0) {
							
							listIterator.remove();
							if (listIterator.hasNext()) {
								System.out.println("now playing" +listIterator.next().toString());
							} 
							
							else 
							{
								                 if (listIterator.hasPrevious()) 
									              System.out.println("now playing" +listIterator.previous().toString());
					
							}
							
	                }
			}
			
		}
	}
	
	private static void printMenu() {
		
		System.out.println("availble options are \n press");
		System.out.println("0- to quit \n" + "1 - to play next song\n"+"2 - to play previos song\n "+ "3 - to replay the current song\n"
									 +"4 - to list of all sogs\n"+" 5 - print all availble option \n"+"6- to delete song \n");
		
	}
		
	private static void printList(LinkedList<Song> playList) {

		Iterator<Song>       iterator=playList.iterator();
		System.out.println("--------------------------------------------");
		
		
		while(iterator.hasNext()) {
				System.out.println(iterator.next());
		}
		System.out.println("-----------------------------------------------");
	
	}
	
	}
