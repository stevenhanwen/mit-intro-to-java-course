package assignment_3;

public class main {
    public static void main(String[] args) throws Exception {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Emma", "John", "James", "Jane", "Emily",
                "Daniel", "Aaron", "Kate", "Matt", "Alex", "Neda", };

        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265 };

        System.out.println("The fastest person is: " + names[getFastestPerson(times)] +
                ", with a time of: " + times[getFastestPerson(times)]);

        System.out.println("The second fastest person is: " + names[getSecondFastestPerson(times)] +
                ", with a time of: " + times[getSecondFastestPerson(times)]);

    }

    public static int getSecondFastestPerson(int[] times) {
        int secondFastestPerson = 0;
        int secondFastestTime = times[0];
        int fastestPerson = getFastestPerson(times);

        for (int i = 0; i < times.length; i++) {
            // move on if it is the fastest person
            if (i == fastestPerson) {
                continue;
            }
            if (times[i] < secondFastestTime) {
                secondFastestTime = times[i];
                secondFastestPerson = i;
            }
        }

        return secondFastestPerson;

    }

    public static int getFastestPerson(int[] times) {
        int fastestTime = times[0];
        int fastestPerson = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] < fastestTime) {
                fastestTime = times[i];
                fastestPerson = i;
            }
        }

        return fastestPerson;
    }

}