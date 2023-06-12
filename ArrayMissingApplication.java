import java.util.Arrays;

class FindMissing {
    private int[] array;

    public void setArray(int[] a) {
        array = a;
    }

    public void findMissing() {
        Arrays.sort(array); // Sort the array in ascending order
        int n = array.length;
        int current = array[0];
        int missingCount = 0;

        for (int i = 0; i < n; i++) {
            while (current < array[i]) {
                System.out.print(current + " ");
                current++;
                missingCount++;
            }
            current++;
        }

        // Print any remaining missing values after the last element
        while (missingCount < n - 1) {
            System.out.print(current + " ");
            current++;
            missingCount++;
        }

        System.out.println();
    }
}

class ArrayMissingApplication {
    public static void main(String[] args) {
        int[] a = {1, 5, 8, 12, 14};

        FindMissing finder = new FindMissing();
        finder.setArray(a);
        finder.findMissing();
    }
}
