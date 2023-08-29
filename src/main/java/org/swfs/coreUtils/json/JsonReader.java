package org.swfs.coreUtils.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static JsonObject readElementFromJson(String filename, String elementIdentifier)
        throws IOException {
        Object obj = new JsonParser()
            .parse(new FileReader("src/main/java/org/swfs/pageFactory/WebPages/" + filename + ".json"));
        JsonObject jsonObject = (JsonObject) obj;

        return jsonObject.getAsJsonObject(elementIdentifier);
    }
}
