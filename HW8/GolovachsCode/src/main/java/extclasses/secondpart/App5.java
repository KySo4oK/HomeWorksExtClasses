package extclasses.secondpart;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class App5 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if(System.currentTimeMillis()%2 == 0){
                throw new EOFException();
            }else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e){

        }

    }
}
