CREATE DATABASE BTVN11;

USE BTVN11;

CREATE TABLE may_tinh(
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ma varchar(100)
	ten nvarchar(100),
	gia float,
	bo_nho nvarchar(100),
	mau_sac nvarchar(100),
	hang nvarchar(100),
	mieu_ta nvarchar(100)
)