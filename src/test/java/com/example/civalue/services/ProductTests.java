package com.example.civalue.services;

import com.example.civalue.client.InternalDataClient;
import com.example.civalue.daos.ProductDAO;
import com.example.civalue.repositories.ProductRepository;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductTests {
    @InjectMocks
    Product product = spy(Product.class);

    @Mock
    InternalDataClient internalDataClient;
    @Mock
    ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validProductFromDataClient_ProductDAOStored() {
        doReturn(new Product("ABC", "CAT", "BRA"))
                .when(this.internalDataClient).getProductMeta(any());
        ArgumentCaptor<ProductDAO> argument = ArgumentCaptor.forClass(ProductDAO.class);
        this.product.saveProductMeta("ABC");
        verify(this.productRepository, times(1)).save(argument.capture());
        assertEquals("ABC", argument.getValue().getProductId());
        assertEquals("CAT", argument.getValue().getCategory());
        assertEquals("BRA", argument.getValue().getBrand());
    }
}
