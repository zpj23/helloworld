<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!--[if lt IE 9]>
<script type="text/javascript" src="${ctx}/lib/html5.js"></script>
<script type="text/javascript" src="${ctx}/lib/respond.min.js"></script>
<script type="text/javascript" src="${ctx}/lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="${ctx}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>



<title>用户管理</title>
<script type="text/javascript">

$(document).ready(function(){
// 	initDep();
});

/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-删除*/
function admin_del(id){
	layer.confirm('确认要删除吗？',function(index){
		if(id==1||id=="1"){
			layer.msg('管理员不可删除!',{icon:5,time:3000});
			return;
		}
		//此处请求后台程序，下方是成功后的前台处理……
		$.ajax({
			   type: "POST",
			   url: "jlUserInfoAction_delUser",
			   async:false,
			   data: "id="+id,
			   success: function(data){
				   if(data==1){
						layer.msg('已删除!',{icon:1,time:1000});
				   }else{
					   layer.msg('删除失败!',{icon: 5,time:1000});
				   }
				   tolist();
			   }
			});
	});
}
/*管理员-编辑*/
function admin_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-停用*/
function admin_stop(id){
	layer.confirm('确认要停用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$.ajax({
			   type: "POST",
			   url: "jlUserInfoAction_ssUser",
			   async:false,
			   data: "id="+id,
			   success: function(data){
				   if(data==1){
					   layer.msg('已停用!',{icon: 5,time:1000});
				   }else{
					   layer.msg('停用失败!',{icon: 5,time:1000});
				   }
				   tolist();
			   }
			});
	});
}

/*管理员-启用*/
function admin_start(id){
	layer.confirm('确认要启用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		$.ajax({
			   type: "POST",
			   url: "jlUserInfoAction_ssUser",
			   async:false,
			   data: "id="+id,
			   success: function(data){
				   if(data==1){
					   layer.msg('已启用!', {icon: 6,time:1000});
				   }else{
					   layer.msg('启用用失败!',{icon: 5,time:1000});
				   }
				   tolist();
			   }
			});
		
		
	});
}
function searchInfo(){
	list_iframe.contentWindow.load($('#datemin').val(),$('#datemax').val(),$('#username').val(),$('#departmentid').val());
}
function tolist(){
	list_iframe.contentWindow.load($('#datemin').val(),$('#datemax').val(),$('#username').val(),$('#departmentid').val());
}

function dataimport(){
	
	var value=$("#file").val();
	if(value==""){
		layer.msg('请选择需要导入的文档',{icon: 5,time:3000});
		return;
	}
	form1.action="jlUserInfoAction_importExcel";
	form1.submit();
}

function changePw(){
	var id=list_iframe.contentWindow.selectOneData();
	layer_show("修改密码","jlUserInfoAction_changePw?id="+id,"400","300");
}
//初始化部门下拉框
function initDep(){
	   $.ajax({
	     type: "POST",
	     url: "${ctx}/department/getDep",
	     async:false,
	     success: function(data1){
	      var str="";
	      var data = $.parseJSON(data1);
	      str="<option value='' >请选择</option>";
	      for(var i=0;i<data.length;i++){
	       str+="<option value='"+data[i].code+"' >"+data[i].name+"</option>";
	      }
	      $("#departmentid").html(str);

	     }
	});
}

</script>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 用户管理<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
<form action="" name="form1" method="post"  id="form1" enctype="multipart/form-data" >
 
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')}'})" id="datemin" name="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" name="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名" id="username" name="username">
		<span class="select-box inline">
			<select class="select" size="1" name="departmentid" id="departmentid" value="" onchange="" datatype="*" nullmsg="请选择所属部门！">
	          <option value="" selected>请选择部门</option>
	        </select>
        </span>
		<button type="button"  class="btn btn-success" onclick="searchInfo();" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	 <span class="l">
<!-- 	 <input type="file" id="file" name="file" style="width:150px;" /> -->
		<span class="btn-upload form-group">
			<input class="input-text upload-url" type="text" name="ad" id="ad" readonly  datatype="*" nullmsg="请添加附件！" style="width:200px">
			<a href="javascript:void();" style="color: white" class="btn btn-primary upload-btn radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
			<input type="file" multiple name="file" class="input-file">
		</span>
	  <a href="javascript:;" style="color: white" onclick="dataimport()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe600;</i>批量导入</a>
	  <a href="javascript:;" style="color: white" onclick="admin_add('添加用户','jlUserInfoAction_toAdd','800','650')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span>
	  <a href="javascript:;" style="color: white" onclick="changePw()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe692;</i>修改密码</a>
	  
	   <span class="r">共有数据：<strong>1111</strong> 条</span>
	</div>
	</form>
		<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">用户名</th>
				<th width="40">性别</th>
				<th width="90">手机</th>
				<th width="150">邮箱</th>
				<th width="">地址</th>
				<th width="130">加入时间</th>
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>1</td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('张三','member-show.html','10001','360','400')">张三</u></td>
				<td>男</td>
				<td>13000000000</td>
				<td>admin@mail.com</td>
				<td class="text-l">北京市 海淀区</td>
				<td>2014-6-11 11:11:42</td>
				<td class="td-status"><span class="label label-success radius">已启用</span></td>
				<td class="td-manage"><a style="text-decoration:none" onClick="member_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','change-password.html','10001','600','270')" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
		</tbody>
	</table>
		</div>
		
<!-- <iframe id="list_iframe" name="list_frame" src="jlUserInfoAction_toiframe" width="100%" height="75%" frameborder="0"></iframe> -->
</div>

</body>
</html>