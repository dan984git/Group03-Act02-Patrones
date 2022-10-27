package ec.edu.ups.patron.adapter.temperatura;

import java.util.Random;

public class MockTemperatura {
	public static int temperaturaRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

}
