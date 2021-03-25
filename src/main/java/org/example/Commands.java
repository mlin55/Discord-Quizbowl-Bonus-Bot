package org.example;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.example.BonusBot.CE;
import static org.example.BonusBot.FA;
import static org.example.BonusBot.GEO;
import static org.example.BonusBot.HIST;
import static org.example.BonusBot.LIT;
import static org.example.BonusBot.MYTH;
import static org.example.BonusBot.PHIL;
import static org.example.BonusBot.RELIG;
import static org.example.BonusBot.SCI;
import static org.example.BonusBot.SOCSCI;
import static org.example.BonusBot.TRASH;
import static org.example.BonusBot.bonuses;

public class Commands extends ListenerAdapter {

    public boolean on = false;
    public boolean inBonus = false;
    public boolean givingAns = false;
    public BonusSet currBonus = new BonusSet();
    public int part = 1;
    public int heard = 0;
    public int pts = 0;
    public double ppb = 0;

    public void onGuildMessageReceived( GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;
        String msgSent= event.getMessage().getContentRaw();

        //end always works
        if (msgSent.equalsIgnoreCase(BonusBot.prefix + "end")) {
            event.getChannel().sendMessage("Final stats: ").queue();
            event.getChannel().sendMessage("Bonus cycles heard: " + heard).queue();
            event.getChannel().sendMessage("Total points: " + pts).queue();
            event.getChannel().sendMessage("Average Points per bonus: " + ppb).queue();
            event.getChannel().sendMessage("Ending bonus bot").queue();
            on = false;
            inBonus = false;
            part = 1;
            currBonus = new BonusSet();
            heard = 0;
            pts = 0;
            ppb = 0;
            bonuses = new ArrayList<>();
            givingAns = false;
        }

        //if giving answer move on
        if (givingAns)
        {
            event.getChannel().sendMessage("The answer was: ").queue();
            event.getChannel().sendMessage(currBonus.answers[part - 1]).queue();
            event.getChannel().sendMessage("Were you correct? Type Y for yes, anything else for no").queue();
            givingAns = false;
        }
        else
        {
            //checking if correct
            if (on && inBonus)
            {
                //if correct
                if (msgSent.equalsIgnoreCase("y")) {
                    event.getChannel().sendMessage("Nice job!").queue();
                    pts += 10;
                }
                //if wrong
                else {
                    event.getChannel().sendMessage("Better luck next time!").queue();
                }
                part++;
                //if reached end of bonus reset
                if (part >= 4) {
                    part = 1;
                    heard++;
                    ppb = Double.valueOf(pts) / heard;
                    inBonus = false;
                    currBonus = new BonusSet();
                    event.getChannel().sendMessage("Current ppb: " + ppb).queue();
                    givingAns = false;
                }
                else
                {
                    event.getChannel().sendMessage(currBonus.text[part - 1]).queue();
                    givingAns = true;
                }
            }
            else {
                //commands that always work outside of bonus
                if (msgSent.equalsIgnoreCase(BonusBot.prefix + "help")) {
                    event.getChannel().sendMessage("To use this bot, simply enter the answer to each bonus part. Your number of heard bonuses, total points accumulated, and points per bonus will be automatically calculated.").queue();
                    event.getChannel().sendMessage("Commands: ").queue();
                    event.getChannel().sendMessage("!start- turns on the bot ").queue();
                    event.getChannel().sendMessage("!next- moves onto the next bonus").queue();
                    event.getChannel().sendMessage("!end- turns off the bot ").queue();
                }

                if (msgSent.length() >= 7 && msgSent.substring(0,7).equalsIgnoreCase(BonusBot.prefix + "start ")) {
                    if (on)
                        event.getChannel().sendMessage("Bonus Bot is already on");
                    else
                    {
                        event.getChannel().sendMessage("Starting bonus bot").queue();
                        Scanner sc = new Scanner(msgSent.substring(7));
                        sc.useDelimiter(",");
                        List<String> cats = new ArrayList<>();
                        while (sc.hasNext())
                            cats.add(sc.next());
                        for (String x: cats)
                        {
                            Scanner st = new Scanner(x);
                            String cat = st.next();
                            int diff = st.nextInt();
                            if (cat.equalsIgnoreCase("Current Events"))
                                addDiff(CE, diff);
                            else if (cat.equalsIgnoreCase("Fine Arts"))
                                addDiff(FA, diff);
                            else if (cat.equalsIgnoreCase("Geography"))
                                addDiff(GEO, diff);
                            else if (cat.equalsIgnoreCase("History"))
                                addDiff(HIST, diff);
                            else if (cat.equalsIgnoreCase("Literature"))
                                addDiff(LIT, diff);
                            else if (cat.equalsIgnoreCase("Mythology"))
                                addDiff(MYTH, diff);
                            else if (cat.equalsIgnoreCase("Philosophy"))
                                addDiff(PHIL, diff);
                            else if (cat.equalsIgnoreCase("Religion"))
                                addDiff(RELIG, diff);
                            else if (cat.equalsIgnoreCase("Science"))
                                addDiff(SCI, diff);
                            else if (cat.equalsIgnoreCase("Social Science"))
                                addDiff(SOCSCI, diff);
                            else if (cat.equalsIgnoreCase("Trash"))
                                addDiff(TRASH, diff);
                            else
                                event.getChannel().sendMessage("Invalid categories. Type !help for information on how to choose categories and difficulties");
                        }
                    }
                    on = true;
                }

                if (on) {
                    //commands that only execute when bot is on
                    if (msgSent.equalsIgnoreCase(BonusBot.prefix + "isOn")) {
                        event.getChannel().sendMessage("Bot is on").queue();
                    }

                    if (msgSent.equalsIgnoreCase(BonusBot.prefix + "next")) {
                        int rand = (int) (Math.random() * 8);
                        currBonus = bonuses.get((int) (Math.random() * bonuses.size()));
                        inBonus = true;
                        event.getChannel().sendMessage(currBonus.leadin).queue();
                        event.getChannel().sendMessage(currBonus.text[0]).queue();
                        givingAns = true;
                    }
                }
            }
        }
    }

    public static void addDiff(Category cat, int diff) {
        if (diff == 1)
            bonuses.addAll(cat.d1.bonii);
        else if (diff == 2)
            bonuses.addAll(cat.d2.bonii);
        else if (diff == 3)
            bonuses.addAll(cat.d3.bonii);
        else if (diff == 4)
            bonuses.addAll(cat.d4.bonii);
        else if (diff == 5)
            bonuses.addAll(cat.d5.bonii);
        else if (diff == 6)
            bonuses.addAll(cat.d6.bonii);
        else if (diff == 7)
            bonuses.addAll(cat.d7.bonii);
        else if (diff == 8)
            bonuses.addAll(cat.d8.bonii);
        else if (diff == 9)
            bonuses.addAll(cat.d9.bonii);
    }
}
