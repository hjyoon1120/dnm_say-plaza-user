<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

</div><!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- Slimscroll -->
<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>

<!-- AdminLTE App -->
<script src="/resources/dist/js/app.min.js"></script>

<!-- iCheck -->
    <script src="/resources/plugins/iCheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>

</body>
</html>
