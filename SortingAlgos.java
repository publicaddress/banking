import java.io.*;
import java.util.*;

public class SortingAlgos<T extends Comparable <T>> {
    private T pivotValue;
    private T temp;
  
    

    public void quickSort(ArrayList<T> sortKey, int start, int end) {
        if (start < end) {
            //Partition the array and get the pivot point
            int p = partition(sortKey, start, end);

            //Sort the portion before the pivot point
            quickSort(sortKey, start, p - 1);

            //Sort the portion after the pivot point
            quickSort(sortKey, p + 1, end);
        }
    }

    public int partition(ArrayList<T> sortKey, int start, int end) {
        pivotValue = sortKey.get(start);
        int pivotPosition = start;
        //Rearrange the rest of the array elements to partition the subrange from start to end
        for (int pos = start + 1; pos <= end; pos++) {
            if(sortKey.get(pos).compareTo(pivotValue) < 0) {
            //sortKey.get(pos) is the "current" item
            //swap the current item with the item to the right of the picot element
            swap(sortKey, pivotPosition + 1, pos);
            //swap the current item with the pivot element
            swap(sortKey, pivotPosition, pivotPosition + 1);
            //adjust the pivot position so it stays with the pivot element
            pivotPosition++;
            }
        }
        return pivotPosition;
    }

    public void swap(ArrayList<T> sortKey, int pos1, int pos2) {
        temp = sortKey.get(pos1);
        sortKey.set(pos1, sortKey.get(pos2));
        sortKey.set(pos2, temp);
    }

       
    /* Method bubbleSort() generic
     * Input:
     * ArrayList<T> a - array to be sorted
     * Process:
     * bubble sort - alternate algorithm
     * Output:
     * ArrayList<T> a sorted into ascending order
     */
    
    public void bubbleSort(ArrayList<T> a) {
        
        for(int lastPos = a.size() - 1; lastPos >= 0; lastPos--) {
            for(int pos = 0; pos < lastPos; pos++) {
                if(a.get(pos).compareTo(a.get(pos + 1)) > 0) {
                    temp = a.get(pos);
                    a.set(pos, a.get(pos + 1));
                    a.set(pos + 1, temp);
                }
            }
        }
    }

/*

*/
    public void insertionSort (ArrayList<T> a) {
        int cand;
          for(int pos = 1; pos < a.size(); pos++) {
              temp = a.get(pos);
              cand = pos;
              while (cand > 0 && a.get(cand -1).compareTo(temp) > 0) {
                  a.set(cand, a.get(cand - 1));
                  cand--;
              }
              a.set(cand, temp);
          }
    }
    
}
