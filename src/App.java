import java.util.Arrays;
import java.util.Random;

public class App{
    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        int n = arr.length; 
        boolean swapped;
        for(int i = 0;  i < n; i ++){
            swapped = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static <T extends Comparable<T>> T[] mergeSort(T[] arr){
        if(arr.length <= 1){
            return arr;
        }

        int mid = arr.length / 2;
        T[] left = Arrays.copyOfRange(arr, 0, mid);
        T[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        return merge(arr, left, right);
    }

    private static <T extends Comparable<T>> T[] merge(T[] arr, T[] left, T[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) <= 0){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i < left.length){
            arr[k++] = left[i++];
        }
        while(j < right.length){
            arr[k++] = right[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int x = rand.nextInt(1000) + 1; // Generate a random positive integer
        Integer[] arr = new Integer[x];

        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(100);
        }

        mergeSort(arr);
        System.out.println("Merge sort: " + Arrays.toString(arr));
        
        bubbleSort(arr);
        System.out.println("Bubble sort: " + Arrays.toString(arr));
    }
}