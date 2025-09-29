package main.java.com.cinemate.model;

import java.util.ArrayList;

public class Theater {
    
    private String name;
    private String location;
    private ArrayList<Screen> screens;

    public Theater(String name, String location) {
        this.name = name;
        this.location = location;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void showMovies() {

        System.out.println("Movies playing at " + name + ", " + location + ":");

        for (Screen screen : screens) {
            
            Movie movie = screen.getMovie();
            
            if (movie != null) {
                movie.displayDetails();
            } 
            else {
                System.out.println("No movie assigned to Screen " + screen.getId());
            }
        }
    }
}
