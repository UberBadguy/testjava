/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.dto;

import java.io.Serializable;

/**
 *
 * @author amontess
 */
public class UsuarioPerfilDTO implements Serializable{
    private int id_usuario;
    private String login_usuario;
    private String pass_usuario;
    private int id_perfil;
    private String nombre_perfil;

    public UsuarioPerfilDTO() {
    }

    public UsuarioPerfilDTO(int id_usuario, String login_usuario, String pass_usuario, int id_perfil, String nombre_perfil) {
        this.id_usuario = id_usuario;
        this.login_usuario = login_usuario;
        this.pass_usuario = pass_usuario;
        this.id_perfil = id_perfil;
        this.nombre_perfil = nombre_perfil;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }
            
}
