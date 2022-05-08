package fr.kleecontrib.port;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class BCryptTest {

	@Test
	void bCrypt() {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String pwdEncoded = bcrypt.encode("test");
		Assertions.assertThat(bcrypt.matches("test", pwdEncoded)).isTrue();
	}
}
