CREATE DATABASE WS_FA22_BL1

USE WS_FA22_BL1

CREATE TABLE WS_FA22_BL1.dbo.danh_muc (
	id uniqueidentifier DEFAULT newID() NOT NULL,
	ten_danh_muc nvarchar(100) NULL,
	CONSTRAINT danh_muc_PK PRIMARY KEY (id)
);

CREATE TABLE WS_FA22_BL1.dbo.san_pham (
	id uniqueidentifier DEFAULT newID() NOT NULL,
	danh_muc_id uniqueidentifier NULL,
	ten_san_pham nvarchar(100) NULL,
	so_luong int NULL,
	gia_nhap decimal(38,0) NULL,
	gia_ban decimal(38,0) NULL,
	mieu_ta nvarchar(4000) NULL,
	CONSTRAINT san_pham_PK PRIMARY KEY (id),
	CONSTRAINT san_pham_FK FOREIGN KEY (danh_muc_id) REFERENCES WS_FA22_BL1.dbo.danh_muc(id)
);

CREATE TABLE WS_FA22_BL1.dbo.hoa_don (
	id uniqueidentifier DEFAULT newID() NOT NULL,
	ngay_tao datetime NULL,
	CONSTRAINT hoa_don_PK PRIMARY KEY (id),
);

ALTER TABLE WS_FA22_BL1.dbo.hoa_don ADD ten_nguoi_nhan nvarchar(100) NULL;
ALTER TABLE WS_FA22_BL1.dbo.hoa_don ADD dia_chi nvarchar(100) NULL;
ALTER TABLE WS_FA22_BL1.dbo.hoa_don ADD so_dien_thoai varchar(20) NULL;
ALTER TABLE WS_FA22_BL1.dbo.hoa_don ADD trang_thai int DEFAULT 0 NULL;

CREATE TABLE WS_FA22_BL1.dbo.hoa_don_chi_tiet (
	id uniqueidentifier DEFAULT newID() NOT NULL,
	hoa_don_id uniqueidentifier NULL,
	san_pham_id uniqueidentifier NULL,
	so_luong int NULL,
	don_gia decimal(38,0) DEFAULT 0 NULL,
	CONSTRAINT hoa_don_chi_tiet_PK PRIMARY KEY (id),
	CONSTRAINT hoa_don_chi_tiet_FK FOREIGN KEY (hoa_don_id) REFERENCES WS_FA22_BL1.dbo.hoa_don(id),
	CONSTRAINT hoa_don_chi_tiet_FK_1 FOREIGN KEY (san_pham_id) REFERENCES WS_FA22_BL1.dbo.san_pham(id)
);

-- Insert Danh Mục
INSERT INTO WS_FA22_BL1.dbo.danh_muc
(id, ten_danh_muc)
VALUES(N'AEB632DB-EC8E-46BA-9EF8-0A12C47C8A29', N'danh mục 2');
INSERT INTO WS_FA22_BL1.dbo.danh_muc
(id, ten_danh_muc)
VALUES(N'FCF58EAA-65F1-4449-B155-260B6FD1254B', N'danh mục 4');
INSERT INTO WS_FA22_BL1.dbo.danh_muc
(id, ten_danh_muc)
VALUES(N'575756D7-4987-408E-9892-4293ACF3FE73', N'danh mục 5');
INSERT INTO WS_FA22_BL1.dbo.danh_muc
(id, ten_danh_muc)
VALUES(N'4E0A185F-35F1-4137-806A-BBB7DBEFD07C', N'danh mục 1');
INSERT INTO WS_FA22_BL1.dbo.danh_muc
(id, ten_danh_muc)
VALUES(N'2B8D1C87-DA09-45AF-ACE8-DF6D8BDF5E28', N'danh mục 3');

-- Insert Sản Phẩm 
INSERT INTO WS_FA22_BL1.dbo.san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(N'A28542A5-6175-4238-B7FD-6857A610155B', N'AEB632DB-EC8E-46BA-9EF8-0A12C47C8A29', N'Sản phẩm 2', 200, 12000, 14000, N'Miêu tả 2');
INSERT INTO WS_FA22_BL1.dbo.san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(N'2B6492B4-280E-4E08-B045-86852E3290C6', N'AEB632DB-EC8E-46BA-9EF8-0A12C47C8A29', N'Sản phẩm 1', 100, 10000, 15000, N'Miêu tả 1');
INSERT INTO WS_FA22_BL1.dbo.san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(N'A5ACA757-00EB-4B83-9FF5-C040E852C01B', N'AEB632DB-EC8E-46BA-9EF8-0A12C47C8A29', N'Sản phẩm 3', 150, 8000, 12000, N'Miêu tả 3');
INSERT INTO WS_FA22_BL1.dbo.san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(N'FE20AB55-B859-44EE-8402-C94A4BF3F76C', N'2B8D1C87-DA09-45AF-ACE8-DF6D8BDF5E28', N'Sản phẩm 6', 160, 12000, 18000, N'Miêu tả 6');
INSERT INTO WS_FA22_BL1.dbo.san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(N'3B0E3D4D-E276-4B43-8A25-F0A1797C19A9', N'FCF58EAA-65F1-4449-B155-260B6FD1254B', N'Sản phẩm 4', 120, 4000, 10000, N'Miêu tả 4');
INSERT INTO WS_FA22_BL1.dbo.san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(N'61B5C5F1-555A-457B-966C-FEB54D6BEB34', N'FCF58EAA-65F1-4449-B155-260B6FD1254B', N'Sản phẩm 5', 130, 8000, 12000, N'Miêu tả 5');

-- Insert Hoá Đơn
INSERT INTO WS_FA22_BL1.dbo.hoa_don
(id, ngay_tao, ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
VALUES(N'C4952459-E478-4526-9704-5241EEE58102', '2022-10-01 03:52:55.597', N'Nguyễn Văn C', N'Thái Bình', N'0986789888', 0);
INSERT INTO WS_FA22_BL1.dbo.hoa_don
(id, ngay_tao, ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
VALUES(N'784B10A8-0FFB-4F4A-AE38-8B6FAA61A65D', '2022-09-02 03:52:55.597', N'Nguyễn Văn B', N'Nam Định', N'0987654567', 1);
INSERT INTO WS_FA22_BL1.dbo.hoa_don
(id, ngay_tao, ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
VALUES(N'23E0C49D-A863-40FB-85F6-FFBA9D8C23AD', '2022-06-02 03:52:55.597', N'Nguyễn Văn A', N'Hà Nội', N'0123456789', 0);

-- Insert Hoá Đơn Chi tiết
INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(N'0372D1C0-E4EB-43B9-A4D1-51D3CA474A7C', N'C4952459-E478-4526-9704-5241EEE58102', N'A28542A5-6175-4238-B7FD-6857A610155B', 2, 14000);
INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(N'7F2313BD-E8E4-4D26-AE22-5F684A14151A', N'784B10A8-0FFB-4F4A-AE38-8B6FAA61A65D', N'61B5C5F1-555A-457B-966C-FEB54D6BEB34', 1, 12000);
INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(N'D4FC7C30-464A-40DF-93E2-79D67C7CB50A', N'23E0C49D-A863-40FB-85F6-FFBA9D8C23AD', N'A28542A5-6175-4238-B7FD-6857A610155B', 1, 14000);
INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(N'EF7B55AA-B828-441D-9924-C7EACE4602AB', N'784B10A8-0FFB-4F4A-AE38-8B6FAA61A65D', N'A28542A5-6175-4238-B7FD-6857A610155B', 1, 14000);
INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(N'2E13EDA9-54EB-4BA0-B356-F3F7CD853F41', N'C4952459-E478-4526-9704-5241EEE58102', N'2B6492B4-280E-4E08-B045-86852E3290C6', 1, 15000);
INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(N'C50188E8-2C84-4E70-87CA-F85BB0130500', N'C4952459-E478-4526-9704-5241EEE58102', N'A5ACA757-00EB-4B83-9FF5-C040E852C01B', 2, 12000);
