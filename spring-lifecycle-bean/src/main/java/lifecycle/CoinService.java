package lifecycle;

import org.springframework.stereotype.Service;



@Service
public abstract class CoinService {
	public abstract Coin getCoin();
	
	public void showCoinValue() {
		System.out.println(getCoin().getValue());
	}
}
