/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import Modelos.modelo;
import Vistas.Loggin;
import Controladores.controlador;
import Vistas.Usuarios;
import Vistas.Postres;
import Vistas.Clientes;
import Vistas.Loggin;

import Vistas.Menu;
import Vistas.Pedido;
import Vistas.Proveedores;

/**
 *
 * @author Danis
 */
public class ProyectoDaniela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    modelo mod = new modelo();
    mod.conectarMysql();
    Loggin lg = new Loggin();
    Usuarios ad = new Usuarios();
    Postres post = new Postres();
    Pedido ped = new Pedido();
    Menu mn = new Menu();
    Proveedores pro = new Proveedores();
    Clientes clien = new Clientes();
    controlador con =new controlador(lg,mod,ad,post,clien,mn,ped);
    lg.mostrarcontra.setBorder(null);
    lg.mostrarcontra.setOpaque(false);
    lg.setVisible(true);
    
  
       
        
    }
    
}
