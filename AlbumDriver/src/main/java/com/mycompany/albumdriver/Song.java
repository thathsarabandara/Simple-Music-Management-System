/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.albumdriver;

/**
 *
 * @author thath
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Song {

    String getGenre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    enum Genre {
        CLASSICAL, POP, REGGAE, JAZZ, COUNTRY
    }

    private String songName;
    private Genre selectedGenre;
    private int durationInSeconds;
    private String durationInMinutes;
    private String durationInHours;
    private int releasedYear;
    private Artist artist = new Artist();

    public String getSongName() {
        return songName;
    }

    public Genre getSelectedGenre() {
        return selectedGenre;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getDurationInMinutes() {
        int x = durationInSeconds / 60;
        int y = durationInSeconds % 60;
        durationInMinutes = x + ":" + y;
        return durationInMinutes;
    }

    public String getDurationInHours() {
        int z = durationInSeconds / 3600;
        int x = (durationInSeconds / 60) % 60;
        int y = durationInSeconds % 60;
        durationInHours = z + ":" + x + ":" + y;
        return durationInHours;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setSongsInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the song name: ");
        songName = scanner.nextLine().trim();
        if (songName.isEmpty()) {
            System.out.println("Invalid song name. Please enter a non-empty name.");
            scanner.close(); 
            return;
        }

        System.out.println("Choose a Genre type:");
        for (Genre genre : Genre.values()) {
            System.out.println(genre.ordinal() + 1 + ". " + genre);
        }

        int userInput;
        do {
            System.out.print("Enter the number corresponding to your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
            userInput = scanner.nextInt();
        } while (userInput < 1 || userInput > Genre.values().length);

        
        selectedGenre = Genre.values()[userInput - 1];

        artist.setArtistInformation();

        System.out.println("Enter the Duration in Seconds ");
        durationInSeconds = scanner.nextInt();

        System.out.println("Enter the released year of the song ");
        releasedYear = scanner.nextInt();

         
    }

    public void getSongsInformation() {
        System.out.println("Song title - " + getSongName());
        System.out.println("Song Genre - " + getSelectedGenre());
        artist.getInformationOfArtists();
        System.out.println("Duration in seconds - " + getDurationInSeconds());
        System.out.println("Duration in Minutes - " + getDurationInMinutes());
        System.out.println("Duration in Hours - " + getDurationInHours());
        System.out.println("Released Year - " + getReleasedYear());
    }

    public boolean matchesSearchTerm(String searchTerm) {
        return this.songName.contains(searchTerm) || this.artist.getArtistName(0).contains(searchTerm);
    }
}