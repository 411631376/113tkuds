public class IsSorted {

    public static boolean isSorted(int[] arr, int index) {
        if (index == 0 || index == 1) {
            return true;
        }
        if (arr[index - 1] > arr[index]) {
            return false;
        }
        return isSorted(arr, index - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 9};
        int[] arr2 = {4, 3, 2};

        System.out.println(isSorted(arr1, arr1.length - 1));
        System.out.println(isSorted(arr2, arr2.length - 1));
    }
}
