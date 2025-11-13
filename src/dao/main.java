/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package dao; 

import dto.Producto;
import java.util.ArrayList;

/**
 *
 * @author Fernando 
 */

public class main { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("--- Iniciando prueba desde Main.java ---");
        

        DAOProducto dao = new DAOProducto();


        ArrayList<Producto> productos = dao.leerTodos(); 

        System.out.println("Productos encontrados: " + productos.size());

        
        for (Producto prod : productos) {
            
            System.out.println(prod.toString());
        }
        
        System.out.println("--- Fin de la prueba ---");
    }
}