package assignment1;

class GravityCalculator {
    public static void main(String[] arguments) {
        /* Part One output: The object's position after 10.0 seconds is 0.0 m. */

        /* Part Two */
        // params
        double gravity = -9.81;  // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;

        // compute the position of an object after falling for 10 seconds, outputting the position in meters.
        double finalPosition = 0.5 * gravity * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
        System.out.println("The object's position after " + fallingTime +
                " seconds is " + finalPosition + " m.");
    }
} 