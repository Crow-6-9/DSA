class FindFloorCeil {
    private int[] arr;

    public void setValue(int[] array) {
        arr = array;
    }

    public int[] getFloorCeil(int x) {
        int[] result = new int[2];
        result[0] = -1; // floor
        result[1] = -1; // ceil

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result[0] = arr[mid];
                result[1] = arr[mid];
                return result;
            } else if (arr[mid] < x) {
                result[0] = arr[mid];
                low = mid + 1;
            } else {
                result[1] = arr[mid];
                high = mid - 1;
            }
        }

        return result;
    }
}

class CeilAndFloorApplication {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 0;

        FindFloorCeil finder = new FindFloorCeil();
        finder.setValue(arr);

        int[] floorCeil = finder.getFloorCeil(x);

        System.out.println("For x = " + x + ":");
        if (floorCeil[0] != -1) {
            System.out.println("Floor = " + floorCeil[0]);
        } else {
            System.out.println("Floor does not exist in the array.");
        }
        if (floorCeil[1] != -1) {
            System.out.println("Ceil = " + floorCeil[1]);
        } else {
            System.out.println("Ceil does not exist in the array.");
        }
    }
}
