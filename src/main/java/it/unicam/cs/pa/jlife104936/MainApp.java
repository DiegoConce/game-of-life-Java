package it.unicam.cs.pa.jlife104936;

import it.unicam.cs.pa.jlife104936.controller.Controller;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("bela");

        Controller ctrl = new Controller();

        ctrl.init();
        System.out.println(ctrl.getBoard().toString());

        ctrl.applyRules();

        System.out.println(ctrl.getBoard().toString());

        ctrl.applyRules();

        System.out.println(ctrl.getBoard().toString());
    }


}
