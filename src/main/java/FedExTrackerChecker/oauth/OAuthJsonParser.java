package FedExTrackerChecker.oauth;

import FedExTrackerChecker.Main;
import com.google.gson.Gson;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;

@Getter
public class OAuthJsonParser {
    public static OAuthJson readJson() {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/oauth.json");
        if (file.exists()) {
            try {
                Gson gson = new Gson();
                return gson.fromJson(new FileReader(file), OAuthJson.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        Main.exit("Could not read FedExTrackerChecker.requests.OAuthJson file at: " + file.getAbsolutePath());
        return new OAuthJson();
    }

    public static HashMap<String, String> getOAuthFields() throws IllegalAccessException {
        OAuthJson oAuthJsonParser = readJson();
        HashMap<String, String> oAuthFields = new HashMap<>();
        for (Field field : oAuthJsonParser.getClass().getDeclaredFields()) {
            String fieldName = field.getName();
            String fieldVal = (String) field.get(oAuthJsonParser);
            if (fieldVal != null) {
                oAuthFields.put(fieldName, fieldVal);
            }
        }
        return oAuthFields;
    }
}


