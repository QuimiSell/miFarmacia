/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase1;

/**
 *
 * @author Selvin1
 */
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

// Clase para representar un medicamento
class Medicamento {
    String nombre;
    int cantidad;
    double precio;

    public Medicamento(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}

// Clase principal de la aplicación
public class FarmaciaApp {
    private Queue<Medicamento> inventario; // Cola para gestionar el inventario
    private Stack<Medicamento> ventas;     // Pila para gestionar las ventas

    public FarmaciaApp() {
        inventario = new LinkedList<>();
        ventas = new Stack<>();
    }

    // Método para agregar un nuevo medicamento al inventario
    public void agregarMedicamento(String nombre, int cantidad, double precio) {
        Medicamento medicamento = new Medicamento(nombre, cantidad, precio);
        inventario.add(medicamento);
    }

    // Método para vender un medicamento al cliente
    public void venderMedicamento(String nombre, int cantidad) {
        // Verificar si el medicamento está disponible en el inventario
        for (Medicamento med : inventario) {
            if (med.nombre.equals(nombre)) {
                // Verificar si hay suficiente cantidad para vender
                if (med.cantidad >= cantidad) {
                    med.cantidad -= cantidad;
                    ventas.push(new Medicamento(nombre, cantidad, med.precio));
                    System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre);
                    return;
                } else {
                    System.out.println("No hay suficiente cantidad de " + nombre + " en el inventario.");
                    return;
                }
            }
        }
        System.out.println("El medicamento " + nombre + " no está disponible en el inventario.");
    }

    // Método para mostrar el inventario 
    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Medicamento med : inventario) {
            System.out.println(med.nombre + " - Cantidad: " + med.cantidad + " - Precio: Q" + med.precio);
        }
    }

    // Método para mostrar el registro de ventas
    public void mostrarRegistroVentas() {
        System.out.println("Registro de Ventas:");
        for (Medicamento med : ventas) {
            System.out.println("Venta: " + med.cantidad + " unidades de " + med.nombre + " - Total: Q" + (med.cantidad * med.precio));
        }
    }

    public static void main(String[] args) {
        FarmaciaApp farmacia = new FarmaciaApp();

        // Agregar algunos medicamentos al inventario
        farmacia.agregarMedicamento("Paracetamol", 50, 5.0);
        farmacia.agregarMedicamento("Ibuprofeno", 30, 7.5);

        // Vender algunos medicamentos
        farmacia.venderMedicamento("Paracetamol", 10);
        farmacia.venderMedicamento("Ibuprofeno", 20);

        // Mostrar inventario y registro de ventas
        farmacia.mostrarInventario();
        farmacia.mostrarRegistroVentas();
    }
}
