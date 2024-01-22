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

public class Album {
    private String albumName;
    private Publisher publisher = new Publisher();

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Album Name - ");
        this.albumName = scanner.nextLine();
        if (albumName.isEmpty()) {
            System.out.println("Invalid album name. Please enter a non-empty name.");
            return;
        }
        publisher.setPublisherInformation();
    }

    public void getAlbumInformation() {
        System.out.println("Album Name - " + getAlbumName());
        publisher.getPublisherInformation();
    }
}

