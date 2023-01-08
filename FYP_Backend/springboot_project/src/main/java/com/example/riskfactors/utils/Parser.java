package com.example.riskfactors.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Parser {

    public JSONObject getJson(String fileName) {
        File file = new File(fileName);
        try {
            String content = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
            JSONObject obj = new JSONObject(content);
            if (!obj.isEmpty()) {
                return obj;
            } else {
                return null;
            }
        } catch (IOException e) {
            log.error("Exception : " + e.getMessage());
            return null;
        }
    }

    public String convert(String fileName) throws IOException, JSONException {
        String line = "";
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null)
                str += line;
            JSONObject json = XML.toJSONObject(str);
            this.deleteFile(fileName);
            return json.toString();
        } catch (IOException | JSONException e) {
            log.error("Exception : " + e.getMessage());
            return null;
        }
    }

    public boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            log.info("Deleted file " + fileName);
            return true;
        }
        return false;
    }

}
