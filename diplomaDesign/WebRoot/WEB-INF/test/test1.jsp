<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>用户信息检查</title>
		<script type="text/javascript">
			function check(){
				var checkInput = document.getElementsByTagName("input");
				var i;
				for(i=0; i<checkInput.length; i++){
					if(checkInput[i].value == ""){
						alert(checkInput[i].name + " can't be null");
						return false;
					}
				}
				return true;
			}
		</script>
	</head>
	<body>
		<form action="????" method="post" onsubmit="return check()">
			<input type="text" name="name" id="name" />
			<input type="text" name="password" id="password" />
			<input type="submit" value="提交"/>
		</form>		
	</body>
</html>

