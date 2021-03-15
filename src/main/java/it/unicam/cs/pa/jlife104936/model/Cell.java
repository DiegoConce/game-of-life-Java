package it.unicam.cs.pa.jlife104936.model;

public class Cell implements Cellula {

    private boolean status;

    @Override
    public boolean isAlive() {
        return status;
    }

    @Override
    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }

}
