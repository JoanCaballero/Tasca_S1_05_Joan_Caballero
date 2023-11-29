import java.io.*;

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
    }

    public void directoriAlfabeticamentRecursiuTxt(String nomDirectori){
        Path path = Path.of(nomDirectori);
        String outputFile = "directoris.txt";
        try{
            Files.walkFileTree(path, new FileWalker(outputFile));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void llegirTxt(String nomArxiu) throws IOException {
        FileReader fr = new FileReader(nomArxiu);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        br.close();
    }*/
    public void serialitzarObjecte(Object persona, String arxiu){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arxiu))) {
            oos.writeObject(persona);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Persona desserialitzarObjecte(String arxiu) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arxiu))){
            Persona persona = (Persona) ois.readObject();
            return persona;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
