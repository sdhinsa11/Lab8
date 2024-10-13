package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mock list for my city list
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add city/province to the list
     * check if the list added that city
     * check if another city we did not add is in the list
     */
    @Test
    void testHasCity() {
        list = MockCityList();
        // Use the same City object for both adding and checking
        City edmonton = new City("Edmonton", "Alberta");
        list.addCity(edmonton);

        assertEquals(true, list.hasCity(edmonton), "City should be in the list");

        City newCity = new City("Vancouver", "BC");
        assertEquals(false, list.hasCity(newCity), "City should not be in the list.");
    }

    /**
     * grab city name to delete
     * remove the city from the list
     * check if there is a city to delete
     * Then delete city and see if count decreased
     */
    @Test
    void testDeleteCity() throws Exception {
        list = MockCityList();

        // Add the city first before attempting to delete
        City edmonton = new City("Edmonton", "Alberta");
        list.addCity(edmonton); // Add the city to the list

        assertEquals(1, list.getCount(), "There should be 1 city in the list."); // Check list size

        list.delete(edmonton); // Delete the city
        assertEquals(0, list.getCount(), "There should be 0 cities in the list after deletion."); // Check list size after deletion
    }

    /**
     * test if there is a city in already
     * add a city
     * test that city
     */
    @Test
    void testCountCities() {
        list  = MockCityList();
        assertEquals(1, list.countCities(), "Initially, there should be 1 city in the list.");

        City city = new City("Victoria", "British Columbia");
        list.addCity(city);
        assertEquals(2, list.countCities(), "There should be 2 cities in the list after adding one.");
    }
}
