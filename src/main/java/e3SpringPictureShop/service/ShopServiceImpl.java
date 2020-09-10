package e3SpringPictureShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e3SpringPictureShop.dao.IShopDAO;
import e3SpringPictureShop.dto.Shop;

@Service
public class ShopServiceImpl implements IShopService {

	// Use of methods from repository DAO
	@Autowired
	IShopDAO iShopDAO;

	// Create shop
	@Override
	public Shop createShop(Shop shop) {
		return iShopDAO.save(shop);
	}

	// Get all shops
	@Override
	public List<Shop> listShops() {
		return iShopDAO.findAll();
	}

	// Get shop by id
	@Override
	public Shop getShop(Long id) {
		return iShopDAO.findById(id).get();
	}

	// Update shop
	@Override
	public Shop updateShop(Shop shop) {
		return iShopDAO.save(shop);
	}

	// Delete shop
	@Override
	public void deleteShop(Long id) {
		iShopDAO.deleteById(id);
		// TODO - burn all books from shop???
	}

}
