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
public class Cola_Vector {
    //atributos
    int Q[]; //usamos un vector
    int Frente; //usamos un vector (primero)
    int Atras;////un indice llamado Atras ultimo
    //

    public Cola_Vector(int cant) {
      Q=new int[cant];
      Frente=-1;
      Atras=-1;
    }
    
    public boolean vacia(){
        return Frente==-1;
    }
    public boolean llena(){
        return ((Atras+1)%Q.length)==Frente;
    }
    
    public void Encolar(int elemento){
        if (llena()) {
            System.out.println("Error cola llena");
            return;
        }else{
            //int a=Atras+1;
             
            Atras=(Atras+1)%Q.length;
           // System.out.println(Atras);
            if (vacia()) {
                Frente=Atras;
            }
            Q[Atras]=elemento;
            
        }
    }
    
    public int decolar(){
        int x=Q[Frente];
        if (Frente==Atras) {
            Frente=-1;
            Atras=-1;
        }else{
          Frente=(Frente+1)%Q.length;  
        }
        return x;
    }
    
    public int get(){
        return Q[Frente];
    }
    
    
    
    
    
    
    
    
    
    public String toString(){
        String S="Q={";//Frente=(Frente+1)%Q.length;  
        for (int i = Frente; i != Atras; i=(i+1)%Q.length) {
            S=S+Q[i]+" | ";
        }
        if (!vacia()) {
            S=S+Q[Atras];
        }
        return  S+"}";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        Cola_Vector A=new Cola_Vector(5);
        
        
        A.Encolar(23);
         A.Encolar(28);
          A.Encolar(50);
          System.out.println(A);
    }
    
    
    
    
    
    
    
}
