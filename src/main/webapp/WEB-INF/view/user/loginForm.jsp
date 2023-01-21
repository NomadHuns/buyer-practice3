<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>로그인 페이지</h1>
        <hr>
        <form action="/login" method="post">
            아이디&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" placeholder="Enter username"
                autofocus><br>
            비밀번호&nbsp;&nbsp;<input type="password" name="password" placeholder="Enter password"><br>
            <button type="submit">로그인</button>
        </form>
        <%@ include file="../layout/footer.jsp" %>