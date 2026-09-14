package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Pazar Arabası Uygulaması ---");
            System.out.println("0: Uygulamayı Durdur");
            System.out.println("1: Eleman Ekle");
            System.out.println("2: Eleman Çıkar");
            System.out.print("Seçiminiz: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "0":
                    running = false;
                    System.out.println("Uygulama durduruldu.");
                    break;
                case "1":
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırabilirsiniz): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case "2":
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırabilirsiniz): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen 0, 1 veya 2 giriniz.");
                    break;
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Mevcut Pazar Arabası Listesi: " + groceryList);
    }
}