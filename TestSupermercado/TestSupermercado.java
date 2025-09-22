package TestSupermercado;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Modelo.Producto;
import Modelo.ItemCarrito;
import Modelo.Carrito;
import Modelo.Supermercado;

public class TestSupermercado {

	public static void main(String[] args) {
		System.out.println("Test Supermercado");	
		try {
			
			Supermercado supermercadoKpop = new Supermercado();
			try {
				supermercadoKpop.agregarProducto("Pan Bimbo", 12.5f);
				supermercadoKpop.agregarProducto("Leche La Serenísima", 20.0f);
				supermercadoKpop.agregarProducto("Queso Cremoso Ilolay", 35.0f);
				supermercadoKpop.agregarProducto("Huevos San Juan", 18.5f);
				supermercadoKpop.agregarProducto("Arroz Gallo Oro", 45.0f);
				supermercadoKpop.agregarProducto("Fideos Luchetti", 30.0f);
				supermercadoKpop.agregarProducto("Aceite Natura", 75.5f);
				supermercadoKpop.agregarProducto("Yerba Taragüi", 90.0f);
				supermercadoKpop.agregarProducto("Azúcar Ledesma", 28.0f);
				supermercadoKpop.agregarProducto("Pan Bimbo", 15f);
			}catch(Exception e){
				System.out.println("Error forzado(agregarProducto) "+ e);
			}
			
			System.out.println(supermercadoKpop);
			System.out.println("Productos que se agregaron usando el metodo agregarProducto");
			for (Producto p : supermercadoKpop.getGondola()) {
				System.out.println(p);
			}
			
			System.out.println("Prueba metodo traerProducto " + supermercadoKpop.traerProducto(2));
			
			try {
				supermercadoKpop.modificaProducto(3, "Queso Cremoso Ilolay", 45.9f);
				System.out.println("Prueba metodo modificaProducto " + supermercadoKpop.traerProducto(3));
				supermercadoKpop.modificaProducto(15, "", 0f);
				
			}catch(Exception e) {
				System.out.println("Error forzado(modificaProducto)" + e);
			}
			
			try {
				supermercadoKpop.eliminarProducto(7);
				System.out.println("Prueba metodo elimianarProducto, no se porque fue eliminado Producto ID 7: " + supermercadoKpop.traerProducto(7));
				supermercadoKpop.eliminarProducto(15);
				
			}catch(Exception e) {
				System.out.println("Error forzado 1 (eliminarProducto)" + e);
			}
			
			try {
				supermercadoKpop.agregarCarrito(LocalDate.now(), LocalDateTime.now());
				supermercadoKpop.getLstCarrito().get(0).agregarItem(supermercadoKpop.traerProducto(1), 5);
				supermercadoKpop.getLstCarrito().get(0).agregarItem(supermercadoKpop.traerProducto(2), 20);
				System.out.println(supermercadoKpop.getLstCarrito());
				System.out.println("Cantidad del item antes de agregar item\n" + supermercadoKpop.getLstCarrito().get(0).getLstItem().get(0));
				supermercadoKpop.getLstCarrito().get(0).agregarItem(supermercadoKpop.traerProducto(1), 10);
				System.out.println("Cantidad agregada al existir el item\n" + supermercadoKpop.getLstCarrito().get(0).getLstItem().get(0));
			}catch(Exception e) {
					System.out.println(e);				
			}
			
			try {
				supermercadoKpop.eliminarProducto(1);
			}catch(Exception e) {
				System.out.println("Error forzado 2 (eliminarProducto) existe carrito id 1 "  + e);
			}
			
			try {
				supermercadoKpop.getLstCarrito().get(0).eliminarItem(supermercadoKpop.traerProducto(1), 15);
				System.out.println("Eliminar item, se pudo eliminar por completo caso 1 ID 1" + supermercadoKpop.getLstCarrito().get(0).getLstItem());
			}catch(Exception e) {
				System.out.println("Error forzado 1 (eliminarProducto) existe carrito id 1 "  + e);
			}
			try {
				supermercadoKpop.getLstCarrito().get(0).eliminarItem(supermercadoKpop.traerProducto(2), 10);
				System.out.println("Eliminar item, se pudo eliminar por restando cantidad caso 2 ID 2" + supermercadoKpop.getLstCarrito().get(0).getLstItem());
			}catch(Exception e) {
				
				System.out.println("Error forzado 2 (eliminarProducto) existe carrito id 2 "  + e);
			}
			try {
				supermercadoKpop.getLstCarrito().get(0).eliminarItem(supermercadoKpop.traerProducto(1), 10);
			}catch(Exception e) {
				System.out.println("Error forzado 3 (eliminarProducto)"  + e);
			}
			
			try {
				supermercadoKpop.getLstCarrito().get(0).agregarItem(supermercadoKpop.traerProducto(1), 75);
				
				for(var it : supermercadoKpop.getLstCarrito().get(0).getLstItem()) {
					System.out.println("Items" + it);
					System.out.println("Subtotal: " + it.calcularSubTotal());
				}
				
				System.out.println("Total carrito: " + supermercadoKpop.getLstCarrito().get(0).calcularTotal());
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}catch(Exception e) {
			System.out.println("Error general" + e);
		}
	}

}


/*List<Producto> listaProductos = new ArrayList<>();
listaProductos.add(new Producto(1, "Pan Bimbo", 12.5f));
listaProductos.add(new Producto(2, "Leche La Serenísima", 20.0f));
listaProductos.add(new Producto(3, "Queso Cremoso Ilolay", 35.0f));
listaProductos.add(new Producto(4, "Huevos San Juan", 18.5f));
listaProductos.add(new Producto(5, "Arroz Gallo Oro", 45.0f));
listaProductos.add(new Producto(6, "Fideos Luchetti", 30.0f));
listaProductos.add(new Producto(7, "Aceite Natura", 75.5f));
listaProductos.add(new Producto(8, "Yerba Taragüi", 90.0f));
listaProductos.add(new Producto(9, "Azúcar Ledesma", 28.0f));*/
