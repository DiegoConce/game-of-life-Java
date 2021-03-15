package it.unicam.cs.pa.jlife104936.model;

@FunctionalInterface
public interface Regola {

    Cellula applyRules(int numOfNeighbours, Cellula cell);
}
