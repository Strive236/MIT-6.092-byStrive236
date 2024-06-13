package assignment7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MagicSquares {
    private static void readAndTransformMagicSquares(BufferedReader br, int[][] array) throws IOException {
        String line = null;
        for (int i = 0; (line = br.readLine()) != null;) {
            if (!line.isEmpty()) {
                String[] str = line.split("\t");
                for (int j = 0; j < str.length; j++) {
                    array[i][j] = Integer.valueOf(str[j]);
                }
                i++;
            }
        }
    }

    private static boolean checkMagicSquares(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[0][i];
        }

        for (int i = 0; i < array.length; i++) {
            int sum1 = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum1 += array[i][j];
            }
            if (sum != sum1) {
                return false;
            }
        }

        for (int i = 0; i < array.length; i++) {
            int sum1 = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum1 += array[j][i];
            }
            if (sum != sum1) {
                return false;
            }
        }

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < array.length; i++) {
            sum1 += array[i][i];
            sum2 += array[array.length - 1 - i][array.length - 1 - i];
        }

        if (sum1 != sum || sum2 != sum) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // generate readers
        FileReader frMercury = new FileReader("C:\\Users\\Lenovo\\Desktop\\MIT 6.092\\src\\assignment7\\Mercury.txt");
        BufferedReader brMercury = new BufferedReader(frMercury);
        FileReader frLuna = new FileReader("C:\\Users\\Lenovo\\Desktop\\MIT 6.092\\src\\assignment7\\Luna.txt");
        BufferedReader brLuna = new BufferedReader(frLuna);

        // read the files line by line
        int n = 8;
        int[][] mercuryArray = new int[n][n];
        readAndTransformMagicSquares(brMercury, mercuryArray);
        System.out.print("Mercury is ");
        if (checkMagicSquares(mercuryArray)) System.out.println("Magic Squares");
        else System.out.println("not Magic Squares");

        int m = 9;
        int[][] lunaArray = new int[m][m];
        readAndTransformMagicSquares(brLuna, lunaArray);
        checkMagicSquares(lunaArray);
        System.out.print("Luna is ");
        if (checkMagicSquares(lunaArray)) System.out.println("Magic Squares");
        else System.out.println("not Magic Squares");

        brMercury.close();
        brLuna.close();
    }
}

