package com.global.hitss.store;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.global.hitss.store.domain.Address;
import com.global.hitss.store.domain.Client;
import com.global.hitss.store.domain.Payment;
import com.global.hitss.store.domain.PaymentBill;
import com.global.hitss.store.domain.PaymentCard;
import com.global.hitss.store.domain.Product;
import com.global.hitss.store.domain.ProductType;
import com.global.hitss.store.domain.Sale;
import com.global.hitss.store.domain.SaleItem;
import com.global.hitss.store.domain.enums.ClientType;
import com.global.hitss.store.domain.enums.StatePayment;
import com.global.hitss.store.repositories.AddressRepository;
import com.global.hitss.store.repositories.ClientRepository;
import com.global.hitss.store.repositories.PaymentRepository;
import com.global.hitss.store.repositories.ProductRepository;
import com.global.hitss.store.repositories.ProductTypeRepository;
import com.global.hitss.store.repositories.SaleItemRepository;
import com.global.hitss.store.repositories.SaleRepository;

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
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalHitssStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ProductType pt1 = new ProductType(null,"Informática");
		ProductType pt2 = new ProductType(null,"Jardim");
		ProductType pt3 = new ProductType(null,"Ferramentas");
		ProductType pt4 = new ProductType(null,"Eletrônicos");
		ProductType pt5 = new ProductType(null,"Cama mesa e banho");
		ProductType pt6 = new ProductType(null,"Flamengo");
		ProductType pt7 = new ProductType(null,"Disco de Vinil");
		
		
		Product p1 = new Product(null, "PenDrive 128GB", 100.00, 10);
		Product p2 = new Product(null, "Impressora Epson", 900.00, 3);
		Product p3 = new Product(null, "Teclado Microsoft", 80.00, 3);
		
		pt1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		pt2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getProductTypes().addAll(Arrays.asList(pt1));
		p2.getProductTypes().addAll(Arrays.asList(pt1, pt2));
		p3.getProductTypes().addAll(Arrays.asList(pt1));
		
		productTypeRepository.saveAll(Arrays.asList(pt1, pt2, pt3, pt4, pt5, pt6, pt7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));	
		
		Client cli1 = new Client(null, "Renato Dalforne", "renato.dalforne@gmail.com", "09165490703", ClientType.PESSOAFISICA);
		
		cli1.getPhones().addAll(Arrays.asList("21984597970","2122010457"));
		
		Address a1 = new Address(null, "Rua Luiz de Brito", "Rio de Janeiro", "RJ", "81", "Maria da Graça", "20785360", cli1);
		Address a2 = new Address(null, "Av Marechal Câmara", "Rio de Janeiro", "RJ", "260", "Centro", "20760029", cli1);
		
		cli1.getAdresses().addAll(Arrays.asList(a1,a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Sale sa1 = new Sale(null, sdf.parse("14/09/2020 10:32"), cli1, a1, 1);		
		Sale sa2 = new Sale(null, sdf.parse("10/09/2020 19:30"), cli1, a2, 1);
		
		Payment pay1 = new PaymentCard(null, StatePayment.QUITADO, sa1, 6);
		sa1.setPayment(pay1);
		
		Payment pay2 = new PaymentBill(null, StatePayment.PENDENTE, sa2, sdf.parse("20/09/2020 00:00"), null);
		sa2.setPayment(pay2);
		
		cli1.getSales().addAll(Arrays.asList(sa1, sa2));		
		
		saleRepository.saveAll(Arrays.asList(sa1,sa2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		
		SaleItem si1 = new SaleItem(sa1, p1, 0.00, 1, 100.00);
		SaleItem si2 = new SaleItem(sa1, p3, 0.00, 2, 80.00);
		SaleItem si3 = new SaleItem(sa2, p2, 100.00, 1, 900.00);
		
		sa1.getItens().addAll(Arrays.asList(si1, si2));
		sa2.getItens().addAll(Arrays.asList(si3));
		
		p1.getItens().addAll(Arrays.asList(si1));
		p2.getItens().addAll(Arrays.asList(si3));
		p3.getItens().addAll(Arrays.asList(si2));
	
		saleItemRepository.saveAll(Arrays.asList(si1, si2, si3));
		
	}

}
