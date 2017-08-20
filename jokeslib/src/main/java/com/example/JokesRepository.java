package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokesRepository {

    private List<String> jokeList = new ArrayList<String>() {{
        add("How did the programmer die in the shower? He read the shampoo bottle instructions: Lather. Rinse. Repeat.");
        add("Database Admins walked into a NoSQL bar. A little while later they walked out because they couldn’t find a table.");
        add("To understand what recursion is, you must first understand recursion.");
    }};

    public String getJoke() {
        Random random = new Random();
        return jokeList.get(random.nextInt(jokeList.size() - 1));
    }
}
