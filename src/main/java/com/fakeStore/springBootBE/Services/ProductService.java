package com.fakeStore.springBootBE.Services;

import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    String getAllProducts();
    String getProductByID(Long productID);
    String createProduct();
    String deleteProductByID(Long productID);
    String updateProductByID(Long productID);
}
