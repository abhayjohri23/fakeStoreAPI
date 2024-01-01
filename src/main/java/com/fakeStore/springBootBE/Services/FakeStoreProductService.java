package com.fakeStore.springBootBE.Services;
import com.fakeStore.springBootBE.ClientService.FakeStoreProductClientService;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Exceptions.FormatException;
import com.fakeStore.springBootBE.Exceptions.NoRecordFoundException;
import com.fakeStore.springBootBE.Models.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private final FakeStoreProductClientService fakeStoreProductClientService;
    public FakeStoreProductService(FakeStoreProductClientService fakeStoreProductClientService){
        this.fakeStoreProductClientService = fakeStoreProductClientService;
    }
    @Override
    public List<GenericProductDTO> getAllProducts() throws NoRecordFoundException,FormatException {
        List<GenericProductDTO> list = fakeStoreProductClientService.getAllProducts();
        return list;
    }

    @Override
    public GenericProductDTO getProductByID(Long productID) {
        return fakeStoreProductClientService.getProductByID(productID);
    }

    @Override
    public GenericProductDTO createProduct(Product productDTO) {
        return fakeStoreProductClientService.createProduct(productDTO);
    }

    @Override
    public GenericProductDTO deleteProductByID(Long productID) {
        return fakeStoreProductClientService.deleteProductByID(productID);
    }
    @Override
    public GenericProductDTO updateProductByID(FakeStoreProductDTO product,Long productID){
        return fakeStoreProductClientService.updateProductByID(product,productID);
    }
}
