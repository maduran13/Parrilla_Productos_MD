package com.application.products;

import com.application.products.controllers.ProductController;
import com.application.products.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductAvailability() throws Exception {
        List<Integer> expectedProductIds = new ArrayList<>();
        expectedProductIds.add(1);
        expectedProductIds.add(2);
        expectedProductIds.add(3);
        when(productService.getProductsList()).thenReturn(expectedProductIds);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/available"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").value(3));
    }
}
