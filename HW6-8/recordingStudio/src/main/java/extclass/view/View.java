package extclass.view;

import extclass.model.Sound;

import java.util.ArrayList;

public class View {
    public void printMainMenu() {
    }

    public void printWrongInputMessage() {
        printMessage(TextConstant.WRONG_INPUT);
    }

    public void printAddSoundMenu(ArrayList<Sound> sounds) {
        printSoundNamesWithIndex(sounds);
        printMessage(TextConstant.SELECT_ID_OF_SONG);
    }

    private void printSoundNamesWithIndex(ArrayList<Sound> sounds) {
        for(int i = 0; i < sounds.size(); i++){
            printMessage(sounds.get(i).toString());
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
