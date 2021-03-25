package org.example;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Difficulty {

    public List<BonusSet> bonii = new ArrayList<>();

    public Difficulty (File read) {
        Scanner sc = null;
        try {
            sc = new Scanner(read);
            while (sc.hasNextLine())
            {
                String leadin = sc.nextLine();
                String[] text = {sc.nextLine(), sc.nextLine(), sc.nextLine()};
                String[] ans = {sc.nextLine(), sc.nextLine(), sc.nextLine()};
                BonusSet bonus = new BonusSet(leadin, text, ans);
                bonii.add(bonus);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
