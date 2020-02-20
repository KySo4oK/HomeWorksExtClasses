package extclass.model;

public class Sound {
    public Sound(int length, String writer, String name, Genre genre) {
        this.length = length;
        this.writer = writer;
        this.name = name;
        this.genre = genre;
    }

    private int length;
    private String writer;
    private String name;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    private Genre genre;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

