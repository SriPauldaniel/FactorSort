import java.util.Scanner;

public class FactorSort {
    public static int countFactors(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    public static void factorSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                int factors1 = countFactors(arr[minIndex]);
                int factors2 = countFactors(arr[j]);
                if (factors1 > factors2 || (factors1 == factors2 && arr[minIndex] > arr[j])) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        factorSort(arr);
        printArray(arr);
        sc.close();
    }
}