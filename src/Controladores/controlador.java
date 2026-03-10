/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import Vistas.Loggin;

import Modelos.modelo;
import Modelos.modelo.Itempedido;
import Modelos.modelo.Itempropo;
import Modelos.modelo.nompos;
import Vistas.ActualizarPostre;
import Vistas.Usuarios;
import Vistas.Postres;
import Vistas.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vistas.Proveedores;
import Vistas.Materiales;
import javax.swing.JComboBox;
import Vistas.Pedido;
import Vistas.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author Danis
 */
public class controlador implements ActionListener {
    
    private Loggin loggin;
  
    private modelo modelo;
    private Usuarios usuarios;
    private Clientes clien;
    private Proveedores prove;
    private Materiales mate;
    private Postres postre;
    private Pedido pd;
    private Menu mn;
    private ActualizarPostre ap;
    
    
    public controlador (Loggin loggin,modelo modelo,Usuarios usuarios,Postres postre,Clientes clien,Menu mn,Pedido pd){
        
  
        this.loggin = loggin;
        this.modelo = modelo;
        this.usuarios = usuarios;
        this.clien = clien;
        this.mn = mn;
        this.pd = pd;
        this.loggin.ingresar.addActionListener(this);
        this.loggin.mostrarcontra.addActionListener(this);

        
     
        

        
        
        
        
  }
    //Controlador de agregar usuarios
    public controlador(modelo mode, Usuarios usuarios) {
        this.usuarios = usuarios;
        this.modelo = mode;
    }//Controlador de agregar clientes
     public controlador(modelo mode, Clientes clien) {
        this.clien = clien;
        this.modelo = mode;
    }//Controlador de agregar proveedores
     public controlador(modelo mode, Proveedores prove) {
        this.prove = prove;
        this.modelo = mode;
     }//Controlador de materiales
        public controlador(modelo mode, Materiales mate) {
        this.mate = mate;
        this.modelo = mode;
     }//Controlador de pedido
        public controlador(modelo mode, Pedido pd) {
        this.pd = pd;
        this.modelo = mode;
     }//Controlador de tabla
        public controlador(modelo mode,Postres postre){
            this.postre=postre;
            this.modelo=mode;
        }
         public controlador(modelo mode,ActualizarPostre ap){
            this.ap=ap;
            this.modelo=mode;
        }
        
        
        public void upc(){
            JComboBox Usuario = pd.usua;
            JComboBox Pago = pd.pag;
            JComboBox Cliente = pd.clien;
            JComboBox postre = pd.selecpos;
            modelo.buscarelementos(Usuario, Pago, Cliente,postre, "nombre", "nombre", "nombre","nombre");
        }
//     //Constructor de postres(productos)
//    public controlador(Producto pro, Admin1 admi1, ConsultasProducto cp) {
//        this.pro = pro;
//        this.admi1 = admi1;
//        this.cp = cp;
        
//        this.admi1.btnagregar.addActionListener(this);
//        this.admi1.btnmodificar.addActionListener(this);
//        this.admi1.btnborrar.addActionListener(this);
//        this.admi1.btnbuscar.addActionListener(this);
//        this.admi1.btnlimpiar.addActionListener(this);
    
     
  
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
          
        if(e.getSource()== loggin.ingresar){
        modelo.setContra(loggin.txtcontra.getText());
        modelo.setUsuario(loggin.txtusuario.getText());
        modelo.loggin();
        String rol= modelo.getRol();
        if(rol.equals("1")){
            loggin.setVisible(false);
            JOptionPane.showMessageDialog(null,"BIENVENIDO ADMINISTRADOR");
            mn.setVisible(true);
         
            
            
           
            
        }else if (rol.equals("2")){
            loggin.setVisible(false);
             JOptionPane.showMessageDialog(null,"BIENVENIDO EMPLEADO");
            pd.setVisible(true);
            
        }
        }
        if (e.getSource()==loggin.mostrarcontra){
            if(loggin.mostrarcontra.isSelected()){
                loggin.txtcontra.setEchoChar((char)0);
           }
            else{
                loggin.txtcontra.setEchoChar('•');
                
            }
        }

    
    }


        
    
    public void nuevousuario(){
        String newusu = usuarios.getusu();
        String newcontra = usuarios.getcontra();
        String newrol = usuarios.getrol();
        String desrol = usuarios.getTxtdescrip();
        String nombrepe = usuarios.getTxtnombrepe();
        String Apep = usuarios.getTxtpaterno();
        String Amat = usuarios.getTxtmaterno();
        String fe = usuarios.getTxtfecha();
        modelo.usuarioycontra(newusu,newcontra,newrol,desrol,nombrepe,Apep,Amat,fe);
    }
    public void nuevocliente(){
        String Nombres = clien.getclientenombres();
        String apepa = clien.getclienpa();
        String apema = clien.getclienma();
        String fecha = clien.getclienfecha();
        modelo.Clientes(Nombres, apepa, apema, fecha);
        
    }
    public void nuevoprove(){
        String Nombres = prove.getprovenombres();
        String apepa = prove.getprovepa();
        String apema = prove.getprovema();
        String fecha = prove.getprovefecha();
        String distri = prove.getprovedistri();
        modelo.Proveedor(Nombres, apepa, apema, fecha, distri);
        
    }
    public void proveypos(){
        JComboBox prove = mate.prove;
        modelo.proveypos(prove, "nombre");
    }
    public void materiales(){
        String precio = mate.getprecio();
        String cantidad = mate.getcantidad();
        String nombre = mate.getnombre();
        JComboBox prov = mate.prove;
        int idproveedor = getIdProvee(prov);
        modelo.Materiales(precio, cantidad, nombre, idproveedor);
    }
    private int getIdProvee(JComboBox<Itempropo> prov){
        Itempropo selectedItem = (Itempropo) prov.getSelectedItem();
        if(selectedItem != null){
            return selectedItem.getId();
        }else {
            return -1;
        }
    }    
    public void inserpedido(){
        String nombre = pd.gettxtnombrepedido();
        JComboBox idusu = pd.usua;
        JComboBox idpago = pd.pag;
        JComboBox idcliente = pd.clien;
        JComboBox idpostres = pd.selecpos;
        int idu = getelementos(idusu);
        int idp = getelementos(idpago);
        int idc = getelementos(idcliente);
        int idpos = getelementos(idpostres);
        modelo.inserpedido(nombre, idu, idp, idc, idpos);
        
   }
    private int getelementos(JComboBox<Itempedido> pedi){
        Itempedido ped = (Itempedido) pedi.getSelectedItem();
        
        if(ped != null){
            return ped.getId();
        }else{
            return -1;
        }
    }
           public void tabla(){
           Statement st1;
           ResultSet rs1;
           Connection cx = modelo.conectarMysql();
           DefaultTableModel dft;
           
           String postre1 = "SELECT Id, Nombre, Precio, Inventario FROM postres";
           try{
               st1 = cx.createStatement();
               rs1 = st1.executeQuery(postre1);
               Object[] po1 = new Object[4];
               dft = (DefaultTableModel) postre.tablapostres.getModel();
               
               while(rs1.next()){
                   po1 [0] = rs1.getInt("Id");
                   po1 [1] = rs1.getString("Nombre");
                   po1 [2] = rs1.getFloat("Precio");
                   po1 [3] = rs1.getInt("Inventario");
                   dft.addRow(po1);
               }
               postre.tablapostres.setModel(dft);
               
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,"ERROR AL INSERTAR"+e);
           }

       }
           public void selecpos(){
               JComboBox post= ap.nombrepostres;
               modelo.nombrepostres(post);
           }

           public void actualizarpos(){
               String nombre= ap.getNuevonombre();
               String precio= ap.getTxtprecio();
               String inventario = ap.getTxtinventario();
               JComboBox idps =ap.nombrepostres;
               int acpos = getpos(idps);
               modelo.actualizarpos(nombre, precio, inventario, acpos);
           }
           
           private int getpos(JComboBox<nompos> pedi){
        nompos ped = (nompos) pedi.getSelectedItem();
        
        if(ped != null){
            return ped.getId();
        }else{
            return -1;
        }
    }
           public void agregarpos(){
               String nombre = postre.getNombre();
               String precio = postre.getPrecio();
               String inventario = postre.getInventario();
               modelo.agregarpos(nombre, precio, inventario);
           }
           
       
   
}

  
    

