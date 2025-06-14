package org.yroqwooz.MovieCatalogue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonManager {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static void writeJson(String path, List<Movie> list) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File(path), list);
            System.out.println("JSON успешно записан");
        } catch (IOException e) {
            System.out.println("Ошибка при записи JSON:" + e.getMessage());
        }
    }

    public static List<Movie> readJson(String path) {
        List<Movie> movies;
        try {
            movies = mapper.readValue(
                    new File(path),
                    new TypeReference<List<Movie>>(){});
            System.out.println("JSON успешно прочитан");
            return movies;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении JSON:" + e.getMessage());
        }
        return null;
    }
}
