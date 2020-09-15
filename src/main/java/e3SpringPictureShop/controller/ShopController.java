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
	public String createShop(@RequestBody Shop shop) {
		shopServiceImpl.createShop(shop);
		return shop.getName() + " shop has been created";
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
	public String updateShop(@PathVariable(name = "id") Long id, @RequestBody Shop shop) {
		Shop shopToUpdate = shopServiceImpl.getShop(id);
		if(shop.getName()!=null) {	//If name is not modified
			shopToUpdate.setName(shop.getName()); 
		}
		if(shop.getCapacity()!=0) {	//If capacity is not modified
			shopToUpdate.setCapacity(shop.getCapacity());
		}
		shopServiceImpl.updateShop(shopToUpdate);
		return shopToUpdate.getName() + " shop has been updated\n";
	}

	// Delete shop
	@DeleteMapping("/shops/{id}")
	public String deleteShop(@PathVariable(name = "id")Long id) {
		//In order to delete shop:
		//Shop does not have to have pictures // Shop has to be empty 
		//if not error 500 will appear
		Shop shop = shopServiceImpl.getShop(id);
		String msg;
		if(shop.getPictures().size() != 0) {
			msg = "Shop cannot be deleted due to still has pictures.\n "
	           		+ "First you should burn all pictures from shop.\n" + " Try at: http://localhost:8080/api/burn/" + shop.getId();
		} else {
			shopServiceImpl.deleteShop(id);
			msg = shop.getName() + " shop has been deleted";
		}
		return msg;	
	}

}
