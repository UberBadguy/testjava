/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentancion;

import duoc.cl.jee010.miconstructora.dto.ProductoVentaUsuarioDTO;
import duoc.cl.jee010.miconstructora.entidades.Producto;
import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.entidades.Ventas;
import duoc.cl.jee010.miconstructora.negocio.ProductoBO;
import duoc.cl.jee010.miconstructora.utilidades.Utilitaria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amontess
 */
@WebServlet(name = "AgregarCarritoServlet", urlPatterns = {"/agregarCarritoServlet", "/addCarrito"})
public class AgregarCarritoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String codigo;
        if (sesion.getAttribute("codigoVenta") != null) {
            codigo = sesion.getAttribute("codigoVenta").toString();
        } else {
            codigo = Utilitaria.generaCodigo();
            sesion.setAttribute("codigoVenta", codigo);
        }
        ProductoBO objProductoBO = new ProductoBO();
        int id_codigo = Integer.parseInt(request.getParameter("ddlProducto"));
        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
        Producto objProducto = objProductoBO.buscaProductoXCodigo(id_codigo);
        User objUsuario = (User) sesion.getAttribute("usuarioConectado");
        Ventas objVenta = new Ventas(codigo, cantidad, objProducto.getId_producto(), objUsuario.getId());

        ProductoVentaUsuarioDTO objProductoVentaUsuarioDTO = new ProductoVentaUsuarioDTO(objProducto.getId_producto(),
                objUsuario.getId(), objProducto.getNombre_producto(), objProducto.getMarca_producto(), objProducto.getPrecio_producto(),
                objVenta.getCodigo_venta(), objVenta.getCantidad_venta(), objUsuario.getLogin());

        if (sesion.getAttribute("listadoVentas") != null) {
            List<Ventas> listaVentas = (List<Ventas>) sesion.getAttribute("listadoVentas");
            listaVentas.add(objVenta);

            List<ProductoVentaUsuarioDTO> listadoDTO = (List<ProductoVentaUsuarioDTO>) sesion.getAttribute("listadoDTOProductoVenta");
            listadoDTO.add(objProductoVentaUsuarioDTO);
            response.sendRedirect("GrillaVentas.jsp");
        } else {
            List<Ventas> listaVentas = new LinkedList<>();
            listaVentas.add(objVenta);
            sesion.setAttribute("listadoVentas", listaVentas);

            List<ProductoVentaUsuarioDTO> listadoDTO = new LinkedList<>();
            listadoDTO.add(objProductoVentaUsuarioDTO);
            sesion.setAttribute("listadoDTOProductoVenta", listadoDTO);
            response.sendRedirect("GrillaVentas.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
