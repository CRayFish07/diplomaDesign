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

</head>
<body>
    <!--顶部-->
    <div class="layout_top_header">
            <div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">办公室管理系统</span></div>
            <div id="ad_setting" class="ad_setting">
                    <span style="color: red;">欢迎您的登录</span>
            </div>
            
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="layout_left_menu">
        <ul id="menu">
            <li class="childUlLi">
               <a href="????"><i class="glyph-icon icon-home"></i>首页</a>
                <ul>
                    <li><a href="dispatch?mark=deptMeet"><i class="glyph-icon icon-chevron-right"></i>自己部门的会议</a></li>
                	<li><a href="dispatch?mark=deptMeetOurs"><i class="glyph-icon icon-chevron-right"></i>自己参加的会议</a></li>
                </ul>
            </li>
            <li class="childUlLi">
            	<a href="log!logOut" onclick="return exitConfirm();"><i class="glyph-icon icon-reorder"></i>退出</a>
            </li>
             <li class="childUlLi">
            	<a href="dispatch?mark=changePasswordE"><i class="glyph-icon icon-reorder"></i>修改密码</a>
            </li>
        </ul>
    </div>
    <!--菜单-->
    <div id="layout_right_content" class="layout_right_content">
		
		<!-- 中部的导航空间-->
        <div class="route_bg">
        	
        </div>
        <div class="mian_content">
            <div id="page_content">
            	<!-- 这一部分是中间显示的部分可以将这一部分换成其他的内容来改变内容-->
                <iframe id="menuFrame" name="menuFrame" src="${pageContext.request.contextPath}/workE/deptMeeting.jsp" style="overflow:visible;"
                        scrolling="yes" frameborder="no" width="100%" height="100%">
               </iframe> 
            </div>
        </div>
    </div>
    <div class="layout_footer">
        <p>Tanoya copyright Inc@ 2015</p>
    </div>
</body>
</html>
