/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectodesupermercado.controller;

import proyectodesupermercado.controller.authentication.Usuario;

/**
 *
 * @author DELL
 */
public interface CreadorUsuario {
    Result<Usuario> registerUser(Usuario usuario);
}
