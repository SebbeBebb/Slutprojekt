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
        System.out.println("[3] Hitta Plats");
        System.out.println("[5] Räkna ut vinst");
        System.out.println("[6] Avboka plats");
        System.out.println("[7] Avsluta programmet");
        byte val = key.nextByte();

        switch (val) {
            case 1 -> {
                bokapassagerare();
            }
            case 2 -> {
                ledigaplatser();
            }
            case 3 -> {
                hitta_plats();
            }
            case 4 -> {
                pens_ung();
            }
            case 5 -> {
                double vinst = beräkna_vinst(bussplats_fält);
                System.out.println(vinst);
            }
            case 6 -> {
                avbokaplats();
            }
            case 7 -> {
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
        key.nextLine();
        System.out.print("Är fönsterplats nödvändigt?[Ja/Nej] ");
        String fönster = key.nextLine();
        if (fönster.equalsIgnoreCase("Ja")) {
            System.out.print("Skriv in personnummer för resenär: ");
            int persnr = key.nextInt();
            if (persnr > 19000101 && persnr < 20231231) {
                for (int i = 1; i < bussplats_fält.length; i++) {
                    if (i % 4 == 0 && i != 20 || i - 1 % 4 == 0) {
                        if (bussplats_fält[i] == 0) {
                            System.out.println("Du har fönsterplats " + i);
                            bussplats_fält[i] = persnr;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Inte ett riktigt persnonnummer");
            }
        } else if (fönster.equalsIgnoreCase("Nej")) {
            System.out.print("Skriv in personnummer för resenär: ");
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
        } else {
            System.out.println("Ogiltigt val");
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

    static void hitta_plats() {
        System.out.print("Ange personnummer på bokningen som du vill hitta: ");
        int hitta_pers = key.nextInt();
        for (int i = 1; i < bussplats_fält.length; i++) {
            if (bussplats_fält[i] == hitta_pers) {
                System.out.println("Personen har platsen: " + i);
            }
        }
    }

    static void pens_ung() {
        for (int i = 1; i < bussplats_fält.length; i++) {
            if (bussplats_fält[i] / 10000 > 2005 || bussplats_fält[i] / 10000 < 1954 && bussplats_fält[i] > 0) {
                System.out.println("Dessa personer är ungdomar eller pensionärer: " + bussplats_fält[i]);
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
