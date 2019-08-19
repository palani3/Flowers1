package com.example.flowers;

public class User {public String block, name,date;
    //phone, price;
    public String phone, price;

    /*public User(String toString, String s) {
        this.block = block;
        this.name = name;
        this.phone = phone;
        this.price = price;


    }
*/
    public User(String block, String name, String phone, String price,String date) {
        this.block = block;
        this.name = name;
        this.phone = phone;
        this.price = price;
        this.date=date;

    }



    public String getBlock()
    {return block;}


    public void setBlock(java.lang.String block) {
        this.block = block;
    }

    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name=name;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone()
    {
        this.phone=phone;
    }
    public String getPrice()
    {
        return price;
    }
    public void setPrice()
    {
        this.price=price;
    }
    public String getDate(){return date;}
    public void setDate(){this.date=date;}


}

