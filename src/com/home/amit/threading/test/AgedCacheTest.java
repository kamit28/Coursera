package com.home.amit.threading.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.home.amit.threading.AgedCache;

public class AgedCacheTest {

	@Test
	public final void testPut() throws InterruptedException {
		AgedCache<Integer, Integer> agedCache = new AgedCache<>(20);
		for (int i = 0; i < 10; i++) {
			agedCache.put(i, i);
		}

		// Should return values here;
		assertTrue(agedCache.get(0) == 0);
		assertTrue(agedCache.get(9) == 9);

		// Should return size as 10
		assertEquals(agedCache.size(), 10);

		// Let the cache expire
		Thread.sleep(5005);
		// should return map size as 0
		assertTrue(agedCache.size() == 0);
		// should not return any object from map
		assertEquals(agedCache.get(1), null);
	}

	@Test
	public final void testGet() throws InterruptedException {
		AgedCache<String, String> agedCache = new AgedCache<>();
		agedCache.put("Amit", "Kumar");
		agedCache.put("Sumit", "Kumar");

		assertNotNull(agedCache.get("Amit"));
		assertNotNull(agedCache.get("Sumit"));
		assertNull(agedCache.get("Rohit"));
		assertEquals(agedCache.get("Amit"), "Kumar");

		// wait for a little more than default of 5 seconds for expiration
		Thread.sleep(5010);
		assertNull(agedCache.get("Amit"));
		assertNull(agedCache.get("Sumit"));
	}

	@Test
	public final void testRemove() {
		AgedCache<Integer, Integer> agedCache = new AgedCache<>(10);
		for (int i = 0; i < 10; i++) {
			agedCache.put(i, i);
		}

		agedCache.remove(2);

		// Should return null
		assertNull(agedCache.get(2));
		// Size should be 9
		assertTrue(agedCache.size() == 9);
	}

	@Test
	public final void testClear() {
		AgedCache<Integer, Integer> agedCache = new AgedCache<>(10);
		for (int i = 0; i < 10; i++) {
			agedCache.put(i, i);
		}

		// Should return values here;
		assertTrue(agedCache.get(0) == 0);
		assertTrue(agedCache.get(9) == 9);

		// Should return size as 10
		assertEquals(agedCache.size(), 10);

		agedCache.clear();

		// should return size as 0
		assertTrue(agedCache.size() == 0);
	}

	@Test
	public final void testContainsKey() {
		AgedCache<Integer, Integer> agedCache = new AgedCache<>(10);
		for (int i = 0; i < 10; i++) {
			agedCache.put(i, i);
		}

		// Should be true
		assertTrue(agedCache.containsKey(2));

		agedCache.remove(2);

		// Should return null
		assertFalse(agedCache.containsKey(2));
	}

	@Test
	public final void testContainsValue() {
		AgedCache<String, String> agedCache = new AgedCache<>();
		agedCache.put("Amit", "Kumar");
		agedCache.put("Anshu", "Kumari");

		// Should be true
		assertTrue(agedCache.containsValue("Kumari"));
		assertTrue(agedCache.containsValue("Kumari"));

		agedCache.remove("Anshu");

		// Should return null
		assertFalse(agedCache.containsValue("Kumari"));
	}
}
