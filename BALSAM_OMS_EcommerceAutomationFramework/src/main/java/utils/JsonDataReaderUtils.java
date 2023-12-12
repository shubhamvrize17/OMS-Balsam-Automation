package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonDataReaderUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return objectMapper.readTree(path.toFile());
    }

    public static String getString(JsonNode jsonNode, String fieldName) {
        return jsonNode.get(fieldName).asText();
    }

    public static int getInt(JsonNode jsonNode, String fieldName) {
        return jsonNode.get(fieldName).asInt();
    }

    public static void main(String[] args) {
        try {
            // Example of using the utility
            JsonNode testData = readJsonFile("src//test//resources//testData//test.json");
            String username = getString(testData, "username");
            int age = getInt(testData, "age");

            System.out.println("Username: " + username);
            System.out.println("Age: " + age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

