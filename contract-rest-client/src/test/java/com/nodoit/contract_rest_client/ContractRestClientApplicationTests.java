package com.nodoit.contract_rest_client;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nodoit.contract_rest_client.model.Person;

@SpringBootTest
@AutoConfigureStubRunner(
		// run server in port 8100
		ids = "com.nodoit:contract-rest-service:0.0.1-SNAPSHOT:stubs:8100",
		// local jar from .m2/
		stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ContractRestClientApplicationTests {

	@Test
	void getPersonFromServiceContract() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Person> response = restTemplate.getForEntity("http://localhost:8100/person/1", Person.class);

		BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
		BDDAssertions.then(response.getBody().getId()).isEqualTo(1L);
		BDDAssertions.then(response.getBody().getName()).isEqualTo("foo");
		BDDAssertions.then(response.getBody().getSurname()).isEqualTo("bee");
	}

}
