package com.epam.task2;

/** Class for sport equipment item
 * Created by Nikita_Zenchyk on 1/20/2017.
 */
public class SportEquipment {
    private String category;
    private String title;
    private int price;

    public SportEquipment(String category, String title, int price) {
        this.category = category;
        this.price = price;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment that = (SportEquipment) o;

        if (price != that.price) return false;
        if (!category.equals(that.category)) return false;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + price;
        return result;
    }

    public String getCategory() {
        return category;
    }
    public int getPrice() {
        return price;
    }
    public String  getTitle() {
        return title;
    }
}
