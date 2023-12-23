package com.fakeStore.springBootBE.DTOs;

import lombok.Getter;
import lombok.Setter;
//Created after we started discussing DTOs: Check the DTO commit for this.
@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String category;        //Category shouldn't be made as enum in cases where category value is not fixed.
    private String description;
    private String image;

}
