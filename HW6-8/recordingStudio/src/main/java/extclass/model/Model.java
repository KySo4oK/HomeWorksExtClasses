package extclass.model;

import java.util.ArrayList;

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


    public ArrayList<Sound> getSoundsByRangeOfLength(int min, int max) {
        ArrayList<Sound> soundsByRange = new ArrayList<>();
        for (int i = 0; i < sounds.length; i++) {
            if ((sounds[i].getLength() >= min) && (sounds[i].getLength() <= max)) {
                soundsByRange.add(sounds[i]);
            }
        }
        return soundsByRange;
    }

    public int getLength() {
        return 0;
    }

    public void sortByGenre() {

    }

}
