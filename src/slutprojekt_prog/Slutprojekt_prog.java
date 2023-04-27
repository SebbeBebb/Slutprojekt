package slutprojekt_prog;

import java.util.Scanner;

public class Slutprojekt_prog {

    public static Scanner key = new Scanner(System.in);
    public static int[] bussplats_fält = new int[22];
    public static boolean cont = true;
    public static double v;

    public static void main(String[] args) {
        while (cont == true) {
            meny();
        }
    }

    static void meny() {
        System.out.println("Vad vill du göra idag?");
        System.out.println("[1] Boka passagerare");
        System.out.println("[2] Lediga platser");
        System.out.println("[3] Räkna ut vinst");
        System.out.println("[4] Avboka plats");
        System.out.println("[5] Avsluta programmet");
        byte val = key.nextByte();

        switch (val) {
            case 1 -> {

                bokapassagerare();

            }
            case 2 -> {

                ledigaplatser();

            }
            case 3 -> {

                double vinst = beräkna_vinst(bussplats_fält);
                System.out.println(vinst);
            }
            case 4 -> {

                avbokaplats();
            }
            case 5 -> {
                System.out.println("hejdå");
                cont = false;
                break;
            }
            default -> {
                System.out.println("Ogiltigt val");
            }
        }
    }

    static void bokapassagerare() {
        System.out.println("Skriv in personnummer för resenär");
        int persnr = key.nextInt();
        if (persnr > 19000101 && persnr < 20231231) {
            for (int i = 1; i < bussplats_fält.length; i++) {
                if (bussplats_fält[i] == 0) {
                    System.out.println("Du har plats " + i);
                    bussplats_fält[i] = persnr;
                    break;
                }
            }
        } else {
            System.out.println("Inte ett riktigt persnonnummer");
        }
    }

    static void ledigaplatser() {
        for (int i = 1; i < bussplats_fält.length; i++) {
            if (bussplats_fält[i] == 0) {
                System.out.println("Plats " + i + " är ledig");
            } else {
                System.out.println("Plats " + i + " är upptagen");
            }
        }
    }

    static double beräkna_vinst(int bussplats_fält[]) {
        for (int i = 1; i < bussplats_fält.length; i++) {
            if (bussplats_fält[i] / 10000 < 1954 && bussplats_fält[i] > 0) {
                System.out.println(bussplats_fält[i]);
                v = v + 199.90;
            } else if (bussplats_fält[i] / 10000 > 2005) {
                System.out.println(bussplats_fält[i]);
                v = v + 149.90;
            } else if (bussplats_fält[i] / 10000 < 2005 && bussplats_fält[i] / 10000 > 1954) {
                System.out.println(bussplats_fält[i]);
                v = v + 299.90;
            }
        }
        return v;
    }

    static void avbokaplats() {
        System.out.print("Ange personnummer som du vill avboka: ");
        int persnr = key.nextInt();
        for (int i = 1; i < bussplats_fält.length; i++) {
            if (bussplats_fält[i] == persnr) {
                bussplats_fält[i] = 0;
                System.out.println("Din plats har avbokats");
            }
        }
    }
}
