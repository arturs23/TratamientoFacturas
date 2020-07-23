/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.fac.dao;

import co.fac.dto.Empresa;
import java.util.List;

/**
 *
 * @author OscarEsteban
 */
public interface Operaciones {
      public int insertar(Empresa empresa);
      public int actualizar (Empresa empresa);
      public int borrar(String pk);
      public List<Empresa> Listar();
          
      
}
