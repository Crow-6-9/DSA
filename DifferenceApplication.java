import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ArrayDifference {
    private int[] array;

    public void setArray(int[] a) {
        array = a;
    }

    public int[] getPair(int difference) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = array[i] - difference;

            if (map.containsKey(complement)) {
                int[] pair = {array[i], complement};
                return pair;
            }

            map.put(array[i], i);
        }

        return null;
    }
}

class DifferenceApplication {
    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 50, 80};
        int n = 78;

        ArrayDifference diff = new ArrayDifference();
        diff.setArray(arr);

        int[] pair = diff.getPair(n);
        if (pair != null) {
            System.out.println("Pair found: {" + pair[0] + ", " + pair[1] + "}");
        } else {
            System.out.println("No pair found with the given difference.");
        }
    }
}
