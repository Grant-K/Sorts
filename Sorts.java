import java.util.*;
public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList <Integer> list){
        //Sort Code Start
        int n = list.size();
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) 
            {
                if (list.get(j) > list.get(j + 1)) 
                {
                    steps += 3;
                    // swap arr[j] and arr[j+1]
                    temp = list.get(j);
                    steps += 1;
                    list.set(j, list.get(j + 1));
                    steps += 2;
                    list.set(j + 1, temp);
                    steps += 1;
                    swapped = true;
                }
            }

            // IF no two elements were 
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        //Sort Code End
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Integer> list){
        //Sort Code Start
        for (int i = 0; i < list.size(); i++) {
            // find position of smallest num between (i + 1)th element and last element
            int pos = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(pos))
                    pos = j;
                steps += 3;
            }
            // Swap min (smallest num) to current position on array
            int min = list.get(pos);
            steps += 1;
            list.set(pos, list.get(i));
            steps += 2;
            list.set(i, min);
            steps += 1;
        }
        //Sort Code End
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Integer> list){
        //Sort Code Start
        for(int i=1; i < list.size(); i++){

            int key = list.get(i);
            steps += 1;
            for(int j = i-1; j >= 0; j--){
                if(key < list.get(j)){
                    steps += 2;
                    // Shifting Each Element to its right as key is less than the existing element at current index
                    list.set(j+1,list.get(j));
                    steps += 2;
                    // Special case scenario when all elements are less than key, so placing key value at 0th Position
                    if(j==0){
                        list.set(0, key);
                        steps += 1;
                    }
                }else{
                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                    list.set(j+1,key);
                    steps += 1;
                    break; // You need to break the loop to save un necessary iteration
                }
            }
        }
        //Sort Code End
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
    }

    public void mergeSort(ArrayList <Integer> list, int low, int high) {
        //Sort Code Start
        // check if low is smaller than high, if not then the array is sorted
        if( low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            //System.out.print ("low " + low + "middle " + middle + " high " + high);
            // Sort the left side of the array
            mergeSort(list, low, middle);
            // Sort the right side of the array
            mergeSort(list, middle + 1, high);
            // Combine them both
            merge(list, low, middle, high);
        }
        //Sort Code End
    }

    private void merge(ArrayList <Integer> list, int low, int middle, int high) {
        ArrayList <Integer> helper = new ArrayList <Integer> ();
        int i = low;
        int j = middle + 1;
        // Copy the smallest values from either the left or the right side
        // to the helper
        while (i <= middle || j <= high) {
            if (i > middle) {
                helper.add(list.get(j));
                j++;
                steps += 1;
            }
            else if (j > high){
                helper.add(list.get(i));
                i++;
                steps += 1;
            }
            else if (list.get(i) <= list.get(j)) {
                helper.add(list.get(i));
                i++;
                steps += 4;
            } else {
                helper.add(list.get(j));
                j++;
                steps += 4;
            }
        }
        int m = low;
        // Copy the merged part back into the original list from low to high index
        for(int l = 0; l < helper.size(); l++) {
            list.set(m, helper.get(l));
            m++;
            steps += 1;
        }
    }

    public int sequentialSearch(ArrayList <Integer> list, int findMe)
    {
        int thisIt = list.get(0);
        int thisIndex = 0;
        steps += 1;
        for(thisIndex = 0; (thisIndex < list.size()) && (thisIt != findMe); thisIndex++)
        {
            thisIt = list.get(thisIndex);
            steps += 1;
        }
        steps += 1;
        if(thisIt != findMe)
        {
            return -1;
        }
        else
            return thisIndex;
    }

    public int binarySearch(ArrayList <Integer> list, int findMe, int min, int max)
    {
        if(max < min)
            return -1;
        else
        {
            int mid = (max + min)/2;
            steps += 1;
            if(list.get(mid) > findMe)
                return binarySearch(list, findMe, min, mid - 1);
            else if(list.get(mid) < findMe)
            {
                steps += 1;
                return binarySearch(list, findMe, mid + 1, max);
            }
            else
                return mid;
        }
    }

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}