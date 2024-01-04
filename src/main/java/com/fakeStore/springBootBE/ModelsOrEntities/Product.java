package com.fakeStore.springBootBE.ModelsOrEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private String image;
    private String description;
    private double price;
    @ManyToOne
    private Category category;

    public String toString(){
        return "{"+title+","+description+","+price+","+category+","+image+"}";
    }
}
