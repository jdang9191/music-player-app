import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class main{

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args){

        

        Album album = new Album("Album 1", "AC/DC");

        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStruck", 5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");

        album.addSong("Rap God", 4.5);
        album.addSong("Not afraid", 3.5);
        album.addSong("Lose yourself", 4.5);
        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlaylist("TNT", playlist_1);
        albums.get(0).addToPlaylist("Highway to hell", playlist_1);
        albums.get(1).addToPlaylist("Rap GOd", playlist_1);
        albums.get(1).addToPlaylist("Lose yourself", playlist_1);

        play(playlist_1);


    }

    private static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size() == 0){
            System.out.println("This playlist has no songs");
        }
        else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }
                    else{
                        System.out.println("no song available, reached the end of the list");
                        forward = false;
                    }
                    break;
                   
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();

                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("we have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("now playin1g " + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
         System.out.println("0 - to quit\n" +
         "1 - to play next song\n" +
         "2 - to play previous song\n" +
         "3 - to replay the current song\n" +
         "4 - list of all songs \n" + 
         "5 - print all available options\n" +
         "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playlist){
       Iterator<Song> iterator = playlist.iterator();
        // Iterator<Song> iterator = playlist.iterator();
        System.out.println("----------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("----------------------");

    }
   

}