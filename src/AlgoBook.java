import java.util.Arrays;

public class AlgoBook {



    static int [] arr = new int[] { 5, 100,23, 4, 12, 52, 0, -1, -137 };

    public static void main(String[] args) {
      System.out.println("Evklid's: \n" + algoEvklids(2, 3));
      bubbleSorting(Arrays.copyOf(arr, arr.length));
      insertionSorting(Arrays.copyOf(arr, arr.length));
      mergingAlgo(new int[] { -123, -12, 0, 23, 43, 911 }, new int[] { -13, 0, 3, 4, 5, 22, 91, 125, 146, 155 });
    }
    //Evklids algo O(log(min(a,b)))
    public static int algoEvklids(int a, int b) {
      if(b == 0) return a;
      int r = a % b;
      return algoEvklids(b, r);
    }
    //Bubble sorting O(n^2)
    public static void bubbleSorting(int [] arrtoSort) {
        for(int i = arrtoSort.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrtoSort[j] > arrtoSort[j + 1]) {
                    int temp = arrtoSort[j];
                    arrtoSort[j] = arrtoSort[j + 1];
                    arrtoSort[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubbles normal: \n" + Arrays.toString(arrtoSort));
        arrtoSort = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = arr.length - 1; j > i; j--) {
                if (arrtoSort[j] < arrtoSort[j - 1]) {
                    int temp = arrtoSort[j];
                    arrtoSort[j] = arrtoSort[j - 1];
                    arrtoSort[j - 1] = temp;
                }
            }
        }
        System.out.println("Bubbles inverted: \n" + Arrays.toString(arrtoSort));
    }
    //Insertion algo O(n^2 / 2) ~ O(n^2)
    public static void insertionSorting(int [] arrToSort) {
        //with while loop
        for (int i = 1; i < arrToSort.length; i++) {
            int newNum = arrToSort[i];
            int currIndex = i - 1;
            while (currIndex >= 0 && newNum < arrToSort[currIndex]) {
                arrToSort[currIndex + 1] = arrToSort[currIndex];
                currIndex--;
            }
            arrToSort[currIndex + 1] = newNum;
        }
        System.out.println("Insertion sorting with while loop: \n" + Arrays.toString(arrToSort));
        arrToSort = Arrays.copyOf(arr, arr.length);
        //with for loop
        for (int i = 1; i < arrToSort.length; i++) {
           for(int j = i; j > 0 && arrToSort[j-1] > arrToSort[j]; j--) {
               int newNum = arrToSort[j];
               arrToSort[j] = arrToSort[j-1];
               arrToSort[j-1] = newNum;
           }
        }
        System.out.println("Insertion sorting with only for loop: \n" + Arrays.toString(arrToSort));
    }

    //Merge sorting O(N)
    static void mergingAlgo(int [] arrToMerge1, int [] arrToMerge2) {
        int [] result = new int[arrToMerge1.length + arrToMerge2.length];
        int pointerA = 0;
        int pointerB = 0;
        while(pointerA + pointerB != result.length) {
            int sumPointer = pointerA + pointerB;
            if (pointerA == arrToMerge1.length) {
                System.arraycopy(arrToMerge2, pointerB, result, sumPointer, result.length - sumPointer);
                break;
            }
            if (pointerB ==  arrToMerge2.length) {
                System.arraycopy(arrToMerge1, pointerA, result, sumPointer, result.length - sumPointer);
                break;
            }
            if(arrToMerge1[pointerA] >= arrToMerge2[pointerB]) {
                result[sumPointer] = arrToMerge2[pointerB++];
            } else {
                result[pointerA + pointerB] = arrToMerge1[pointerA++];
            }
        }
        System.out.println("Merge sorting: \n" + Arrays.toString(result));

    }

}
