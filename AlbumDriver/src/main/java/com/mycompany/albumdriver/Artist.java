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
import java.time.LocalDateTime;

public class Artist {

    Iterable<Artist> getArtists() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getBirthYear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    enum ArtistType {
        WRITER, SINGER, COMPOSER
    }

    private String[] artistNames = new String[3];
    private int[] yearsOfBirth = new int[3];
    private ArtistType[] artistTypes = new ArtistType[3];

    public void setYearOfBirth(int artistIndex, int yearOfBirth) {
        if (yearOfBirth > 0 && yearOfBirth <= LocalDateTime.now().getYear()) {
            this.yearsOfBirth[artistIndex] = yearOfBirth;
        } else {
            System.out.println("Invalid year of birth");
        }
    }

    public void setArtistType(int artistIndex, ArtistType artistType) {
        this.artistTypes[artistIndex] = artistType;
    }

    public String getArtistName(int artistIndex) {
        return artistNames[artistIndex];
    }

    public int getYearOfBirth(int artistIndex) {
        return yearsOfBirth[artistIndex];
    }

    public ArtistType getArtistType(int artistIndex) {
        return artistTypes[artistIndex];
    }

    public int getArtistAge(int artistIndex) {
        int thisYear = LocalDateTime.now().getYear();
        return thisYear - yearsOfBirth[artistIndex];
    }

    public void setArtistInformation() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter information for Artist " + (i + 1));
            setArtistDetails(i);
        }
    }

    private void setArtistDetails(int artistIndex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of Artist " + (artistIndex + 1) + ": ");
        artistNames[artistIndex] = scanner.nextLine();
        System.out.println("Enter the birth year of Artist " + (artistIndex + 1) + ": ");
        setYearOfBirth(artistIndex, scanner.nextInt());
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the type of Artist " + (artistIndex + 1) + " (WRITER, SINGER, COMPOSER): ");
        String typeInput = scanner.next();
        setArtistType(artistIndex, ArtistType.valueOf(typeInput.toUpperCase()));
    }

    public void getInformationOfArtists() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Details for Artist " + (i + 1));
            System.out.println("Artist type - " + getArtistType(i) +
                    "\nArtist Name - " + getArtistName(i) +
                    "\nArtist age - " + getArtistAge(i) + "\n");
        }
    }
}


