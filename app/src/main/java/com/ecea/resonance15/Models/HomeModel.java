package com.ecea.resonance15.Models;

import com.ecea.resonance15.R;
import com.ecea.resonance15.Resonance_Home;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by goku on 20-09-2015.
 */
public class HomeModel {

    //Home page
    public static ArrayList<String> titles=new ArrayList<String>(Arrays.asList("Events","Workshops","Social Hub"));
    public static ArrayList<Integer> image=new ArrayList<Integer>(Arrays.asList(R.drawable.temp,R.drawable.temp,R.drawable.temp));



    //Events model
    public static ArrayList<String> eventtitles=new ArrayList<>(Arrays.asList("Analocked","Beginners bias","Codesense","Doped","How Stuff Works","Matrimaze","Mindsweeper","Kick-off","Track The Track","c10ck it"));
    public static ArrayList<Integer> eventimages=new ArrayList<>(Arrays.asList(R.drawable.analocked,R.drawable.beginnersbias,R.drawable.codesense,R.drawable.temp,R.drawable.howstuffworks,R.drawable.temp,R.drawable.your_drawable,R.drawable.temp,R.drawable.trackthetrack,R.drawable.temp));
    public static ArrayList<String> eventurl=new ArrayList<>(Arrays.asList("analocked.html","beginnersbias.html","codesense.html","doped.html","howstuffworks.html","matrimaze.html","mindsweeper.html","kickoff.html","trackthetrack.html","c10ckit.html"));

    //Workshop
    public static ArrayList<String> wtitles=new ArrayList<>(Arrays.asList("Voice Contreolled Robot"));
    public static ArrayList<Integer> wimages=new ArrayList<>(Arrays.asList(R.drawable.ic_launcher));
    public static ArrayList<String> wurl=new ArrayList<>(Arrays.asList("voice_control.html"));

}
