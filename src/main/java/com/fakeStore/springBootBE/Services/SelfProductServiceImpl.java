package com.fakeStore.springBootBE.Services;

import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Exceptions.NoRecordFoundException;
import com.fakeStore.springBootBE.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public List<GenericProductDTO> getAllProducts() throws NoRecordFoundException {
        return null;
    }

    @Override
    public GenericProductDTO getProductByID(Long productID) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(Product productDTO) {
        return null;
    }

    @Override
    public GenericProductDTO deleteProductByID(Long productID) {
        return null;
    }
    @Override
    public GenericProductDTO updateProductByID(FakeStoreProductDTO product, Long productID){
        return null;
    }
}
