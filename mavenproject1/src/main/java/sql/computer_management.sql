-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 07, 2024 lúc 07:34 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `computer_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `StaffID` varchar(10) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gmail` varchar(40) NOT NULL,
  `Enable` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`StaffID`, `Username`, `Password`, `Gmail`, `Enable`) VALUES
('3122560020', 'admin2', 'admin2', 'no', 'u'),
('3122560022', 'vithoang', 'hoang1', 'vithoang1608@gmail.com', 'unlock'),
('admin', 'admin', 'admin', 'khoanguyen052096@gmail.com', 'unlock');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `activity`
--

CREATE TABLE `activity` (
  `ActID` varchar(10) NOT NULL,
  `StaffID` varchar(10) NOT NULL,
  `ActName` varchar(255) NOT NULL,
  `ActTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
  `BrandID` varchar(10) NOT NULL,
  `BrandName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `brand`
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
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `CusID` varchar(10) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `PhoneNumber` varchar(12) NOT NULL,
  `Gmail` varchar(50) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`CusID`, `FirstName`, `LastName`, `Gender`, `PhoneNumber`, `Gmail`, `Address`) VALUES
('3122560022', 'Hoàng', 'Nguyễn', 'Nam', '0961589023', 'vithoang1608@gmail.com', '123 Nguyễn Văn Cừ'),
('3122560023', 'Hoàng', 'Vũ', 'Nam', '0961589024', 'hoangvu8@gmail.com', '273 An Dương Vương'),
('3122560024', 'Quang', 'Dương', 'Nam', '0971495534', 'quangteoprokt@gmail.com', '302 Dương Bá Trạc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import`
--

CREATE TABLE `import` (
  `importID` varchar(10) NOT NULL,
  `SupplierID` varchar(10) NOT NULL,
  `StaffID` varchar(10) NOT NULL,
  `Total` int(20) NOT NULL,
  `Created_Time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `importdetail`
--

CREATE TABLE `importdetail` (
  `ImportID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `ProductID` varchar(10) NOT NULL,
  `BrandID` varchar(10) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Quantity` int(10) NOT NULL,
  `IMG` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
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
-- Cấu trúc bảng cho bảng `productdetail`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `productdetail`
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
-- Cấu trúc bảng cho bảng `promotion`
--

CREATE TABLE `promotion` (
  `PromotionID` varchar(10) NOT NULL,
  `PromotionName` varchar(100) NOT NULL,
  `From` datetime NOT NULL,
  `To` datetime NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `promotion`
--

INSERT INTO `promotion` (`PromotionID`, `PromotionName`, `From`, `To`, `Status`) VALUES
('TET01', 'Sale 4/4 2024 vui ve', '2024-04-04 08:37:53', '2024-05-05 08:37:53', 'on');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `promotiondetail`
--

CREATE TABLE `promotiondetail` (
  `PromotionID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `PromotionPercent` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `promotiondetail`
--

INSERT INTO `promotiondetail` (`PromotionID`, `ProductID`, `Description`, `PromotionPercent`) VALUES
('TET01', 'LENOVO11', 'Sale 4/4 vui ve', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receipt`
--

CREATE TABLE `receipt` (
  `ReceiptID` varchar(10) NOT NULL,
  `CusID` varchar(10) NOT NULL,
  `StaffID` varchar(10) NOT NULL,
  `CreatedTime` datetime NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `receipt`
--

INSERT INTO `receipt` (`ReceiptID`, `CusID`, `StaffID`, `CreatedTime`, `Total`) VALUES
('BILL01', '3122560022', '3122560022', '2024-04-04 08:35:58', 20000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receiptdetail`
--

CREATE TABLE `receiptdetail` (
  `ReceiptID` varchar(10) NOT NULL,
  `PromotionID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `UnitPrice` double NOT NULL,
  `OriginalTotal` double NOT NULL,
  `SubTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `receiptdetail`
--

INSERT INTO `receiptdetail` (`ReceiptID`, `PromotionID`, `ProductID`, `Quantity`, `UnitPrice`, `OriginalTotal`, `SubTotal`) VALUES
('BILL01', 'TET01', 'LENOVO11', 1, 21000000, 190000000, 1000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
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
  `IMG` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`StaffID`, `FirstName`, `LastName`, `YearOfBirth`, `Gender`, `PhoneNumber`, `Address`, `Salary`, `Role`, `IMG`) VALUES
('3122560020', 'Khuê', 'Minh', 2002, 'Nam', '097673245', '317 An Dương Vương', 12, 'Quản lý', 0x6d696e686b6875652c6a7067),
('3122560022', 'Hoàng', 'Việt ', 2004, 'nam', '096159023', '230 Dương Bá Trạc', 1000, 'Nhân viên', 0x76696574686f616e672e6a7067),
('admin', 'Khoa', 'Nguyễn', 2002, 'Nam', '077*****31', '271 An Dương Vương', 20000000, 'admin', 0x6e677579656e6b686f612c6a7067);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` varchar(10) NOT NULL,
  `SupplierName` varchar(50) NOT NULL,
  `PhoneNumber` varchar(12) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`, `PhoneNumber`, `Address`) VALUES
('SUP01', 'Tạp hóa VÂN', '0961589023', '312 An Dương Vương');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`StaffID`);

--
-- Chỉ mục cho bảng `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`ActID`),
  ADD KEY `fk_act_staffid` (`StaffID`);

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`BrandID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CusID`);

--
-- Chỉ mục cho bảng `import`
--
ALTER TABLE `import`
  ADD PRIMARY KEY (`importID`),
  ADD KEY `fk_import_staffid` (`StaffID`),
  ADD KEY `fk_import_supplierid` (`SupplierID`);

--
-- Chỉ mục cho bảng `importdetail`
--
ALTER TABLE `importdetail`
  ADD PRIMARY KEY (`ImportID`),
  ADD KEY `fk_importdetail_productid` (`ProductID`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `fk_product_brandid` (`BrandID`);

--
-- Chỉ mục cho bảng `productdetail`
--
ALTER TABLE `productdetail`
  ADD PRIMARY KEY (`ProductID`);

--
-- Chỉ mục cho bảng `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`PromotionID`);

--
-- Chỉ mục cho bảng `promotiondetail`
--
ALTER TABLE `promotiondetail`
  ADD PRIMARY KEY (`PromotionID`),
  ADD KEY `fk_promotiondetail_productid` (`ProductID`);

--
-- Chỉ mục cho bảng `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`ReceiptID`),
  ADD KEY `fk_cus_cusid` (`CusID`),
  ADD KEY `fk_staff_receipt_staffid` (`StaffID`);

--
-- Chỉ mục cho bảng `receiptdetail`
--
ALTER TABLE `receiptdetail`
  ADD PRIMARY KEY (`ReceiptID`),
  ADD KEY `fk_reciptdetail_productid` (`ProductID`),
  ADD KEY `fk_reciptdetail_promotionid` (`PromotionID`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_acc_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Các ràng buộc cho bảng `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `fk_act_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Các ràng buộc cho bảng `import`
--
ALTER TABLE `import`
  ADD CONSTRAINT `fk_import_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`),
  ADD CONSTRAINT `fk_import_supplierid` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`);

--
-- Các ràng buộc cho bảng `importdetail`
--
ALTER TABLE `importdetail`
  ADD CONSTRAINT `fk_importdetail_importid` FOREIGN KEY (`ImportID`) REFERENCES `import` (`importID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_importdetail_productid` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_brand` FOREIGN KEY (`BrandID`) REFERENCES `brand` (`BrandID`);

--
-- Các ràng buộc cho bảng `productdetail`
--
ALTER TABLE `productdetail`
  ADD CONSTRAINT `fk_productdetail` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `promotiondetail`
--
ALTER TABLE `promotiondetail`
  ADD CONSTRAINT `fk_promotiondetail_productid` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `fk_promotiondetail_promotionid` FOREIGN KEY (`PromotionID`) REFERENCES `promotion` (`PromotionID`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `fk_cus_cusid` FOREIGN KEY (`CusID`) REFERENCES `customer` (`CusID`),
  ADD CONSTRAINT `fk_staff_receipt_staffid` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Các ràng buộc cho bảng `receiptdetail`
--
ALTER TABLE `receiptdetail`
  ADD CONSTRAINT `fk_reciptdetail_productid` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `fk_reciptdetail_promotionid` FOREIGN KEY (`PromotionID`) REFERENCES `promotiondetail` (`PromotionID`),
  ADD CONSTRAINT `fk_reciptdetail_receiptid` FOREIGN KEY (`ReceiptID`) REFERENCES `receipt` (`ReceiptID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
