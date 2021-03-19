package org.pngquant;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("missing args");
            return;
        }
        PngQuant pngQuant = new PngQuant();
        if (!Files.probeContentType(Paths.get(args[0])).toLowerCase().contains("image/png")) {
            throw new RuntimeException("not png file");
        }
        File in = new File(args[0]);
        File out = new File(args[1]);
        try {
            ImageIO.write(pngQuant.getRemapped(ImageIO.read(in)), "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
