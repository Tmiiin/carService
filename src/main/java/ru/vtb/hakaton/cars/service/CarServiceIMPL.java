package ru.vtb.hakaton.cars.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.vtb.hakaton.cars.service.Interface.CarService;
import ru.vtb.hakaton.cars.view.CarModel;
import ru.vtb.hakaton.cars.view.Offer.Offer;
import ru.vtb.hakaton.cars.view.Offer.OfferProperties;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceIMPL implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    public List<OfferProperties> getInformation(CarModel car){
        //File marketplace = new File();
        try {
            List<OfferProperties> offerPropertiesList = new ArrayList<>();
            Gson gson = new Gson();
            Offer address = gson.fromJson(getMarketplace(), Offer.class);
            for(OfferProperties offerProperties: address.getList()){
                if(offerProperties.getAlias().equals(car.getMark()))
                    offerPropertiesList.add(offerProperties);
            }
            logger.info(address.getList().toString());
            return offerPropertiesList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getMarketplace() throws IOException {
        URL obj = new URL("https://gw.hackathon.vtb.ru/vtb/hackathon/marketplace");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("X-IBM-Client-Id", "2d952b2cc508f4103e3de4d276392dfd");

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return response.toString();
    }
}
