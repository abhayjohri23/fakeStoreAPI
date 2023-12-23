package com.fakeStore.springBootBE.Services;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;
    private String getAllProductRequestURL = "https://fakestoreapi.com/products";
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestURL = "https://fakestoreapi.com/products/{id}";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO getProductByID(Long productID) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        return null;
    }

    @Override
    public GenericProductDTO createProduct() {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        return null;
    }

    @Override
    public GenericProductDTO deleteProductByID(Long productID) {
        return null;
    }
}
