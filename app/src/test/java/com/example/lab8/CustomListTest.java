package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest(){
        //to push
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    void testHasCity() {
        list = MockCityList();
        City test = new City("Edmonton", "Alberta");
        assertFalse(list.hasCity(test));
        list.addCity(test);
        assertTrue(list.hasCity(test));
    }
    @Test
    void testDelete() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }
    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(0,list.countCities());
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        assertEquals(1,list.countCities());

    }
}
