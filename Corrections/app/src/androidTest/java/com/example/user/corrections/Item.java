package com.example.user.corrections;

/**
 * Created by Luiz Felipe on 26/11/2015.
 */
public class Item {

    private int _id;
    private String item;

    public Item() {

    }

    public Item(String item) {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
