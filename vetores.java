import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class TesteVetores {

    static void geraVetor(int[] v) {
        Random random = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(10 * v.length);
        }
    }

    static void exibeVetor(String msg, int[] v) {
        System.out.println("\n" + msg);
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    static void bubbleSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v.length - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
    }

    static void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int temp = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > temp) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = temp;
        }
    }

    static void selectionSort(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = v[i];
            v[i] = v[minIndex];
            v[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;
    int[] v;
    do {
        System.out.print("\ndigite o tamanho do vetor: ");
        n = scanner.nextInt();
        if (n > 0) {
            v = new int[n];
            geraVetor(v);
            long inicio = new Date().getTime();
            bubbleSort(v);
            long fim = new Date().getTime();
            System.out.println("\ntempo do bubble: " + (fim - inicio) + " milissegundos");
            
            inicio = new Date().getTime();
            insertionSort(v);
            fim = new Date().getTime();
            System.out.println("\ntempo do insertion: " + (fim - inicio) + " milissegundos");
            
            inicio = new Date().getTime();
            selectionSort(v);
            fim = new Date().getTime();
            System.out.println("\ntempo do selection: " + (fim - inicio) + " milissegundos");
        }
    } while (n > 0);
    scanner.close();
}