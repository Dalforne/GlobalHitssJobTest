package com.global.hitss.store;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.global.hitss.store.domain.Address;
import com.global.hitss.store.domain.Client;
import com.global.hitss.store.domain.Product;
import com.global.hitss.store.domain.ProductType;
import com.global.hitss.store.domain.enums.ClientType;
import com.global.hitss.store.repositories.AddressRepository;
import com.global.hitss.store.repositories.ClientRepository;
import com.global.hitss.store.repositories.ProductRepository;
import com.global.hitss.store.repositories.ProductTypeRepository;

@SpringBootApplication
public class GlobalHitssStoreApplication implements CommandLineRunner {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalHitssStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ProductType pt1 = new ProductType(null,"Informática");
		ProductType pt2 = new ProductType(null,"Jardim");
		
		
		Product p1 = new Product(null, "PenDrive 128GB", 100.00, 10);
		Product p2 = new Product(null, "Impressora Epson", 900.00, 3);
		Product p3 = new Product(null, "Teclado Microsoft", 80.00, 3);
		
		pt1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		pt2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getProductTypes().addAll(Arrays.asList(pt1));
		p2.getProductTypes().addAll(Arrays.asList(pt1, pt2));
		p3.getProductTypes().addAll(Arrays.asList(pt1));
		
		productTypeRepository.saveAll(Arrays.asList(pt1, pt2));		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));	
		
		Client cli1 = new Client(null, "Renato Dalforne", "renato.dalforne@gmail.com", "09165490703", ClientType.PESSOAFISICA);
		
		cli1.getPhones().addAll(Arrays.asList("21984597970","2122010457"));
		
		Address e1 = new Address(null, "Rua Luiz de Brito", "Rio de Janeiro", "RJ", "81", "Maria da Graça", "20785360", cli1);
		Address e2 = new Address(null, "Av Marechal Câmara", "Rio de Janeiro", "RJ", "260", "Centro", "20760029", cli1);
		
		cli1.getAdresses().addAll(Arrays.asList(e1,e2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
