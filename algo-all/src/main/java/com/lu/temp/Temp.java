package com.lu.temp;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-05-09
 */
public class Temp {

    @Test
    public void test1() {
        String a = "ktp.blurry|photoFileId=cb60450ecf7bc1121dd60028b18a7bc1.jpeg, blurry=18.17421146262003, threshold=50";
        String[] split = a.split("photoFileId=");
        String[] split1 = split[1].split(",");
        System.out.println(Arrays.toString(split));
        System.out.println(Arrays.toString(split1));
    }

    @Test
    public void test() throws IOException {
        //ktp.blurry|photoFileId=cb60450ecf7bc1121dd60028b18a7bc1.jpeg, blurry=18.17421146262003, threshold=50
        File file = new File("C:\\Users\\Administrator\\Desktop\\blurry.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = null;
        System.out.print("[");
        while ((s = reader.readLine()) != null) {
            System.out.println(",");
            System.out.print("\"");
            String[] split = s.split("photoFileId=");
            String s1 = split[1];
            String[] split1 = s1.split(",");
            String s3 = split1[0];
            System.out.print(s3);
            System.out.print("####");
            String s2 = split1[1];
            System.out.print(s2.split("=")[1] + "." + s3.split("\\.")[1]);
            System.out.print("\"");
        }
        System.out.print("]");
    }

}
