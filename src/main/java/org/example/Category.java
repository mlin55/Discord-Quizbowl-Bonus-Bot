package org.example;
import java.io.*;

public class Category {
    public Difficulty d1;
    public Difficulty d2;
    public Difficulty d3;
    public Difficulty d4;
    public Difficulty d5;
    public Difficulty d6;
    public Difficulty d7;
    public Difficulty d8;
    public Difficulty d9;


    public Category(File f1, File f2, File f3, File f4, File f5, File f6, File f7, File f8, File f9) {
        d1 = new Difficulty(f1);
        d2 = new Difficulty(f2);
        d3 = new Difficulty(f3);
        d4 = new Difficulty(f4);
        d5 = new Difficulty(f5);
        d6 = new Difficulty(f6);
        d7 = new Difficulty(f7);
        d8 = new Difficulty(f8);
        d9 = new Difficulty(f9);
    }

    public Difficulty getDiff (int num) {
        if (num == 1)
            return d1;
        if (num == 2)
            return d2;
        if (num == 3)
            return d3;
        if (num == 4)
            return d4;
        if (num == 5)
            return d5;
        if (num == 6)
            return d6;
        if (num == 7)
            return d7;
        if (num == 8)
            return d8;
        if (num == 9)
            return d9;
        //invalid
        return null;
    }
}
