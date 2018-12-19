<%@include file="head.jsp"%>


<body id="page-top">

<%@include file="navbar.jsp"%>

<div id="wrapper">

    <!-- Sidebar -->
    <%@include file="sidebar.jsp"%>

    <div id="content-wrapper">

        <div class="container-fluid">
        <h1>Asset Added Successfully</h1>
        <hr>

            Stock symbol: ${name}
            <br />
            Date bought:  ${dateBought}
            <br />
            Quantity bought:  ${qtyBought}
            <br />
            Price:  $${price}
            <br/>
            Fees:  $${fees}
            <br />
            <br/>
            <hr>
            <br/>
            <div>
                <a href="${pageContext.request.contextPath}/add-asset.jsp" class="btn btn-lg btn-success btn-block">Add Another Asset</a>
                <a href="${pageContext.request.contextPath}/ViewAssets" class="btn btn-lg btn-success btn-block">View All Assets</a>
            </div>

    </div>
    <!-- /.container-fluid -->

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

<!-- Sticky Footer -->
<%@include file="footer.jsp"%>

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

</body>

</html>
