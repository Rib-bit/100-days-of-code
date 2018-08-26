package masterclass;

public class Song {
    private String title;
    private double duration;

    public Song(String title) {
        this.title = title;
        this.duration = Math.floor(Math.random()* 400);
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
