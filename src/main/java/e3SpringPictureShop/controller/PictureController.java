package e3SpringPictureShop.controller;

import java.sql.Date;
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

import e3SpringPictureShop.dto.Picture;
import e3SpringPictureShop.dto.Shop;
import e3SpringPictureShop.service.PictureServiceImpl;

@RestController
@RequestMapping("/api")
public class PictureController {

	// Use of methods from Service
	@Autowired
	PictureServiceImpl pictureServiceImpl;

	// Create picture
	@PostMapping("/shops/{id}/pictures")
	public Picture addPicture(@PathVariable(name = "id") Shop shop, @RequestBody Picture picture) {
		picture.setAuthor(picture.getAuthor());
		picture.setShop(shop);
		picture.setDate(new Date(System.currentTimeMillis()));
		return pictureServiceImpl.addPicture(picture);
	}

	// Get all pictures
	@GetMapping("/pictures")
	public List<Picture> listAllPictures() {
		return pictureServiceImpl.listAllPictures();
	}

	// Get pictures from shop
	@GetMapping("/shops/{id}/pictures")
	public List<Picture> listPictures(@PathVariable(name = "id") Shop shop) {
		return pictureServiceImpl.listPictures(shop);
	}

	// Get picture by id
	@GetMapping("/pictures/{id}")
	public Picture getPicture(@PathVariable(name = "id") Long id) {
		return pictureServiceImpl.getPicture(id);
	}

	// Update picture
	@PutMapping("/pictures/{id}")
	public Picture updatePicture(@PathVariable(name = "id") Long id, @RequestBody Picture picture) {
		Picture pictureToUpdate = pictureServiceImpl.getPicture(id);
		pictureToUpdate.setTitle(picture.getTitle());
		pictureToUpdate.setAuthor(picture.getAuthor());
		pictureToUpdate.setPrice(picture.getPrice());
		return pictureServiceImpl.updatePicture(pictureToUpdate);
	}

	// Delete picture
	@DeleteMapping("/pictures/{id}")
	public void deletePicture(@PathVariable(name = "id")Long id) {
		pictureServiceImpl.deletePicture(id);
	}

	// Delete all picture from shop
	@DeleteMapping("/burn/{id}")
	public void burnPictures(@PathVariable(name = "id")Shop shop) {
		List<Picture> pictures = shop.getPictures();
		for (Picture p : pictures) {
			Long pictureId = p.getId();
			pictureServiceImpl.deletePicture(pictureId);
		}
		
	}

}
