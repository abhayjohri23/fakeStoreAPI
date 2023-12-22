package com.fakeStore.springBootBE.Services;

import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<GenericProductDTO> getAllProducts();

    GenericProductDTO createProduct(Long productID);
}
