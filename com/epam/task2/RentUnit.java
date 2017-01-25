package com.epam.task2;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class to store and rent items from shop
 * Created by Nikita_Zenchyk on 1/20/2017.
 */
public class RentUnit {
    private ArrayList<User> userswithrentitems = new ArrayList<>();

    /**
     * Method to rent unit
     *
     * @param unit to rent
     * @throws Exception if out of rent limit
     */

    public void rentUnit(int userid, SportEquipment unit, Map<SportEquipment, Integer> shop) throws Exception {
        if (!canRent(unit, shop)) {
            throw new Exception("Not enough items in shop to rent.");
        }
        boolean flag = false;
        for (User user : userswithrentitems) {
            if (user.getUserid() == userid) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            User usertoadd = new User(userid);
            userswithrentitems.add(usertoadd);
        }
        for (User user : userswithrentitems) {
            if (user.getUserid() == userid) {
                for (SportEquipment item : shop.keySet()) {
                    if (item.equals(unit)) {
                        shop.replace(item, shop.get(item) - 1);
                        user.addRentItem(unit);
                    }
                }
            }
        }
    }

    /**
     * Method to remove unit from rent list
     *
     * @param unit to remove
     */
    public void returnUnit(int userid, SportEquipment unit, Map<SportEquipment, Integer> shop) {
        for (User user : userswithrentitems) {
            if (user.getUserid() == userid) {
                user.removeRentItem(unit);
                if (user.getRenteditems().isEmpty()) {
                    userswithrentitems.remove(user);
                }
                for (SportEquipment item : shop.keySet()) {
                    if (item.equals(unit)) {
                        shop.replace(item, shop.get(item) + 1);
                    }
                }
            }
        }
    }

    /**
     * Method to get list of rented items
     *
     * @return String line of users and item rented
     */
    public String listOfUnitsInRent() {
        String outputline = "Rented items." + System.lineSeparator();
        for (User user : userswithrentitems) {
            for (SportEquipment unit : user.getRenteditems())
                outputline += "UserID: " + user.getUserid() + ". Category: " + unit.getCategory()
                        + ". Title: " + unit.getTitle()
                        + ". Price: " + unit.getPrice()
                        + "."
                        + System.lineSeparator();
        }
        if (outputline.isEmpty()) {
            outputline = "No units in shop.";
        }
        return outputline;
    }

    /**
     * Method to check if there is item to rent
     *
     * @param unit item to check
     * @param shop total units in shop
     * @return true if can rent, else false
     */
    private boolean canRent(SportEquipment unit, Map<SportEquipment, Integer> shop) {
        boolean ans = false;
        for (SportEquipment item : shop.keySet()) {
            if (item.equals(unit)) {
                if (shop.get(item) >= 1) {
                    ans = true;
                }
            }
        }
        return ans;
    }
}
