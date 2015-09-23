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
    public static ArrayList<String> titles=new ArrayList<String>(Arrays.asList("Home","Events","Workshops","Contacts","Social Hub","About Us"));
    public static ArrayList<Integer> image=new ArrayList<Integer>(Arrays.asList(R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp));



    //Events model
    public static ArrayList<String> eventtitles=new ArrayList<>(Arrays.asList("Analocked","Beginners bias","Codesense","Doped","How Stuff Works","Matrimaze","Mindsweeper","Kick-off","Track The Track"));
    public static ArrayList<Integer> eventimages=new ArrayList<>(Arrays.asList(R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp,R.drawable.temp));
    public static ArrayList<String> eventurl=new ArrayList<>(Arrays.asList("analocked.html","beginnersbias.html","codesense.html","doped.html","howstuffworks.html","matrimaze.html","mindsweeper.html","kickoff.html","trackthetrack.html"));
}
