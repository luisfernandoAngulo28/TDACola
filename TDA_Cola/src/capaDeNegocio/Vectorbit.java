/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeNegocio;

/**
 *
 * @author Fernandoo Angulo AyudantiaSB
 * El 23
 */
public class Vectorbit {
   
  int v[];
  int dim;
  int bit;
  public Vectorbit(int cant,int bit){
      int ne=((cant*bit)/32)+1;     //cantidad de enteros que se necesitan...es decir para 5 elementos 2 enteros de 7bits
          this.bit=bit;                        //  [7/7/7/7/] [7/]   = enteros
       if(bit*cant%32!=0){                           //
           ne++;
       }
         
    v=new int [ne];
    dim = cant;
  }
    public void insertar(int ele,int pos){   // v[pos]=ele
      if (pos<=dim){
           int mask =(int)Math.pow(2,bit)-1;
          ele=ele & mask;
          int ele1=ele;
          int nbit=sacar_nbit(pos);
          int nent=sacar_nent(pos);
          
          mask=mask<<(nbit-1);
          v[nent]=v[nent]&(~mask);
          ele=ele<<(nbit-1);
          v[nent]=v[nent]|ele;
            if (((nbit-1)+bit)>32){
                int nbitf=bit-(32-(nbit-1));
                int mask1=(int)Math.pow(2,nbitf)-1;
                v[nent+1]=v[nent+1]&(~mask1);
                ele1=ele1>>>(bit-nbitf);
               
                v[nent+1]=v[nent+1]|ele1;
            }
      }else{
          System.out.println("fuera de rango");
      }
  }
  public int sacar(int pos){
      int nbit=sacar_nbit(pos);
      int nent=sacar_nent(pos);
      int mask=(int)Math.pow(2,bit)-1;
      mask=mask <<(nbit-1);
      mask= mask & v[nent] ;
      mask=mask >>>(nbit-1);
          if (((nbit-1)+bit)>32){
             int nbitf=bit-(32-(nbit-1));
             int mask1=(int)Math.pow(2,bit)-1;
             mask1=mask1>>(bit-nbitf);
             mask1= mask1 & v[nent+1];
             mask1=mask1<<(bit-nbitf);
             mask=mask |mask1; 
          }
      return mask;
  }
  public int sacar_nbit(int pos){
      return((bit*(pos-1)%32)+1);
  }
  public int sacar_nent(int pos){
      return((bit*(pos-1))/32);
  }

    @Override
    public String toString() {
      String s="V= ";
      for(int i=1;i<=dim;i++){
          s=s+" "+sacar(i);
      }
      return s;
    }
      public static void main(String[] args) {
   Vectorbit a =new Vectorbit(10,8);
 
       a.insertar(10,2);
          a.insertar(81,5);
   
    
        System.out.println(a);
    }
    
}


