package n1exercici1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GestioDirectori {

    public List<File> directoriAlfabeticament(String nomDirectori){
        List<File> directoriList = new ArrayList<>();
        try(Stream<Path> stream = Files.list(Paths.get(nomDirectori))){
            directoriList = stream.map(Path::toFile).sorted().toList();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return directoriList;
    }
}
