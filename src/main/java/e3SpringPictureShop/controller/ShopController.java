package e3SpringPictureShop.controller;

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

import e3SpringPictureShop.dto.Shop;
import e3SpringPictureShop.service.ShopServiceImpl;


@RestController
@RequestMapping("/api")
public class ShopController {

	// Use of methods from Service
	@Autowired
	ShopServiceImpl shopServiceImpl;

	// Create shop
	@PostMapping("/shops")
	public Shop createShop(@RequestBody Shop shop) {
		return shopServiceImpl.createShop(shop);
	}

	// Get all shops
	@GetMapping("/shops")
	public List<Shop> listShops() {
		return shopServiceImpl.listShops();
	}

	// Get shop by id
	@GetMapping("/shops/{id}")
	public Shop getShop(@PathVariable(name = "id") Long id) {
		return shopServiceImpl.getShop(id);
	}

	// Update shop
	@PutMapping("/shops/{id}")
	public Shop updateShop(@PathVariable(name = "id") Long id, @RequestBody Shop shop) {

		Shop shopToUpdate = shopServiceImpl.getShop(id);
		shopToUpdate.setName(shop.getName());
		shopToUpdate.setCapacity(shop.getCapacity());
		return shopServiceImpl.updateShop(shopToUpdate);
	}

	// Delete shop
	@DeleteMapping("/shops/{id}")
	public void deleteShop(Long id) {
		shopServiceImpl.deleteShop(id);
		// TODO - burn all books from shop???
	}

}
