-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 23, 2021 at 07:39 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spring_boot`
--

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

DROP TABLE IF EXISTS `fakultas`;
CREATE TABLE IF NOT EXISTS `fakultas` (
  `id_fakultas` int(10) NOT NULL AUTO_INCREMENT,
  `nama_fakultas` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_fakultas`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fakultas`
--

INSERT INTO `fakultas` (`id_fakultas`, `nama_fakultas`) VALUES
(1, 'Teknik'),
(2, 'Management');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `jurusan`
--

DROP TABLE IF EXISTS `jurusan`;
CREATE TABLE IF NOT EXISTS `jurusan` (
  `id` int(10) DEFAULT NULL,
  `nama_jurusan` varchar(50) DEFAULT NULL,
  `id_fakultas` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jurusan`
--

INSERT INTO `jurusan` (`id`, `nama_jurusan`, `id_fakultas`) VALUES
(1, 'Teknik Informatika', 1),
(2, 'Sistem Informasi', 1),
(3, 'Management Bisnis', 2);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

DROP TABLE IF EXISTS `mahasiswa`;
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `id` int(10) DEFAULT NULL,
  `nim` int(10) DEFAULT NULL,
  `nama_mahasiswa` varchar(50) DEFAULT NULL,
  `tahun_masuk` varchar(50) DEFAULT NULL,
  `id_matkul` int(11) DEFAULT NULL,
  `id_jurusan` int(11) DEFAULT NULL,
  `id_fakultas` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama_mahasiswa`, `tahun_masuk`, `id_matkul`, `id_jurusan`, `id_fakultas`) VALUES
(1, 17164010, 'Kunsarifan', '2017', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

DROP TABLE IF EXISTS `matakuliah`;
CREATE TABLE IF NOT EXISTS `matakuliah` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nama_matkul` varchar(50) DEFAULT NULL,
  `semester` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`id`, `nama_matkul`, `semester`) VALUES
(1, 'Bahasa Pemrograman I', '2'),
(2, 'Java', '3');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
