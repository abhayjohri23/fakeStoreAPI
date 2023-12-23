package com.fakeStore.springBootBE.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String image;
    private String description;
    private double price;
    private String category;
}
