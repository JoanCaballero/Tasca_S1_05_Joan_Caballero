import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //"C:\\Users\\formacio\\Desktop\\JC"
        //"directoris.txt"
        Persona persona = new Persona("Joan", 24);
        GestioDirectori gestioDirectori = new GestioDirectori();
        gestioDirectori.serialitzarObjecte(persona, "persona.ser");
        gestioDirectori.desserialitzarObjecte("persona.ser");
    }
}

