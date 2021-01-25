package com.mc.connection;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class PathCheckTest extends PathAbstractTest {
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void philadelphia2Albany() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Albany"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}
	
	
	@Test
	public void boston2Newark() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Newark"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("yes", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void boston2Philadelphia() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Philadelphia"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("yes", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void phil2phil() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Philadelphia"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void badReq() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("orgin", "Trenton").param("destination", "Boston"))
				.andReturn();

		assertEquals(400, mvcResult.getResponse().getStatus());
	}

	
	@Test
	public void trenton2Boston() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Trenton").param("destination", "Boston"))
				.andReturn();

		assertEquals("no", mvcResult.getResponse().getContentAsString());
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void error() throws Exception {
		String uri = "/cnnected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Phil").param("destination", "Albny"))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}


}