package masterclass;

public class SongIPod {
    private String title;
    private double duration;

    public SongIPod(String title) {
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

    @Override
    public String toString(){
        return this.getTitle();
    }
}
