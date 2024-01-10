package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      insertionSort(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex + 1; i < toIndex; i++) {
            T currentValue = array[i];
            int j = i - 1;
            
            // Move to the left as long as currentValue is bigger
            while (j >= fromIndex && array[j].compareTo(currentValue) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            // Set currentValue to the right spot
            array[j + 1] = currentValue;
        }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      //Goes through table station from choosen index
      for (int i = fromIndex + 1; i < toIndex; i++) {
         //Store current element
         T current = array[i];
         int j = i - 1;
         //Moves elements to right until finds right spot to current element
         while (j >= fromIndex && comparator.compare(array[j], current) > 0) {
            array[j + 1] = array[j];
            j--;
         }
         //Place current element to right spot
         array[j + 1] = current;
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      reverse(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
         T temp = array[i];
         array[i] = array[j];
         array[j] = temp;
     }
   }

   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   // Recursive method

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      if (fromIndex < toIndex) {
         int middle = fromIndex + (toIndex - fromIndex) / 2;
         int comparison = aValue.compareTo(fromArray[middle]);
         
         if (comparison == 0) {
             return middle; //founded
         } else if (comparison < 0) {
             return binarySearch(aValue, fromArray, fromIndex, middle); //continues with left side
         } else {
             return binarySearch(aValue, fromArray, middle + 1, toIndex); //continues with right side
         }
     }
     return -1; //not found
   }

   /* 

   // Iterative method

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      while (fromIndex < toIndex) {
         int middle = fromIndex + (toIndex - fromIndex) / 2;
         int comparison = aValue.compareTo(fromArray[middle]);

         if (comparison == 0) {
            return middle; //founded
         } else if (comparison < 0){
            toIndex = middle; //continues with left side
         } else {
            fromIndex = middle + 1; //continues with right side
         }
      }
      return -1; //not found
   }
   */

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      while (fromIndex != toIndex) {
         int middle = fromIndex + (toIndex - fromIndex) / 2;
         int comparison = comparator.compare(aValue, fromArray[middle]);

         if (comparison == 0) {
            return middle; //founded
         } else if (comparison < 0) {
            toIndex = middle; //continues with left side
         } else {
            fromIndex = middle + 1; //continues with right side
         }
      }
      return -1; //not found
   }

   ///////////////////////////////////////////
   // QuickSort - Algorithm
   ///////////////////////////////////////////

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      fastSort(array, 0, array.length - 1);
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length - 1, comparator);
   }

   public static <E extends Comparable<E>> void fastSort(E[] array, int low, int high) {
      if (low < high) {
            int pivotIndex = partition(array, low, high);
            fastSort(array, low, pivotIndex - 1);
            fastSort(array, pivotIndex + 1, high);
      }
   }

   public static <E> void fastSort(E[] array, int low, int high, Comparator<E> comparator) {
      if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            fastSort(array, low, pivotIndex - 1, comparator);
            fastSort(array, pivotIndex + 1, high, comparator);
      }
   }

   private static <E extends Comparable<E>> int partition(E[] array, int low, int high) {
      E pivot = array[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
               i++;
               swap(array, i, j);
            }
      }

      swap(array, i + 1, high);
      return i + 1;
   }

   private static <E> int partition(E[] array, int low,int high, Comparator<E> comparator) {
      E pivot = array[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
               i++;
               swap(array, i, j);
            }
      }

      swap(array, i + 1, high);
      return i + 1;
   }

   ///////////////////////////////////////////
   // Swap
   ///////////////////////////////////////////  

   private static <E> void swap(E[] array, int i, int j) {
      E temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }
}
