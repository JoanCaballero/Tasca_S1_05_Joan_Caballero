package n1exercici4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //"C:\\Users\\formacio\\Desktop\\JC"
        //"directoris.txt"
        GestioDirectori gestioDirectori = new GestioDirectori();
        gestioDirectori.llegirTxt("directoris.txt");
    }
}

