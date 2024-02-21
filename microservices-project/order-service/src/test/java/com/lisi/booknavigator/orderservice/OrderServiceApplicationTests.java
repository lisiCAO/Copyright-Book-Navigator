package com.lisi.booknavigator.orderservice;

import com.lisi.booknavigator.orderservice.dto.OrderLineItemsDto;
import com.lisi.booknavigator.orderservice.dto.OrderRequest;
import com.lisi.booknavigator.orderservice.reponsitory.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest
class OrderServiceApplicationTests {

	@Container
	static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.26")
			.withDatabaseName("testdb")
			.withUsername("test")
			.withPassword("test");

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", mySQLContainer::getUsername);
		registry.add("spring.datasource.password", mySQLContainer::getPassword);
	}

	@Test
	void shouldPlaceOrder() throws Exception{
		OrderLineItemsDto lineItem= getLineItem();
		OrderRequest orderRequest= getOrderRequest(lineItem);


		String orderRequestString = objectMapper.writeValueAsString(orderRequest);

		mockMvc.perform(post("/api/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(orderRequestString))
				.andExpect(status().isCreated());

	}

	private OrderLineItemsDto getLineItem() {
		return OrderLineItemsDto.builder()
				.skuCode("SKU123")
				.price(BigDecimal.valueOf(1200))
				.quantity(1)
				.build();
	}

	private OrderRequest getOrderRequest(OrderLineItemsDto lineItem) {
		return new OrderRequest(Collections.singletonList(lineItem));
	}

}
