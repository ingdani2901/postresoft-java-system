/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


import com.mysql.cj.protocol.Resultset;
import java.awt.HeadlessException;
import java .sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author Danis
 */
public class modelo {
    //Variables de el login para entrar
        private String contra;
        private String usuario;
        private String rol="0";
        private String rol2;
        
      public  Connection conectarMysql(){
      Connection cx = null;
    
      try{
          String url = "jdbc:mysql://localhost:3306/pasteleria";
          String usuario = "root";
          String contraseña = "daniela290104";
          
          cx= DriverManager.getConnection(url,usuario,contraseña);
//          JOptionPane.showMessageDialog(null,"Se conecto a la base de datos: ");
      }catch(SQLException e){
          System.out.print("NO SE CONECTO A LA BASE DE DATOS: ");
          e.printStackTrace();
          
      }
      modelo mod = new modelo();
      mod.setConnection(cx);
      con = cx;
      
      return con;

    
}
//Aquí lo que hice fue la inserción de usuarios dentro de mi base de datos, dentro de la tabla usuarios
  public String usuarioycontra (String usu, String contra,String rol,String Descripcion, String Nombres, String ApePat,String ApeMat,String FechaDeNacimiento){
      
      Connection cx = conectarMysql();
      try{
          //Insertar Persona
          String Per = "INSERT INTO Persona (Nombres,ApePat,ApeMat,FechaDeNacimiento) VALUES (?,?,?,?)";
          PreparedStatement P = cx.prepareStatement(Per,PreparedStatement.RETURN_GENERATED_KEYS);
          try{
          
          P.setString(1, Nombres);
           P.setString(2, ApePat);
            P.setString(3, ApeMat);
             P.setString(4, FechaDeNacimiento);
          
          int filaPerson = P.executeUpdate();
        
          
          int idPerson = 0;
          try(var generatedKeys = P.getGeneratedKeys()){
              if(generatedKeys.next()){
                  idPerson = generatedKeys.getInt(1);
              }else{
                  throw new SQLException("Error al obtener id de rol");
              }
          }
          //Insertar Empleado
          String Emple = "INSERT INTO Empleado (Persona) VALUES (?)";
          PreparedStatement E = cx.prepareStatement(Emple,PreparedStatement.RETURN_GENERATED_KEYS);
          
          E.setInt(1, idPerson);
          
          int filaEmple = E.executeUpdate();
          JOptionPane.showMessageDialog(null,"SE REALIZÓ CORRECTAMENTE");
          
          int idEmple = 0;
          try(var generatedKeys = E.getGeneratedKeys()){
              if(generatedKeys.next()){
                  idEmple = generatedKeys.getInt(1);
              }else{
                  throw new SQLException("Error al obtener id de empleado");
              }
          }
          rol2 = rol;

          String inser = "INSERT INTO Usuario(Nombre, Contraseña, rol ,empleado ) VALUES (?, ?, ?, ?)";
          PreparedStatement statement = cx.prepareStatement(inser);
          
          int r = Integer.parseInt(rol2);
          statement.setString(1, usu);
          statement.setString(2, contra);
          statement.setInt(3, r);
          statement.setInt(4, idEmple);
          
          int filasAfectadas = statement.executeUpdate();
          System.out.println("SE REALIZÓ CORRECTAMENTE");


          cx.close();
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN SER VACIOS/ESCRIBISTE MAL LA FECHA DE NACIMIENTO","ERROR",JOptionPane.ERROR_MESSAGE);
              
          }
          
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR EN LA BASE DE DATOS "+e);
          e.printStackTrace();
          
      }
      return usu + contra + rol + Descripcion+ Nombres + ApePat+ ApeMat+ FechaDeNacimiento;
}
      public String Clientes(String Nombres, String ApellidoPate, String ApellidoMate, String Fecha){
          Connection cx = conectarMysql();
          try{
              String clien = "INSERT INTO Persona(Nombres,ApePat,ApeMat,FechaDeNacimiento)VALUES(?,?,?,?)";
              PreparedStatement cl = cx.prepareStatement(clien, PreparedStatement.RETURN_GENERATED_KEYS);
               
          cl.setString(1, Nombres);
          cl.setString(2, ApellidoPate);
          cl.setString(3, ApellidoMate);
          cl.setString(4, Fecha);
          
          int filascliente = cl.executeUpdate();
         
          
          int idPersona = 0;
           try(var generatedKeys = cl.getGeneratedKeys()){
              if(generatedKeys.next()){
                  idPersona = generatedKeys.getInt(1);
              }else{
                  throw new SQLException("Error al obtener id de rol");
              }
          }
           String cliente = "INSERT INTO Cliente(Persona)VALUES(?)";
           PreparedStatement cl1 = cx.prepareStatement(cliente);
           cl1.setInt(1, idPersona);
           
           int filascl1 = cl1.executeUpdate();
           JOptionPane.showMessageDialog(null,"SE REALIZÓ CORRECTAMENTE");
           cx.close();
         
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"LOS CAMPOS NO PUEDEN SER VACIOS");
          
          
      }
          return Nombres + ApellidoPate + ApellidoMate + Fecha; 
          
          
      }
      public String Proveedor(String Nombres, String ApellidoPate, String ApellidoMate, String Fecha, String Distribuidora){
          Connection cx = conectarMysql();
          try{
              String clien = "INSERT INTO Persona(Nombres,ApePat,ApeMat,FechaDeNacimiento)VALUES(?,?,?,?)";
              PreparedStatement cl = cx.prepareStatement(clien, PreparedStatement.RETURN_GENERATED_KEYS);
               
          cl.setString(1, Nombres);
          cl.setString(2, ApellidoPate);
          cl.setString(3, ApellidoMate);
          cl.setString(4, Fecha);
          
          int filascliente = cl.executeUpdate();
          JOptionPane.showMessageDialog(null,"SE REALIZÓ CORRECTAMENTE");
          
          int idPersona = 0;
           try(var generatedKeys = cl.getGeneratedKeys()){
              if(generatedKeys.next()){
                  idPersona = generatedKeys.getInt(1);
              }else{
                  throw new SQLException("Error al obtener id de proveedor");
              }
           }
           String Proveedor = "INSERT INTO Proveedores(Distribuidora,Persona)VALUES(?,?)";
           PreparedStatement cl2 = cx.prepareStatement(Proveedor);
           cl2.setString(1, Distribuidora);
           cl2.setInt(2, idPersona);
           
           int filasproveedor = cl2.executeUpdate();
           
           cx.close();
           
            }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"LOS CAMPOS NO PUEDEN SER VACIOS");
            }
          
          return Nombres + ApellidoPate + ApellidoMate + Fecha + Distribuidora; 
          
          }

      public class Itempropo{
          private int id;
          private String nom;

        public Itempropo(int id, String nom) {
            this.id = id;
            this.nom = nom;
        }
        public int getId(){
            return id;
        }
          @Override
        public String toString(){
            return nom;
        }
     }
      public String proveypos(JComboBox proveedores,String prove){
           Connection cx = conectarMysql();
           String proveedor = "SELECT persona.nombres, proveedores.id FROM proveedores JOIN persona ON proveedores.persona = persona.id";
           Statement pr;
           try{
               pr = cx.createStatement();
               ResultSet rs = pr.executeQuery(proveedor);
               while(rs.next()){
                   int idp = rs.getInt("id");
                   String n = rs.getString("nombres");
                   proveedores.addItem(new Itempropo(idp, n));
               }
               
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR"+e);
               
           }
 return  proveedor + prove;
      }
      public String Materiales(String Precio,String Cantidad,String Nombre,int Proveedores){
          Connection cx = conectarMysql();
          try{
              String material = "INSERT INTO Materiales(Precio,Cantidad,Nombre,Proveedores)VALUES (?,?,?,?)";
              PreparedStatement mat = cx.prepareStatement(material);
              mat.setString(1, Precio);
              mat.setString(2, Cantidad);
              mat.setString(3, Nombre);
              mat.setInt(4, Proveedores);
              int filasmate = mat.executeUpdate();
              JOptionPane.showMessageDialog(null, "SE REALIZÓ CORRECTAMENTE");
              cx.close();
              
          }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN SER VACIOS");
              
          }
          return Precio + Cantidad + Nombre + Proveedores;
          
      }
       public class Itempedido{
          private int id;
          private String nom;

        public Itempedido(int id, String nom) {
            this.id = id;
            this.nom = nom;
        }
        public int getId(){
            return id;
        }
          @Override
        public String toString(){
            return nom;
        }
     }//BUSCAR ELEMENTOS PARA PEDIDO
       public String buscarelementos(JComboBox Usuario,JComboBox Pago,JComboBox Cliente,JComboBox postres, String nombreusu,String nombrepago, String nombrecliente,String nombrepostres){
           Connection cx = conectarMysql();
           String usuario = "SELECT id, nombre FROM usuario";
           Statement us;
           try{
               us = cx.createStatement();
               ResultSet rs = us.executeQuery(usuario);
               while(rs.next()){
                   int idu = rs.getInt("id");
                   String nom = rs.getString("Nombre");
                   Usuario.addItem(new Itempedido(idu,nom));
               }
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR ELEMENTOS");
           }
           String pago = "SELECT id, tipo FROM pago";
           Statement pg;
           try{
               pg = cx.createStatement();
               ResultSet rs = pg.executeQuery(pago);
               while(rs.next()){
                   int idu = rs.getInt("id");
                   String nom = rs.getString("tipo");
                   Pago.addItem(new Itempedido(idu,nom));
               }
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR ELEMENTOS");
           }
           
           String cliente = "SELECT persona.nombres, cliente.id FROM cliente JOIN persona ON cliente.persona = persona.id";
           Statement cl;
           try{
               cl = cx.createStatement();
               ResultSet rs = cl.executeQuery(cliente);
               while(rs.next()){
                   int idu = rs.getInt("id");
                   String nom = rs.getString("Nombres");
                   Cliente.addItem(new Itempedido(idu,nom));
               }
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR ELEMENTOS"+e);
           }
           String postre = "SELECT id,nombre FROM Postres";
           Statement sta;
            try{
               sta = cx.createStatement();
               ResultSet rs = sta.executeQuery(postre);
               while(rs.next()){
                   int idu = rs.getInt("id");
                   String nom = rs.getString("Nombre");
                   postres.addItem(new Itempedido(idu,nom));
               }
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR ELEMENTOS"+e);
           }
           return usuario + pago + cliente + nombreusu + nombrepago + nombrecliente + postre + nombrepostres;
           
           
           
       }
       public String inserpedido(String Nombre, int idUsuario, int idPago, int idCliente, int idpostres){
            Connection cx = conectarMysql();
            try{
                String pedido = "INSERT INTO Pedido(Nombre,Usuario,Pago,Cliente)VALUES (?,?,?,?)";
                PreparedStatement ts = cx.prepareStatement(pedido,PreparedStatement.RETURN_GENERATED_KEYS);
                ts.setString(1, Nombre);
                ts.setInt(2, idUsuario);
                ts.setInt(3, idPago);
                ts.setInt(4, idCliente);
                int filasinserpedido = ts.executeUpdate();
                 
                 int idpedido = 0;
                 try(var generatedKeys = ts.getGeneratedKeys()){
                     if(generatedKeys.next()){
                         idpedido = generatedKeys.getInt(1);
                     }else{
                         throw new SQLException("Error al obtener id del pedido");
                     }
                 }
                 String pedidopos = "INSERT INTO PedidoPostres(Pedido,Postres)VALUES(?,?)";
                 PreparedStatement pe = cx.prepareStatement(pedidopos);
                 pe.setInt(1, idpedido);
                 pe.setInt(2, idpostres);
                 int filasposped = pe.executeUpdate();
                 JOptionPane.showMessageDialog(null, "SE REALIZÓ PEDIDO CON EXITO");
                 
              cx.close();
                
            }catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR"+e);
                
            }
            return Nombre + idUsuario + idPago + idCliente + idpostres;
           
       }
       public String tabla(String postre1){
           Statement st1;
           ResultSet rs1;
           Connection cx = conectarMysql();
           
           postre1 = "SELECT Id, Nombre, Precio, Inventario FROM postres";
           try{
               st1 = cx.createStatement();
               rs1 = st1.executeQuery(postre1);
               Object[] po1 = new Object[4];
               
               while(rs1.next()){
                   po1 [0] = rs1.getInt("Id");
                   po1 [1] = rs1.getString("Nombre");
                   po1 [2] = rs1.getFloat("Precio");
                   po1 [3] = rs1.getInt("Inventario");
               }
               
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,"ERROR AL INSERTAR"+e);
           }
return postre1;
       }
       
       
       
       
       public class nompos{
          private int id;
          private String nom;

        public nompos(int id, String nom) {
            this.id = id;
            this.nom = nom;
        }
        public int getId(){
            return id;
        }
          @Override
        public String toString(){
            return nom;
        }
     }


       
       //Tomar el nombre de los potres la vista postres
       public String nombrepostres(JComboBox<nompos>agarranom){
           String postre= "SELECT id,nombre FROM Postres";
           Statement sl;
           Connection cx = conectarMysql();
           try{
               sl = cx.createStatement();
               ResultSet rs = sl.executeQuery(postre);
               while (rs.next()){
                   int idp = rs.getInt("Id");
                   String bn = rs.getString("Nombre");
                   agarranom.addItem(new nompos(idp,bn));
               }
               cx.close();
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,"ERROR AL BUSCAR DATOS"+e);
               
           }
           return agarranom.toString();
       }
       
       public String actualizarpos(String Nombre,String Precio,String Inventario,int idpostre){
           Connection cx = conectarMysql();
           try{
               String p = "UPDATE Postres\n" +
"SET  nombre =?, precio = ?, inventario=? WHERE id =?";
               PreparedStatement ts = cx.prepareStatement(p);
               ts.setString(1,Nombre);
               ts.setString(2,Precio);
               ts.setString(3,Inventario);
               ts.setInt(4, idpostre);
               
               int filasacpos = ts.executeUpdate();
                JOptionPane.showMessageDialog(null,"SE ACTUALIZÓ CORRECTAMENTE");
               
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,"LOS CAMPOS NO PUEDEN SER VACIOS");
               
           }
           return Nombre + Precio +Inventario + idpostre;
           
       }
       public String agregarpos(String Nombre,String Precio,String Inventario){
           Connection cx = conectarMysql();
           try{
               String agre = "INSERT INTO Postres (Nombre,Precio,Inventario)VALUES (?,?,?)";
               PreparedStatement sa = cx.prepareStatement(agre);
               sa.setString(1, Nombre);
               sa.setString(2, Precio);
               sa.setString(3, Inventario);
               
               int filasagre = sa.executeUpdate();
               JOptionPane.showMessageDialog(null,"POSTRE CREADO CORRECTAMENTE");
               cx.close();
               
           }catch(HeadlessException | SQLException e){
               JOptionPane.showMessageDialog(null,"LOS CAMPOS NO PUEDEN SER VACIOS");
               
               
           } 
           return Nombre + Precio + Inventario;
           
       }


//CONTRASEÑA DEL LOGGIN
    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setConnection(Connection con1){
     this.con = con1;   
    }

    public String getRol() {
        return rol;
    }
    private Connection con;
    

    public void loggin(){
         Connection cone = conectarMysql();
         String consulta= "SELECT Usuario.nombre,contrasena,rol FROM Usuario,rol\n"+" WHERE rol.id = usuario.rol\n"+"AND Usuario.nombre=\""+usuario+"\" \n"+"AND usuario.contrasena="+contra;
         
         int x=0;
         try{
             Statement st;
             st=(Statement)cone.createStatement();
             ResultSet rs = st.executeQuery(consulta);
             String rol3 = "";
             if(rs.next()){
                 rol3 = rs.getString(3);
                 
                 x++;
             }
             if(x==1){
                 this.rol = rol3;
             }
            
                 if(x==0){
                 JOptionPane.showMessageDialog(null,"EL USUARIO O CONTRASEÑA NO EXISTEN");
                 }

              
             
         }catch(SQLException e){
             System.out.println("HUBO UN ERROR EN LA CONSULTA"+e);
             
         }
        
    }
   
         

        
       
}
        
            
       