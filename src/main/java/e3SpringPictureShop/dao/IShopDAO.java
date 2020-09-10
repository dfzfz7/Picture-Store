package e3SpringPictureShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import e3SpringPictureShop.dto.Shop;


public interface IShopDAO extends JpaRepository<Shop, Long>{

}
