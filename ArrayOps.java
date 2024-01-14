public class ArrayOps {
    public static void main(String[] args) {
        int[] input = { 2,8,3,7,8 };
        int[] input2 = { 1, 2, 4, 3, 5, 6, 2 };
        System.out.println("Second max value: " + secondMaxValue(input));
        // System.out.println("Contains the same elements: " + containsTheSameElements(input, input2));
    }

    public static int findMissingInt(int[] array) {
        int max = 0;
        boolean found = false;

        if (array.length == 1) { // if array's length is 1, return the next number
            return array[0] + 1;
        }

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            found = false;
            for (int j = 0; j < array.length; j++) {
                if (max - array[j] == array[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return max - array[i];
            }
        }

        
        return -1;
    }

    public static int secondMaxValue(int[] array) {
        int max = 0;
        int secondMax = 0;
        boolean unique = false;
        int[] arrWithoutMax = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != max) {
                arrWithoutMax[i] = array[i];
            } else if (!unique) {
                unique = true;
                arrWithoutMax[i] = 0;
            } else {
                arrWithoutMax[i] = array[i];
            }
        }

        for (int i = 0; i < arrWithoutMax.length; i++) {
            if (secondMax < arrWithoutMax[i]) {
                secondMax = arrWithoutMax[i];
            }
        }

        return secondMax;
    }

    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        int[] maxArray, minArray;
        if (array1.length != array2.length) {
            maxArray = Math.max(array1.length, array2.length) == array1.length ? array1 : array2;
            minArray = Math.min(array1.length, array2.length) == array1.length ? array1 : array2;
        } else {
            maxArray = array1;
            minArray = array2;
        }

        for (int i = 0; i < maxArray.length; i++) {
            for (int j = 0; j < minArray.length; j++) {
                if (maxArray[i] == minArray[j]) {
                    break;
                } else if (j == minArray.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSorted(int[] array) {
        boolean decreases = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[i + 1]) {
                decreases = true;
                break;
            }
        }
        return true;
    }

}
