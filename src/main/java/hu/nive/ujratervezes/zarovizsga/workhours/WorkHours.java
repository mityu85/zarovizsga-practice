package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String name = "";
            int min = Integer.MAX_VALUE;
            String hours = "";
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (Integer.parseInt(temp[1]) < min) {
                    name = temp[0];
                    min = Integer.parseInt(temp[1]);
                    hours = temp[2];
                }
            }
            return name + ": " + hours;
        } catch (IOException e) {
            throw new IllegalStateException("File cannot read", e);
        }
    }
}
