/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rudy_DEAL
 */
public class MouvementNormalFactory implements AbstractMouvementFactory{
    
    //private static MouvementNormalFactory instance;

    public MouvementNormalFactory() {}
    
    /*
    public MouvementNormalFactory getInstance() {
        if (instance == null) {
            instance = new MouvementNormalFactory();
        }
        return this.instance;
    }*/
    
    
    

    @Override
    public Mouvement getMouvement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
