package e3SpringPictureShop.service;

import java.util.List;

import e3SpringPictureShop.dto.Shop;


public interface IShopService {

	//CRUD METHODS
	
	//Create shop
	public Shop createShop(Shop shop);
	
	//Get all shops
	public List<Shop> listShops();
	
	//Get shop by id
	public Shop getShop(Long id);
	
	//Update shop
	public Shop updateShop(Shop shop);
	
	//Delete shop
	public void deleteShop(Long id);
	
}
