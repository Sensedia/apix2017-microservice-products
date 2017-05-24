package com.sensedia.apix.database;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sensedia.apix.product.IProductRepository;
import com.sensedia.apix.product.Product;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by renanpetronilho on 23/04/17.
 */
@Component
public class DatabaseCreate implements CommandLineRunner {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private IProductRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        repository.save(readerJson("classpath:database/database_celulares.json"));
        repository.save(readerJson("classpath:database/database_iphone.json"));
    }

    private List<Product> readerJson(String resource) throws IOException {
        String json = IOUtils.toString(resourceLoader.getResource(resource).getInputStream());
        List<Product> products = parseAsListOf(Product.class, json);
        return products;
    }

    public static <T> List<T> parseAsListOf(Class<T> klass, String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<T> result = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, klass));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
