package extclass.model;

public class Song extends Sound {
    private String singer;

    public Song(int length, String writer, String name, Genre genre, String singer) {
        super(length,writer,name,genre);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
