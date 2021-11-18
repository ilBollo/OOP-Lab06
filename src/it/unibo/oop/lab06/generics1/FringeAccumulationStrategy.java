package it.unibo.oop.lab06.generics1;

import java.util.Deque;

public interface FringeAccumulationStrategy<S> {
	
	void addToFringe(Deque<? super S> fringe, S step);

}
