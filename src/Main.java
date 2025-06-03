import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        int[] arr = {-5, 0, 1, 1, 2, 3, 6, 8, 22, 45, 678};
        int[] arr2 = {-10, 2, 3, 6, 7, 7, 7, 9, 11, 1000, 1010, 1100};


        int[] arr3 = twoArrs(arr, arr2);
        System.out.println(Arrays.toString(arr3));

        
    }
    public static int[] twoArrs(int[] one, int[] two) {
        int[] three = new int[one.length + two.length];
        int j = 0;
        int k = 0;

        for (int i = 0; i < three.length; i++) {
            if (j < one.length && (one[j] <= two[k])) {
                three[i] = one[j++];
            } else if (k < two.length) {
                three[i] = two[k++];
            }
        }
        return three;
    }



}