package com.galil.shopping;

import java.util.LinkedList;
import java.util.List;

import com.galil.shopping.persistence.AddressRepository;
import com.galil.shopping.persistence.CartRepository;
import com.galil.shopping.persistence.CustomerRepository;
import com.galil.shopping.persistence.ItemRepository;
import com.galil.shopping.persistence.PersistenceService;
import com.galil.shopping.persistence.StoreRepository;
import com.galil.shopping.persistence.UserRepository;
import com.learning.hibernate.shopping.model.Address;
import com.learning.hibernate.shopping.model.Cart;
import com.learning.hibernate.shopping.model.Customer;
import com.learning.hibernate.shopping.model.CustomerCard;
import com.learning.hibernate.shopping.model.Item;
import com.learning.hibernate.shopping.model.Store;
import com.learning.hibernate.shopping.model.StoreBranch;
import com.learning.hibernate.shopping.model.User;
import com.learning.hibernate.shopping.model.UserRole;

public class Application {

	static Application app;
	
	PersistenceService ps;
	StoreRepository storeRepository;
	AddressRepository addressRepository;
	UserRepository userRepository;
	CartRepository cartRepository;
	ItemRepository itemRepository;
	CustomerRepository customerRepository;
	
	Store store;
	StoreBranch nazarethBranch, umAlFahimBranch, terahBranch;
	List<StoreBranch> storeBranches = new LinkedList<>();
	
	Customer ramiCustomer, fatimaCustomer;

	
	public static void main(String[] args) {
		log("Starting application..");

		start();
	}

	private static void start() {
		app = new Application();
		app.initServices();
		app.createApplicationData();
		app.performShoppingOperations();
	}

	private Application() {
	}

	private void initServices() {
		log("Initializing application services..");

		ps = PersistenceService.getInstance();

		storeRepository = new StoreRepository();
		storeRepository.setPersistenceService(ps);

		userRepository = new UserRepository();
		userRepository.setPersistenceService(ps);

		addressRepository = new AddressRepository();
		addressRepository.setPersistenceService(ps);

		cartRepository = new CartRepository();
		cartRepository.setPersistenceService(ps);

		itemRepository = new ItemRepository();
		itemRepository.setPersistenceService(ps);
		
		customerRepository = new CustomerRepository();
		customerRepository.setPersistenceService(ps);
		
	}
	
	private void createApplicationData() {
		log("Creating application data..");
		createStoreAndBranches();
		createUsers();
		createItems();
		createCustomers();
	}

	private void createStoreAndBranches() {
		store = new Store();
		store.setName("Mashhadawi");
		storeRepository.save(store);

		nazarethBranch = new StoreBranch();
		nazarethBranch.setBranchName("Mashhadawi Nazareth");
		nazarethBranch.setBranchLocation("Nazareth");
		nazarethBranch.setStore(store);
		storeBranches.add(nazarethBranch);

		umAlFahimBranch = new StoreBranch();
		umAlFahimBranch.setBranchName("Mashhadawi Um Al Fahim");
		umAlFahimBranch.setBranchLocation("Um Al Fahim");
		umAlFahimBranch.setStore(store);
		storeBranches.add(umAlFahimBranch);

		terahBranch = new StoreBranch();
		terahBranch.setBranchName("Mashhadawi Terah");
		terahBranch.setBranchLocation("Terah");
		terahBranch.setStore(store);
		storeBranches.add(terahBranch);

		storeBranches.forEach(b -> storeRepository.save(b));
	}

	private void createItems() {
		log("Creating items..");

		Item item1 = new Item();
		item1.setBarcode("121215878875255454");
		item1.setManufactur("Mashhadawi");
		item1.setName("Rice");
		item1.setStore(store);
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setBarcode("121215877777255454");
		item2.setManufactur("Mashhadawi");
		item2.setName("Oil");
		item2.setStore(store);
		itemRepository.save(item2);
		
		Item item3 = new Item();
		item3.setBarcode("12122002200454");
		item3.setManufactur("Nutella");
		item3.setName("Nutella Chocolate");
		item3.setStore(store);
		itemRepository.save(item3);
	}

	private void createUsers() {
		log("Creating users..");

		Address user1Address = new Address("USA", "New York", "street 1", "BO-1001");
		addressRepository.save(user1Address);

		User u1 = new User();
		u1.setFirstName("Muhammad");
		u1.setLastName("Omar");
		u1.setEmail("m.o@gmail.com");
		u1.setPhone("+97050225874");
		u1.setRole(UserRole.ADMIN);
		u1.setUsername("admin");
		u1.setPassword("admin");
		u1.setAddress(user1Address);
		userRepository.save(u1);

		Address user2Address = new Address("England", "London", "street 2", "BO-121");
		addressRepository.save(user2Address);

		User u2 = new User();
		u2.setFirstName("Ali");
		u2.setLastName("Mustafa");
		u2.setEmail("ali.mustafa@gmail.com");
		u2.setPhone("+97050220054");
		u2.setRole(UserRole.OPERATOR);
		u2.setUsername("operator");
		u2.setPassword("admin");
		u2.setAddress(user2Address);
		userRepository.save(u2);

		printUsers();
	}

	private void createCustomers() {
		log("Creating customers...");

		// Create first customer
		Address cust1Address = new Address("Jordan", "Amman", "street 1", null);
		addressRepository.save(cust1Address);

		ramiCustomer = new Customer();
		ramiCustomer.setFirstName("Rami");
		ramiCustomer.setLastName("Omar");
		ramiCustomer.setEmail("rami.o@gmail.com");
		ramiCustomer.setPhone("+96050225874");
		ramiCustomer.setAddress(cust1Address);
		customerRepository.save(ramiCustomer);
		
		CustomerCard cc1 = new CustomerCard(ramiCustomer, "12341200123411234", "Vista Card", "RAMI OMAR" , 10,2,2024, 777);
		customerRepository.save(cc1);
		
		// Create another customer
		Address cust2Address = new Address("Plaestine", "Nablus", "Rafedia street", "BO3030");
		addressRepository.save(cust2Address);
		
		fatimaCustomer = new Customer();
		fatimaCustomer.setFirstName("Fatima");
		fatimaCustomer.setLastName("Saeed");
		fatimaCustomer.setEmail("fatemi.saied@outlook.com");
		fatimaCustomer.setPhone("+9705990225874");
		fatimaCustomer.setAddress(cust2Address);
		customerRepository.save(fatimaCustomer);
		
		CustomerCard cc2 = new CustomerCard(fatimaCustomer, "12341234123411234", "Master Card", "FATIMA SAED" , 10,5,2026, 780);
		customerRepository.save(cc2);
	}

	private void performShoppingOperations() {
		Cart cart1 = new Cart();
		cart1.setCustomer(ramiCustomer);
		cart1.setStore(store);
		cart1.setStoreBranch(umAlFahimBranch);
		Item riceItem = itemRepository.select("121215878875255454");
		cart1.addItem(riceItem);

		Item nutellaItem = itemRepository.select("12122002200454");
		cart1.addItem(nutellaItem);

		long id = (long) cartRepository.save(cart1);
		
		log("Cart is created with id: " + id);

		Cart currentCart = cartRepository.select(ramiCustomer);

		log("Current created Cart is: " + currentCart);
	}
	
	private void printUsers() {
		log("Printing users..");
		List<User> users = userRepository.selectAll();
		users.forEach(System.out::println);
	}

	public static void log(String message) {
		System.out.println("* Application::LOG >> " + message);
	}
}
