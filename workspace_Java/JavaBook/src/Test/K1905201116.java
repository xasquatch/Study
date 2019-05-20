package Test;

import java.util.Random;
import java.util.Scanner;

public class K1905201116{

    private int x1, y1, x2, y2, i, j;

    public void setting() {
        Random rd = new Random();
        x1 = rd.nextInt();
        y1 = rd.nextInt();
        x2 = rd.nextInt();
        y2 = rd.nextInt();
    }

    public void insertKey(){

        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        j = sc.nextInt();
    }

    public void discriminate(){
        if (i>=x1 && i <= x2) {
            
        }
    }

    public static void main(String[] args) {
        K1905201116 k = new K1905201116();
        k.setting();
        k.insertKey();
    }
}