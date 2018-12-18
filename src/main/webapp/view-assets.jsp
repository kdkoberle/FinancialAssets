<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>


<body id="page-top">

<%@include file="navbar.jsp"%>

<div id="wrapper">

    <!-- Sidebar -->
    <%@include file="sidebar.jsp"%>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- DataTables Example -->
            <h2>Username <c:out value="${sessionScope.username}"/></h2>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Assets</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Asset</th>
                                <th>Buy Price</th>
                                <th>Sell Price</th>
                                <th>Quantity</th>
                                <th>Buy Date</th>
                                <th>Sell Date</th>
                                <th>Fees</th>
                                <th>(Un)Realized Gain/Loss $</th>
                                <th>(Un)Realized Gain/Loss %</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userAsset" items="${userAssets}">
                            <tr>
                                <td>${userAsset.assetName}</td>
                                <td>$ ${userAsset.buyPrice}</td>
                                <td>${userAsset.sellPrice}</td>
                                <td>${userAsset.qty}</td>
                                <td>${userAsset.buyDate}</td>
                                <td>${userAsset.sellDate}</td>
                                <td>$ ${userAsset.fees}</td>
                                <td>$ ${userAsset.gainOrLossDollar}</td>
                                <td>${userAsset.gainOrLossPercent} %</td>
                                <td>
                                    <div name="${userAsset.userAssetId}">
                                        <span><a href="/SoldAsset">Sold</a></span>
                                        <span><a href="/EditAsset">Edit</a></span>
                                        <span><a href="/DeleteAsset">Delete</a></span>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>



                    </div>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <!-- Sticky Footer -->
        <%@include file="footer.jsp"%>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>



<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>
<script src="js/demo/chart-area-demo.js"></script>

</body>

</html>
