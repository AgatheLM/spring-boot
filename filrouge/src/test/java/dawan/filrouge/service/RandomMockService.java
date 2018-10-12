package dawan.filrouge.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import dawan.filrouge.service.RandomService;

import org.mockito.Mockito;

@Profile("test")
@Configuration
public class RandomMockService {

		@Bean
		@Primary
		public RandomService randomService() {
			return Mockito.mock(RandomService.class);
		}
}
