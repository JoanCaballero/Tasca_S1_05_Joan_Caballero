package n1exercici3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileWalker implements FileVisitor<Path> {

    private final BufferedWriter writer;

    public FileWalker(String outputFile) throws IOException{
        this.writer = new BufferedWriter(new FileWriter(outputFile, true));
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        writer.write(String.format("(D): %s ", dir));
        writer.write("(" + formatDateTime(attrs.lastModifiedTime()) + ")");
        writer.newLine();
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isSymbolicLink()){
            writer.write(String.format("Symbolic link: %s ", file));
        }
        else if(attrs.isRegularFile()){
            writer.write(String.format("(F): %s", file));
        }
        else{
            writer.write(String.format("Other: %s ", file));
        }
        writer.write("(" + formatDateTime(attrs.lastModifiedTime()) + ")");
        writer.newLine();
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        writer.write(exc.getMessage());
        writer.newLine();
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
    private String formatDateTime(FileTime lastModifiedTime) {

        LocalDateTime localDateTime = lastModifiedTime
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}
