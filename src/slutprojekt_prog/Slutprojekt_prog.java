package slutprojekt_prog;

import java.util.Scanner;

public class Slutprojekt_prog {

    public static Scanner key = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Vad vill du göra idag?");
        System.out.println("[1] Boka passagerare");
        System.out.println("[2] Lediga platser");
        System.out.println("[3] Räkna ut vinst");
        System.out.println("[4] Avsluta programmet");

        byte val = key.nextByte();
        switch (val) {
            case 1 -> {
                bokapassagerare();
            }
            case 2 -> {
                ledigaplatser();
            }
            case 3 -> {
                vinst();
            }
            case 4 -> {
                
                break;
            }
            default -> {
                System.out.println("Ogiltigt val");
            }
        }
    }
    static void bokapassagerare(){
    
    }
    static void ledigaplatser(){
        
    }
    static void vinst(){
        
    }
}
