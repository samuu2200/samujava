package es.samujava.hibernate;

import es.samujava.hibernate.front.CarreraCaballosFront;

public class CarreraCaballosMain {
    public static void main(String[] args) {
        CarreraCaballosFront front = new CarreraCaballosFront("Carrera 1");
        front.iniciaMenuCarrera();
    }
}
