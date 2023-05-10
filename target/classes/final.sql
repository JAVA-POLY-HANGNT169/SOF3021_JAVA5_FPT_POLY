CREATE DATABASE SOF3021_VIDEO_DEMO;

GO
USE SOF3021_VIDEO_DEMO;
GO

CREATE TABLE hang (
                      id uniqueidentifier DEFAULT NEWID() NOT NULL,
                      ma varchar(20) NULL,
                      ten_hang nvarchar(100) NULL,
                      CONSTRAINT hang_PK PRIMARY KEY (id),
                      CONSTRAINT hang_UN UNIQUE (ma)
);

CREATE TABLE may_tinh (
                          id uniqueidentifier DEFAULT NEWID() NOT NULL,
                          hang_id uniqueidentifier NULL,
                          ma varchar(20) NULL,
                          ten_may_tinh nvarchar(100) NULL,
                          gia float NULL,
                          mau_sac nvarchar(100) NULL,
                          mieu_ta nvarchar(100) NULL,
                          CONSTRAINT may_tinh_PK PRIMARY KEY (id),
                          CONSTRAINT may_tinh_UN UNIQUE (ma),
                          CONSTRAINT may_tinh_FK FOREIGN KEY (hang_id) REFERENCES hang(id)
);
ALTER TABLE may_tinh ADD bo_nho varchar(50) NULL;

INSERT INTO hang
(id, ma, ten_hang)
VALUES(N'448C3F2B-FC69-4D18-B13C-1B8BAC6ED489', N'H03', N'Dell');
INSERT INTO hang
(id, ma, ten_hang)
VALUES(N'E6ACC1B3-A79D-4546-9800-7431B96047B3', N'H02', N'Acer');
INSERT INTO hang
(id, ma, ten_hang)
VALUES(N'08FD9D5B-3A99-432A-AEAA-A7C9556D0B72', N'H01', N'Lenovo');
INSERT INTO hang
(id, ma, ten_hang)
VALUES(N'5F8179C4-9F03-47CC-A106-FBED92481EF3', N'H04', N'Macbook');

INSERT INTO may_tinh
(id, hang_id, ma, ten_may_tinh, gia, mau_sac, mieu_ta, bo_nho)
VALUES(N'63D0059A-D8AE-42AC-B499-05E1085A6580', N'5F8179C4-9F03-47CC-A106-FBED92481EF3', N'M05', N'G15 5520', 20000000, N'Đen', N'Laptop văn phòng', N'512GB');
INSERT INTO may_tinh
(id, hang_id, ma, ten_may_tinh, gia, mau_sac, mieu_ta, bo_nho)
VALUES(N'DC928A50-D50B-4867-BFB9-27FC3ACB95D9', N'E6ACC1B3-A79D-4546-9800-7431B96047B3', N'M04', N'Nitro 5 Eagle', 58000000, N'Xám', N'Laptop văn phòng', N'1TB');
INSERT INTO may_tinh
(id, hang_id, ma, ten_may_tinh, gia, mau_sac, mieu_ta, bo_nho)
VALUES(N'F349496B-5587-4D23-A4DE-31FE6586F3F0', N'448C3F2B-FC69-4D18-B13C-1B8BAC6ED489', N'M03', N'Vostro 5620', 18000000, N'Xanh', N'Laptop văn phòng', N'512GB');
INSERT INTO may_tinh
(id, hang_id, ma, ten_may_tinh, gia, mau_sac, mieu_ta, bo_nho)
VALUES(N'E83CA190-D904-4B00-AD9A-A42400C9151E', N'448C3F2B-FC69-4D18-B13C-1B8BAC6ED489', N'M01', N'Idea Pad Slim', 38000000, N'Xám', N'Laptop văn phòng', N'256GB');
INSERT INTO may_tinh
(id, hang_id, ma, ten_may_tinh, gia, mau_sac, mieu_ta, bo_nho)
VALUES(N'207392AC-54A0-4FB5-A6F2-B3AA8E3B5BE7', N'448C3F2B-FC69-4D18-B13C-1B8BAC6ED489', N'M02', N'Aspire ', 25000000, N'Đen', N'Laptop văn phòng', N'512GB');