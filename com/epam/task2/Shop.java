package com.epam.task2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for items that are in shop
 * Created by Nikita_Zenchyk on 1/20/2017.
 */
public class Shop {
    private Map<SportEquipment, Integer> goods = new HashMap<>();

    public Shop() throws NullPointerException, IOException, SAXException, ParserConfigurationException {
        this.goods.putAll(new ReadFromFile().read());
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    /**
     * Method to find sport equipment unit by title
     *
     * @param title for search
     * @return array list of sport equipment unit
     * @throws Exception if no unit found
     */
    public ArrayList<SportEquipment> findUnitByTitle(String title) throws Exception {
        ArrayList<SportEquipment> units = null;
        for (SportEquipment unit : goods.keySet()) {
            if (unit.getTitle().equals(title)) {
                units.add(unit);
            }
        }
        if (!units.isEmpty()) {
            return units;
        } else {
            throw new Exception("Item not found.");
        }
    }

    /**
     * Method to find sport equipment unit by category
     *
     * @param category for search
     * @return array list of sport equipment unit
     * @throws Exception if no unit found
     */
    public ArrayList<SportEquipment> findUnitByCategory(String category) throws Exception {
        ArrayList<SportEquipment> units = null;
        for (SportEquipment unit : goods.keySet()) {
            if (unit.getCategory().equals(category)) {
                units.add(unit);
            }
        }
        if (!units.isEmpty()) {
            return units;
        } else {
            throw new Exception("Item not found.");
        }
    }

    /**
     * Method to find sport equipment unit by price
     *
     * @param price for search
     * @return array list of sport equipment unit
     * @throws Exception if no unit found
     */
    public ArrayList<SportEquipment> findUnitByPrice(int price) throws Exception {
        ArrayList<SportEquipment> units = null;
        for (SportEquipment unit : goods.keySet()) {
            if (unit.getPrice() == price) {
                units.add(unit);
            }
        }
        if (!units.isEmpty()) {
            return units;
        } else {
            throw new Exception("Item not found.");
        }
    }

    /**
     * Method to get list of units in shop
     *
     * @return string line of units in shop
     */
    public String getListOfUnits() {
        String outputline = "Units in shop." + System.lineSeparator();
        for (SportEquipment unit : goods.keySet()) {
            outputline += "Category: " + unit.getCategory()
                    + ". Title: " + unit.getTitle()
                    + ". Price: " + unit.getPrice()
                    + ". Count: " + goods.get(unit)
                    + "."
                    + System.lineSeparator();
        }
        if (outputline.isEmpty()) {
            outputline = "No units in shop.";
        }
        return outputline;
    }
}