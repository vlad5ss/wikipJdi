package android.utils;


import android.model.CountryDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UtilsParseJson {

    public static List<String> getCountryFromJson() {
        ByteArrayOutputStream byteArrayOutputStream = getByteArrayOutputStream();
        ArrayList<CountryDto> countryName = getCountryDtos(byteArrayOutputStream);

        return countryName.stream().map(p -> p.name).collect(Collectors.toList());
    }


    private static ArrayList<CountryDto> getCountryDtos(ByteArrayOutputStream byteArrayOutputStream) {
        Type listType = new TypeToken<ArrayList<CountryDto>>() {
        }.getType();
        ArrayList<CountryDto> countryName = new Gson().fromJson(byteArrayOutputStream.toString(), listType);

        return countryName;
    }


    private static ByteArrayOutputStream getByteArrayOutputStream() {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\cities.json");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}
