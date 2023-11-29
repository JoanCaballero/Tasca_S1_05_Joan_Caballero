package n1exercici2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileWalker implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.format("(D): %s ", dir);
        System.out.println("(" + formatDateTime(attrs.lastModifiedTime()) + ")");
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isSymbolicLink()){
            System.out.format("Symbolic link: %s ", file);
        }
        else if(attrs.isRegularFile()){
            System.out.format("(F): %s", file);
        }
        else{
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + formatDateTime(attrs.lastModifiedTime()) + ")");
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc.getMessage());
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
