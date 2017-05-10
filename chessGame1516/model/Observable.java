/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxime
 */
public abstract class Observable {
    
    protected List<Observer> observers = new ArrayList<Observer>();
    
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    
    public void notifies(Object o) {
        for (Observer observer : this.observers) {
            observer.update(o);
        }
    }
    
}
