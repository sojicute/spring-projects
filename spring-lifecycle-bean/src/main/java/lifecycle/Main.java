package lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		CoinService coin = context.getBean(CoinService.class);
		while (true) {
			coin.showCoinValue();
			Thread.sleep(2000);
		}
	}

}
