package com.epam.task2;

import java.util.ArrayList;

/**
 * Class for storing user information
 * Created by Nikita_Zenchyk on 1/25/2017.
 */
public class User {
    private int userid;
    private ArrayList<SportEquipment> renteditems = new ArrayList<>();

    public User(int userid) {
        this.userid = userid;
    }

    /**
     * Method to add item to user rent list
     *
     * @param item to add
     * @throws Exception if user has 3 items and add's 4
     */
    public void addRentItem(SportEquipment item) throws Exception {
        if (checkRentLimit()) {
            renteditems.add(item);
        } else {
            throw new Exception("Out of rent limit");
        }
    }

    /**
     * Method to remove item from user rent list
     *
     * @param item
     */
    public void removeRentItem(SportEquipment item) {
        renteditems.remove(item);
    }

    public int getUserid() {
        return userid;
    }

    /**
     * Method check if user has less the 3 item in user rent list
     *
     * @return
     */
    private boolean checkRentLimit() {
        if (renteditems.size() <= 3) {
            return true;
        }
        return false;
    }

    public ArrayList<SportEquipment> getRenteditems() {
        return renteditems;
    }
}
