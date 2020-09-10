package e3SpringPictureShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e3SpringPictureShop.dao.IPictureDAO;
import e3SpringPictureShop.dto.Picture;
import e3SpringPictureShop.dto.Shop;


@Service
public class PictureServiceImpl implements IPictureService {

	//Use of methods from repository DAO
	@Autowired
	IPictureDAO iPictureDAO;
	
	//Create picture
	@Override
	public Picture addPicture(Picture picture) {
		return iPictureDAO.save(picture);
	}

	//Get all pictures
	@Override
	public List<Picture> listAllPictures() {
		return iPictureDAO.findAll();
	}

	//Get pictures from shop
	@Override
	public List<Picture> listPictures(Shop shop) {
		return iPictureDAO.findAllByShop(shop);
	}

	//Get picture by id
	@Override
	public Picture getPicture(Long id) {
		return iPictureDAO.findById(id).get();
	}

	//Update picture
	@Override
	public Picture updatePicture(Picture picture) {
		return iPictureDAO.save(picture);
	}

	//Delete picture
	@Override
	public void deletePicture(Long id) {
		iPictureDAO.deleteById(id);	
	}

	//Delete all picture from shop
	@Override
	public void burnPictures(Shop shop) {
		iPictureDAO.deleteAllByShop(shop);
	}

}
