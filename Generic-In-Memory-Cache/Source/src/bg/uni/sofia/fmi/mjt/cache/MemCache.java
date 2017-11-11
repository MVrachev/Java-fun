package bg.uni.sofia.fmi.mjt.cache;

import java.time.LocalDateTime;
import java.util.HashMap;


public class MemCache<K, V> implements Cache<K, V> {

	private long MAX_CAPACITY;
	private HashMap<K,Pair<V,LocalDateTime>> container;
	private int getTries;
	private int hits;
	
	public MemCache() {
		MAX_CAPACITY = 1000;
		container = new HashMap<>();
	}

	public MemCache(long capacity) {
		MAX_CAPACITY = capacity;
		container = new HashMap<K, Pair<V,LocalDateTime>>();
	}
	
	public boolean isExpired(LocalDateTime currentElement) {
		
		if(currentElement.isBefore(LocalDateTime.now()))
			return true;
		return false;
		
	}
	
	public boolean allExpired(){
		Pair<V, LocalDateTime> current = new Pair<>();
		for(K key: container.keySet()) {
			current = container.get(key);
			if(!isExpired(current.getSecond())) {
				return false;
			}
		}
		return true;
	}
	
	public  V get(K key) {
		++getTries;
		LocalDateTime keyExpirationDate = getExpiration(key);
		if(keyExpirationDate != null) {
			++hits;
			if(isExpired(keyExpirationDate)) {
				container.remove(key);
			}
		}
		return null;
	}
	
	public void removeAnExpired() {
		Pair<V, LocalDateTime> current = new Pair<>();
		for(K key: container.keySet()) {
			current = container.get(key);
			if(isExpired(current.getSecond())) {
				container.remove(key);
				return;
			}
		}
	}
	
	// I need mine exception
	@Override
	public void set(K key, V value, LocalDateTime expiresAt) throws CapacityExceededException {
		
		if(container.size() > MAX_CAPACITY && allExpired())
			throw new CapacityExceededException();
		if(key == null || value == null)
			return;
		if(container.size() > MAX_CAPACITY && !allExpired()) {
			removeAnExpired();
		}
		Pair<V,LocalDateTime> newPair = new Pair<>(value,expiresAt);
		if(container.containsKey(key)) {
			container.put(key, newPair);
		}
			
	}

	@Override
	public LocalDateTime getExpiration(K key) {
		Pair<V,LocalDateTime> curr = container.get(key);
		return curr == null ? null : curr.getSecond();
	}

	@Override
	public boolean remove(K key) {
		if(container.containsKey(key)) {
			container.remove(key);
			return true;
		}
		return false;
	}

	@Override
	public long size() {
		return container.size();
	}

	@Override
	public void clear() {
		container.clear();
		hits = 0;
		getTries = 0;
	}

	@Override
	public double getHitRate() {
		if(hits == 0)
			return 0;
		return hits/getTries;
	}

}
