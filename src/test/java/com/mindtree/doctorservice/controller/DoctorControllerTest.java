package com.mindtree.doctorservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.doctorservice.entity.DoctorEntity;
import com.mindtree.doctorservice.pojo.Doctor;
import com.mindtree.doctorservice.service.DoctorService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers= DoctorController.class)
@WebAppConfiguration
public class DoctorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DoctorService doctorService;
	
	@Test
	public void testAddDoctor() throws Exception {
		
		DoctorEntity mockDoctor = new DoctorEntity();
		mockDoctor.setId(1);
		mockDoctor.setName("Dr Krupali");
		mockDoctor.setAge(25);
		mockDoctor.setGender("female");
		mockDoctor.setSpecialised("Cardiologist");
		String inputInJson = this.mapToJson(mockDoctor);
		String URI ="/addDoctor";
		MockHttpServletRequestBuilder requestBuilder =MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
		
	}
	
	@Test
	public void testGetAllDoctor() throws Exception {
		List<Doctor> doctorEntities = new ArrayList<>();
		Doctor mockDoctor = new Doctor();
		mockDoctor.setId(1);
		mockDoctor.setName("Dr Krupali");
		mockDoctor.setAge(25);
		mockDoctor.setGender("female");
		mockDoctor.setSpecialised("Cardiologist");
		doctorEntities.add(mockDoctor);
		
		String inputInJson = this.mapToJson(doctorEntities);
		String URI ="/getDoctorList";
		
		when(doctorService.getAllDoctors()).thenReturn(doctorEntities);
		MockHttpServletRequestBuilder requestBuilder =MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(inputInJson, outputInJson);
		
	}
	
	@Test
	public void testDoctorById() throws Exception {
		DoctorEntity mockDoctor = new DoctorEntity();
		mockDoctor.setId(1);
		mockDoctor.setName("Dr Krupali");
		mockDoctor.setAge(25);
		mockDoctor.setGender("female");
		mockDoctor.setSpecialised("Cardiologist");
		
		String inputInJson = this.mapToJson(mockDoctor);
		when(doctorService.getDoctor(1)).thenReturn(mockDoctor);
		String URI ="/getDoctor/1";
		MockHttpServletRequestBuilder requestBuilder =MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(inputInJson, outputInJson);
	}
	
//	Maps an object into json string
	private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
	
	

}
