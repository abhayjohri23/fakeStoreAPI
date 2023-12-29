package com.fakeStore.springBootBE.Services;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Exceptions.FormatException;
import com.fakeStore.springBootBE.Exceptions.NoRecordFoundException;
import com.fakeStore.springBootBE.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;
    private final String baseRequestURL = "https://fakestoreapi.com/products/{id}";
    private final String getProductURL = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<GenericProductDTO> getAllProducts() throws NoRecordFoundException,FormatException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(getProductURL,FakeStoreProductDTO[].class);

        if(responseEntity == null)
            throw new NoRecordFoundException("Record not found");

        FakeStoreProductDTO[] listOfProducts = responseEntity.getBody();
        if(listOfProducts == null)
            throw new FormatException("API Format issues");

        return getGenericProductDTOList(listOfProducts);
    }

    private static List<GenericProductDTO> getGenericProductDTOList(FakeStoreProductDTO[] listOfProducts) {
        List<GenericProductDTO> answer = new ArrayList<>();

        for(FakeStoreProductDTO productResponse: listOfProducts){
            GenericProductDTO genericProductDTO = new GenericProductDTO();

            genericProductDTO.setId(productResponse.getId());
            genericProductDTO.setPrice(productResponse.getPrice());
            genericProductDTO.setImage(productResponse.getImage());
            genericProductDTO.setTitle(productResponse.getTitle());
            genericProductDTO.setCategory(productResponse.getCategory());
            genericProductDTO.setDescription(productResponse.getDescription());

            answer.add(genericProductDTO);
        }
        return answer;
    }

    @Override
    public GenericProductDTO getProductByID(Long productID) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(baseRequestURL, FakeStoreProductDTO.class,productID);

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
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.postForEntity(getProductURL,productDTO, FakeStoreProductDTO.class);

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
    public GenericProductDTO deleteProductByID(Long productID) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.exchange(baseRequestURL, HttpMethod.DELETE,null,FakeStoreProductDTO.class,productID);

        FakeStoreProductDTO response = responseEntity.getBody();
        GenericProductDTO productDTO = new GenericProductDTO();

        productDTO.setId(response.getId());
        productDTO.setTitle(response.getTitle());
        productDTO.setDescription(response.getDescription());
        productDTO.setImage(response.getImage());
        productDTO.setCategory(response.getCategory());
        productDTO.setPrice(response.getPrice());

        return productDTO;
    }
    @Override
    public GenericProductDTO updateProductByID(FakeStoreProductDTO product,Long productID){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO response = restTemplate.postForEntity(baseRequestURL,product,FakeStoreProductDTO.class,productID).getBody();
//        FakeStoreProductDTO response = responseEntity.getBody();
        GenericProductDTO productDTO = new GenericProductDTO();

        productDTO.setId(response.getId());
        productDTO.setTitle(response.getTitle());
        productDTO.setDescription(response.getDescription());
        productDTO.setImage(response.getImage());
        productDTO.setCategory(response.getCategory());
        productDTO.setPrice(response.getPrice());

        return productDTO;
    }
}
