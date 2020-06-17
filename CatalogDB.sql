create database `CATALOGDB`;

CREATE TABLE `Category` (
  `categoryId` int PRIMARY KEY auto_increment,
  `categoryName` varchar(255)
);

CREATE TABLE `Product` (
  `productId` int PRIMARY KEY auto_increment,
  `productName` varchar(255),
  `productDescription` varchar(255),
  `productPrice` double,
  `categoryId` int
);

CREATE TABLE `ProductImage` (
  `imageId` int PRIMARY KEY auto_increment,
  `imagePath` varchar(255),
  `productId` int
);

CREATE TABLE `Contact` (
  `contactId` int PRIMARY KEY auto_increment,
  `contactEmail` varchar(255),
  `contactNumber` varchar(255),
  `contactFaceBook` varchar(255),
  `contactInstagram` varchar(255),
  `contactTwitter` varchar(255),
  `contactYoutube` varchar(255)
);

CREATE TABLE `CatalogUser` (
  `userId` int PRIMARY KEY auto_increment,
  `userEmail` varchar(255),
  `userPassword` varchar(255),
  `userName` varchar(255),
  `isAdmin` bool
);

CREATE TABLE `Suggestion` (
  `suggestionId` int PRIMARY KEY auto_increment,
  `suggestionDescription` varchar(255),
  `userdId` int
);

ALTER TABLE Category ADD FOREIGN KEY (categoryId) REFERENCES Product(categoryId);

ALTER TABLE Product ADD FOREIGN KEY (productId) REFERENCES ProductImage(productId);

ALTER TABLE CatalogUser ADD FOREIGN KEY (userdId) REFERENCES Suggestion(userdId);
