package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.entity.Producto;

public interface ProductoService {
	
	  List<Producto> allProducto();
	  Producto addProducto(Producto producto);
	  Producto findProducto(Integer idproducto);
	  void deleteProducto(Integer idproducto);
	  Integer generatedIdProducto();

}
