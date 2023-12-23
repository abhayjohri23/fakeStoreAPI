package com.fakeStore.springBootBE.Services;

import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO getProductByID(Long productID) {
        return null;
    }

    @Override
    public String createProduct() {
        return null;
    }

    @Override
    public String deleteProductByID(Long productID) {
        return null;
    }
    @Override
    public String updateProductByID(Long productID){
        return null;
    }
}
