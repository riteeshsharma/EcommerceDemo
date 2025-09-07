package dev.riteesh.EcommerceDemo.service;

import dev.riteesh.EcommerceDemo.dtos.FakeStoreProductDto;
import dev.riteesh.EcommerceDemo.exceptions.ProductNotFoundException;
import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    private RedisTemplate redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

        Product productFromRedis = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+productId);
        if(productFromRedis != null){
            return productFromRedis;
        }

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found with Id" + productId);
        }
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_"+productId,fakeStoreProductDto.toProduct());
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNumber) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
