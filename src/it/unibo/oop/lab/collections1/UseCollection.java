package it.unibo.oop.lab.collections1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int ELEMS = 100_000;
	private static final long TO_MS = 1_000_000;
	private static final int READS = 1_000;
	
	private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	
    	 /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
            	
    	final List<Integer> val = new ArrayList<Integer>();
    	for (int i = 1000; i < 2000; i++) {
    		val.add(i);	
    	}
    	
    	System.out.println(val.toString());
    	
    	/*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
       
    	final List<Integer> val2 = new LinkedList<>(val); 
        
    	System.out.println(val2.toString());

    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final int temp = val.get(val.size() - 1); 
    	val.set((val.size() - 1), val.get(0));
    	val.set(0, temp);
    	System.out.println(val.toString());

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (final int i : val) {
    		System.out.println(i);
    		System.out.println(", ");
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	for (int i = 1; i <= ELEMS; i++) {
            val.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS
                + time
                + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            val2.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS
                + time
                + "ns (" + time / TO_MS + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 1; i <= READS; i++) {
            val.get(val.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + READS
                + time
                + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime();
        for (int i = 1; i <= READS; i++) {
            val2.get(val.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + READS
                + time
                + "ns (" + time / TO_MS + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        final Map<String, Long> world = new HashMap<>();
        world.put("Africa", AFRICA_POPULATION);
        world.put("Americas", AMERICAS_POPULATION);
        world.put("Antarctica", ANTARCTICA_POPULATION);
        world.put("Asia", ASIA_POPULATION);
        world.put("Europe", EUROPE_POPULATION);
        world.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        long tot = 0;
        for (final long population : world.values()) {
        	tot += population;
        }
        System.out.println(world.toString()+"\ntot world population is:" + tot  );
    }
}
