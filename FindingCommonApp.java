import java.util.ArrayList;
import java.util.List;

class FindCommon {
    private int[] arr1;
    private int[] arr2;
    private int[] arr3;

    public void setArray(int[] a1, int[] a2, int[] a3) {
        arr1 = a1;
        arr2 = a2;
        arr3 = a3;
    }

    public int[] getCommonElements() {
        List<Integer> commonElements = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                commonElements.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        int[] result = new int[commonElements.size()];
        for (int m = 0; m < commonElements.size(); m++) {
            result[m] = commonElements.get(m);
        }

        return result;
    }
}

class FindingCommonApp {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        FindCommon commonFinder = new FindCommon();
        commonFinder.setArray(arr1, arr2, arr3);

        int[] commonElements = commonFinder.getCommonElements();

        System.out.print("Output: ");
        for (int element : commonElements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
