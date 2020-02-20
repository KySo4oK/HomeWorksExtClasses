package extclass.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Model {
    private ArrayList<Sound> sounds;

    public Model(int quantity) {
        sounds = new ArrayList<>();
        for (int i = 0; i < quantity / 2; i++) {
            sounds.add(new Sound(60 + i * 10,
                    "writer" + i, "name" + i,
                    Genre.values()[i % 4]));
        }
        for (int i = quantity / 2; i < quantity; i++) {
            sounds.add(new Song(60 + i * 10,
                    "writer" + i, "name" + i,
                    Genre.values()[i % 4],
                    "Singer" + i));
        }
    }


    public ArrayList<Sound> getSoundsByRangeOfLength(int min, int max) {
        ArrayList<Sound> soundsByRange = new ArrayList<>();
        for (int i = 0; i < sounds.size(); i++) {
            if ((sounds.get(i).getLength() >= min) && (sounds.get(i).getLength() <= max)) {
                soundsByRange.add(sounds.get(i));
            }
        }
        return soundsByRange;
    }

    public int getLength() {
        int length = 0;
        for (int i = 0; i < sounds.size(); i++) {
            length += sounds.get(i).getLength();
        }
        return length;
    }

    public void sortByGenre() {
        sounds.sort(Comparator.comparing(Sound::getGenre));
    }
}