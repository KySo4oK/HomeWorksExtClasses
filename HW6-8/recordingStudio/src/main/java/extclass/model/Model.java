package extclass.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Model {
    private ArrayList<Sound> sounds;
    private ArrayList<Sound> collection;

    public ArrayList<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(ArrayList<Sound> sounds) {
        this.sounds = sounds;
    }

    public ArrayList<Sound> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Sound> collection) {
        this.collection = collection;
    }

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
        this.collection = new ArrayList<>();
    }


    public ArrayList<Sound> getSoundsByRangeOfLength(int min, int max) {
        ArrayList<Sound> soundsByRange = new ArrayList<>();
        for (Sound sound : sounds) {
            if ((sound.getLength() >= min) && (sound.getLength() <= max)) {
                soundsByRange.add(sound);
            }
        }
        return soundsByRange;
    }

    public int getLength() {
        int length = 0;
        for (Sound sound : collection) {
            length += sound.getLength();
        }
        return length;
    }

    public void sortByGenre() {
        sounds.sort(Comparator.comparing(Sound::getGenre));
    }

    public void addSongByID(int index) {
        collection.add(sounds.get(index));
    }
}