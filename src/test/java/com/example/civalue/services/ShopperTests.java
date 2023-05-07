package com.example.civalue.services;

import com.example.civalue.client.InternalDataClient;
import com.example.civalue.daos.ShopperProductsDAO;
import com.example.civalue.repositories.ShopperProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ShopperTests {
    @InjectMocks
    Shopper shopper = spy(Shopper.class);

    @Mock
    InternalDataClient internalDataClient;
    @Mock
    ShopperProductRepository shopperProductRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validShopperId_ShopperProductsListSaved() {
        List<Product> shopperProducts = new ArrayList<>();
        shopperProducts.add(new Product("ABC", 23.33346457567));
        shopperProducts.add(new Product("DEF", 56.2542345345));
        shopperProducts.add(new Product("GHI", 99.2542345345));
        doReturn(shopperProducts)
                .when(this.internalDataClient).getShopperProductsData(any());
        Class<ArrayList<ShopperProductsDAO>> listClass = (Class<ArrayList<ShopperProductsDAO>>)(Class)ArrayList.class;
        ArgumentCaptor<ArrayList<ShopperProductsDAO>> argument = ArgumentCaptor.forClass(listClass);
        this.shopper.saveShopperProducts("2-ER");
        verify(this.shopperProductRepository, times(1)).saveAll(argument.capture());
        assertEquals("ABC", argument.getValue().get(0).getProductId());
        assertEquals(23.33346457567, argument.getValue().get(0).getRelevancyScore());
        assertEquals("DEF", argument.getValue().get(1).getProductId());
        assertEquals("GHI", argument.getValue().get(2).getProductId());
        assertEquals("2-ER", argument.getValue().get(2).getShopperId());
    }
}
