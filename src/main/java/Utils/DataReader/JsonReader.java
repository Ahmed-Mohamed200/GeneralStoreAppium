package Utils.DataReader;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonReader {

    //JsonNode → The method returns a Jackson JsonNode object, which represents a parsed JSON structure in a tree format.
    public static JsonNode readJsonFile(String filePath) throws IOException {
        // Read JSON file content as a String
        //Before
        //{
        //    "name": "John Doe",
        //    "age": 30
        //}
        String json = Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        //After "{\"name\": \"John Doe\", \"age\": 30}"

        // Parse JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        //Parses the JSON String into a tree-like structure (JsonNode).
        return objectMapper.readTree(json); // Returns a JSON tree (JsonNode)

    }


}
