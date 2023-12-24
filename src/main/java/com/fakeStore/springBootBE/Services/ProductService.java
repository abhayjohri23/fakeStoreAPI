package com.fakeStore.springBootBE.Services;

import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<GenericProductDTO> getAllProducts();
    GenericProductDTO getProductByID(Long productID);
    GenericProductDTO createProduct(Product product);
    GenericProductDTO deleteProductByID(Long productID);
    GenericProductDTO updateProductByID(FakeStoreProductDTO product, Long productID);
}
