package dawan.filrouge.service;

public class RandomService {
	
	public int getNumber(int a, int b) {
		return (int) (Math.random()*(a-b))+b;
	}

}
