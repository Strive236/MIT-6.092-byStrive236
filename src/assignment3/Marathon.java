package assignment3;

class Marathon {
    public static int findBestRunnerIndex(int[] values) {
        int minIndex = -1;

        for (int i = 0; i < values.length; i++) {
            if (minIndex == -1 || values[i] < values[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static int findSecondBestRunnerIndex(int[] values) {
        int secondIndex = -1;
        int minIndex = findBestRunnerIndex(values);

        for (int i = 0; i < values.length; i++) {
            if (i == minIndex) continue;
            if ((secondIndex == -1) || values[i] < values[secondIndex]) secondIndex = i;
        }

        return secondIndex;
    }

    public static void main (String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };

        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }

        System.out.println("bestRunnerIndex: " + findBestRunnerIndex(times));
        System.out.println("secondBestRunnerIndex: " + findSecondBestRunnerIndex(times));
    }
}
