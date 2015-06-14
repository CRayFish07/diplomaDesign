<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>办公室管理系统</title>

<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tendina.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="javascript/checkInput.js"></script>

<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
    <!--顶部-->
    <div class="layout_top_header">
            <div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">办公室管理系统</h1></span></div>
            <div class="ad_setting" id="ad_setting">
            	<span style="color:red">欢迎管理员登陆</span>
            </div>
            <!--
            <div id="ad_setting" class="ad_setting">
                <a class="ad_setting_a" href="javascript:; ">
                    <i class="icon-user glyph-icon" style="font-size: 20px"></i>
                    <span>管理员</span>
                    <i class="icon-chevron-down glyph-icon"></i>
                </a>
                <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-user glyph-icon"></i> 个人中心 </a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置 </a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
                </ul>
            </div>
            -->
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="layout_left_menu">
        <ul id="menu">
            <li class="childUlLi">
               <a href="main.html"  target="menuFrame"><i class="glyph-icon icon-home"></i>首页</a>
                <ul>
                    <li><a href="dispatch?mark=addEmp"><i class="glyph-icon icon-chevron-right"></i>用户添加</a></li>
                </ul>
            </li>
            <li class="childUlLi">
            	<a href="????" target="menuFrame"><i class="glyph-icon icon-reorder"></i>员工管理</a>
            	<ul>
            		<li><a href="dispatch?mark=deleteEmp" ><i class="glyph-icon icon-chevron-right"></i>删除用户</a></li>
            		<li><a href="dispatch?mark=updateEmp" ><i class="glyph-icon icon-chevron-right"></i>修改用户</a></li>
            		<li><a href="dispatch?mark=addUserLog"><i class="glyph-icon icon-chevron-right"></i>添加账号</a></li>
            	</ul>
            </li>
            <li class="childUlLi">
            	<a href="????" target="menuFrame"><i class="glyph-icon icon-reorder"></i>房间管理</a>
            	<ul>
            		<li><a href="dispatch?mark=addRoom" ><i class="glyph-icon icon-chevron-right"></i>增加房间</a></li>
            		<li><a href="dispatch?mark=deleteRoom" ><i class="glyph-icon icon-chevron-right"></i>删除房间</a></li>
            		<li><a href="dispatch?mark=updateRoom" ><i class="glyph-icon icon-chevron-right"></i>修改房间</a></li>
            	</ul>
            </li>
            <li class="childUlLi">
            	<a href="log!logOut" onclick="return exitConfirm();"><i class="glyph-icon icon-reorder"></i>退出</a>
            </li>
             <li class="childUlLi">
            	<a href="dispatch?mark=changePasswordA"><i class="glyph-icon icon-reorder"></i>修改密码</a>
            </li>
        </ul>
    </div>
    <!--菜单-->
    <div id="layout_right_content" class="layout_right_content">
		
		<!-- 使用导航链接-->
        <div class="route_bg">
        	<!-- 
            <a href="#">主页</a><i class="glyph-icon icon-chevron-right"></i>
            <a href="#">菜单管理</a>
           -->
        </div>
        <div class="mian_content">
            <div id="page_content">
            	<!-- 这一部分是中间显示的部分可以将这一部分换成其他的内容来改变内容-->
            	<!-- 
                <iframe id="menuFrame" name="menuFrame" src="../administrator/addEmployee.jsp" style="overflow:visible;"
                        scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
                
                -->
                
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
				<input class="input_from" type="text" placeholder="请输入手机号码" name="phone" id="phone"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">QQ</label>
			<div class="controls">
				<input type="text" name="QQ" class="input_from" placeholder="请输入QQ密码" id="QQ"/>
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
				<input type="text" name="email" class="input_from" placeholder="请输入Email" id="email"/>
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
		<div class="control-group">
			<label class="laber_from"></label>
			<div class="controls">
				<button  class="btn btn-success" style="width:100px;" onclick="return confirmEmployee();">提交</button>
				<button  class="btn btn-success" style="width:100px;" onclick="return clearInput();">取消</button>
			</div>
		</div>
	</form>
	
</div>
            </div>
        </div>
    </div>
    <div class="layout_footer">
        <p>Tanoya copyright Inc@ 2015</p>
    </div>
    
</body>
</html>
