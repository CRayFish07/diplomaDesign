<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>给部门成员发送邀请信息</title>

<script type="text/javascript" src="js/jquery.min.js"></script>

<link rel="stylesheet" href="../css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
	<form action="sendMail" method="post">
		<div class="control-group">
			<label class="laber_from">会议主题</label>
			<div  class="controls" >
				<input class="input_from" type="text" placeholder="请输入会议主题" name="theme" value="${meeting.meeting_name}"/>
				<p class=help-block></p>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">开始时间</label>
			<div class="controls">
				<input class="input_from" type="text" placeholder="会议开始时间" name="meetingStart" value="${meeting.meeting_start}"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">结束时间</label>
			<div class="controls">
				<input type="text" name="meetingEnd" class="input_from" placeholder="请输入结束时间" value="${meeting.meeting_end }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">申请时间</label>
			<div class="controls">
				<input type="text" name="applicationTime" class="input_from" placeholder="请输入申请时间" value="${meeting.meeting_order_time }" />
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">会议发起人</label>
			<div class="controls">
				<input type="text" name="launcher" class="input_from" placeholder="请输入会议发起人" value="${meeting.log_name }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">房间id</label>
			<div class="controls">
				<input type="text" name="roomId"  class="input_from" placeholder="房间id" value="${meeting.meeting_room_id }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">部门id</label>
			<div class="controls">
				<input type="text" name="deptId" class="input_from" placeholder="部门id" value="${meeting.dept_id}"/>
			</div>
		</div>
		
		<div class="control-group">
			<input class="laber_from" value="${meeting.meeting_id}" name="id" style="display: none;"/>
		</div>
		<div class="control-group">
			<label class="laber_from">联系人地址</label>
			<div class="controls">
				<textarea name="tarList" rows="6" cols="30"></textarea>
			</div>
		</div>
		
		<div class="control-group">
			<label class="laber_from"></label>
			<div class="controls">
				<button  class="btn btn-success" style="width:100px;" >发送</button>
				<button  class="btn btn-success" style="width:100px;" >取消</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>