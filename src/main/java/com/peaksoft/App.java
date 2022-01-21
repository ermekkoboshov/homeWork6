package com.peaksoft;

import com.peaksoft.Classes.Cities;
import com.peaksoft.Classes.Countries;
import com.peaksoft.Classes.ThePresident;
import com.peaksoft.dao.Jdbc;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Cities> cities;
        List<Countries> countries = new ArrayList<>();
        List<ThePresident> thePresidents = new ArrayList<>();
        Jdbc jdbc = new Jdbc();
        Jdbc.addCities();
        jdbc.getAllCities();
        Jdbc.getCityById();
        cities = jdbc.getCities();
        Jdbc.addCountries();
        jdbc.getAllCountries();
        Jdbc.getCountryById();
        countries = jdbc.getCountries();
        Jdbc.addPresidents();
        jdbc.getAllPresident();
        Jdbc.getPresidentById();
        
        thePresidents = jdbc.getThePresidents();

    }

}
