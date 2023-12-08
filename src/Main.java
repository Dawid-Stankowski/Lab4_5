import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Tworzenie tablicy dwuwymiarowej dla 100 elementów
        int liczbaWierszy = 10;
        int liczbaKolumn = 10;
        int[][] tablica = new int[liczbaWierszy][liczbaKolumn];

        // Wypełnianie tablicy liczbami losowymi z zakresu od 20 do 45
        wypelnijTablice(tablica, 20, 45);

        // Wyświetlanie nieposortowanej tablicy
        System.out.println("Tablica przed sortowaniem:");
        wyswietlTablice(tablica);

        // Sortowanie tablicy
        sortujTablice(tablica);

        // Wyświetlanie posortowanej tablicy
        System.out.println("\nTablica po sortowaniu:");
        wyswietlTablice(tablica);

        // Tworzenie histogramu
        int[] histogram = tworzHistogram(tablica);

        // Wyświetlanie histogramu
        System.out.println("\nHistogram:");
        wyswietlHistogram(histogram);
    }

    // Metoda do wypełniania tablicy liczbami losowymi z zakresu
    private static void wypelnijTablice(int[][] tablica, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
    }

    // Metoda do wyświetlania tablicy
    private static void wyswietlTablice(int[][] tablica) {
        for (int[] wiersz : tablica) {
            for (int wartosc : wiersz) {
                System.out.print(wartosc + "\t");
            }
            System.out.println();
        }
    }

    // Metoda do sortowania tablicy
    private static void sortujTablice(int[][] tablica) {
        for (int[] wiersz : tablica) {
            Arrays.sort(wiersz);
        }
    }

    // Metoda do tworzenia histogramu
    private static int[] tworzHistogram(int[][] tablica) {
        int[] histogram = new int[45 - 20 + 1];

        for (int[] wiersz : tablica) {
            for (int wartosc : wiersz) {
                histogram[wartosc - 20]++;
            }
        }

        return histogram;
    }

    // Metoda do wyświetlania histogramu
    private static void wyswietlHistogram(int[] histogram) {
        for (int i = 20; i <= 45; i++) {
            System.out.println(i + ": " + histogram[i - 20]);
        }
    }
}
