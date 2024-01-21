package com.fakeStore.springBootBE.ModelsOrEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Product")
@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private String image;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "categoryId")        //Mind we have given the name to the column which has FK
    private Category category;
    //It means that we have configured inheritance and association of category and product class.
    //@JoinColumn refers to the foreign key taken from the associated table (i.e. Product). We have given its name by the attribute "name"
    //@JoinColumn() is always used on the owner side of the relation. Owner = "Entity contained within another Entity". Here Product is contained within Category.
    //So, product side is assigned the ownership. (Reverse is also possible but not recommended)

    /*OneToMany and ManyToOne are applied together for bidirectional nature of the relation, which means that both the entity details can be retrieved from each other's table.*/
    //It is recommended to use both together, although one can be used individually as well.
    public String toString(){
        return "{"+title+","+description+","+price+","+category+","+image+"}";
    }
}
