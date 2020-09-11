package e3SpringPictureShop.service;

import java.util.List;

import e3SpringPictureShop.dto.Picture;
import e3SpringPictureShop.dto.Shop;

public interface IPictureService {

	// CRUD METHODS

	// Create picture
	public Picture addPicture(Picture picture);

	// Get all pictures
	public List<Picture> listAllPictures();

	// Get pictures from shop
	public List<Picture> listPictures(Shop shop);

	// Get picture by id
	public Picture getPicture(Long id);

	// Update picture
	public Picture updatePicture(Picture picture);

	// Delete picture
	public void deletePicture(Long id);

}
