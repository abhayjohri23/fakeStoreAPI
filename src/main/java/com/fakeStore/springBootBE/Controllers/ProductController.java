package com.fakeStore.springBootBE.Controllers;
import com.fakeStore.springBootBE.DTOs.ExceptionDTO;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Exceptions.FormatException;
import com.fakeStore.springBootBE.Exceptions.NoRecordFoundException;
import com.fakeStore.springBootBE.ModelsOrEntities.Product;
import com.fakeStore.springBootBE.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;
    public ProductController(@Qualifier(value = "FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("all")
    public List<GenericProductDTO> getAllProducts() throws NoRecordFoundException, FormatException {
        return productService.getAllProducts();
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<ExceptionDTO> handleExceptionForNoRecords(){
        return new ResponseEntity(new ExceptionDTO(404,"Record is not found"), HttpStatus.ACCEPTED);
    }
    //Exception DTO is used here to return the exception deserialized by the dispatcher to JSON Output: {404,Record not found}.
    //If you want to manipulate the Postman response or the header metadata for the kind of response (Status code of Postman), return the ResponseEntity<>
    //which has both body of the message and metadata (E.g. header data like status code) in it.
    @ExceptionHandler(FormatException.class)
    public String handleExceptionForFormatOfAPI(FormatException formatException){
        return formatException.getMessage();
    }

    @PostMapping("add")
    public GenericProductDTO createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductByID(@PathVariable("id") Long productID){
        return productService.getProductByID(productID);
    }
    @DeleteMapping("{id}")
    public GenericProductDTO deleteProductByID(@PathVariable("id") Long productID){
        return productService.deleteProductByID(productID);
    }
    @PostMapping("{id}")
    public GenericProductDTO updateProductByID(@PathVariable("id") Long productID,@RequestBody FakeStoreProductDTO product){
        return productService.updateProductByID(product,productID);
    }
}
