insert into product (`id`,`product_id`,`brand`,`category`) values (1,'PR-1','Soccer','GAME')
insert into product (`id`,`product_id`,`brand`,`category`) values (2,'PR-2','Dance','GAME')
insert into shopper (`id`,`shopper_id`,`age`) values (1,'SH-1',15)
insert into shopper (`id`,`shopper_id`,`age`) values (2,'SH-2',19)
insert into shopper_product (`id`,`shopper_id`,`product_id`,`relevancy_score`) values (1,'SH-1','PR-1', 23.19)
insert into shopper_product (`id`,`shopper_id`,`product_id`,`relevancy_score`) values (2,'SH-1','PR-2', 56.19)
insert into shopper_product (`id`,`shopper_id`,`product_id`,`relevancy_score`) values (3,'SH-2','PR-1', 99.19)
insert into shopper_product (`id`,`shopper_id`,`product_id`,`relevancy_score`) values (4,'SH-2','PR-2', 59.19)