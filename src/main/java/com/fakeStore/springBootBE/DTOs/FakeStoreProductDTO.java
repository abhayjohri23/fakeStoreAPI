package com.fakeStore.springBootBE.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long productID;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

}
