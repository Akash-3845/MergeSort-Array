import java.util.Scanner;
class MergeSort{


    void merge(int[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void mergeSort(int[] arr, int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

}





public class MergeSortDriver {
    static void printArray(int[] arr)
    {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of an array:-");
        Scanner sc = new Scanner(System.in);
        int size  = sc.nextInt();//get the size of an array
        if (size <=1){
            System.out.println("invalid array size");//check the size if size is 0 or 1 there is no elements for sorting
        }else {
            int[] array = new int[size];
            System.out.println("Enter the elements");
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();

            }
            System.out.println("Given array");
            printArray(array);
            MergeSort object = new MergeSort();

            object.mergeSort(array, 0, array.length - 1);
            System.out.println("\nSorted array");
            printArray(array);
        }
    }
}
