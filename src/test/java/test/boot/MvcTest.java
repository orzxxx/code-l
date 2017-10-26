package test.boot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import test.boot.controller.ForTestController;
import test.boot.dao.TProdInfoDao;
import test.boot.service.impl.ProdInfoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ForTestController.class)
public class MvcTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private TProdInfoDao tProdInfoDao;
	
	@MockBean
	private ProdInfoServiceImpl impl;
	
	@Test
	public void saveTest() throws Exception {
		mvc.perform(post("/save"))
		.andExpect(content().string("1"));
	}
}
