package com.worldbank.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldbank.model.Result;
import com.worldbank.model.Student;
import com.worldbank.service.TestService;
import com.worldbank.service.rest.studentController;

//@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(studentController.class)
@AutoConfigureMockMvc
public class SmokeTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	TestService testService;

	@Autowired
	private ObjectMapper objectMapper;

	String contentJson = "{\"name\":\"chinmoy\",\"roll\":20}";

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		Student student = new Student();
		student.setName("Dong");
		student.setRoll(12);
		Result r = new Result();
		r.setMessage("test message");
		r.setCode(10);
		Mockito.when(testService.method1(student)).thenReturn(r);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/test").accept(MediaType.APPLICATION_JSON)
				.content(contentJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult m = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = m.getResponse();
		System.out.println(response.getStatus());
		String contentAsString = response.getContentAsString();
		Result response1 = objectMapper.readValue(contentAsString, Result.class);
		System.out.println(response1.getMessage());

	}
}