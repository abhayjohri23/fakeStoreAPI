package com.fakeStore.springBootBE.Services;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductByIDRequestURL = "https://fakestoreapi.com/products/{id}";
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
    public String createProduct() {
        return "Product created in this service";
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
