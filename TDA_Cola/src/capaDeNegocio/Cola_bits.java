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
public class Cola_bits {
 //atributos
    Vectorbit Q; //usamos un vector
    int Frente; //usamos un vector (primero)
    int Atras;////un indice llamado Atras ultimo
    //

    public Cola_bits(int cant,int nbits) {
      Q=new Vectorbit(cant, nbits);
      Frente=0;
      Atras=0;
    }
    
    public boolean vacia(){
        return Frente==0;
    }
    public boolean llena(){
        return ((Atras+1)%Q.dim)==Frente;
    }
    
    public void Encolar(int elemento){
        if (vacia()) {
          Frente++;
          Atras++;
          Q.insertar(elemento, Atras);
        }else{
            if (!llena()) {//si tienes espacios
                 Atras=(Atras+1)%Q.dim;
                   Q.insertar(elemento, Atras);
            }else{
                 System.out.println("Error cola llena");
                return;
            }
 
        }
    }
    
    public int decolar(){
        int x=Q.sacar(Frente);
        if (Frente==Atras) {
            Frente=0;
            Atras=0;
        }else{
          Frente=(Frente+1)%Q.dim;  
        }
        return x;
    }
    
    public int get(){
        return Q.sacar(Frente);
    }
    
    
    
    
    
    
    
    
    
    public String toString(){
        String S="Q={";//Frente=(Frente+1)%Q.length;  
        for (int i = Frente; i != Atras; i=(i+1)%Q.dim) {
            S=S+Q.sacar(i)+" | ";
        }
        if (!vacia()) {
            S=S+Q.sacar(Atras);
        }
        return  S+"}";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        Cola_bits A=new Cola_bits(10,7);
        
        
        A.Encolar(23);
         A.Encolar(28);
          A.Encolar(50);
          System.out.println(A);
    }
    
    
    
    
    
}
