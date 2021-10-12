package lifecycle;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	
	@Bean
	@Scope("periodical")
	public Coin coin() {
		Random random = new Random();
		return new Coin(random.nextDouble());
	}
	
	@Bean
	public CoinService coinService() {
		return new CoinService() {

			@Override
			public Coin getCoin() {
				return coin();
			}
			
			
		};
	}
	
}
