package assignment2;

public class FooCorporation {
    public static void totalPay(double basePay, double hoursWorked) {
        double res = 0;

        if (basePay < 8) {
            System.out.println("Hourly employees should be paid at least $8.00 an hour");
        } else if (hoursWorked > 60) {
            System.out.println("An employee not work more than 60 hours in a week. ");
        } else {
            if (hoursWorked <= 40) {
                res += basePay * hoursWorked;
            } else if (hoursWorked <=60) {
                res += basePay * 40 + 1.5 * basePay * (hoursWorked - 40);
            }

            System.out.println("total pay is $" + res);
        }
    }

    public static void main(String[] args) {
        totalPay(7.50, 35);
        totalPay(8.20, 47);
        totalPay(10.00, 73);
    }
}
