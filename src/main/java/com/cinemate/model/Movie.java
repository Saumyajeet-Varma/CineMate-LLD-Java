public class Movie {
    
    private String id;
    private String title;
    private String genre;
    private int duration;

    public Movie(String id, String title, String genre, int duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Movie: " + title + " (" + genre + "), Duration: " + duration + " mins");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }
}
