import java.util.Random;

public class ComparacionQuickSort {

    public static void main(String[] args) {
        // 1. Definimos los tamaños que queremos comparar
        int[] tamaños = {1000, 5000, 10000};
        
        System.out.println("=== TABLA DE RESULTADOS PARA EXCEL ===");
        System.out.printf("%-10s | %-15s | %-15s%n", "Tamaño (n)", "Original (ns)", "Media (ns)");
        System.out.println("---------------------------------------------------------");

        // 2. El ciclo recorre cada tamaño automáticamente
        for (int n : tamaños) {
            int[] original = generarArreglo(n);
            int[] media = original.clone();

            // Medir QuickSort Original (Pivote al final)
            long t1 = System.nanoTime();
            quickSortOriginal(original, 0, original.length - 1);
            long t2 = System.nanoTime();

            // Medir QuickSort Media (Pivote central)
            long t3 = System.nanoTime();
            quickSortMedia(media, 0, media.length - 1);
            long t4 = System.nanoTime();

            // Imprime los resultados de cada tamaño en una fila
            System.out.printf("%-10d | %-15d | %-15d%n", n, (t2 - t1), (t4 - t3));
        }
    }

    // --- MÉTODOS DE ORDENAMIENTO ---
    public static void quickSortOriginal(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortOriginal(arr, low, pi - 1);
            quickSortOriginal(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void quickSortMedia(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivote = arr[low + (high - low) / 2]; 
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivote) i++;
            while (arr[j] > pivote) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }
        if (low < j) quickSortMedia(arr, low, j);
        if (high > i) quickSortMedia(arr, i, high);
    }

    private static int[] generarArreglo(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(100000);
        return a;
    }
}