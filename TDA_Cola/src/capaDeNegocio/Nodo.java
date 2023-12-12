
package capaDeNegocio;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernandoo 
 * 
 */
public class Nodo {

    int dato;
    // Objet dato para un Nodo general

  Nodo Enlace; //clase de auto referencia
  ///constructor________________________________________________________________________________________________________________
public Nodo(){
    Enlace=null;
    //objet=null;
}
//            Objet dato  
public  Nodo(int dato,Nodo Enlace){
      this.Enlace=Enlace;
      this.dato=dato;
  }
public Nodo(int dato)
    {
        this.dato   =   dato;
        this.Enlace =   null;
    }
/* Aplicando abstraccion  tenemos los siguientes metodos
 ________________
|  dato   |Enlace|
|  set    |  get |
|  get    | set  |------------->
|         |      |
|_________|______|
_____NODO______________

}
//---------------------------------Metodos------------------------------------------------------------------------------
*/
 public void setDato(int dato){
      this.dato=dato;
    }
    public void setEnlace(Nodo p){
      this.Enlace=p;
    }
    public int getDato(){
      return dato;
    }
    public Nodo getEnlace(){
      return Enlace;
    }
    //Mostrar
    @Override
    public String toString(){
      String s="[dato=";
      s=s+getDato();
      return s+"  | ]";
    }
    
    public static void main(String[] args) {
    int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número que quiere ingresar al Nodo "));
        Nodo p =new Nodo();
        p.setDato(dato);
        p.setEnlace(null);
        
        System.out.println(p.toString());
        JOptionPane.showMessageDialog(null, p.toString());
       //[3 |]        
    //-------------------------------------------------------------------------------------------------------------------
        Nodo q =new Nodo(5,null);
        q.setDato(1);
        q.setEnlace(null);
        System.out.println(q.toString());

        //[1 |]
    //-------------------------------------------------------------------------------------------------------------------
         Nodo r =new Nodo();
         r.setDato(2);
         r.setEnlace(null);
         System.out.println(r.toString());
         // [2 |]
    //-------------------------------------------------------------------------------------------------------------------
        //como ordenar los elementos ??
         q.setEnlace(r);
         r.setEnlace(p);
         p.setEnlace(q);
          System.out.println("-----------ordenado seria----------");
          System.out.println(q.toString());
          System.out.println(r.toString());
          System.out.println(p.toString());
          /*[1 |]
            [2 |]
            [3 |]
            una lista son secuencias 
           */
          
          System.out.println("---------------------");
          
          p.getEnlace().getEnlace().getEnlace();
           System.out.println(p.toString());
       ///[dato=3  | ]
    
       p.setDato(8);
       p.setEnlace(null);
        System.out.println(p.toString());
        //[dato=8  | ]
        int x=p.getDato();
        System.out.println(x);//8
        
       // Nodo r=new Nodo(0,p.getEnlace());
        //Nodo q=new Nodo();
        q.setDato(2);
        q.setEnlace(null);
        System.out.println(q.toString());
        //[dato=2  | ]
        r.setDato(4);
        System.out.println(r.toString());
        //[dato=4  | ]
        q.setEnlace(r);
        System.out.println(q.toString());
        //[dato=2  | ]
        r.setEnlace(p);
        System.out.println(r.toString());
        
        p.setEnlace(q);
        q.setEnlace(r);
        q.getEnlace().setEnlace(p);
        q.getEnlace().getEnlace().setEnlace(q);
        System.out.println(q.toString());
        

    }
}