<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 2/16/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="/may-tinh/update?id=${mayTinh.id}" method="post" class="container">
    Mã: <input type="text" name="ma" value="${mayTinh.ma}"> <br>
    Tên: <input type="text" name="ten" value="${mayTinh.ten}"> <br>
    Giá: <input type="text" name="gia" value="${mayTinh.gia}"> <br>
    Bộ nhớ: <input type="text" name="boNho" value="${mayTinh.boNho}"> <br>
    Màu sắc:
    <input type="radio" name="mauSac" value="Đen" ${mayTinh.mauSac == "Đen" ? "checked" : ""} checked>Đen
    <input type="radio" name="mauSac" value="Bạc" ${mayTinh.mauSac == "Bạc" ? "checked" : ""}>Bạc
    <br>
    Hãng:
    <select name="hang">
        <option value="MSI" ${mayTinh.hang == "MSI" ? "selected" : ""}>MSI</option>
        <option value="ASUS" ${mayTinh.hang == "ASUS" ? "selected" : ""}>ASUS</option>
        <option value="ACER" ${mayTinh.hang == "ACER" ? "selected" : ""}>ACER</option>
        <option value="DELL" ${mayTinh.hang == "DELL" ? "selected" : ""}>DELL</option>
    </select>
    <br>
    Mô tả: <input type="text" name="moTa" value="${mayTinh.mieuTa}"><br>
    <button class="btn btn-success" type="submit">Update</button>
</form>
</body>
</html>
