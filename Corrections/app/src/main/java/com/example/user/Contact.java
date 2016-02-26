package com.example.user;

/**
 * Created by mateuspalhares on 26/03/15.
 */
public class Contact {

    // private variables
    int _id;
    String _name;
    byte[] _image;
    String _desc;
    String _lat;



    public String get_long() {
        return _long;
    }

    public void set_long(String _long) {
        this._long = _long;
    }

    public String get_lat() {
        return _lat;
    }



    public void set_lat(String _lat) {
        this._lat = _lat;
    }

    String _long;



    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    // Empty constructor
    public Contact() {

    }

    // constructor
    public Contact(String _name, byte[] _image, String _desc, String _lat, String _long) {
        this._name = _name;
        this._image = _image;
        this._desc = _desc;
        this._lat = _lat;
        this._long = _long;
    }
    public Contact(int _id, String _name, byte[] _image, String _desc, String _lat, String _long) {
        this._id = _id;
        this._name = _name;
        this._image = _image;
        this._desc = _desc;
        this._lat = _lat;
        this._long = _long;
    }

    public Contact(int keyId,String desc, String name, byte[] image) {
        this._id = keyId;
        this._name = name;
        this._image = image;
        this._desc = desc;

    }
    public Contact(String desc, String name, byte[] image) {
        this._name = name;
        this._image = image;
        this._desc = desc;

    }
    public Contact(int keyId, String name, byte[] image) {
        this._id = keyId;
        this._name = name;
        this._image = image;

    }
    public Contact(String name, byte[] image) {
        this._name = name;
        this._image = image;

    }
    public Contact(int keyId) {
        this._id = keyId;

    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int keyId) {
        this._id = keyId;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

    // getting phone number
    public byte[] getImage() {
        return this._image;
    }

    // setting phone number
    public void setImage(byte[] image) {
        this._image = image;
    }
}