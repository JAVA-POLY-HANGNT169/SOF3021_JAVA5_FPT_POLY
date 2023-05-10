<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Quản Lý Máy Tính</h2></header>
<main>
    <section>
        <form action="/may-tinh/add" method="post" class="container">
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
                <c:forEach items="${hangs }" var="h">
                    <option value="${h.id}" ${h.id == mayTinh.hang.id ? 'selected="selected"' : ''}>${h.tenHang}</option>
                </c:forEach>
            </select>
            <br>
            Mô tả: <input type="text" name="moTa" value="${mayTinh.mieuTa}"><br>
            <button class="btn btn-success" type="submit">Add</button>
        </form>
    </section>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Bộ nhớ</th>
                    <th scope="col">Màu sắc</th>
                    <th scope="col">Tên Hãng</th>
                    <th scope="col">Mô Tả</th>
                    <th scope="col">hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listMayTinh.content }" var="mayTinh">
                    <tr>
                        <td>${mayTinh.ma}</td>
                        <td>${mayTinh.ten}</td>
                        <td>${mayTinh.gia}</td>
                        <td>${mayTinh.boNho }</td>
                        <td>${mayTinh.mauSac }</td>
                        <td>${mayTinh.hang.tenHang}</td>
                        <td>${mayTinh.mieuTa}</td>
                        <td>
                            <a class="btn btn-success" href="/may-tinh/detail/${mayTinh.id}">detail</a>
                            <a class="btn btn-primary" href="/may-tinh/view-update/${mayTinh.id}">update</a>
                            <a class="btn btn-danger" href="/may-tinh/delete/${mayTinh.id}">xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:forEach begin="0" end="${ listMayTinh.totalPages -1}" varStatus="loop">
                        <li class="page-item">
                            <a class="page-link" href="/may-tinh/hien-thi?page=${loop.begin + loop.count - 1}">
                                    ${loop.begin + loop.count }
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </section>
</main>
<footer><p style="text-align: center;">HangNT169</p></footer>
</body>
</html>
