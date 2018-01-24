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
            System.out.println();
            System.out.println("Bubble Sort Start");
            System.out.println();
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
                        // swap arr[j] and arr[j+1]
                        temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
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
            System.out.println("Bubble Sort End");
            System.out.println();
    }

/**
 *  Description of the Method
 *
 * @param  list  reference to an array of integers to be sorted
 */
public void selectionSort(ArrayList <Integer> list){
//replace these lines with your code
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
//replace these lines with your code
System.out.println();
System.out.println("Insertion Sort");
System.out.println();
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