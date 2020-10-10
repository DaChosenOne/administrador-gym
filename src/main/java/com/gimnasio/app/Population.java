package com.gimnasio.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.models.ItemVenta;
import com.gimnasio.app.models.Producto;
import com.gimnasio.app.models.Rol;
import com.gimnasio.app.models.Trabajador;
import com.gimnasio.app.models.Venta;
import com.gimnasio.app.repository.ClienteRepository;
import com.gimnasio.app.repository.ProductoRepository;
import com.gimnasio.app.repository.TrabajadorRepository;
import com.gimnasio.app.repository.VentaRepository;

@Component
public class Population  implements CommandLineRunner{

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	public void run(String... args) throws Exception {
	      
		 
		  //Crear primer trabajador
		  Trabajador t1 = new Trabajador();
	      t1.setCorreo("admin@gmail.com");
	      t1.setPassword("12345");
	      Rol rol = Rol.USER_ROLE;
	      t1.setRole(rol);
	      t1.setActivo(true);
	      trabajadorRepository.save(t1);
	      
	    
	      //Crear segundo trabajador
		  Trabajador t2 = new Trabajador();
	      t2.setCorreo("trabajador@gmail.com");
	      t2.setPassword("12345");
	      t2.setRole(rol);
	      t2.setActivo(false);
	      trabajadorRepository.save(t2);
	      
	    //Crear segundo trabajador
		  Trabajador t3 = new Trabajador();
	      t3.setCorreo("administrador@gmail.com");
	      t3.setPassword("#$ddfrtf$");
	      Rol rol1 = Rol.ADMIN_ROLE;
	      t3.setActivo(true);
	      t3.setRole(rol1);
	      trabajadorRepository.save(t3);
	      
	      Cliente c1 = new Cliente();
	      c1.setCorreoElectronico("doomlord97@gmail.com");
	      c1.setActivo(true);
	      c1.setFechaInicio(new Date());
	      c1.setFechaTermino(new Date());
	      c1.setNombre("Jesus Samano");
	      c1.setTelefono("7341157770");
	      clienteRepository.save(c1);
	      
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Date date1 = sdf.parse("2009-12-31");
	      Date date2 = sdf.parse("2010-01-31");
	      
	      Cliente c2 = new Cliente();
		  c2.setCorreoElectronico("doomlord97@gmail.com");
		  c2.setActivo(true);
		  c2.setFechaInicio(date1);
		  c2.setFechaTermino(date2);
		  c2.setNombre("Jesus Samano");
		  c2.setTelefono("7341157770");
		  clienteRepository.save(c2);
		      
		  
	      Producto producto = new Producto();
	      producto.setCantidad(20L);
	      producto.setCategoria("Proteina");
	      producto.setMarca("Muscletech");
	      producto.setNombre("Proteina Whey 73 servicios");
	      producto.setPrecio(1299L);
	      producto.setSku("DA345aAdcSXqsw");
	      productoRepository.save(producto);
	      
	      Producto producto2 = new Producto();
	      producto2.setCantidad(20L);
	      producto2.setCategoria("Creatina");
	      producto2.setMarca("Muscletech");
	      producto2.setNombre("Creatina Monohidratada 100 servicios");
	      producto2.setPrecio(500L);
	      producto2.setSku("12345asdca2qsw");
	      productoRepository.save(producto2);
	      
	      
	      Producto producto3 = new Producto();
	      producto3.setCantidad(10L);
	      producto3.setCategoria("Testoterona");
	      producto3.setMarca("Muscletech");
	      producto3.setNombre("Precursos de testoterona 59 servs.");
	      producto3.setPrecio(799L);
	      producto3.setSku("dse45asdca2qsw");
	      productoRepository.save(producto3);
	      
	      ItemVenta itemVenta = new ItemVenta();
	      itemVenta.setCantidad(2);
	      itemVenta.setProducto(productoRepository.findById(1L).get());
	     
	      ItemVenta itemVenta2 = new ItemVenta();
	      itemVenta2.setCantidad(3);
	      itemVenta2.setProducto(productoRepository.findById(2L).get());
	    
	      
	      List<ItemVenta> items = new ArrayList<>();
	      items.add(itemVenta);
	      items.add(itemVenta2);
	      
	      
	      Venta venta = new Venta();
	      venta.setDescuento(0L);
	      venta.setNombre("Felipe Figueroa");
	      venta.setObservaciones("Niguna");
	      venta.setItems(items);
	      venta.setPagoTotal(venta.getTotal());;
	      ventaRepository.save(venta);
	      
	      ventaRepository.findAll().forEach(System.out::println);;
	      
	  }

}
