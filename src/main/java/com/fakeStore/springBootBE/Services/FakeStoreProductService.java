package com.fakeStore.springBootBE.Services;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductByIDRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProductURL = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public String getAllProducts() {
        return "All products are displayed";
    }

    @Override
    public GenericProductDTO getProductByID(Long productID) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(getProductByIDRequestURL, FakeStoreProductDTO.class,productID);

        FakeStoreProductDTO productResponse = responseEntity.getBody();
        GenericProductDTO genericProductDTO = new GenericProductDTO();

        if (productResponse != null) {
            genericProductDTO.setId(productResponse.getId());
            genericProductDTO.setPrice(productResponse.getPrice());
            genericProductDTO.setImage(productResponse.getImage());
            genericProductDTO.setTitle(productResponse.getTitle());
            genericProductDTO.setCategory(productResponse.getCategory());
            genericProductDTO.setDescription(productResponse.getDescription());
        }


        return genericProductDTO;
    }

    @Override
    public GenericProductDTO createProduct(Product productDTO) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.postForEntity(createProductURL,productDTO, FakeStoreProductDTO.class);

        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
        GenericProductDTO genericProductDTO = new GenericProductDTO();

        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());

        return genericProductDTO;
    }

    @Override
    public String deleteProductByID(Long productID) {
        return "Product with ID: "+ productID+"is deleted";
    }
    @Override
    public String updateProductByID(Long productID){
        return "Product with productID: "+productID+"is updated";
    }
}
