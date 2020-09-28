<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<header>
    <jsp:include page="fragment/header.jsp"/>
</header>
<div class="container-fluid">
    <div class="row">
        <aside>
            <jsp:include page="fragment/aside.jsp"/>
        </aside>
        <main>
            <jsp:include page="${correntPage}"/>
        </main>
    </div>
</div>
<footer>
    <jsp:include page="fragment/footer.jsp"/>
</footer>
<script src="/static/js/jquery.js"></script>
</body>
</html>