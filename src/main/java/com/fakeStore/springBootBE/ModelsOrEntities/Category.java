package com.fakeStore.springBootBE.ModelsOrEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    private String categoryName;

    @OneToMany(mappedBy = "category")
    /*mappedBy - Used for the indication of the inverse or the referencing side simply should map to the owning side (i.e. Product).
    * The value of mappedBy is the name of the association-mapping attribute (=Category class's category attribute) on the owning side. */
    private List<Product> productList;

    //Follow: https://www.baeldung.com/jpa-joincolumn-vs-mappedby

    //https://www.baeldung.com/jpa-cascade-types - Cascade types for the relations where you need cascading changes to happen b/w relations.
    //Covered Types: PERSIST and REMOVE - Used in cascade attribute of @OneToMany/@OneToOne etc. OR @Cascade annotation
}
