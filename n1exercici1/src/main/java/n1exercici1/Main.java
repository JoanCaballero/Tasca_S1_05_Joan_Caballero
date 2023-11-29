package n1exercici1;

import java.io.File;
import java.util.List;

public class Main {
    //mvn exec:java -D"exec.args"="C:\\Users\\formacio\\Desktop\\JC"
    public static void main(String[] args) {
        GestioDirectori gestioDirectori = new GestioDirectori();
        List<File> directoriList = gestioDirectori.directoriAlfabeticament(args[0]);
        directoriList.forEach(System.out::println);
    }
}

