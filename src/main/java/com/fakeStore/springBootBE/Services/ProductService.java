package com.fakeStore.springBootBE.Services;

import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    String getAllProducts();
    GenericProductDTO getProductByID(Long productID);
    GenericProductDTO createProduct(Product product);
    String deleteProductByID(Long productID);
    String updateProductByID(Long productID);
}
