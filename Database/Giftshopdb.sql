CREATE DATABASE giftShopDb
USE giftShopDb
CREATE TABLE Account (
   aid   INT    NOT NULL identity(1,1),
   username NVARCHAR (32)     NOT NULL,
   [password] NVARCHAR (20)     NOT NULL,
   
   isAdmin BIT	  NOT NULL,
   
   PRIMARY KEY (aid)
);

SET IDENTITY_INSERT Account OFF
GO

INSERT INTO Account(username, [password], isAdmin) VALUES ('abc', '1234', 0);
INSERT INTO Account(username, [password], isAdmin) VALUES ('rooney123', 'av123', 1);
INSERT INTO Account(username, [password], isAdmin) VALUES ('ronaldol07', 'messi10', 1);
INSERT INTO Account(username, [password], isAdmin) VALUES ('kagawa23', 'japan123', 0);
INSERT INTO Account(username, [password], isAdmin) VALUES ('xyz', 'abc123', 0);
INSERT INTO Account(username, [password], isAdmin) VALUES ('flawless13', 'catcat123', 0);
INSERT INTO Account(username, [password], isAdmin) VALUES ('buffor76', 'aafg123', 0);



GO
CREATE TABLE Customer (
   custid   INT    NOT NULL identity(1,1),
   firstname NVARCHAR (150)     NOT NULL,
   lastname NVARCHAR (150)     NOT NULL,
   [address] NVARCHAR (50)     NOT NULL,
   [city] NVARCHAR (50)     NOT NULL,
   [phone] NVARCHAR (50)     NOT NULL,
   
   PRIMARY KEY (custid),
   );
SET IDENTITY_INSERT Customer OFF
INSERT INTO Customer(firstname,lastname,[address],city,phone)
values ('Nguyen','Kim','255-Tay Ho','Ha Noi','0984235765')
INSERT INTO Customer(firstname,lastname,[address],city,phone)
values ('Tran','Vu','199-Kim Ho','Thai Nguyen','0984765245')
INSERT INTO Customer(firstname,lastname,[address],city,phone)
values ('Le','Kim Anh','265-Kim Ma','Ha Noi','0914535765')
INSERT INTO Customer(firstname,lastname,[address],city,phone)
values ('La','Tu','153-Tran Hung Dao','Ha Noi','0915635876')
INSERT INTO Customer(firstname,lastname,[address],city,phone)
values ('Ly','Nha','456-Thanh Xuan','Ha Noi','0914567234')

CREATE TABLE CustomerAccount (
   custid   INT    NOT NULL,
    aid   INT		
   
   PRIMARY KEY (custid,aid ),
    CONSTRAINT fk_aid_1514 FOREIGN KEY (aid) REFERENCES Account(aid),
    CONSTRAINT fk_custid_1514 FOREIGN KEY (custid) REFERENCES Customer(custid)
   );

INSERT INTO CustomerAccount(custid,aid)
values (1,5)
INSERT INTO CustomerAccount(custid,aid)
values (2,4)
INSERT INTO CustomerAccount(custid,aid)
values (1,1)



CREATE TABLE Category (
   cid   INT    NOT NULL identity(1,1),
   categoryname NVARCHAR (80)     NOT NULL,
   
   
   PRIMARY KEY (cid)
);


SET IDENTITY_INSERT Category OFF
GO
INSERT INTO Category(categoryname) VALUES ('Fashion');
INSERT INTO Category(categoryname) VALUES ('Equipment');
INSERT INTO Category(categoryname) VALUES ('Accessories');
INSERT INTO Category(categoryname) VALUES ('Other');


CREATE TABLE Product (
   pid   INT    NOT NULL identity(1,1),
   productname NVARCHAR (150)     NOT NULL,
   productimg NVARCHAR (1500)     NOT NULL,
   productprice INT  NOT NULL,
   productnote  NVARCHAR (150)     NOT NULL,
   cid   INT    NOT NULL,
   
   PRIMARY KEY (pid),
   CONSTRAINT fk_category_4124 FOREIGN KEY (cid) REFERENCES[Category](cid)
   );
SET IDENTITY_INSERT Product OFF
GO
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Home Shirt 2021-22','https://images.footballfanatics.com/manchester-united/manchester-united-home-shirt-2021-22_ss4_p-12052601+u-at664r59yn8qgpq61tz1+v-206a8d38ca49417f845b1e6711c02106.jpg?_hv=1&w=340',55,'Manchester United Home Shirt 2021-22 with new design ',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era On Black Cool','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-black-on-black-devil-9fifty-snapback-cap-black-unisex_ss4_p-11861921+u-hwiw6zwz6e49k0dh2cum+v-3e3df06d73fd424b8e952022d5dfda3c.jpg?_hv=1&w=340',25,'Black Devil 9FIFTY Snapback Cap - Black - Unisex',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Black Phone Case','https://opdienthoai.shop/wp-content/uploads/2021/05/MU-99-1.jpg',2,'New cloths for your phone',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Mascot PVC Backpack','https://images.footballfanatics.com/manchester-united/manchester-united-mascot-pvc-backpack_ss4_p-12068555+u-1a952rlsadt2edvae9oi+v-fac5cabfca52442f9e3700320049a66a.jpg?_hv=1&w=340',15,'New backpack for this season',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Away Shirt 2021-22','https://images.footballfanatics.com/manchester-united/manchester-united-away-shirt-2021-22_ss4_p-12052603+u-b7sp7qmu31as2usy5man+v-765af7e8dd784446a6249a8959f37917.jpg?_hv=1&w=340',55,'Manchester United Away Shirt 2021-22 with new design',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Power Backpack - Red','https://images.footballfanatics.com/manchester-united/manchester-united-power-backpack-red_ss4_p-12070952+u-8qynecqmng4q4j0efij8+v-fee5827b420640c8b6f441ea12dc7959.jpg?_hv=1&w=340',17,'Manchester United Power Backpack - Red Always by your side',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Waistbag - Black','https://images.footballfanatics.com/manchester-united/manchester-united-waistbag-black_ss4_p-12070947+u-1geixs7gae54l95y3plv+v-d92222011e30463a9daf30a1f6103d2e.jpg?_hv=1&w=340',18,'Manchester United Waistbag - Black reach out',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Golf Umbrella','https://images.footballfanatics.com/manchester-united/manchester-united-golf-umbrella_ss4_p-12072778+u-15sqjj83wtbvdeuqpzhf+v-02a79b8a9d0a44f4a128fb13723de2e8.jpg?_hv=1&w=340',40,'Manchester United Golf Umbrella experts with vision',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Love Keyring','https://images.footballfanatics.com/manchester-united/manchester-united-love-keyring_ss4_p-12013358+u-1f4u56bjs9ejr5zvda90+v-8651e6cc9ad940d6be6721220473076f.jpg?_hv=1&w=340',3,'Manchester United Love Keyring more of what you want',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Third Shirt 2021-22','https://images.footballfanatics.com/manchester-united/manchester-united-third-shirt-2021-22_ss4_p-12052548+u-11j173tm5vq2ycw9fyvr+v-2f47135b2bc64b3a8d5cc4b1f32349ad.jpg?_hv=1&w=340',43,'Manchester United Third Shirt 2021-22 more ways to be you.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Latte Mug - 11oz','https://images.footballfanatics.com/manchester-united/manchester-united-latte-mug-11oz_ss4_p-12015457+u-19fs85zst5dr5ogv67jb+v-17086eafc4bf4585b8a62dd305321e34.jpg?_hv=1&w=340',10,'Manchester United Latte Mug - 11oz Good with food.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United x Paul Smith - Tie','https://images.footballfanatics.com/manchester-united/manchester-united-x-paul-smith-tie_ss4_p-12046270+u-1ro4sz64pim1mpxqceia+v-c3bfdaeb58594fb589887bca092bac51.jpg?_hv=1&w=340',110,'Manchester United x Paul Smith - Tie Partners in eye care.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United 3D Crest Magnet','https://images.footballfanatics.com/manchester-united/manchester-united-3d-crest-magnet_ss4_p-11910389+u-yh0scowve9upuwsa4laf+v-1a28697d33b54b0c999e809123cb72c4.jpg?_hv=1&w=340',3,'Manchester United 3D Crest Magnet Treasure every day.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United x Paul Smith - Print Interior Billfold Wallet','https://images.footballfanatics.com/manchester-united/manchester-united-x-paul-smith-vintage-rosette-print-interior-billfold-wallet_ss4_p-11972325+u-rk8qchpsiwgbjqhmkyma+v-720555f2c82142908a283143651eaa87.jpg?_hv=1&w=340',155,'Manchester United x Paul Smith - Vintage Rosette Print Interior Billfold Wallet Just for you.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United x Paul Smith - Canvas Wash Bag','https://images.footballfanatics.com/manchester-united/manchester-united-x-paul-smith-vintage-rosette-canvas-wash-bag_ss4_p-11975046+u-1avskchz0baity7yixf4+v-c775d640801e41d580de1484e4b0b8f9.jpg?_hv=1&w=340',145,'Manchester United x Paul Smith - Vintage Rosette Canvas Wash Bag Quality is essential.',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Sancho Framed Print - A3','https://images.footballfanatics.com/manchester-united/manchester-united-sancho-framed-print-a3_ss4_p-12095554+u-19a7g67bmg15igs0hkdz+v-bb1b5cbf7b1b4d73878b4be6515ddb1e.jpg?_hv=1&w=340',35,'Manchester United Sancho Framed Print - A3 Ready to order.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United De Gea Bobble Head','https://images.footballfanatics.com/manchester-united/manchester-united-de-gea-bobble-head_ss4_p-12057413+u-r7k17tk4owz7blkgcll7+v-65dbf020603549789d4664bb989c493b.jpg?_hv=1&w=340',14,'Manchester United De Gea Bobble Head Yours need to fulfill here.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Fernandes Bobble Head','https://images.footballfanatics.com/manchester-united/manchester-united-fernandes-bobble-head_ss4_p-12057447+u-18bwg77hba3lvxdwlvov+v-e6a3c8ea7c11491b8f9c48e4f333f3c8.jpg?_hv=1&w=340',14,'Manchester United Fernandes Bobble Head Shop on your couch.',4)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Classic Organiser Bag - Black','https://images.footballfanatics.com/manchester-united/manchester-united-classic-organiser-bag-black_ss4_p-12070953+u-18d0fij4hsebkc5gsc9l+v-2c5dfad4469d4c78ad714feb237fe6a8.jpg?_hv=1&w=340',16,'Manchester United Classic Organiser Bag - Black Nobody care like us.',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Crest Football - Red-White-Black - Size 1','https://images.footballfanatics.com/manchester-united/manchester-united-crest-football-red-white-black-size-1_ss4_p-12030629+u-npu31wrfslg5j459yfub+v-e53e79600ca64661951d808814a8013e.jpg?_hv=1&w=340',8,'Manchester United Crest Football - Red-White-Black - Size 1 step away to you.',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Power Backpack - Black','https://images.footballfanatics.com/manchester-united/manchester-united-power-backpack-black_ss4_p-12070948+u-ib9zzzhvzuvaqhuf4mb3+v-a0a2b66dbca2493390d8044b8d2819a3.jpg?_hv=1&w=340',21,'Manchester United Power Backpack - Black Our prices are unbeatable!',2)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Cristiano Ronaldo Scarf - Red','https://images.footballfanatics.com/manchester-united/manchester-united-cristiano-ronaldo-scarf-red_ss4_p-12094029+u-1ej1ngc5iob1jb60h1en+v-e8cda73e38dc4901a07ba6f64744ad79.jpg?_hv=1&w=340',13,'Manchester United Cristiano Ronaldo Scarf - Red You’re in good hands with us.',3)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Synthetic Watch Charcoal/Red','https://images.footballfanatics.com/manchester-united/manchester-united-synthetic-watch-charcoal/red_ss4_p-12065417+u-clro0aptvoucbg1kt9jd+v-7a96750de3ad40bf98b18f52c0d269a6.jpg?_hv=1&w=340',20,'Manchester United Synthetic Watch Charcoal/Red The happiest place on earth.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Stripe Crest Tie - Red','https://images.footballfanatics.com/manchester-united/manchester-united-stripe-crest-tie-red_ss4_p-12072996+u-13n7n74jldut0r8uyro7+v-771b998205af410f83131e1e081293e2.jpg?_hv=1&w=340',15,'Manchester United Stripe Crest Tie - Red Get the look of your dreams.',3)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Maui Jim Mongoose Sunglasses - Grey','https://images.footballfanatics.com/manchester-united/manchester-united-maui-jim-mongoose-sunglasses-grey_ss4_p-12047480+u-pdril20q6ojqedrmj2sv+v-e976983694c14625b37728c3f6848744.jpg?_hv=1&w=340',238,'Manchester United Maui Jim Mongoose Sunglasses - Grey  It can be more.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Home Goalkeeper Shirt 2021-22','https://images.footballfanatics.com/manchester-united/manchester-united-home-goalkeeper-shirt-2021-22_ss4_p-12052534+u-13di054spowzypp38az2+v-b381e8435e6144408d5456b56a0aea14.jpg?_hv=1&w=340',46,'Manchester United Home Goalkeeper Shirt 2021-22 Let shine.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Teamgeist T-Shirt - White','https://images.footballfanatics.com/manchester-united/manchester-united-teamgeist-t-shirt-white_ss4_p-12084837+u-kvpcl21pe4m227nwnwaj+v-bdd4c97337dd462d9597b89ce6773660.jpg?_hv=1&w=340',29,'Manchester United Teamgeist T-Shirt - White The way you are perfect.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Training All Weather Jacket-Grey','https://images.footballfanatics.com/manchester-united/manchester-united-training-all-weather-jacket-grey_ss4_p-12052540+u-ivabpnk3p6qlr73l8xwz+v-49890bd3dad44b22a2d55e7a43ce159b.jpg?_hv=1&w=340',45,'Manchester United Training All Weather Jacket-Grey No more shy let get it.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United adidas Ronaldo MCR T-Shirt - White','https://images.footballfanatics.com/manchester-united/manchester-united-adidas-ronaldo-mcr-t-shirt-white_ss4_p-12093453+u-dolnu0idsj4nug5d6pb+v-bfe26699d9db46e49d1b3a7ce86f76d7.jpg?_hv=1&w=340',18,'Manchester United adidas Ronaldo MCR T-Shirt - White CR7 in my heart.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Ball Keyring - Silver','https://images.footballfanatics.com/manchester-united/manchester-united-ball-keyring-silver_ss4_p-11889499+u-4atfwlkbk1vsx1xbpq3j+v-889e43eb9e934af7adf307388c8128e5.jpg?_hv=1&w=340',5,'Manchester United Ball Keyring - Silver Be a memory of your life.',4)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Iridescent Cap - Black - Unisex','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-iridescent-9fifty-streth-snap-back-cap-black-unisex_ss4_p-13308294+u-17ni2res12pcbdv7ifd8+v-d74edfbc4126499f812a05e790c2bf4e.jpg?_hv=1&w=340',31,'Manchester United New Era Iridescent Cap - Black - Unisex Do you want some hip hop.',3)


INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Devil Bobble Hat - Black - Unisex','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-iridescent-devil-bobble-hat-black-unisex_ss4_p-13308299+u-164fgcie3zox817t7tc3+v-10b7614756cb420c9885202edd871f7c.jpg?_hv=1&w=340',25,'Manchester United New Era Devil Bobble Hat - Black - Unisex No more cold.',3)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Devil AOP Cap - Black - Unisex','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-devil-aop-trucker-9forty-cap-black-unisex_ss4_p-13308295+u-o9f43jwh32bjqw6i5y88+v-13b403a59a0b4abfad9de6ade45b94b3.jpg?_hv=1&w=340',26,'Manchester United New Era Devil AOP Cap - Black - Unisex Special from simple.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Rubber Crest Cap - Navy - Unisex','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-rubber-crest-9forty-adjustable-cap-navy-unisex_ss4_p-12060713+u-c4ngu9jttkxzqlhit2bo+v-739ed914353544e8bbcdf81b6c247085.jpg?_hv=1&w=340',16,'Manchester United New Era Rubber Crest Cap - Navy - Unisex You just need to buy it.',3)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United TAG Heuer TH Formula 1 Quartz Watch','https://images.footballfanatics.com/manchester-united/manchester-united-tag-heuer-th-formula-1-quartz-watch_ss4_p-13302342+u-znom43bbzandzse01l0a+v-51e730d6cb174d8da1ef275fdeb23fd5.jpg?_hv=1&w=340',1350,'Manchester United TAG Heuer TH Formula 1 Quartz Watch You deserve this.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Pogba Print - A2 Always Cool','https://images.footballfanatics.com/manchester-united/manchester-united-pogba-print-a2_ss4_p-12095579+u-1bus4oty29muo47l3tir+v-c1110ba20dfa4c17bde21ed34734ee8e.jpg?_hv=1&w=340',20,'Manchester United Pogba Print - A2 Star with new hair style.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United x Paul Smith - Case Print','https://images.footballfanatics.com/manchester-united/manchester-united-x-paul-smith-vintage-rosettes-print-leather-iphone-6/6s/7/8-case_ss4_p-11977906+u-10b7rlx32k1u9h0gnzot+v-73d9d03d951049ffaea50c91dbf735f0.jpg?_hv=1&w=340',75,'Manchester United x Paul Smith - Case Print Your phone with look special.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Official 2022 Desk Calendar','https://images.footballfanatics.com/manchester-united/manchester-united-official-2022-desk-calendar_ss4_p-12072148+u-xisrcqfu4lzag5vkoa6d+v-e8e2c8a6cba7449fbbdf70b143fc1793.jpg?_hv=1&w=340',5,'Manchester United Official 2022 Desk Calendar New year new happy.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United x Paul Smith - Print 13 Laptop Case','https://images.footballfanatics.com/manchester-united/manchester-united-x-paul-smith-vintage-rosette-print-13-laptop-case_ss4_p-11976499+u-l9o6dnwg7ovyh61kouur+v-405e5d51ebd24cc68b8facc7dc46fba1.jpg?_hv=1&w=340',165,'Manchester United x Paul Smith - Print 13 Laptop Case Your laptop will be cool.',4)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Pre Match Warm Top - Black','https://images.footballfanatics.com/manchester-united/manchester-united-pre-match-warm-top-black_ss4_p-12085143+u-d8q1y4nycdumk31nsxwz+v-edf57b4ae14947ce96fa5b6f4daeaf6f.jpg?_hv=1&w=340',90,'Manchester United Pre Match Warm Top - Black Warm but still cool.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Anthem Jacket - Maroon ','https://images.footballfanatics.com/manchester-united/manchester-united-anthem-jacket-maroon_ss4_p-12018317+u-g1iva0sht5jif6fcc3fq+v-cee34be94ae14f618e190876796818fa.jpg?_hv=1&w=340',60,'Manchester United Anthem Jacket - Maroon Some different for you.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Windbreaker Jacket - Black','https://images.footballfanatics.com/manchester-united/manchester-united-windbreaker-jacket-black_ss4_p-12085775+u-10f4wco7425e0ybxfxep+v-a190ced812d3444a95fa1ca33e8b9387.jpg?_hv=1&w=340',65,'Manchester United Windbreaker Jacket - Black Black always cool.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Bamboo Mix Lunchbox and Cutlery Set','https://images.footballfanatics.com/manchester-united/manchester-united-bamboo-mix-lunchbox-and-cutlery-set_ss4_p-12057484+u-1gnq41v5fmi16iohjtcu+v-42201b42023346e3b9fde45749c0099f.jpg?_hv=1&w=340',10,'Manchester United Bamboo Mix Lunchbox and Cutlery Set Make you feel happy.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Gift Wrap 2021-2022','https://images.footballfanatics.com/manchester-united/manchester-united-gift-wrap_ss4_p-11974519+u-fwwo5vzohg74ynayhj2d+v-cfbde8eeaf7643e994d3e1048db002c5.jpg?_hv=1&w=340',6,'Manchester United Gift Wrap 2021-2022 Gift and a gift.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Pre Match Top - Black','https://images.footballfanatics.com/manchester-united/manchester-united-pre-match-top-black_ss4_p-12085178+u-n0q5md9i6cxmp87j2ev5+v-1584c0bb6365449bacf6e6b7c5c077e7.jpg?_hv=1&w=340',55,'Manchester United Pre Match Top - Black New design new style.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United x Paul Smith - Leather Glove','https://images.footballfanatics.com/manchester-united/manchester-united-x-paul-smith-leather-glove_ss4_p-12046271+u-15wnmv0i6p23gso6ckub+v-af62e7871ff242c7a8c5bf9d5efced1d.jpg?_hv=1&w=340',165,'Manchester United x Paul Smith - Leather Glove Keep your hand be safe.',2)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United 1973 No 7 Retro Shirt - Red - Mens','https://images.footballfanatics.com/manchester-united/manchester-united-1973-no-7-retro-shirt-red-mens_ss4_p-11969815+u-79of9t1fruk7ub1a7b2i+v-3acb1a21ff34413280adccea5c055724.jpg?_hv=1&w=340',26,'Manchester United 1973 No 7 Retro Shirt - Red - Mens Victory memory.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Sancho T-Shirt by Stanley Chow','https://images.footballfanatics.com/manchester-united/manchester-united-sancho-t-shirt-by-stanley-chow-white-unisex_ss4_p-13303062+u-8zb5x6wttf20qas8nc68+v-2055fcb0e12142318f84e855ed2a8d31.jpg?_hv=1&w=340',28,'Manchester United Sancho T-Shirt by Stanley Chow Simple T-Shirt.',2)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Backpack-Red 2021-2022','https://images.footballfanatics.com/manchester-united/manchester-united-backpack-red_ss4_p-12053273+u-18bledrdbraqoz8072ym+v-68358d0244114b078771409ec24cfc27.jpg?_hv=1&w=340',24,'Manchester United Backpack-Red 2021-2022 Wanna be special.',2)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Crest Back Pack 2021-2022','https://images.footballfanatics.com/manchester-united/manchester-united-crest-back-pack_ss4_p-11992323+u-qyplwxxjuwdlccdtmt8h+v-3f665e5f32434244aeaff5e54f42cdf8.jpg?_hv=1&w=340',10,'Manchester United Crest Back Pack 2021-2022 Just useful for you.',2)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United adidas 3 Stripe Crew Sweatshirt - Mens','https://images.footballfanatics.com/manchester-united/manchester-united-adidas-3-stripe-crew-sweatshirt-grey-heather-mens_ss4_p-12069963+u-5ozs92df5xt7iohfc68v+v-444a48e47e8c43e88f225fe7ec011003.jpg?_hv=1&w=340',35,'Manchester United adidas 3 Stripe Crew Sweatshirt - Mens Keep warm for winter.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Teamgeist Woven Pants - Black','https://images.footballfanatics.com/manchester-united/manchester-united-teamgeist-woven-pants-black_ss4_p-12085200+u-122wfrces1wfp6645hwz+v-5e65fa469e6b4b47bc2f1fd4e558003c.jpg?_hv=1&w=340',63,'Manchester United Teamgeist Woven Pants - Black Pay less buy more.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United adidas Future Icons Hoodie - Black - Mens','https://images.footballfanatics.com/manchester-united/manchester-united-adidas-future-icons-3-stripe-full-zip-hoodie-black-mens_ss4_p-13303123+u-irx2pyu520ce2f3g1y8b+v-fda9ef9fa9c643c4a27b2b1e18024da1.jpg?_hv=1&w=340',65,'Manchester United adidas Future Icons Hoodie - Black - Mens Feel like a rapper.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Long Pyjamas - Black - Mens','https://images.footballfanatics.com/manchester-united/manchester-united-long-pyjamas-black-mens_ss4_p-12067881+u-kibyy25cbvkk6m6r21og+v-28d21b963bdf41b3a9fd923bc7053752.jpg?_hv=1&w=340',20,'Manchester United Long Pyjamas - Black - Mens Dream come true.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United adidas Feel Vivid Hoodie - Wonder','https://images.footballfanatics.com/manchester-united/manchester-united-adidas-feel-vivid-hoodie-wonder-mauve-mens_ss4_p-13303108+u-kcbsj7t3hl23i8v5xuqy+v-609827601ad044b5b4d97a4cbdbb9732.jpg?_hv=1&w=340',50,'Manchester United adidas Feel Vivid Hoodie - Wonder Pink in the area.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United adidas 3 Stripe Shorts - Grey','https://images.footballfanatics.com/manchester-united/manchester-united-adidas-3-stripe-shorts-grey-heather-mens_ss4_p-12069950+u-12rq98o97vmnlfzf5b8o+v-44c7586eccb64b8596f6e0a538b2116c.jpg?_hv=1&w=340',30,'Manchester United adidas 3 Stripe Shorts - Grey It more than good.',1)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Varane T-Shirt by Stanley Chow - Grey','https://images.footballfanatics.com/manchester-united/manchester-united-varane-t-shirt-by-stanley-chow-grey-marl-unisex_ss4_p-13303061+u-122s19y0bdwxj9selgcb+v-4a942efc68814f6fab65ea9ac4e69de2.jpg?_hv=1&w=340',28,'Manchester United Varane T-Shirt by Stanley Chow - Grey Like a rock.',1)

INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Screen Print Devil Red - Unisex','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-screen-print-devil-39thirty-a-frame-cap-red-unisex_ss4_p-12060727+u-f1pcgx0rqh6shvfha8xp+v-58b30e28faa94a0ea2417681dc033fc6.jpg?_hv=1&w=340',16,'Manchester United New Era Screen Print Devil Red - Unisex.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Devil 9FORTY Adjustable Cap','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-devil-9forty-adjustable-cap-grey-womens_ss4_p-12060715+u-93r92o2ih3hkjnyqjlce+v-469d8dbd8c9c47a0a9343f7ad9db72d4.jpg?_hv=1&w=340',12,'Manchester United New Era Devil 9FORTY Adjustable Cap Sivle to be royal.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Poly Stretch Fit Cap','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-featherweight-poly-39thirty-stretch-fit-cap-red-adult_ss4_p-12014235+u-uxfrii2xru249ggqcwff+v-0f23555e5b544e51bc3d008c5779ace2.jpg?_hv=1&w=340',18,'Manchester United New Era Poly Stretch Fit Cap Like a rose.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Featherweight Rear Arch','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-featherweight-rear-arch-9forty-adjustable-cap-grey-unisex_ss4_p-13308296+u-xhegqk0thwszoaov5tfn+v-16b574c0fd9d4e8e935f7beb4e1ff687.jpg?_hv=1&w=340',25,'Manchester United New Era Featherweight Rear Arch Help you be cooler.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United New Era Devil Two Tone','https://images.footballfanatics.com/manchester-united/manchester-united-new-era-devil-two-tone-9forty-adjustable-cap-grey-unisex_ss4_p-12060717+u-gyga8vzix0a26pcazaaz+v-587594c3285c4abea7595204dba14081.jpg?_hv=1&w=340',20,'Manchester United New Era Devil Two Tone Black make you shine.',3)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Ronaldo Wall Sticker - Lifesize','https://images.footballfanatics.com/manchester-united/manchester-united-ronaldo-wall-sticker-lifesize_ss4_p-13302791+u-dh6yoauztspyp6tulf2a+v-35f845cf85454ab096f994d039162f61.jpg?_hv=1&w=340',50,'Manchester United Ronaldo Wall Sticker - Lifesize CR7 at your home.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Crest Curtain - 54 Inch Drop','https://images.footballfanatics.com/manchester-united/manchester-united-crest-curtain-54-inch-drop_ss4_p-11892073+u-6omo2riizs3bt24q1xie+v-85a48306f6344aa0aa3c8402b1093b57.jpg?_hv=1&w=340',28,'Manchester United Crest Curtain - 54 Inch Drop Wannna try different.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Christmas Santa Puff Soft Toy','https://images.footballfanatics.com/manchester-united/manchester-united-christmas-santa-puff-soft-toy-1125cm_ss4_p-12016309+u-wk8ningpmjdtahf7svrk+v-e65729221e3546e3aed2e167b2ff74bb.jpg?_hv=1&w=340',7,'Manchester United Christmas Santa Puff Soft Toy Happy for your children.',4)
INSERT INTO Product(productname,productimg,productprice,productnote,cid)
Values ('Manchester United Golf Valuables Bag 2021-2022','https://images.footballfanatics.com/manchester-united/manchester-united-golf-valuables-bag_ss4_p-12072773+u-s5ccuyzba6xmktwr1nvm+v-ba080a082352454a85ccdcfd1a47cee5.jpg?_hv=1&w=340',25,'Manchester United Golf Valuables Bag 2021-2022 Be your silde.',2)

CREATE TABLE [Order] (
   orderid   INT    NOT NULL  identity(1,1),
   custid   INT    NOT NULL ,
      
   accountidorder INT   ,  
   orderdate date NOT NULL
   PRIMARY KEY (orderid)
    CONSTRAINT fk_custid_1414 FOREIGN KEY (custid) REFERENCES Customer(custid)
   
);
SET IDENTITY_INSERT [Order] OFF
GO
INSERT INTO [Order](custid,accountidorder,orderdate) VALUES (1,2,'2022-02-23');
INSERT INTO [Order](custid,accountidorder,orderdate) VALUES (2,1,'2022-02-19');
INSERT INTO [Order](custid,accountidorder,orderdate) VALUES (3,2,'2022-02-23');
INSERT INTO [Order](custid,accountidorder,orderdate) VALUES (3,2,'2022-02-25');


CREATE TABLE Cart (
   orderid   INT    NOT NULL ,
   pid   INT    NOT NULL ,
      
   amount INT    NOT NULL,  
   PRIMARY KEY (orderid,pid),
   CONSTRAINT fk_pid_4334 FOREIGN KEY (pid) REFERENCES Product(pid),
   CONSTRAINT fk_orderid_2626 FOREIGN KEY (orderid) REFERENCES [Order](orderid)
);

INSERT INTO Cart (orderid,pid,amount)
Values (1,1,3)
INSERT INTO Cart (orderid,pid,amount)
Values (1,2,4)
INSERT INTO Cart (orderid,pid,amount)
Values (1,3,2)
INSERT INTO Cart (orderid,pid,amount)
Values (1,4,5)
INSERT INTO Cart (orderid,pid,amount)
Values (2,1,4)
INSERT INTO Cart (orderid,pid,amount)
Values (2,2,4)
INSERT INTO Cart (orderid,pid,amount)
Values (2,3,1)
INSERT INTO Cart (orderid,pid,amount)
Values (2,4,1)
INSERT INTO Cart (orderid,pid,amount)
Values (3,1,2)
INSERT INTO Cart (orderid,pid,amount)
Values (3,2,4)
INSERT INTO Cart (orderid,pid,amount)
Values (3,3,4)
INSERT INTO Cart (orderid,pid,amount)
Values (3,4,1)
INSERT INTO Cart (orderid,pid,amount)
Values (4,12,2)
 
 CREATE TABLE Contact (
   contactid   INT    NOT NULL identity(1,1),
   firstname NVARCHAR (150)     NOT NULL,
   lastname NVARCHAR (150)     NOT NULL,
   [email] NVARCHAR (50)     NOT NULL,
   [phone] NVARCHAR (50)     NOT NULL,
   [message] NVARCHAR (300)     NOT NULL,
   contactdate DATE NOT NULL,
   PRIMARY KEY (contactid)
   );
INSERT INTO Contact(firstname,lastname,[email],[phone],[message],contactdate) VALUES ('Tran','Duyen','tranduyen124@gmail.com','0987252624','It cold today','2022-01-19');
INSERT INTO Contact(firstname,lastname,[email],[phone],[message],contactdate) VALUES ('Vu','Minh','vuminh158@gmail.com','0916356254','I can not receive product','2022-02-03');   
INSERT INTO Contact(firstname,lastname,[email],[phone],[message],contactdate) VALUES ('Bui','Trang','buitrang652@gmail.com','0983654264','I can login in shop page','2022-03-11');   
INSERT INTO Contact(firstname,lastname,[email],[phone],[message],contactdate) VALUES ('Luu','Thai','luuthai10@gmail.com','0961264765','Your shop are perfect','2022-02-22');   
INSERT INTO Contact(firstname,lastname,[email],[phone],[message],contactdate) VALUES ('Kim','Tuyen','kimtuyen145@gmail.com','091535635','I have a deal for you','2022-01-11');   
