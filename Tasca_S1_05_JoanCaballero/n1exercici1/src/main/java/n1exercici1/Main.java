package n1exercici1;

import java.io.File;
import java.util.List;

public class Main {
    //"C:\\Users\\formacio\\Desktop\\JC"
    public static void main(String[] args) {
        GestioDirectori gestioDirectori = new GestioDirectori();
        List<File> directoriList = gestioDirectori.directoriAlfabeticament("C:\\Users\\formacio\\Desktop\\JC");
        directoriList.forEach(System.out::println);
    }
}

