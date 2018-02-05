/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.util.List;

/**
 *
 * @author victor
 */
public interface Repositorio<T> {
    boolean Salvar(T obj);
    T Abrir(long id);
    boolean Apagar(T obj);
    List<T> Buscar(T filtro);
}
