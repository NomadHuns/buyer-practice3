<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>구매 내역 페이지</h1>
        <hr>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>제품명</th>
                <th>구매자</th>
                <th>구매수</th>
                <th>구매일</th>
                <th></th>
            </tr>
            <c:forEach items="${purchaseAllDtoList}" var="purchase">
                <tr>
                    <td>${purchase.id}</td>
                    <td>${purchase.name}</td>
                    <td>${purchase.username}</td>
                    <td>${purchase.count}개</td>
                    <td>${purchase.createdAtToString}</td>
                    <td>
                        <form action="/purchase/${purchase.id}/delete" method="post">
                            <button type="submit">취소</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%@ include file="../layout/footer.jsp" %>