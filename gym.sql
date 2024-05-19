-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 05, 2022 lúc 10:55 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `gym`
--
CREATE DATABASE IF NOT EXISTS `gym` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gym`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classroom`
--

CREATE TABLE `classroom` (
  `stt` int(11) NOT NULL,
  `mahocvien` varchar(255) NOT NULL,
  `malop` varchar(255) NOT NULL,
  `tenhocvien` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `idemp` varchar(255) NOT NULL,
  `tenemp` varchar(255) NOT NULL,
  `sdtemp` varchar(255) NOT NULL,
  `emailemp` varchar(255) NOT NULL,
  `genderemp` varchar(255) NOT NULL,
  `positionemp` varchar(255) NOT NULL,
  `passemp` varchar(255) NOT NULL,
  `createemp` datetime DEFAULT current_timestamp(),
  `avatar` varchar(1000) DEFAULT 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/316090422_829751481567201_6711936184425690336_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=174925&_nc_ohc=tAHTEJVO-3UAX_kaFCe&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfCy2-6VLaES_gU8wVU2hj0uFJ3dfucljLwp4tel7PT_4w&oe=638F66CD'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`idemp`, `tenemp`, `sdtemp`, `emailemp`, `genderemp`, `positionemp`, `passemp`, `createemp`, `avatar`) VALUES
('kt000003', 'Le Quoc Viet', '0879748777', 'vle@gmail.com', 'Male', 'Kế toán', '23456', '2022-12-01 04:00:30', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/251847645_588028892406129_260423726795685004_n.jpg?stp=dst-jpg_s851x315&_nc_cat=106&ccb=1-7&_nc_sid=da31f3&_nc_ohc=x3EOjN_6Vc4AX9e_Vjm&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfA4ffQ1gajtTX54zM8X4ejt38HO6_5BMkTDAtHqbIn_WQ&oe=638F74E2'),
('lt000002', 'Đông Nhi', '0214784596', 'dongnhi@gmail.com', 'Male', 'Lễ tân', '123456', '2022-10-30 17:52:20', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t1.6435-9/144668330_424056938803326_1842097521700667_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=174925&_nc_ohc=YqEQlaR0DgMAX-ajd-S&tn=KWoGFGK0B3e-EmZW&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfCGrJoIZJ_91qoKtflaYAYZtmeDyQuRIMiCoRWcyHxCqw&oe=63B27C23'),
('lt000004', 'Hồ Ngọc Hà', '0574126981', 'hnh@gmail.com', 'Female', 'Lễ tân', '123456', '2022-12-01 11:35:26', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/275472664_664022294806788_3854882512238726504_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=19026a&_nc_ohc=93QhKO5coMQAX9FZ70f&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfDc57da1BIJ1Se_fBMgXLj0dOQ7Twpi4Dl_H5PEjFTrig&oe=63904BEF'),
('ql000003', 'Tóc Tiên', '0965874231', 'toctien@gmail.com', 'Female', 'Quản lý', '123456', '2022-08-03 13:56:37', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t1.6435-9/198152502_502686704273682_104451209091447411_n.jpg?stp=c0.169.827.827a_dst-jpg_s851x315&_nc_cat=104&ccb=1-7&_nc_sid=da31f3&_nc_ohc=VJllLKZA-VEAX-hwsNz&tn=KWoGFGK0B3e-EmZW&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfBTilLK4pHvrIn_U4Pg0mc89jlM9uStnSD-agJP_Vt1Ng&oe=63B27E06'),
('ql000004', 'Nguyễn Thúc Thùy Tiên', '0547411336', 'nttt@gmail.com', 'Male', 'Quản lý', '123456', '2022-11-30 17:44:03', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/316090422_829751481567201_6711936184425690336_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=174925&_nc_ohc=tAHTEJVO-3UAX_kaFCe&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfCy2-6VLaES_gU8wVU2hj0uFJ3dfucljLwp4tel7PT_4w&oe=638F66CD'),
('ql000005', 'Noo Phước Thịnh', '0547841322', 'noopt@gmail.com', 'Male', 'Quản lý', '123456', '2022-12-01 10:41:05', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/316090422_829751481567201_6711936184425690336_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=174925&_nc_ohc=tAHTEJVO-3UAX_kaFCe&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfCy2-6VLaES_gU8wVU2hj0uFJ3dfucljLwp4tel7PT_4w&oe=638F66CD'),
('ql000006', 'Thúy Vân', '0178746642', 'minhhang@gmail.com', 'Male', 'Quản lý', '123456', '2022-12-05 14:07:58', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/316090422_829751481567201_6711936184425690336_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=174925&_nc_ohc=tAHTEJVO-3UAX_kaFCe&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfCy2-6VLaES_gU8wVU2hj0uFJ3dfucljLwp4tel7PT_4w&oe=638F66CD');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocvien`
--

CREATE TABLE `hocvien` (
  `stt` int(255) NOT NULL,
  `mahocvien` varchar(255) NOT NULL,
  `tenhocvien` varchar(255) NOT NULL,
  `bomondk` varchar(255) NOT NULL,
  `thoigiandk` varchar(255) NOT NULL,
  `thoigianketthuc` varchar(255) NOT NULL,
  `createdkhocvien` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` varchar(255) NOT NULL,
  `tenkh` varchar(255) NOT NULL,
  `sdtkh` varchar(255) NOT NULL,
  `emailkh` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT 'ROLE_USER',
  `level` varchar(255) DEFAULT 'KHÁCH HÀNG THƯỜNG',
  `point` int(255) DEFAULT 0,
  `status` varchar(255) DEFAULT NULL,
  `createaccount` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkh`, `sdtkh`, `emailkh`, `gender`, `password`, `role`, `level`, `point`, `status`, `createaccount`) VALUES
('LAe516ET', 'Châu Đăng Khoa', '0321458777', 'vipbigbang5xxx@gmail.com', 'Male', '736035', 'ROLE_USER', 'KHÁCH HÀNG THƯỜNG', 0, 'Hoạt động', '2022-12-03 20:59:44'),
('mMr0u8XA', 'Mai Hồng Ngọc', '0123456789', 'khoanguyen30lb@gmail.com', 'Male', '123456', 'ROLE_USER', 'KHÁCH HÀNG VIP', 20, 'Hoạt động', '2022-11-30 10:30:18'),
('R68ctS7p', 'Nguyễn Thị Anh Thư', '0929099064', 'vanhuy1619@gmail.com', 'Female', '123456', 'ROLE_USER', 'KHÁCH HÀNG VIP', 0, 'Hoạt động', '2022-11-29 19:36:37'),
('vxgKNV4R', 'Lê Mỹ Anh', '0784254785', 'lemyanh@gmail.com', 'Female', '585204', 'ROLE_USER', 'KHÁCH HÀNG THƯỜNG', 0, 'Chờ duyệt', '2022-12-03 21:52:54');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

CREATE TABLE `schedule` (
  `stt` int(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `idclb` varchar(255) NOT NULL,
  `ngay` varchar(255) NOT NULL,
  `bomon` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `schedule`
--

INSERT INTO `schedule` (`stt`, `city`, `idclb`, `ngay`, `bomon`, `img`) VALUES
(1, 'hcm', 'GDC', '28/11 - 04/12', 'yoga', 'https://cali.vn/storage/app/uploads/public/637/ac8/35e/637ac835e8bdf815113988.jpg'),
(2, 'hcm', 'AMU', '28/11 - 04/12', 'yoga', 'https://cali.vn/storage/app/uploads/public/637/904/c19/637904c194251413020868.jpg'),
(3, 'hcm', 'GDC', '28/11 - 04/12', 'groupx', 'https://cali.vn/storage/app/uploads/public/637/83a/fd9/63783afd9b28b677129942.jpg'),
(4, 'hcm', 'AMU', '28/11 - 04/12', 'groupx', 'https://cali.vn/storage/app/uploads/public/637/83b/3d1/63783b3d18587997603082.jpg'),
(5, 'hn', 'WPC', '28/11 - 04/12', 'yoga', 'https://cali.vn/storage/app/uploads/public/637/830/e78/637830e78aa06730719278.jpg'),
(6, 'hn', 'MAC', '28/11 - 04/12', 'yoga', 'https://cali.vn/storage/app/uploads/public/637/831/d45/637831d45d1c0323259407.jpg'),
(7, 'hn', 'WPC', '28/11 - 04/12', 'groupx', 'https://cali.vn/storage/app/uploads/public/637/85e/3e3/63785e3e3c41d040626250.jpg'),
(8, 'hn', 'MAC', '28/11 - 04/12', 'groupx', 'https://cali.vn/storage/app/uploads/public/637/85d/a7c/63785da7c0194547618362.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tapthu`
--

CREATE TABLE `tapthu` (
  `stt` int(255) NOT NULL,
  `tenkh` varchar(255) NOT NULL,
  `sdtkh` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `bomon` varchar(255) NOT NULL,
  `thoigian` varchar(255) NOT NULL,
  `datedk` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tapthu`
--

INSERT INTO `tapthu` (`stt`, `tenkh`, `sdtkh`, `email`, `bomon`, `thoigian`, `datedk`) VALUES
(20, 'Hồ Quỳnh Hương', '0145645521', 'kwonjiyong2702@gmail.com', 'groupx', '6h30-7h30', '2022-12-01 02:37:46'),
(26, 'Mai Hồng Ngọc', '0929099071', 'useruser1ck@gmail.com', 'groupx', '6h30-7h30', '2022-12-01 14:53:52'),
(27, 'Mai Hồng Ngọc', '0927099071', 'kwonjiyong2702@gmail.com', 'groupx', '6h30-7h30', '2022-12-01 14:56:09'),
(28, 'Phú Quốc', '0928746525', 'phuquoc@gmail.com', 'groupx', '6h30-7h30', '2022-12-01 14:56:55'),
(30, 'Mai Hồng Ngọc', '0145645520', 'maihn@gmail.com', 'yoga', '12h-13h', '2022-12-01 15:00:58'),
(31, 'Anh Thu', '0927779063', 'anhthu@gmail.com', 'yoga', '8h-9h', '2022-12-01 15:02:20'),
(32, 'Mai Hồng Ngọc', '0123456777', 'mvmanh@gmail.com', 'groupx', '6h30-7h30', '2022-12-03 22:34:56'),
(34, 'Mai Hồng Ngọc', '0929099063', 'mvmanh@gmail.com', 'groupx', '6h30-7h30', '2022-12-05 13:48:08'),
(35, 'Mai Hồng Ngọc', '092909906', 'mvmanh@gmail.com', 'groupx', '6h30-7h30', '2022-12-05 13:48:55'),
(36, 'Mai Hồng Ngọc', '1929099068', 'mvmanh@gmail.com', 'groupx', '6h30-7h30', '2022-12-05 13:49:02'),
(37, 'Anh Thu', '', '', 'yoga', '8h-9h', '2022-12-05 14:02:51'),
(38, 'Anh Thu', '0178474565', 'mvmanh@gmail.com', 'yoga', '8h-9h', '2022-12-05 14:03:04'),
(39, 'Anh Thu2', '0658999666', 'kwonjiyong2702@gmail.com', 'groupx', '6h30-7h30', '2022-12-05 14:03:21');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacher`
--

CREATE TABLE `teacher` (
  `idteacher` varchar(255) NOT NULL,
  `nameteacher` varchar(255) NOT NULL,
  `emailteacher` varchar(255) NOT NULL,
  `sdtteacher` varchar(255) NOT NULL,
  `genderteacher` varchar(255) NOT NULL,
  `passteacher` varchar(255) NOT NULL,
  `createteacher` datetime DEFAULT current_timestamp(),
  `avatar` varchar(1000) DEFAULT 'https://nguoinoitieng.tv/images/nnt/104/0/bhxh.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `teacher`
--

INSERT INTO `teacher` (`idteacher`, `nameteacher`, `emailteacher`, `sdtteacher`, `genderteacher`, `passteacher`, `createteacher`, `avatar`) VALUES
('tc001', 'Becky', 'becky@gmail.com', '0929099065', 'Female', '123456', '2022-11-29 02:30:43', 'https://d9hhrg4mnvzow.cloudfront.net/fit.cali.vn/yoga-an-nhien-300k/87228170-sport-wellbeing-active-lifestyle-concept-portrait-smiling-slim-strong-asian-fitness-girl-personal-workout-trainer-showing-muscles-flexing-biceps-look-proud-white-background_1066044045044010000000.jpg'),
('tc002', 'Amber', 'amber@gmail.com', '0621487452', 'Male', '123456', '2022-12-01 17:46:51', 'https://nguoinoitieng.tv/images/nnt/104/0/bhxh.jpg'),
('tc003', 'Justin', 'arvin@gmail.com', '0974875123', 'Male', '123456', '2022-12-01 17:48:00', 'https://media.gq.com/photos/56bcb218cdf2db6945d2ef93/4:3/w_2000,h_1500,c_limit/bieber-coverstory-square.jpg'),
('tc004', 'Lily', 'lily@gmail.com', '0895472121', 'Female', '123456', '2022-12-02 01:56:48', 'https://akns-images.eonline.com/eol_images/Entire_Site/2022327/rs_1200x1200-220427125053-1200-Kylie-Jenner-red-carpet.jpg?fit=around%7C1200:1200&output-quality=90&crop=1200:1200;center,top'),
('tc005', 'Davis', 'davis@gmail.com', '0978478562', 'Male', '123456', '2022-12-03 11:10:49', 'https://ggstorage.oxii.vn/images/oxii-2019-9-18/728/67843284-464071594189218-4876224252549081228-n.jpg'),
('tc006', 'DangBeo', 'dangbeo@gmail.com', '0465214555', 'Male', '123456', '2022-12-03 11:13:35', 'https://nguoinoitieng.tv/images/nnt/104/0/bhxh.jpg'),
('tc007', 'Ryan', 'pawan@gmail.com', '0314248446', 'Male', '123456', '2022-12-03 19:10:48', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz-b_b5w_gM1ug652U3ZnG-SWYtZcxgl2CNHRK-OxA&s'),
('tc008', 'Kelly', 'kelly@gmail.com', '0451748565', 'Male', '123456', '2022-12-03 21:54:30', 'https://nld.mediacdn.vn/291774122806476800/2021/6/19/t03-16240818944771485276009.jpg'),
('tc009', 'Ashu', 'ashu@gmail.com', '0421589666', 'Male', '123456', '2022-12-05 00:38:01', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-1/301918915_497508739047931_6692552876030758409_n.jpg?stp=dst-jpg_p320x320&_nc_cat=103&ccb=1-7&_nc_sid=c6021c&_nc_ohc=hP0UwoaQv90AX_5Xrkc&_nc_oc=AQmVpfESHslanaKbJ2dlwYMhYw7bJd3EMcYGL9wYNaTwN_QU66fOWFHRHbo-770RbR4&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfAcWFABjPRhlGeNP2Tm1D7r-01NpJUyw2Ub32jf2Kz35g&oe=63926CD6'),
('tc010', 'Maika', 'maika@gmail.com', '0325415875', 'Male', '123456', '2022-12-05 00:48:43', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvyCE9hGpnmUhLy2oT-5KzMcHIj0tB6mH01n-Xyxz-EKOTOoPHbEK0Sj9GTMwSo8IIqQU&usqp=CAU'),
('tc011', 'Jenny', 'jenny@gmail.com', '0952142111', 'Female', '123456', '2022-12-05 01:04:04', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJHBkhKF5fJMuUeHilvXzsbfHQ5QQDylf7DRKA1zY_rxfIjsXL55A_kb36h0Vz6Uv7tU0&usqp=CAU');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `training`
--

CREATE TABLE `training` (
  `stt` int(255) NOT NULL,
  `idteacher` varchar(255) DEFAULT NULL,
  `bomonday` varchar(255) DEFAULT NULL,
  `phongday` varchar(255) DEFAULT NULL,
  `allday` varchar(255) DEFAULT 'true',
  `thoigianday` varchar(255) DEFAULT NULL,
  `thoigianketthuc` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT '#5ac8fa',
  `createtraining` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `training`
--

INSERT INTO `training` (`stt`, `idteacher`, `bomonday`, `phongday`, `allday`, `thoigianday`, `thoigianketthuc`, `color`, `createtraining`) VALUES
(34, 'tc003', 'Pop Dance', 'L1-04', 'true', '2022-12-15', '2022-12-15', '#f44437', '2022-12-01 23:35:39'),
(39, 'tc004', 'HIIT Cycle', 'L2-02', 'false', '2022-12-22T06:00', '2022-12-22T08:00', '#7e5d4e', '2022-12-01 23:46:48'),
(42, 'tc003', 'Les Mills Core', 'L3-10', 'false', '2022-12-21T17:00', '2022-12-21T19:00', '#ff9900', '2022-12-01 23:56:34'),
(48, 'tc004', 'Shape Up', 'L3-07', 'true', '2022-12-27', '2022-12-27', '#f44437', '2022-12-02 02:15:00'),
(49, 'tc004', 'CRUNCH PLUSH', 'L3-01', 'true', '2022-12-08', '2022-12-08', '#4baf4f', '2022-12-02 02:20:19'),
(50, 'tc004', 'Cali Ride', 'L4-01', 'true', '2022-11-30', '2022-11-30', '#5ac8fa', '2022-12-02 02:32:57'),
(52, 'tc003', 'Yoga Core', 'T-09', 'false', '2023-01-04T06:00', '2023-01-04T08:00', '#9c26b0', '2022-12-02 04:18:38'),
(53, 'tc001', 'Zumba', 'L1-01', 'true', '2022-12-29', '2022-12-29', '#5ac8fa', '2022-12-02 05:51:22'),
(54, 'tc003', 'Pole Fit', 'L2-10', 'false', '2022-12-14T16:00', '2022-12-14T18:00', '#5ac8fa', '2022-12-02 05:51:59'),
(55, 'tc005', 'Cali Ride', 'L2-02', 'false', '2022-12-28T07:00', '2022-12-28T09:00', '#5ac8fa', '2022-12-02 05:53:01'),
(56, 'tc001', 'Yoga Core', 'L4-10', 'true', '2022-12-02', '2022-12-02', '#5ac8fa', '2022-12-02 05:54:30'),
(57, 'tc004', 'Pop Dance', 'L4-07', 'false', '2022-12-14T07:00', '2022-12-14T10:00', '#009788', '2022-12-02 05:55:44'),
(58, 'tc002', 'BodyPump', 'T5-01', 'true', '2022-12-01', '2022-12-01', '#9c26b0', '2022-12-02 13:46:25'),
(68, 'tc001', 'S.W.E.A.T', 'L6-01', 'false', '2022-12-03T18:10', '2022-12-03T19:00', '#f44437', '2022-12-03 03:48:24'),
(70, 'tc007', 'Yoga Mix', 'L1-08', 'false', '2022-12-09T08:30', '2022-12-09T09:30', '#3f51b5', '2022-12-03 19:09:37'),
(72, 'tc006', 'Kit Fit', 'T-03', 'true', '2022-12-04', '2022-12-04', '#5ac8fa', '2022-12-04 11:21:05'),
(73, 'tc004', 'Yoga Balance', 'T-05', 'true', '2022-12-04', '2022-12-04', '#5ac8fa', '2022-12-04 11:21:30'),
(76, 'tc006', 'Pole Fit', 'T-07', 'false', '2022-12-06T17:00', '2022-12-06T19:00', '#5ac8fa', '2022-12-04 23:45:37'),
(86, 'tc009', 'Yoga VIP', 'L2-06', 'false', '2022-12-13T06:00', '2022-12-13T07:30', '#9c26b0', '2022-12-05 00:52:24'),
(87, 'tc010', 'BODY COMBAT', 'L2-03', 'false', '2022-12-12T17:00', '2022-12-12T18:30', '#009788', '2022-12-05 00:54:00'),
(88, 'tc001', 'Yoga VIP', 'T-07', 'false', '2022-12-23T05:00', '2022-12-23T06:30', '#f44437', '2022-12-05 00:55:11'),
(89, 'tc008', 'Zumba', 'L3-01', 'false', '2022-12-07T05:00', '2022-12-07T07:00', '#ea1e63', '2022-12-05 14:10:14');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `yourschedule`
--

CREATE TABLE `yourschedule` (
  `stt` int(11) NOT NULL,
  `idkhachhang` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `start` varchar(255) NOT NULL,
  `end` varchar(255) NOT NULL,
  `confirmed` varchar(255) DEFAULT 'false',
  `reason` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `resource` int(11) DEFAULT 1,
  `timecheck` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `yourschedule`
--

INSERT INTO `yourschedule` (`stt`, `idkhachhang`, `title`, `start`, `end`, `confirmed`, `reason`, `location`, `resource`, `timecheck`) VALUES
(1, 'mMr0u8XA', 'BodyPump', '2022-12-04T08:00', '2022-12-04T08:45', 'false', 'Lily', 'L1-02', 1, '2022-12-02 23:35:23'),
(2, 'mMr0u8XA', 'Sexy Dance', '2022-12-05T07:00', '2022-12-05T09:30', 'false', 'Kelly', 'L3-01', 1, '2022-12-02 23:49:07'),
(3, 'mMr0u8XA', 'Zumba', '2022-11-29T17:00', '2022-11-29T19:00', 'false', 'Kelvin', 'T-03', 1, '2022-12-03 03:06:27'),
(4, 'mMr0u8XA', 'CRUNCH PLUS', '2022-12-01T17:00', '2022-12-01T18:30', 'false', 'Candy', 'T2-01', 1, '2022-12-03 03:08:37'),
(5, 'R68ctS7p', 'BODY COMBAT', '2022-11-28T17:45', '2022-11-28T18:15', 'false', 'Miu', 'T4-01', 1, '2022-12-03 03:11:08'),
(6, 'mMr0u8XA', 'KIT FIT', '2022-12-03T17:00', '2022-12-03T18:15', 'false', 'Kelvin', 'L3-03', 1, '2022-12-03 14:39:50'),
(7, 'R68ctS7p', 'Yoga', '2022-12-03T18:00', '2022-12-03T19:00', 'false', 'Vicky', 'L3-01', 1, '2022-12-03 18:18:18'),
(8, 'LAe516ET', 'Hip Opening', '2022-12-03T17:00', '2022-12-03T18:15', 'false', 'Manju', 'T-07', 1, '2022-12-03 22:26:53');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`idemp`);

--
-- Chỉ mục cho bảng `hocvien`
--
ALTER TABLE `hocvien`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `tapthu`
--
ALTER TABLE `tapthu`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`idteacher`);

--
-- Chỉ mục cho bảng `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `yourschedule`
--
ALTER TABLE `yourschedule`
  ADD PRIMARY KEY (`stt`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `classroom`
--
ALTER TABLE `classroom`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `schedule`
--
ALTER TABLE `schedule`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `tapthu`
--
ALTER TABLE `tapthu`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT cho bảng `training`
--
ALTER TABLE `training`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT cho bảng `yourschedule`
--
ALTER TABLE `yourschedule`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
