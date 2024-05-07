-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 05:26 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `computer_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `StaffID` varchar(10) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gmail` varchar(40) NOT NULL,
  `Enable` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`StaffID`, `Username`, `Password`, `Gmail`, `Enable`) VALUES
('admin', 'admin', 'admin12', 'khoanguyen052096@gmail.com', 'unlock');

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `ActID` varchar(10) NOT NULL,
  `StaffID` varchar(10) NOT NULL,
  `ActName` varchar(255) NOT NULL,
  `ActTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `BrandID` varchar(10) NOT NULL,
  `BrandName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`BrandID`, `BrandName`) VALUES
('Acer', 'Acer Inc'),
('Apple', 'Apple Inc'),
('Asus', 'ASUSTeK Computer Inc'),
('DELL', 'Dell Inc'),
('HP', 'HP Inc'),
('Lenovo', 'Lenovo Group'),
('Microsoft', 'Microsoft Corporation'),
('Samsung', 'Samsung Electronics'),
('Sony', 'Sony Corporation'),
('Toshiba', 'Toshiba Corporation');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CusID` varchar(10) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `PhoneNumber` varchar(12) NOT NULL,
  `Gmail` varchar(50) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CusID`, `FirstName`, `LastName`, `Gender`, `PhoneNumber`, `Gmail`, `Address`) VALUES
('KH01', 'Lương', 'Khuê', 'Nữ', '0356678551', 'khueluong@gmail.com', '123 Võ Văn Tần p10 q5'),
('KH02', 'Nguyễn', 'Khoa', 'Nam', '0302040611', 'khoanguyen@gmail.com', '111 Ngô Gia Tự p8 q2'),
('KH03', 'Phan', 'Hân', 'Nữ', '0122665244', 'hanphan@gmail.com', '22 Tôn Đức Thắng p11 q3');

-- --------------------------------------------------------

--
-- Table structure for table `import`
--

CREATE TABLE `import` (
  `importID` varchar(10) NOT NULL,
  `SupplierID` varchar(10) NOT NULL,
  `StaffID` varchar(10) NOT NULL,
  `Total` int(20) NOT NULL,
  `Created_Time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `import`
--

INSERT INTO `import` (`importID`, `SupplierID`, `StaffID`, `Total`, `Created_Time`) VALUES
('PN01', 'SUP01', 'NV01', 150000000, '2024-05-06'),
('PN02', 'SUP01', 'NV02', 80000000, '2024-05-06'),
('PN03', 'SUP01', 'NV01', 32000000, '2024-05-06'),
('PN04', 'SUP01', 'NV02', 90000000, '2024-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `importdetail`
--

CREATE TABLE `importdetail` (
  `ImportDTID` varchar(10) NOT NULL,
  `ImportID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `importdetail`
--

INSERT INTO `importdetail` (`ImportDTID`, `ImportID`, `ProductID`, `Quantity`, `UnitPrice`, `Subtotal`) VALUES
('CPN01', 'PN01', 'ROGZEPHYRU', 3, 50000000, 150000000),
('CPN02', 'PN02', 'HPENVY15', 2, 40000000, 80000000),
('CPN03', 'PN03', 'ASPIRE5', 2, 6000000, 12000000),
('CPN04', 'PN03', 'ASUSVIVO', 2, 10000000, 20000000),
('CPN05', 'PN04', 'THINKPADX1', 3, 30000000, 90000000);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` varchar(10) NOT NULL,
  `BrandID` varchar(10) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Quantity` int(10) NOT NULL,
  `IMG` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `BrandID`, `ProductName`, `UnitPrice`, `Quantity`, `IMG`) VALUES
('ASPIRE5', 'Acer', 'Acer Aspire 5', 12000000, 25, 'acer_aspire5.jpg'),
('ASUSVIVO', 'ASUS', 'ASUS VivoBook S14', 18000000, 10, 'asus_vivobook.jpg'),
('DELLXPS13', 'Dell', 'Dell XPS 13', 29000000, 15, 'dell_xps13.jpg'),
('HPENVY15', 'HP', 'HP Envy 15', 25000000, 12, 'hp_envy15.jpg'),
('LENOVO11', 'Lenovo', 'Lenovo Think Book 14 G2 ITL', 21000000, 20, 'think_book.jpg'),
('LENOVOFLEX', 'Lenovo', 'Lenovo Flex 5', 15000000, 18, 'lenovo_flex.jpg'),
('MACBOOKPRO', 'Apple', 'MacBook Pro 16', 50000000, 8, 'macbook_pro16.jpg'),
('ROGZEPHYRU', 'ASUS', 'ASUS ROG Zephyrus', 40000000, 5, 'rog_zephyrus.jpg'),
('SURFACEPRO', 'Microsoft', 'Microsoft Surface Pro 7', 35000000, 7, 'surface_pro7.jpg'),
('THINKPADX1', 'Lenovo', 'Lenovo ThinkPad X1 Carbon', 45000000, 9, 'thinkpad_x1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `productdetail`
--

CREATE TABLE `productdetail` (
  `ProductID` varchar(10) NOT NULL,
  `CPU` varchar(100) NOT NULL,
  `RAM` varchar(100) NOT NULL,
  `HaskDisk` varchar(255) NOT NULL,
  `Screen` varchar(255) NOT NULL,
  `Webcam` varchar(255) NOT NULL,
  `Pin` varchar(50) NOT NULL,
  `OperatingSys` varchar(255) NOT NULL,
  `Weight` float NOT NULL,
  `Color` varchar(20) NOT NULL,
  `Size` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productdetail`
--

INSERT INTO `productdetail` (`ProductID`, `CPU`, `RAM`, `HaskDisk`, `Screen`, `Webcam`, `Pin`, `OperatingSys`, `Weight`, `Color`, `Size`) VALUES
('ASPIRE5', 'Intel Core i5', '8GB', '512GB SSD', '15.6 inch', 'HD Webcam', '4-cell', 'Windows 10', 1.9, 'Silver', 'Large'),
('ASUSVIVO', 'AMD Ryzen 7', '16GB', '512GB SSD', '14 inch', 'HD Webcam', '3-cell', 'Windows 10', 1.6, 'Black', 'Medium'),
('DELLXPS13', 'Intel Core i7', '16GB', '1TB SSD', '13.3 inch', 'HD Webcam', '4-cell', 'Windows 10', 1.2, 'Rose Gold', 'Small'),
('HPENVY15', 'Intel Core i7', '16GB', '1TB SSD', '15.6 inch', 'HD Webcam', '6-cell', 'Windows 10', 1.9, 'Silver', 'Large'),
('LENOVO11', 'Intel Core i5', '8GB', '512GB SSD', '14 inch', 'HD Webcam', '6-cell', 'Windows 10', 1.5, 'Silver', 'Medium'),
('LENOVOFLEX', 'AMD Ryzen 5', '8GB', '256GB SSD', '14 inch', 'HD Webcam', '4-cell', 'Windows 10', 1.8, 'Graphite Gray', 'Medium'),
('MACBOOKPRO', 'Intel Core i9', '32GB', '1TB SSD', '16 inch', 'HD Webcam', '8-cell', 'macOS', 2, 'Space Gray', 'Large'),
('ROGZEPHYRU', 'AMD Ryzen 9', '32GB', '1TB SSD', '15.6 inch', 'HD Webcam', '6-cell', 'Windows 10', 2.1, 'Black', 'Large'),
('SURFACEPRO', 'Intel Core i7', '16GB', '512GB SSD', '12.3 inch', 'HD Webcam', '5-cell', 'Windows 10', 1.4, 'Platinum', 'Small'),
('THINKPADX1', 'Intel Core i7', '16GB', '512GB SSD', '14 inch', 'HD Webcam', '6-cell', 'Windows 10', 1.3, 'Black', 'Medium');

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `PromotionID` varchar(10) NOT NULL,
  `From` date NOT NULL,
  `To` date NOT NULL,
  `Description` varchar(255) NOT NULL,
  `PromotionPercent` float NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`PromotionID`, `From`, `To`, `Description`, `PromotionPercent`, `Status`) VALUES
('CHAOMUNG', '2024-05-05', '2024-05-31', 'CHÀO MỪNG KHÁCH HÀNG MỚI', 0.2, 'active'),
('GIANGSINH', '2024-05-05', '2024-05-31', 'Chúc mừng giáng sinh', 0.25, 'active'),
('NORMAL', '2024-04-01', '2024-06-01', 'Không có khuyến mãi', 0, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `promotiondetail`
--

CREATE TABLE `promotiondetail` (
  `PromotionDTID` varchar(10) NOT NULL,
  `PromotionID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `PromotionPercent` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `promotiondetail`
--

INSERT INTO `promotiondetail` (`PromotionDTID`, `PromotionID`, `ProductID`, `PromotionPercent`) VALUES
('Detail1', 'CHAOMUNG', 'LENOVOFLEX', 0.2),
('Detail10', 'NORMAL', 'HPENVY15', 0),
('Detail11', 'NORMAL', 'THINKPADX1', 0),
('Detail2', 'CHAOMUNG', 'DELLXPS13', 0.2),
('Detail3', 'CHAOMUNG', 'MACBOOKPRO', 0.2),
('Detail4', 'GIANGSINH', 'LENOVO11', 0.25),
('Detail5', 'GIANGSINH', 'SURFACEPRO', 0.25),
('Detail6', 'GIANGSINH', 'LENOVOFLEX', 0.25),
('Detail7', 'NORMAL', 'ASPIRE5', 0),
('Detail8', 'NORMAL', 'ASUSVIVO', 0),
('Detail9', 'NORMAL', 'ROGZEPHYRU', 0);

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `ReceiptID` varchar(10) NOT NULL,
  `CusID` varchar(10) NOT NULL,
  `StaffID` varchar(10) NOT NULL,
  `CreatedTime` date NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`ReceiptID`, `CusID`, `StaffID`, `CreatedTime`, `Total`) VALUES
('HD01', 'KH01', 'NV01', '2024-05-06', 12000000),
('HD02', 'KH02', 'NV01', '2024-05-06', 36000000),
('HD03', 'KH03', 'NV02', '2024-04-28', 50000000),
('HD04', 'KH01', 'NV01', '2024-04-25', 80000000),
('HD05', 'KH02', 'NV02', '2024-04-23', 50000000),
('HD06', 'KH03', 'NV01', '2024-04-20', 30000000),
('HD07', 'KH01', 'NV02', '2024-04-19', 45000000);

-- --------------------------------------------------------

--
-- Table structure for table `receiptdetail`
--

CREATE TABLE `receiptdetail` (
  `DetailReceiptID` varchar(10) NOT NULL,
  `ReceiptID` varchar(10) NOT NULL,
  `PromotionID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `UnitPrice` double NOT NULL,
  `SubTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `receiptdetail`
--

INSERT INTO `receiptdetail` (`DetailReceiptID`, `ReceiptID`, `PromotionID`, `ProductID`, `Quantity`, `UnitPrice`, `SubTotal`) VALUES
('CHD01', 'HD01', 'NORMAL', 'ASPIRE5', 1, 12000000, 12000000),
('CHD02', 'HD02', 'NORMAL', 'ASUSVIVO', 2, 36000000, 36000000),
('CHD03', 'HD03', 'NORMAL', 'HPENVY15', 2, 25000000, 50000000),
('CHD04', 'HD04', 'NORMAL', 'ROGZEPHYRU', 2, 80000000, 80000000),
('CHD05', 'HD05', 'NORMAL', 'HPENVY15', 2, 50000000, 50000000),
('CHD06', 'HD06', 'NORMAL', 'ASPIRE5', 1, 12000000, 12000000),
('CHD07', 'HD06', 'NORMAL', 'ASUSVIVO', 1, 18000000, 18000000),
('CHD08', 'HD07', 'NORMAL', 'THINKPADX1', 1, 45000000, 45000000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaffID` varchar(10) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `YearOfBirth` int(4) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `PhoneNumber` varchar(12) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Salary` double NOT NULL,
  `Role` varchar(20) NOT NULL,
  `IMG` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `FirstName`, `LastName`, `YearOfBirth`, `Gender`, `PhoneNumber`, `Address`, `Salary`, `Role`, `IMG`) VALUES
('admin', 'Khoa', 'Nguyễn', 2002, 'Nam', '077*****31', 'asadfwewefwef', 20000000, 'admin', 'NV001.png'),
('NV01', 'Lương', 'Khuê', 2002, 'Nữ', '0353322951', '22 Ngô Quyền p2 q1', 15000000, 'staff', 'NV002.png'),
('NV02', 'Nguyễn', 'Vũ', 2002, 'Nam', '0953352952', '11 Trần Hưng Đạo q3, q10', 15000000, 'staff', 'NV003.png');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` varchar(10) NOT NULL,
  `SupplierName` varchar(50) NOT NULL,
  `PhoneNumber` varchar(12) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`, `PhoneNumber`, `Address`) VALUES
('SUP01', 'Tạp hóa VÂN', '0961589023', '312 An Dương Vương');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`StaffID`);

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`ActID`),
  ADD KEY `fk_act_staffid` (`StaffID`);

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`BrandID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CusID`);

--
-- Indexes for table `import`
--
ALTER TABLE `import`
  ADD PRIMARY KEY (`importID`),
  ADD KEY `fk_import_staffid` (`StaffID`),
  ADD KEY `fk_import_supplierid` (`SupplierID`);

--
-- Indexes for table `importdetail`
--
ALTER TABLE `importdetail`
  ADD PRIMARY KEY (`ImportDTID`),
  ADD KEY `fk_importDT_ImportID` (`ImportID`),
  ADD KEY `fk_importDT_ProductID` (`ProductID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `fk_product_brandid` (`BrandID`);

--
-- Indexes for table `productdetail`
--
ALTER TABLE `productdetail`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`PromotionID`);

--
-- Indexes for table `promotiondetail`
--
ALTER TABLE `promotiondetail`
  ADD PRIMARY KEY (`PromotionDTID`),
  ADD KEY `fk_DTPromotion_ProductID` (`ProductID`),
  ADD KEY `fk_DTpromotion_PromotionID` (`PromotionID`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`ReceiptID`),
  ADD KEY `fk_cus_cusid` (`CusID`),
  ADD KEY `fk_staff_receipt_staffid` (`StaffID`);

--
-- Indexes for table `receiptdetail`
--
ALTER TABLE `receiptdetail`
  ADD PRIMARY KEY (`DetailReceiptID`),
  ADD KEY `fk_reciptdetail_productid` (`ProductID`),
  ADD KEY `fk_reciptdetail_promotionid` (`PromotionID`),
  ADD KEY `fk_receiptdetail_id_receipt` (`ReceiptID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_acc_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`),
  ADD CONSTRAINT `fk_account_StaffID` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Constraints for table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `fk_act_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Constraints for table `import`
--
ALTER TABLE `import`
  ADD CONSTRAINT `fk_import_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`),
  ADD CONSTRAINT `fk_import_supplierid` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`);

--
-- Constraints for table `importdetail`
--
ALTER TABLE `importdetail`
  ADD CONSTRAINT `fk_importDT_ImportID` FOREIGN KEY (`ImportID`) REFERENCES `import` (`importID`),
  ADD CONSTRAINT `fk_importDT_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `fk_importdetail_importid` FOREIGN KEY (`ImportID`) REFERENCES `import` (`importID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_importdetail_productid` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_brand` FOREIGN KEY (`BrandID`) REFERENCES `brand` (`BrandID`);

--
-- Constraints for table `productdetail`
--
ALTER TABLE `productdetail`
  ADD CONSTRAINT `fk_productdetail` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE CASCADE;

--
-- Constraints for table `promotiondetail`
--
ALTER TABLE `promotiondetail`
  ADD CONSTRAINT `fk_DTPromotion_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `fk_DTpromotion_PromotionID` FOREIGN KEY (`PromotionID`) REFERENCES `promotion` (`PromotionID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_promotiondetail_productid` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `fk_cus_cusid` FOREIGN KEY (`CusID`) REFERENCES `customer` (`CusID`),
  ADD CONSTRAINT `fk_staff_receipt_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Constraints for table `receiptdetail`
--
ALTER TABLE `receiptdetail`
  ADD CONSTRAINT `fk_receiptdetail_id_receipt` FOREIGN KEY (`ReceiptID`) REFERENCES `receipt` (`ReceiptID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_reciptdetail_productid` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `fk_reciptdetail_promotionid` FOREIGN KEY (`PromotionID`) REFERENCES `promotiondetail` (`PromotionID`),
  ADD CONSTRAINT `fk_reciptdetail_receiptid` FOREIGN KEY (`ReceiptID`) REFERENCES `receipt` (`ReceiptID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
