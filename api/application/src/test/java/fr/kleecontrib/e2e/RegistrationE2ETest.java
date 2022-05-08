package fr.kleecontrib.e2e;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import fr.kleecontrib.Application;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
class RegistrationE2ETest {

	@Autowired
	private MockMvc mvc;

	@Test
	void createARegistration() throws Exception {
		mvc.perform(post("/register").content("""
				{
				\t"name":"name",
				\t"firstName":"firstName",
				\t"email":"firstName.name@test.com",
				\t"phoneNumber":"0678951246",
				\t"password":"123456789"
				}""").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
				content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}
