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

public class Publisher {
    private String publisherName;
    private String publisherAddress;
    private int registrationYear;

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public int getRegistrationYear(){
        return registrationYear;
    }

    public void setPublisherInformation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Publisher Name ");
        this.publisherName = scanner.nextLine();
        System.out.println("Enter Publisher Address");
        this.publisherAddress = scanner.nextLine();
        System.out.println("Enter Registration Year ");
        this.registrationYear = scanner.nextInt();
        
    }

    public void getPublisherInformation(){
        System.out.println("Publisher Name - "+getPublisherName());
        System.out.println("Publisher Address - "+getPublisherAddress());
        System.out.println("Released Year - "+getRegistrationYear());
    }
}