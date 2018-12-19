<%@include file="head.jsp"%>
<body id="page-top">

<%@include file="navbar.jsp"%>



<div id="wrapper">

    <!-- Sidebar -->
    <%@include file="sidebar.jsp"%>

    <div id="content-wrapper">

        <div class="container-fluid">



            <!-- Page Content -->
            <h1>Add Asset</h1>
            <hr>

            <FORM ACTION="${pageContext.request.contextPath}/AddAsset" METHOD="POST">
                <!-- -->
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="name" id="name" class="form-control" placeholder="Stock Symbol" required="required" autofocus="autofocus" name="name">
                        <label for="name">Stock Symbol</label>
                    </div>
                </div>
                <!-- -->
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="dateBought" id="dateBought" class="form-control" placeholder="Date Bought (YYYY-MM-DD)"
                               required="required" autofocus="autofocus" name="dateBought"
                               pattern="^\d{4}-\d{2}-\d{2}$">
                        <label for="dateBought">Date Bought (YYYY-MM-DD)</label>

                    </div>
                </div>
                <!-- -->
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="qtyBought" id="qtyBought" class="form-control" placeholder="Quantity Bought" required="required" name="qtyBought"
                               pattern="^\d*$">
                        <label for="qtyBought">Quantity Bought</label>
                    </div>
                </div>
                <!-- -->
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="price" id="price" class="form-control" placeholder="Price Per Unit" required="required" name="price">
                        <label for="price">Price Per Unit</label>
                    </div>
                </div>
                <!-- -->
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="fees" id="fees" class="form-control" placeholder="Fees (shipping, commission, etc)" required="required" name="fees">
                        <label for="fees">Fees $USD (shipping, commission, etc)</label>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Add Asset" />
            </FORM>
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
<script type="text/javascript" src="js/popper.min.js"></script>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

</body>

</html>
