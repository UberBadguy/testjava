/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

/**
 *
 * @author amontess
 */
public class ProductoVentaUsuarioDTO {
    private int id_producto;
    private int id_venta;
    private int id_usuario;
    private String nombre_producto;
    private String marca_producto;
    private int precio_producto;
    private String codigo_venta;
    private int cantidad_venta;
    private String login_usuario;

    public ProductoVentaUsuarioDTO() {
    }

    public ProductoVentaUsuarioDTO(int id_producto, int id_venta, int id_usuario, String nombre_producto, String marca_producto, int precio_producto, String codigo_venta, int cantidad_venta, String login_usuario) {
        this.id_producto = id_producto;
        this.id_venta = id_venta;
        this.id_usuario = id_usuario;
        this.nombre_producto = nombre_producto;
        this.marca_producto = marca_producto;
        this.precio_producto = precio_producto;
        this.codigo_venta = codigo_venta;
        this.cantidad_venta = cantidad_venta;
        this.login_usuario = login_usuario;
    }
    public ProductoVentaUsuarioDTO(int id_producto, int id_usuario, String nombre_producto, String marca_producto, int precio_producto, String codigo_venta, int cantidad_venta, String login_usuario) {
        this.id_producto = id_producto;        
        this.id_usuario = id_usuario;
        this.nombre_producto = nombre_producto;
        this.marca_producto = marca_producto;
        this.precio_producto = precio_producto;
        this.codigo_venta = codigo_venta;
        this.cantidad_venta = cantidad_venta;
        this.login_usuario = login_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
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

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }
    
}
