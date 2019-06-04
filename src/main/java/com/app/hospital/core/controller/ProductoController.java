package com.app.hospital.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.core.entity.Producto;
import com.app.hospital.core.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoService.allProducto();
	}
	
	@PostMapping
	public void guardarProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
	}
	
	@PutMapping
	public void actualizarProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
	}
	
	@DeleteMapping("/{idproducto}")
	public void eliminarSocio(@PathVariable("idproducto") Integer idproducto) {
		productoService.deleteProducto(idproducto);
	}
	
	@GetMapping("/{idproducto}")
	public Producto obtenerProducto(@PathVariable("idproducto") Integer idproducto) {
		return productoService.findProducto(idproducto);
	}
	
}
 