<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/24/18
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="login.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Login</span></a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Financial Tracker</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="login.jsp">Login</a>
            <a class="dropdown-item" href="view-assets.jsp">Asset Summary</a>
            <a class="dropdown-item" href="add-asset.jsp">Add Asset</a>
            <a class="dropdown-item" href="sold-asset.jsp">Sold Asset</a>
            <a class="dropdown-item" href="register.jsp">Register</a>
            <a class="dropdown-item" href="forgot-password.jsp">Forgot Password</a>
            <div class="dropdown-divider"></div>

        </div>
    </li>


</ul>
