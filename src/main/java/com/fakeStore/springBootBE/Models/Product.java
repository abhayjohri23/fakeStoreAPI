package com.fakeStore.springBootBE.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private String image;
    private String description;
    private double price;
    private String category;

    public String toString(){
        return "{"+title+","+description+","+price+","+category+","+image+"}";
    }
}
