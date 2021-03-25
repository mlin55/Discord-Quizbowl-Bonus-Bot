package org.example;

import java.io.*;
import java.util.*;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.json.simple.parser.ParseException;

import javax.security.auth.login.LoginException;

public class BonusBot {

    public static JDABuilder builder;
    public static String prefix = "!";
    public static Category CE = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Current Events/CE-9.txt"));
    public static Category FA = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Fine Arts/FA-9.txt"));
    public static Category GEO = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Geography/GEO-9.txt"));
    public static Category HIST = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/History/HIST-9.txt"));
    public static Category LIT = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Literature/LIT-9.txt"));
    public static Category MYTH = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Mythology/MYTH-9.txt"));
    public static Category PHIL = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Philosophy/PHIL-9.txt"));
    public static Category RELIG = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Religion/RELIG-9.txt"));
    public static Category SCI = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Science/SCI-9.txt"));
    public static Category SOCSCI = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Social Science/SOCSCI-9.txt"));
    public static Category TRASH = new Category(new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-1.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-2.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-3.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-4.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-5.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-6.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-7.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-8.txt"), new File("C:/Users/jml75/Desktop/Website projects/Bonus Bot/txt files/Trash/TRASH-9.txt"));
    public static List<BonusSet> bonuses = new ArrayList<>();

    public static void main(String[] args) throws LoginException, FileNotFoundException, ParseException {


        String token = "ODEzNTIwMDE3MzkxMzUzODg5.YDQfjg.KiQnZQ-q2bktdI7GjB-EJz-ZTnk";
        builder = JDABuilder.createDefault(token);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        builder.setBulkDeleteSplittingEnabled(false);

        builder.setCompression(Compression.NONE);

        builder.setActivity(Activity.playing("Type help for instructions on how to use me"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerListeners();

        builder.build();
    }

    public static void registerListeners() {
        builder.addEventListeners(new Commands());
    }

}
