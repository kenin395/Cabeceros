package services;

import modelos.Producto;
import java.util.Arrays;
import java.util.List;

/*
 * Author: Kenin Cusme
 * Fecha: 06/11/2025
 * Descripción: Esta clase denominada "ProductoServivesImplement" implementa la interfaz "ProductoServices".
 * Su función principal es simular la obtención de una lista de productos disponibles en el sistema.
 *
 * Actúa como una capa de servicio (Service Layer) encargada de gestionar la lógica relacionada
 * con los productos antes de ser mostrados o procesados por otras capas del sistema,
 * como la capa de presentación o de persistencia.
 *
 * En este ejemplo, los datos se generan de forma estática mediante una lista predefinida,
 * pero en un entorno real podrían provenir de una base de datos u otra fuente externa.
 */

public class ProductoServivesImplement implements ProductoServices {

    /*
     * Método sobrescrito de la interfaz ProductoServices.
     *
     * Este método se encarga de listar o devolver todos los productos disponibles en el sistema.
     * Actualmente, retorna una lista fija utilizando Arrays.asList() con tres objetos Producto,
     * cada uno inicializado con valores de ejemplo.
     *
     * @return Lista de objetos Producto predefinidos.
     */
    @Override
    public List<Producto> Listar() {
        return Arrays.asList(
                new Producto(1L, "Laptop", "Electrónico", 256.20),
                new Producto(2L, "Computadora", "Electrónico", 230.60),
                new Producto(3L, "Cocina", "Electrodoméstico", 300.40)
        );
    }
}
