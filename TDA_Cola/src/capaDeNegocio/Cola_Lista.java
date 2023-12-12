/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeNegocio;

/**
 *
 * @author ferna
 */
public class Cola_Lista {
    Nodo Frente;
    Nodo Atras;
    int cantidad;

    public Cola_Lista() {
        Frente=null;
        Atras=null;
        cantidad=0;
    }
    
    public boolean vacia(){
        return Atras==null;
    }
    
    public void encolar(int elemento){
        if (vacia()) {//si
           Nodo p=new Nodo(elemento);
           Frente=p;
           Atras=p;
           cantidad++;
           
        }else{
             Nodo p=new Nodo(elemento);
             Atras.setEnlace(p);
             Atras=p;
             cantidad++;
        }
    }
    
    public int decolar(){
        int x=Frente.getDato();
        if (Frente==Atras) {
            Frente=null;
            Atras=null;
        }else{
            Frente=Frente.getEnlace();
            cantidad--;
        }
        return x;
    }
    
    public int get(){
        return Frente.getDato();
    }
    
    
    public String toString(){
        String S="Frente ";
        int y;
        for (int i = 1; i <=cantidad; i++) {
            y=decolar();
            S=S+y+" ";
            encolar(y);
        }
        return  S+"Atras";
    }
    
    
    
      
    public static void main(String[] args) {
        Cola_Lista A=new Cola_Lista();
        
        
        A.encolar(11);
         A.encolar(10);
          A.encolar(25);
          System.out.println(A);
    }
    
    
}
