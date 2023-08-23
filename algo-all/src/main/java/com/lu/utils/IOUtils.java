package com.lu.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sheldon
 * @date 2023-08-23
 */
public class IOUtils {

    @Test
    public void test() {
        System.out.println(IOUtils.class.getName());
    }

    public static int[] inputInt() {
        File file = new File("./src/main/java/com/lu/utils/input.txt");
        StringBuilder res = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                res.append(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] split = res.toString().split(",");
        return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    }

    public static String[] inputString() {
        File file = new File("./src/main/java/com/lu/utils/input.txt");
        StringBuilder res = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                res.append(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res.toString().split(",");
    }

    public static long[] inputLong() {
        File file = new File("./src/main/java/com/lu/utils/input.txt");
        StringBuilder res = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                res.append(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] split = res.toString().split(",");
        return Arrays.stream(split).mapToLong(Long::parseLong).toArray();
    }

}
