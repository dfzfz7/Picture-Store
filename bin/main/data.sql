DROP TABLE IF EXISTS `picture`;
DROP TABLE IF EXISTS `shop`;


CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45),
  `author` varchar(45),
  `price` double,
  `entry_date` date,
  `shop_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_picture_shop` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ;


CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopName` varchar(45),
  `capacity` int(11),
  PRIMARY KEY (`id`)
) ;


insert into shop (shopName, capacity) values ('White Collar Barcelona', 30);
insert into shop (shopName, capacity) values ('White Collar Berlin', 40);
insert into shop (shopName, capacity) values ('White Collar Moscow', 50);

insert into picture (title, author, price, entry_date, shop_id) values('Guernica', 'Pablo Picasso', '800', NOW(), 1);
insert into picture (title, author, price, entry_date, shop_id) values('The Scream', 'Edvard Munch', '900', NOW(), 1);
insert into picture (title, author, price, entry_date, shop_id) values('The Persistence of Memory', 'Salvador Dalí', '700', NOW(), 1);
insert into picture (title, author, price, entry_date, shop_id) values('Calvary', null, '500', NOW(), 1);
insert into picture (title, author, price, entry_date, shop_id) values('The Kiss', 'Gustav Klimt', '500', NOW(), 2);
insert into picture (title, author, price, entry_date, shop_id) values('Mona Lisa', 'Leonardo da Vinci', '700', NOW(), 2);
insert into picture (title, author, price, entry_date, shop_id) values('Inferno', null, '600', NOW(), 3);
insert into picture (title, author, price, entry_date, shop_id) values('The Starry Night', 'Vincent Van Gogh', '800', NOW(), 3);
insert into picture (title, author, price, entry_date, shop_id) values('The Night Watch', 'Rembrandt', '400', NOW(), 3);
