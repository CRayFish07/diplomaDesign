<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加员工</title>

<script type="text/javascript" src="js/jquery.min.js"></script>

<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
	<form action="addEmployee" method="post">
		<div class="control-group">
			<label class="laber_from">姓名</label>
			<div  class="controls" ><input class="input_from" type="text" placeholder=" 请输入用户名" name="name"><p class=help-block></p></div>
		</div>
		<div class="control-group">
			<label class="laber_from">性别</label>
			<div class="controls">
				<select class="input_select" name="sex">
					<option selected="selected">男</option>
					<option>女</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">手机</label>
			<div class="controls">
				<input class="input_from" type="text" placeholder="请输入手机号码" name="phone"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">QQ</label>
			<div class="controls">
				<input type="text" name="QQ" class="input_from" placeholder="请输入QQ密码" />
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">公司</label>
			<div class="controls">
				<input type="text" name="company" class="input_from" placeholder="请输入公司名称" />
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">Email</label>
			<div class="controls">
				<input type="text" name="email" class="input_from" placeholder="请输入Email" />
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">住址</label>
			<div class="controls">
				<input type="text" name="address"  class="input_from" placeholder="请输入住址"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">部门</label>
			<div class="controls">
				<select name="department" class="input_select">
					<option value="1">研发部</option>        <!-- value中的值代表研发部 中的代码-->
	  				<option value="2">技术支持部</option>
	  				<option value="3">产品部</option>
	  				<option value="4">营销部</option>
	  				<option value="5">后勤部</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">职务</label>
			<div class="controls">
				<select class="input_select" name="position">
					<option value="1">总经理</option>
					<option value="5">部门经理</option>      <!-- value中的值代表数据库中的部门经理的代码 -->
	  				<option value="9">普通职员</option>
				</select>
			</div>
		</div>
	</form>
	<!-- 原版的数据-->
	<!--
    <FORM>
        <DIV class="control-group">
            <label class="laber_from">用户名</label>
            <DIV  class="controls" ><INPUT class="input_from" type=text placeholder=" 请输入用户名"><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">密码</LABEL>
            <DIV  class="controls" ><INPUT class="input_from" type=text placeholder=" 请输入密码"><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from" >确认密码</LABEL>
            <DIV  class="controls" ><INPUT class="input_from" type=text placeholder=" 请输入确认密码"><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">角色</LABEL>
            <DIV  class="controls" >
                <SELECT class="input_select">
                    <OPTION selected>董事长</OPTION>
                    <OPTION>总经理</OPTION>
                    <OPTION>经理</OPTION>
                    <OPTION>主管</OPTION>
                </SELECT>
            </DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from" ></LABEL>
            <DIV class="controls" ><button class="btn btn-success" style="width:120px;" >确认</button></DIV>
        </DIV>
    </FORM>
    -->
</div>
</body>
</html>