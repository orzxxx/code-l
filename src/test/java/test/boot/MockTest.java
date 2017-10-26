package test.boot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import test.boot.service.impl.ForTestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {
	
	@MockBean
	private ForTestServiceImpl service;
	
	@Test
	public void f1Test() {
		given(service.f1()).willReturn("f1");
		assertThat(service.f1()).isEqualTo("f2");
	}
}
