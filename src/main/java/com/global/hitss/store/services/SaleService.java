package com.global.hitss.store.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.hitss.store.domain.PaymentBill;
import com.global.hitss.store.domain.Sale;
import com.global.hitss.store.domain.SaleItem;
import com.global.hitss.store.domain.enums.StatePayment;
import com.global.hitss.store.repositories.PaymentRepository;
import com.global.hitss.store.repositories.ProductRepository;
import com.global.hitss.store.repositories.SaleItemRepository;
import com.global.hitss.store.repositories.SaleRepository;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	public Sale find(Integer id) {
		Optional<Sale> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + Sale.class.getName()));		
	}
	
	@Transactional
	public Sale insert(Sale obj) {
		obj.setIdSale(null);
		obj.setTmSale(new Date());
		obj.setClient(clientService.find(obj.getClient().getIdClient()));
		obj.getPayment().setStatePayment(StatePayment.PENDENTE);
		obj.getPayment().setSale(obj);
		if(obj.getPayment() instanceof PaymentBill) {
			PaymentBill pay = (PaymentBill) obj.getPayment();
			billService.setPaymentBill(pay, obj.getTmSale());
		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		
		//TODO
		//		@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
		//		productRepository.update (Product,  nrAmout)
		
		for(SaleItem si : obj.getItens()) {
			si.setVlDiscount(0.0);
			si.setProduct(productService.find(si.getProduct().getIdProduct()));
			si.setVlPrice(si.getProduct().getVlPrice());			
			si.setVlPrice(productRepository.findById(si.getProduct().getIdProduct()).get().getVlPrice());
			si.setSale(obj);
		}
		saleItemRepository.saveAll(obj.getItens());
		//emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}

}
