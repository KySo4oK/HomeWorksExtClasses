package extclass.model;

public class Sound {
    Sound(int length, String writer, String name, Genre genre) {
        this.length = length;
        this.writer = writer;
        this.name = name;
        this.genre = genre;
    }

    private int length;

    @Override
    public String toString() {
        return "Sound{" +
                "length=" + length +
                ", writer='" + writer + '\'' +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                '}';
    }

    private String writer;
    private String name;

    Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    private Genre genre;

    int getLength() {
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

