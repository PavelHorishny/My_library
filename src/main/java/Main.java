import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.net.URL;
import java.nio.charset.StandardCharsets;
public class Main {

    public static void main(String[] args) throws IOException {
     /*   URL url = new URL ("https://openlibrary.org/works/OL45804W/editions.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);*/
        //InputStream input = con.getInputStream();

        //System.out.println(new ResponseResolver(Constants.API).getResult());
/*        JSONObject json = new JSONObject(new RequestResolver(Constants.API).getResult());
        System.out.println(json.getInt("numFound"));
        String list [] = new String[json.getInt("numFound")];
        for(int i = 0; i<json.getInt("numFound");i++){
            list[i] = new JSONObject(json.getJSONArray("docs").get(i).toString()).getString("key");
        }
        *//*JSONObject json1 = new JSONObject(json.getJSONArray("docs").get(2).toString());
        System.out.println(json1.getString("key"));*//*
        *//*System.out.println(json1);*//*
        System.out.println(Arrays.toString(list));*/
/*        RequestResolver r = new RequestResolver("9780140328721");
        r.searchIsbn();
        System.out.println(r.getResult());*/
/*       JSONObject o = new JSONObject(new OpenLibraryCommunicator(Constants.API).find());
        System.out.println(o);*/
        System.out.println(new RequestResolver("0631207678","isbn").getResult());
    }
}
