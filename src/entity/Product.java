package entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Product {
    private String manufacturer;
    private String model;
    private Calendar date;
    private String color;
    private Integer price;
    private Integer number;
    private Boolean isAvailable;

    public Product() {
    }

    public Product(String manufacturer, String model, Calendar date, String color, Integer price, Integer number, Boolean isAvailable) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.date = date;
        this.color = color;
        this.price = price;
        this.number = number;
        this.isAvailable = isAvailable;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date.getTime());
    }
    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
