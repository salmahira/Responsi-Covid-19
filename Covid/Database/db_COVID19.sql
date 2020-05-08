-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 07, 2020 at 03:53 PM
-- Server version: 10.4.12-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_COVID19`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_statik`
--

CREATE TABLE `data_statik` (
  `id` int(11) NOT NULL,
  `id_negara` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `terkonfirmasi` int(11) NOT NULL,
  `aktif` int(11) NOT NULL,
  `sembuh` int(11) NOT NULL,
  `meninggal` int(11) NOT NULL,
  `tanggal` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `data_statik`
--

INSERT INTO `data_statik` (`id`, `id_negara`, `terkonfirmasi`, `aktif`, `sembuh`, `meninggal`, `tanggal`) VALUES
(1, 'IDN', 12776, 9465, 2381, 930, '2020-05-07 13:11:20'),
(2, 'IDN', 12776, 9460, 2386, 930, '2020-05-08 06:00:00'),
(3, 'CHN', 9, 0, 0, 0, '2020-05-07 14:06:00'),
(4, 'CHN', 10000, 90, 9, 901, '2020-05-07 14:07:00');

-- --------------------------------------------------------

--
-- Table structure for table `negara`
--

CREATE TABLE `negara` (
  `id_negara` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nama_negara` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `negara`
--

INSERT INTO `negara` (`id_negara`, `nama_negara`) VALUES
('CHN', 'China'),
('IDN', 'Indonesia'),
('USA', 'Amerika Serikat');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_statik`
--
ALTER TABLE `data_statik`
  ADD PRIMARY KEY (`id`),
  ADD KEY `negara` (`id_negara`);

--
-- Indexes for table `negara`
--
ALTER TABLE `negara`
  ADD PRIMARY KEY (`id_negara`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_statik`
--
ALTER TABLE `data_statik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_statik`
--
ALTER TABLE `data_statik`
  ADD CONSTRAINT `data_statik_ibfk_1` FOREIGN KEY (`id_negara`) REFERENCES `negara` (`id_negara`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
