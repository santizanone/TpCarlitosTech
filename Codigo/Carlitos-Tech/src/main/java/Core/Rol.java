/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author losmelli
 */
public enum Rol {
    Admin(1),Cajero(2);
    
    private final int id;

    private Rol(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
    public static Rol getRol(int id){
        for(Rol r:Rol.values()){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
    
    
}
