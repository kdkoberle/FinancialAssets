<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/24/18
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->

<!-- Admin Sidebar -->
<% if (request.isUserInRole("admin")) { %>
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="/ViewAssets">
            <span>Asset Summary</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/add-asset.jsp">
            <span>Add Asset</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/Logout">
            <span>Logout</span></a>
    </li>
</ul>
<% } else if (request.isUserInRole("registered-user")) { %>

<!-- Registered User Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="/ViewAssets">
            <span>Asset Summary</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/add-asset.jsp">
            <span>Add Asset</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/Logout">
            <span>Logout</span></a>
    </li>
</ul>
<% } else { %>
<!-- Nonregistered Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="landing-page.jsp">
            <span>Login</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="register.jsp">
            <span>Register</span></a>
    </li>

</ul>

<% } %>


