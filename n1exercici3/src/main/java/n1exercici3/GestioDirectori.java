package n1exercici3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestioDirectori {

    /*public List<File> directoriAlfabeticament(String nomDirectori){
        List<File> directoriList = new ArrayList<>();
        try(Stream<Path> stream = Files.list(Paths.get(nomDirectori))){
            directoriList = stream.map(Path::toFile).sorted().toList();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return directoriList;
    }

    public void directoriAlfabeticamentRecursiu(String nomDirectori){
        Path path = Path.of(nomDirectori);
        try{
            Files.walkFileTree(path, new FileWalker());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }*/

    public void directoriAlfabeticamentRecursiuTxt(String nomDirectori){
        Path path = Path.of(nomDirectori);
        String outputFile = "directoris.txt";
        try{
            Files.walkFileTree(path, new FileWalker(outputFile));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
