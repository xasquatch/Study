-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.6.35-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5169
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- jspbeginner 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `jspbeginner` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jspbeginner`;

-- 테이블 jspbeginner.h_bid 구조 내보내기
CREATE TABLE IF NOT EXISTS `h_bid` (
  `bidno` int(5) NOT NULL AUTO_INCREMENT,
  `bid_price` int(8) NOT NULL,
  `bid_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id` varchar(20) DEFAULT NULL,
  `no` int(5) DEFAULT NULL,
  PRIMARY KEY (`bidno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 jspbeginner.h_board 구조 내보내기
CREATE TABLE IF NOT EXISTS `h_board` (
  `no` int(5) NOT NULL AUTO_INCREMENT,
  `main_img` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(21000) NOT NULL,
  `category` varchar(50) NOT NULL,
  `more_category` varchar(50) NOT NULL,
  `bin_price` int(8) NOT NULL DEFAULT '0',
  `bid_price` int(8) NOT NULL DEFAULT '0',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `area` varchar(10) NOT NULL,
  `trade` varchar(10) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `coords` varchar(100) DEFAULT NULL,
  `status` int(2) NOT NULL,
  `id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 jspbeginner.h_buyer 구조 내보내기
CREATE TABLE IF NOT EXISTS `h_buyer` (
  `no` int(5) NOT NULL,
  `id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 jspbeginner.h_member 구조 내보내기
CREATE TABLE IF NOT EXISTS `h_member` (
  `id` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `mem_name` varchar(20) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `birth` date NOT NULL,
  `postcode` int(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `active` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
