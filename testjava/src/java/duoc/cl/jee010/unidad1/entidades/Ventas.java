/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.entidades;

import java.io.Serializable;

/**
 *
 * @author amontess
 */
public class Ventas implements Serializable{
    private int id_venta;
    private String codigo_venta;
    private int cantidad_venta;
    private int id_producto;
    private int id_usuario;

    public Ventas() {
    }

    public Ventas(int id_venta, String codigo_venta, int cantidad_venta, int id_producto, int id_usuario) {
        this.id_venta = id_venta;
        this.codigo_venta = codigo_venta;
        this.cantidad_venta = cantidad_venta;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
    }
    
    public Ventas(String codigo_venta, int cantidad_venta, int id_producto, int id_usuario) {        
        this.codigo_venta = codigo_venta;
        this.cantidad_venta = cantidad_venta;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(String codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
