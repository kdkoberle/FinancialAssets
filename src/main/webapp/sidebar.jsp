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

    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Assets Tracker</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Assets Tracker:</h6>
            <a class="dropdown-item" href="view-assets.jsp">Asset Summary</a>
            <a class="dropdown-item" href="add-asset.jsp">Add Asset</a>
            <a class="dropdown-item" href="sold-asset.jsp">Sold Asset</a>
            <a class="dropdown-item" href="edit-asset.jsp">Edit Asset</a>
            <a class="dropdown-item" href="remove-asset.jsp">Remove Asset</a>
            <div class="dropdown-divider"></div>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="logout.jsp">
            <span>Logout</span></a>
    </li>
</ul>
<% } else if (request.isUserInRole("registered-user")) { %>

<!-- Registered User Sidebar -->
<ul class="sidebar navbar-nav">

<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-fw fa-folder"></i>
        <span>Assets Tracker</span>
    </a>
    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
        <h6 class="dropdown-header">Assets Tracker:</h6>
        <a class="dropdown-item" href="view-assets.jsp">Asset Summary</a>
        <a class="dropdown-item" href="add-asset.jsp">Add Asset</a>
        <a class="dropdown-item" href="sold-asset.jsp">Sold Asset</a>
        <a class="dropdown-item" href="edit-asset.jsp">Edit Asset</a>
        <a class="dropdown-item" href="remove-asset.jsp">Remove Asset</a>
        <div class="dropdown-divider"></div>
    </div>
</li>
<li class="nav-item">
    <a class="nav-link" href="logout.jsp">
        <span>Logout</span></a>
</li>
</ul>
<% } else { %>
<!-- Nonregistered Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="login.jsp">
            <span>Login</span></a>
    </li>
</ul>

<% } %>


