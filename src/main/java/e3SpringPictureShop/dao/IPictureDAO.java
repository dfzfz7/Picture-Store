package e3SpringPictureShop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import e3SpringPictureShop.dto.Picture;


public interface IPictureDAO extends JpaRepository<Picture, Long>{

	//List all pictures from a shop
	List<Picture> findAllByShop(Long id);
	
	//delete all pictures from a shop
	void deleteAllByShop(Long id);
}
