CREATE TABLE if not exists `PET_INFO` (
  `pet_id` int NOT NULL AUTO_INCREMENT,
  `pet_type` varchar(255) ,
  `pet_name` varchar(355) ,
  `pet_price` BIGINT  ,
  PRIMARY KEY (`pet_id`)
);
