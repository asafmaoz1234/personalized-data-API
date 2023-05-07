package com.example.civalue.client;

import com.example.civalue.services.Product;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@Ignore
public class InternalDataClientTests {
    @Spy
    InternalDataClient internalDataClient = spy(InternalDataClient.class);

    @Test
    void validProductId_validProductMeta() {
        doReturn("https://mocki.io/v1/774a42e6-a51f-45e4-b7f3-792a96f5281f")
                .when(this.internalDataClient).getUrl(anyString(), anyString());
        Product response = internalDataClient.getProductMeta("BB-2144746855");
        assertEquals(response.getCategory(), "Babies");
        assertEquals(response.getProductId(), "BB-2144746855");
        assertEquals(response.getBrand(), "Babyom");
    }

    @Test
    void validShopperId_3ProductsList() {
        doReturn("https://mocki.io/v1/132cc5fc-65cb-4294-be22-69c89d5e6a4b")
                .when(this.internalDataClient).getUrl(anyString(), anyString());
        List<Product> response = internalDataClient.getShopperProductsData("10");
        assertEquals(response.size(), 3);
    }
}
