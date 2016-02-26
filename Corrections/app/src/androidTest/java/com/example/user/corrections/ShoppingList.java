package com.example.user.corrections;

import java.util.Date;

/**
 * Created by Luiz Felipe on 26/11/2015.
 */
public class ShoppingList {

    private int _id;
    private String listName;
    private String shopPlace;
    private Date dueDate;

    public ShoppingList() {
    }

    public ShoppingList(String itemsList, String shopPlace, Date dueDate) {
        this.listName = itemsList;
        this.shopPlace = shopPlace;
        this.dueDate = dueDate;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getShopPlace() {
        return shopPlace;
    }

    public void setShopPlace(String shopPlace) {
        this.shopPlace = shopPlace;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
