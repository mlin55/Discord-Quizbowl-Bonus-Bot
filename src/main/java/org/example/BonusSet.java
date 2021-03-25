package org.example;

public class BonusSet {
    public String leadin;
    public String[] text;
    public String[] answers;

    //temporary; replace once I figure out how to read from json
    public BonusSet (String leadin, String[] text, String[] answers) {
        this.leadin = leadin;
        this.text = text;
        this.answers = answers;
    }

    public BonusSet () {
        leadin = null;
        text = null;
        answers = null;
    }
}
