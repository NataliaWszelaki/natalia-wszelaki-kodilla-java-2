package com.kodilla.testing.weather.stub;

import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperatures() {


        double sum = 0;
        for (double temperature : temperatures.getTemperatures().values()) {
            sum += temperature;
        }
        double averageTemperatures = sum / temperatures.getTemperatures().size();
        return averageTemperatures;
    }

    public double calculateMedianTemperatures() {

        List<Double> listOfTemperatures = temperatures.getTemperatures().values().stream().sorted().collect(Collectors.toList());

        int middleTemperature = listOfTemperatures.size()/2;
        if (middleTemperature % 2 == 1) {
            return listOfTemperatures.get(middleTemperature);
        } else {
            return (listOfTemperatures.get(middleTemperature) + listOfTemperatures.get(middleTemperature + 1)) / 2;
        }
    }

}





