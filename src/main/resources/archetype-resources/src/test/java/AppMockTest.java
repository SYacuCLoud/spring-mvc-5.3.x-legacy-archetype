package ${package};

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ${package}.config.RootConfig;
import ${package}.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/result/MockMvcResultMatchers.html
public class AppMockTest {
	private MockMvc mock;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void initMvc() {
		mock = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testIndex() throws Exception {
		mock.perform(get("/")).andExpect(status().isOk());
	}
}
