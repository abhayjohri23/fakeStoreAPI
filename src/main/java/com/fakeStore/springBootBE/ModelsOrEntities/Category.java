package com.fakeStore.springBootBE.ModelsOrEntities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Category extends BaseModel{
    private String categoryName;
}
