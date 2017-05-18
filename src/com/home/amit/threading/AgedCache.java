package com.home.amit.threading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AgedCache<K, V> {

	private static final int DEFAULT_CAPACITY = 100;

	private Map<K, V> cache;
	private DelayQueue<AgedKey> ageQueue;
	private ScheduledExecutorService removeOldElementsService;
	private ReadWriteLock lock;

	class AgedKey implements Delayed {

		private static final long DEFAULT_DELAY_INTERVAL = 5;

		private final long createdAt = System.currentTimeMillis();
		private final long maxAge;
		private final TimeUnit delayType;
		private final K key;

		public AgedKey(K key) {
			this(key, DEFAULT_DELAY_INTERVAL, TimeUnit.SECONDS);

		}

		public AgedKey(K key, long maxAge, TimeUnit delayType) {
			this.key = key;
			this.maxAge = maxAge;
			this.delayType = delayType;
		}

		public K getKey() {
			return key;
		}

		@Override
		public int compareTo(Delayed o) {
			return Long.compare(this.getDelayMillis(),
					((AgedKey) o).getDelayMillis());
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long delayMillis = getDelayMillis();
			return unit.convert(delayMillis, TimeUnit.MILLISECONDS);
		}

		private long getDelayMillis() {
			return (createdAt + TimeUnit.MILLISECONDS
					.convert(maxAge, delayType)) - System.currentTimeMillis();
		}
	}

	private class RemovalHandler implements Runnable {
		public void run() {
			AgedKey key;
			while ((key = ageQueue.poll()) != null) {
				cache.remove(key.getKey());
			}
		}
	}

	public AgedCache() {
		this(DEFAULT_CAPACITY);
	}

	public AgedCache(int initCapacity) {
		cache = new ConcurrentHashMap<K, V>(initCapacity);
		ageQueue = new DelayQueue<AgedKey>();
		removeOldElementsService = Executors.newSingleThreadScheduledExecutor();
		removeOldElementsService.scheduleWithFixedDelay(new RemovalHandler(),
				1, 5, TimeUnit.MILLISECONDS);
		lock = new ReentrantReadWriteLock();
	}

	public boolean containsKey(K key) {
		try {
			lock.readLock().lock();
			return cache.containsKey(key);
		} finally {
			lock.readLock().unlock();
		}
	}

	public boolean containsValue(V value) {
		try {
			lock.readLock().lock();
			return cache.containsValue(value);
		} finally {
			lock.readLock().unlock();
		}
	}

	public void put(K key, V value) {
		try {
			lock.writeLock().tryLock();

			V oldVal = cache.putIfAbsent(key, value);
			if (oldVal != null) {
				ageQueue.remove(key);
			}
			ageQueue.add(new AgedKey(key));
		} finally {
			lock.writeLock().unlock();
		}
	}

	public V get(K key) {
		try {
			lock.readLock().lock();
			return cache.get(key);
		} finally {
			lock.readLock().unlock();
		}
	}

	public V remove(K key) {
		try {
			V removedKey = null;
			lock.writeLock().lock();
			removedKey = cache.remove(key);
			ageQueue.remove(key);
			return removedKey;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public synchronized void clear() {
		cache.clear();
		ageQueue.clear();
	}

	public int size() {
		return cache.size();
	}
}
