-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 08, 2020 at 04:47 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloodbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`Username`, `Password`) VALUES
('kummi', '123'),
('Novi', '7147'),
('sandy', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `donors`
--

CREATE TABLE `donors` (
  `ID` varchar(50) NOT NULL,
  `Bloodgrp` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Age` varchar(50) DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Height` varchar(50) DEFAULT NULL,
  `Weight` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `AddedBy` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donors`
--

INSERT INTO `donors` (`ID`, `Bloodgrp`, `Name`, `Age`, `Gender`, `Height`, `Weight`, `Address`, `Phone`, `Email`, `AddedBy`) VALUES
('10001', 'A +', 'Novel', '21', 'MALE', '180', '85', 'Sagar', '8904155404', 'novelmiranda7@gmail.com', 'novi'),
('10002', 'A +', 'Kumara', '21', 'MALE', '160', '80', 'Sagara', '8904155404', 'kummi@gmail.com', 'novi'),
('10003', 'B -', 'Ganesh', '22', 'MALE', '145', '111', 'Soraba	', '464644', 'adfadffadfadfdas', 'novi');

-- --------------------------------------------------------

--
-- Table structure for table `expirydates`
--

CREATE TABLE `expirydates` (
  `WholeBlood` varchar(10) NOT NULL,
  `RBC` varchar(10) NOT NULL,
  `PLASMA` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `expirydates`
--

INSERT INTO `expirydates` (`WholeBlood`, `RBC`, `PLASMA`) VALUES
('35', '42', '365');

-- --------------------------------------------------------

--
-- Table structure for table `plasma`
--

CREATE TABLE `plasma` (
  `Type` varchar(30) NOT NULL,
  `Donor ID` varchar(30) DEFAULT NULL,
  `Bag ID` varchar(30) NOT NULL,
  `Blood Group` varchar(30) DEFAULT NULL,
  `Date Added` date DEFAULT NULL,
  `Expiry Date` date DEFAULT NULL,
  `Status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plasma`
--

INSERT INTO `plasma` (`Type`, `Donor ID`, `Bag ID`, `Blood Group`, `Date Added`, `Expiry Date`, `Status`) VALUES
('PLASMA', '10002', 'PS10002', 'A +', '2020-04-03', '2021-04-03', 'SOLD'),
('PLASMA', '10001', 'PS10003', 'A +', '2020-04-03', '2021-04-03', 'SOLD'),
('PLASMA', '10001', 'PS10004', 'A +', '2020-04-03', '2021-04-03', 'SOLD'),
('PLASMA', '10002', 'PS10005', 'A +', '2020-04-08', '2021-04-08', 'ACTIVE'),
('PLASMA', '10003', 'PS10007', 'B -', '2020-04-09', '2021-02-09', 'SOLD'),
('PLASMA', '10002', 'PS10008', 'A +', '2020-04-29', '2021-04-29', 'ACTIVE'),
('PLASMA', '10003', 'PS10009', 'B -', '2020-05-09', '2021-05-09', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `price`
--

CREATE TABLE `price` (
  `Type` varchar(50) NOT NULL,
  `Normal` varchar(50) NOT NULL,
  `Exchange` varchar(50) NOT NULL,
  `Service` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `price`
--

INSERT INTO `price` (`Type`, `Normal`, `Exchange`, `Service`) VALUES
('Plasma', '400', '300', '350'),
('RBC', '1205', '600', '250'),
('Whole Blood', '1000', '500', '200');

-- --------------------------------------------------------

--
-- Table structure for table `rbc`
--

CREATE TABLE `rbc` (
  `Type` varchar(30) NOT NULL,
  `Donor ID` varchar(20) DEFAULT NULL,
  `Bag ID` varchar(20) NOT NULL,
  `Blood Group` varchar(20) DEFAULT NULL,
  `Date Added` date DEFAULT NULL,
  `Expiry Date` date DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rbc`
--

INSERT INTO `rbc` (`Type`, `Donor ID`, `Bag ID`, `Blood Group`, `Date Added`, `Expiry Date`, `Status`) VALUES
('RBC', '10002', 'RB10001', 'A +', '2020-04-03', '2020-05-15', 'SOLD'),
('RBC', '10002', 'RB10002', 'A +', '2020-04-03', '2020-05-15', 'SOLD'),
('RBC', '10001', 'RB10003', 'A +', '2020-04-03', '2020-05-15', 'SOLD'),
('RBC', '10001', 'RB10004', 'A +', '2020-04-03', '2020-05-15', 'ACTIVE'),
('RBC', '10002', 'RB10005', 'A +', '2020-04-05', '2020-05-01', 'SOLD'),
('RBC', '10001', 'RB10006', 'A +', '2020-04-09', '2020-02-21', 'EXPIRED'),
('RBC', '10003', 'RB10007', 'B -', '2020-04-11', '2020-05-23', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `No.` int(11) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Patient Name` varchar(50) DEFAULT NULL,
  `Blood Group` varchar(10) DEFAULT NULL,
  `Component Name` varchar(15) DEFAULT NULL,
  `No. Of Units` varchar(15) DEFAULT NULL,
  `Per Unit Cost` varchar(15) DEFAULT NULL,
  `Total Amount` varchar(20) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Patient Address` varchar(100) DEFAULT NULL,
  `Doctor Name` varchar(50) DEFAULT NULL,
  `Hospital Name` varchar(50) DEFAULT NULL,
  `Hospital Address` varchar(150) DEFAULT NULL,
  `Added By` varchar(50) DEFAULT NULL,
  `Date of sale` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`No.`, `Type`, `Patient Name`, `Blood Group`, `Component Name`, `No. Of Units`, `Per Unit Cost`, `Total Amount`, `DOB`, `Gender`, `Patient Address`, `Doctor Name`, `Hospital Name`, `Hospital Address`, `Added By`, `Date of sale`) VALUES
(1, 'NORMAL', 'fbb', 'A +', 'WHOLE BLOOD', '1', '1000', '1000.0', '2020-04-15', 'FEMALE', 'bxbbb', 'vbvbvb', 'bvb', 'bvbvb', 'novi', '2020-04-10'),
(2, 'NORMAL', '  cvcvv', 'A +', 'RBC', '1', '1205', '1205.0', '2020-04-13', 'MALE', 'cvvcc', 'ccvvcv', 'cvcvv', 'vcvcvv', 'novi', '2020-04-10'),
(3, 'NORMAL', 'ghff', 'A +', 'PLASMA', '1', '400', '750.0', '2020-04-15', 'MALE', 'hjjf', 'hjfjj', 'jghjhg', 'ghjgkgk', 'novi', '2020-04-11'),
(4, 'EXCHANGE', 'sdggv', 'B -', 'RBC', '1', '600', '850.0', '2020-04-01', 'FEMALE', 'gffsg', 'gfgg', 'fggfs', 'gfggfg', 'novi', '2020-04-11'),
(5, 'NORMAL', 'dsvsdv', 'A +', 'PLASMA', '3', '400', '2250.0', '2020-04-15', 'FEMALE', 'adfav', 'dzvadv', 'dvcadvadvvasdv', 'dacvadvc', 'novi', '2020-04-29'),
(6, 'NORMAL', 'mmkm', 'A +', 'WHOLE BLOOD', '1', '1000', '1200.0', '2020-05-13', 'MALE', 'kmmkm', 'lkmmlm', 'knmkn', 'nknn', 'novi', '2020-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `wholeblood`
--

CREATE TABLE `wholeblood` (
  `Type` varchar(30) NOT NULL,
  `Donor ID` varchar(50) DEFAULT NULL,
  `Bag ID` varchar(10) NOT NULL,
  `Blood Group` varchar(10) DEFAULT NULL,
  `Date Added` date NOT NULL,
  `Expiry Date` date NOT NULL,
  `Status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wholeblood`
--

INSERT INTO `wholeblood` (`Type`, `Donor ID`, `Bag ID`, `Blood Group`, `Date Added`, `Expiry Date`, `Status`) VALUES
('WholeBlood', '10001', 'WB10001', 'A +', '2020-04-03', '2020-05-08', 'SOLD'),
('WholeBlood', '10001', 'WB10002', 'A +', '2020-04-03', '2020-05-08', 'SOLD'),
('WholeBlood', '10001', 'WB10003', 'A +', '2020-04-03', '2020-05-08', 'SOLD'),
('WholeBlood', '10001', 'WB10004', 'A +', '2020-04-10', '2020-05-15', 'EXPIRED'),
('WholeBlood', '10002', 'WB10005', 'A +', '2020-04-03', '2020-05-08', 'SOLD'),
('WholeBlood', '10002', 'WB10006', 'A +', '2020-04-03', '2020-05-08', 'SOLD'),
('WholeBlood', '10002', 'WB10007', 'A +', '2020-04-03', '2020-05-08', 'SOLD'),
('WholeBlood', '10001', 'WB10008', 'A +', '2020-04-07', '2020-05-12', 'SOLD'),
('WholeBlood', '10001', 'WB10009', 'A +', '2020-04-07', '2020-05-12', 'SOLD'),
('WholeBlood', '10001', 'WB10010', 'A +', '2020-04-07', '2020-05-12', 'ACTIVE'),
('WholeBlood', '10001', 'WB10011', 'A +', '2020-04-09', '2020-05-14', 'ACTIVE'),
('WholeBlood', '10003', 'WB10012', 'B -', '2020-04-09', '2020-02-14', 'EXPIRED'),
('WholeBlood', '10001', 'WB10013', 'A +', '2020-04-09', '2020-05-14', 'ACTIVE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `donors`
--
ALTER TABLE `donors`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Username` (`AddedBy`);

--
-- Indexes for table `plasma`
--
ALTER TABLE `plasma`
  ADD PRIMARY KEY (`Bag ID`),
  ADD KEY `fk_did` (`Donor ID`);

--
-- Indexes for table `price`
--
ALTER TABLE `price`
  ADD PRIMARY KEY (`Type`);

--
-- Indexes for table `rbc`
--
ALTER TABLE `rbc`
  ADD PRIMARY KEY (`Bag ID`),
  ADD KEY `fk_donorid` (`Donor ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`No.`);

--
-- Indexes for table `wholeblood`
--
ALTER TABLE `wholeblood`
  ADD PRIMARY KEY (`Bag ID`),
  ADD KEY `fk_id` (`Donor ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `No.` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `donors`
--
ALTER TABLE `donors`
  ADD CONSTRAINT `donors_ibfk_1` FOREIGN KEY (`AddedBy`) REFERENCES `admins` (`Username`);

--
-- Constraints for table `plasma`
--
ALTER TABLE `plasma`
  ADD CONSTRAINT `fk_did` FOREIGN KEY (`Donor ID`) REFERENCES `donors` (`ID`);

--
-- Constraints for table `rbc`
--
ALTER TABLE `rbc`
  ADD CONSTRAINT `fk_donorid` FOREIGN KEY (`Donor ID`) REFERENCES `donors` (`ID`);

--
-- Constraints for table `wholeblood`
--
ALTER TABLE `wholeblood`
  ADD CONSTRAINT `fk_id` FOREIGN KEY (`Donor ID`) REFERENCES `donors` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
