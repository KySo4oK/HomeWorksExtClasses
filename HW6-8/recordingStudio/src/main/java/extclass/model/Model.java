package extclass.model;

public class Model {
    private Sound[] sounds;
    public Model(int quantity) {
        sounds = new Sound[quantity];
        for (int i = 0; i < quantity / 2; i++) {
            sounds[i] = new Sound(60 + i * 10,
                    "writer" + i, "name" + i,
                    Genre.values()[i % 4]);
        }
        for (int i = quantity / 2; i < quantity; i++) {
            sounds[i] = new Song(60 + i * 10,
                    "writer" + i, "name" + i,
                    Genre.values()[i % 4],
                    "Singer" + i);
        }
    }




    public Sound[] getSoundsByRangeOfLength() {
        return null;
    }

    public int getLength() {
        return 0;
    }

    public void sortByGenre() {

    }

}
