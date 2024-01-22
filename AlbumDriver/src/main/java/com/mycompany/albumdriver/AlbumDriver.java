/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.albumdriver;

/**
 *
 * @author thath
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlbumDriver {
    private static Scanner input = new Scanner(System.in);
    private static int loop = 0;
    private static final Album album = new Album();
    private static final Song song = new Song();
    private static final Artist artist = new Artist();
    private static final HashMap<String, ArrayList<Song>> albumsMap = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(".............................You are Welcome to the music world!........................................");
        System.out.println("..........................................Let's go!!....................................................");
        System.out.println("................................We are Here to Assist You...............................................");

        while (loop != 5) {
            displayMenu();

            try {
                loop = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; 
            }

            switch (loop) {
                case 1 -> openNewAlbum();
                case 2 -> openExistingAlbum();
                case 3 -> searchSongs();
                case 4 -> displayPlaylists();
                case 5 -> System.out.println("Exiting the program. Goodbye!");
                default -> System.out.println("Invalid input. Please enter 1, 2, 3, 4, or 5.");
            }

            // Inform the user about available options
            if (loop != 5) {
                System.out.println("Press Enter to continue...");
                input.nextLine(); 
            }
        }

        
        input.close();
    }

    private static void displayMenu() {
        System.out.println("If you want to open a new album, Please Enter NO 1 ");
        System.out.println("If you want to open an existing album, Please enter NO 2");
        System.out.println("If you want to search songs in the album,Please enter No 3");
        System.out.println("If you want to display the current playlists, Please enter NO 4");
        System.out.println("If you want to exit from this Program, Please Enter No 5 ");
    }

    private static void openNewAlbum() {
        album.setAlbumInformation();

        System.out.println("Album '" + album.getAlbumName() + "' opened.");

        ArrayList<Song> albumSongs = new ArrayList<>();
        albumsMap.put(album.getAlbumName(), albumSongs);

        System.out.println("Welcome to the album " + album.getAlbumName());

        addSongsToAlbum(); 
    }


private static void addSongsToAlbum() {
    
    int albumAction = 0;

    do {
        displayAlbumMenu();

        try {
            albumAction = input.nextInt(); 
            input.nextLine();  
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();  
            continue;
        }

        switch (albumAction) {
            case 1:
                addSongToAlbum(album.getAlbumName());
                break;
            case 2:
                System.out.println("Exiting from creating a new album ");
                break;
            default:
                System.out.println("Invalid input. Please enter 1 or 2.");
        }
    } while (albumAction != 2);
}





    private static void displayAlbumMenu() {
        System.out.println("If you want to add songs, Please enter No 1 ");
        System.out.println("If you want to exit from the album, Please enter No 2 ");
    }

    private static void addSongToAlbum(String albumName) {
        song.setSongsInformation();
        albumsMap.get(albumName).add(song); 
        System.out.println("Song '" + song.getSongName() + "' added to the album.");
    }

    private static void openExistingAlbum() {
        System.out.println("Enter the existing album name: ");
        String existingAlbumName = input.nextLine().trim();

        if (albumsMap.containsKey(existingAlbumName)) {
            System.out.println("Opening existing album '" + existingAlbumName + "'.");
        } else {
            System.out.println("Album '" + existingAlbumName + "' not found.");
        }
        addSongsToAlbum();
    }

    private static void searchSongs() {
        int searchSongsLoop = 0;

        while (searchSongsLoop != 4) {
            System.out.println("If you want to search songs by Title , Please enter NO 1");
            System.out.println("If you want to search songs by Artist , Please enter NO 2");
            System.out.println("If you want to search songs by year , Please enter NO 3 ");
            System.out.println("If you want to go back , Please enter NO 4 ");
            searchSongsLoop = input.nextInt();
            input.nextLine(); 

            switch (searchSongsLoop) {
                case 1 -> searchSongsByTitle();
                case 2 -> searchSongsByArtist(); 
                case 3 -> searchSongsByYear(); 
                case 4 -> System.out.println("You are exiting from the Search song Menu ");
                default -> System.out.println("You entered an invalid number, Please enter 1, 2, 3, or 4");
            }
        }
    }

    private static void searchSongsByTitle() {
        System.out.println("Enter the title to search for: ");
        String title = input.nextLine().trim();

        ArrayList<Song> matchingSongs = new ArrayList<>();

        for (ArrayList<Song> albumSongs : albumsMap.values()) {
            for (Song song : albumSongs) {
                if (song.matchesSearchTerm(title)) {
                    matchingSongs.add(song);
                }
            }
        }

        displayMatchingSongs(matchingSongs);
    }

    private static void searchSongsByArtist() {
        System.out.println("Enter the artist to search for: ");
        String artist = input.nextLine().trim();

        ArrayList<Song> matchingSongs = new ArrayList<>();

        for (ArrayList<Song> albumSongs : albumsMap.values()) {
            for (Song song : albumSongs) {
                if (song.matchesSearchTerm(artist)) {
                    matchingSongs.add(song);
                }
            }
        }

        displayMatchingSongs(matchingSongs);
    }

    private static void searchSongsByYear() {
        System.out.println("Enter the year to search for: ");
        int year = input.nextInt();
        input.nextLine(); 

        ArrayList<Song> matchingSongs = new ArrayList<>();

        for (ArrayList<Song> albumSongs : albumsMap.values()) {
            for (Song song : albumSongs) {
                if (song.getReleasedYear() == year) {
                    matchingSongs.add(song);
                }
            }
        }

        displayMatchingSongs(matchingSongs);
    }

    private static void displayMatchingSongs(ArrayList<Song> matchingSongs) {
        if (matchingSongs.isEmpty()) {
            System.out.println("No matching songs found.");
        } else {
            System.out.println("Matching songs:");
            for (Song song : matchingSongs) {
                System.out.println("Album: " + getAlbumName(song) +
                        ", Song: " + song.getSongName() +
                        ", Artist: " + artist.getArtistName(0)+
                        ", Released Year: " + song.getReleasedYear());
            }
        }
    }

    private static String getAlbumName(Song song) {
        for (String albumName : albumsMap.keySet()) {
            if (albumsMap.get(albumName).contains(song)) {
                return albumName;
            }
        }
        return "Unknown Album";
    }

    private static void displayPlaylists() {
    System.out.println("Displaying current playlists...");

    for (String albumName : albumsMap.keySet()) {
        System.out.println("Album Name: " + albumName);
        ArrayList<Song> songs = albumsMap.get(albumName);

        if (songs.isEmpty()) {
            System.out.println("No songs in this album.");
        } else {
            System.out.println("Songs:");

            for (Song song : songs) {
                System.out.println("\tSong Name: " + song.getSongName());
                System.out.println("\tGenre: " + song.getGenre());
                System.out.println("\tDuration: " + song.getDurationInSeconds() + " seconds");
                System.out.println("\tReleased Year: " + song.getReleasedYear());

                System.out.println("\tArtists:");

                for (Artist artist : artist.getArtists()) {
                    System.out.println("\t\tName: " + artist.getName());
                    System.out.println("\t\tBirth Year: " + artist.getBirthYear());
                    System.out.println("\t\tType: " + artist.getType());
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}

}
