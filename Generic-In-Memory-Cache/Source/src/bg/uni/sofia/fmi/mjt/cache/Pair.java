package bg.uni.sofia.fmi.mjt.cache;

public class Pair<K,V> {

	private K first;
	private V second;
	
	Pair(){}
	Pair(K first, V second){
		this.first = first;
		this.second = second;
	}
	
	public K getFirst() {
		return first;
	}
	public void setFirst(K first) {
		this.first = first;
	}
	public V getSecond() {
		return second;
	}
	public void setSecond(V second) {
		this.second = second;
	}
	
}
