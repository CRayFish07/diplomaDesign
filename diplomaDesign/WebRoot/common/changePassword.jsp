<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>

<script type="text/javascript" src="../js/jquery.min.js"></script>

<link rel="stylesheet" href="../css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../js/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
	<form action="changePassword" method="post">
		<div class="control-group">
			<label class="laber_from">旧密码</label>
			<div  class="controls" ><input class="input_from" type="text" name="oldPassword" placeholder="请输入旧密码" /><p class=help-block></p></div>
		</div>
		<div class="control-group">
			<label class="laber_from">新密码</label>
			<div class="controls">
				<input class="input_from" type="text" name="newPassword" placeholder="其输入新密码" />
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">请确认新密码</label>
			<div class="controls">
				<input type="text" name="newPasswordCon" class="input_from" placeholder="请确认新密码" />
			</div>
		</div>

		<div class="control-group">
			<label class="laber_from"></label>
			<div class="controls">
				<button  class="btn btn-success" style="width:100px;" >申请</button>
				<button  class="btn btn-success" style="width:100px;" >取消</button>
			</div>
		</div>
	</form>
	
</div>
</body>
</html>