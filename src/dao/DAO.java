/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author AlumnosUTJCCD
 */
public interface DAO<T> {
    
    public int crear(T t);
    public ArrayList<T> leerTodos();
    public ArrayList<T> leerAlgunos(String dato);
    public T leerId(String id);
    public int actualizar(String id, T t);
    public int borrar(String id);
}
