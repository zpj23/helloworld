<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<% 
	String info = (String)request.getAttribute("info");

%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="js/EasyUI/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/EasyUI/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="js/EasyUI/demo/demo.css">
<link rel="stylesheet" type="text/css" href="js/EasyUI/css/style_fxpg.css" />
<link rel="stylesheet" type="text/css" href="js/EasyUI/themes/blue/style.css" />
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/EasyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/EasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/EasyUI/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" charset="utf-8" src="js/ueditor1_4_3-utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor1_4_3-utf8-jsp/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor1_4_3-utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor1_4_3-utf8-jsp/lang/en/en.js"></script>

<style type="text/css">
.pd3{padding: 3px;}

.ge {
  background: url(images/ge.jpg) no-repeat;
  background-position: center;
  width: 2px;
  height: 26px;
  display: inline-block;
  vertical-align: top;
  overflow: hidden;
}
</style>
<title>商品列表信息库</title>
<script type="text/javascript" charset="UTF-8">
var ueditor_beizhu;//备注的框
var add_edit_flag="0";//0为add；1为edit
var info="<%=info%>";
$(function(){
	if(info!=null&&info!=""&&info!="null"){
		resultShow(info);
	}
	  $('#datagrid1').datagrid({
		  url:'goods/findList',
		  queryParams : { 
			  sp_name:$("#sp_name_search").val(),
			  sp_location:$("#sp_location_search").val()
			},
			rowStyler:function(rowIndex,rowData){  
	            return 'height:40px;font-family:微软雅黑;font-size:32px;';  
	        },
	  	toolbar:'#datagrid_toolbar',
		onClickRow : function(rowIndex, rowData){
		},
			columns : [ [ {
				field : 'id',
				checkbox : true,
				width : 130
				
			},
			{	
				field : 'sp_name',
				title : '名称',
				width : 240,
				formatter : function(value, row, index) {
				    value ="<a href=\"\" style=\"color:black;\" onclick=\"edit1('"+row.id+"');return false;\">"+row.sp_name+"</a>";
					return value;
				}
			},
			
			{	
				field : 'sp_location',
				title : '所处位置',
				width : 200
			},
			{	
				field : 'sp_selling_price',
				title : '价格',
				width : 200
			},
			{	
				field : 'sp_serial_number',
				title : '序列号',
				width : 200
			},
			
			{	
				field : 'sp_remark',
				title : '备注',
				width : 200
			},
			{	
				field : 'sp_add_date',
				title : '录入时间',
				width : 200
			}

			] ]
	  });
	  $('#myDialog').dialog({
		  	closed:true,
			modal:true,
			title:'新增',
			border:false
		}); 
	  $('#myDialog_view').dialog({
		  	closed:true,
			modal:true,
			title:'查看',
			border:false
		});
	  $("body").keydown(function() {
          if (event.keyCode == "13") {//keyCode=13是回车键
              $('#subm').click();
          }
      });
	  
	  initField();
	  initUedit("");
	});
	function initUedit(str){
		$("#beizhu_div").html("");
		ueditor_beizhu = new baidu.editor.ui.Editor({
	    	textarea:'sp_remark',					//表单提交的name
	    	name:'sp_remark'
		});
		ueditor_beizhu.render("beizhu_div");
		ueditor_beizhu.addListener("ready", function () {
            // editor准备好之后才可以使用
         	   ueditor_beizhu.setContent(str);
        });
	}
	
	function append(){
		$('#myDialog').dialog({
			modal:true,
			closed:false,
			title:'新增',
			border:false
		}); 
		ueditor_beizhu.setContent("");
		form1.reset();
		add_edit_flag="0";
	}
	// 点击名称调用的编辑方法
	function edit1(sysid){
		
		$("#editid_view").val(sysid);
		getLookData();
		$('#myDialog_view').dialog({
			modal:true,
			closed:false,
			title:'查看',
			border:false
		}); 
		add_edit_flag="2";
		
	}
	//点击修改按钮
	function edit(){
		var row =$('#datagrid1').datagrid("getSelected");
		if(row!=null){
			$("#editid").val(row.id);
			getEditData();
			$('#myDialog').dialog({
				modal:true,
				closed:false,
				title:'编辑',
				border:false
			}); 
			add_edit_flag="1";
			
		}else{
			alert("请选择编辑项");
		}
		
	}
	//  点击名称查看
	function getLookData(){
		$.ajax({
			   type: "POST",
			   url: "spAction?flag=findByPK",
			   dataType:"json",	   
			   data: "id="+$("#editid_view").val(),
			   success: function(rowData){
				   $("#editid_view").val(rowData.id);
				   $.each(rowData,function(k,v){
						   
						$("#"+k+"_view").html(v);
					});
			   }
			});
	}
	//点击修改
	function getEditData(){
		$.ajax({
			   type: "POST",
			   url: "spAction?flag=findByPK",
			   dataType:"json",	   
			   data: "id="+$("#editid").val(),
			   success: function(rowData){
				   form1.reset();
				   $("#editid").val(rowData.id);
				   $.each(rowData,function(k,v){
							$('#'+k).val(v);
							if("sp_remark"==k){
								ueditor_beizhu.setContent(v);
							}
					});
				   $("#form1").form('validate');
			   }
			});
	}
	function saveData(){
		if(add_edit_flag=="0"){
			var actionUrl="spAction?flag=add";
			execute(actionUrl);
		}else if(add_edit_flag=="1"){
			var actionUrl="spAction?flag=update";
			execute(actionUrl);
		}else if(add_edit_flag=="2"){
			back();
		}
		
	}
	function execute(actionUrl){
		if($("#form1").form('validate')){
			subFrom(actionUrl);
		}
	}
	function subFrom(actionUrl){
		 $("#form1").form("submit",
				 {
			 		url: actionUrl,
			 		data:$('#form1').serialize(),
			 		success:function (data) {
			 			$('#datagrid1').datagrid("reload");
			 			resultShow(data);
			 			back();
			 		}
				 }
		 
		 );

	}
	function back(){
		$('#myDialog').dialog("close"); 
	}
	function removedOne(){
		var row =$('#datagrid1').datagrid("getSelected");
		if(row!=null){
			
			$.messager.confirm('系统提示','您确定删除吗?',function(r){
				if (r){
					$("#removeid").val(row.id);
					var actionUrl="spAction?flag=del";
					//subFrom(actionUrl);
					$.ajax({
						 type: "POST",
						   url: actionUrl,
						   dataType:"json",	   
						   data: "removeid="+$("#removeid").val(),
						   success: function(data){
							   $('#datagrid1').datagrid("reload");
							   resultShow(data.info);
						   }
					});
				}
			});
		}else{
			alert("请选择删除项");
		}
	}
	function resultShow(str){
		$.messager.show({
			title:'系统提示',
			msg:str
		});
	}
	//带条件查询具体信息
	function searchInfo(){
		$('#datagrid1').datagrid("load", { 
			  sp_name:$("#sp_name_search").val(),
			  sp_location:$("#sp_location_search").val()
			});
	}
	//提交时验证数据信息
	function initField(){
		$("#sp_name").validatebox({   
		     required:true,
		     validType:'length[1,500]'
		  }); 
		$("#sp_location").validatebox({   
		     required:true,
		     validType:'length[1,500]'
		  }); 
		  
		  $("#sp_purchase_price").validatebox({   
			     required:true,
			     validType:'length[1,100]'
			  });  
		  $("#sp_selling_price").validatebox({   
			     required:true,
			     validType:'length[1,100]'
			  });  
		  
	}
	//查看明文
	function mw(){
		if($("#password").attr("type")=="text"){
			$("#password").attr("type","password");
			$("#mm").html("解密");
		}else{
			$("#password").attr("type","text");
			$("#mm").html("加密");
		}
	}
</script>
</head>
<body >

<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',split:false,border:false">
			<div class="panel pd3" style="background-color: #E6EEF8;">
				<div class="panel-header">
					<a class="easyui-linkbutton" iconCls="icon-add" onClick="append();"
						plain="true" href="javascript:void(0);">增加</a><span class="ge"></span> <a class="easyui-linkbutton" iconCls="icon-edit" onClick="edit();"
						plain="true" href="javascript:void(0);">编辑</a> 
						<a class="easyui-linkbutton" iconCls="icon-remove"
						onClick="removedOne();" plain="true" href="javascript:void(0);">删除</a>
				</div>
			</div>
		</div>
	<div data-options="region:'center',border:false"
			style="padding-top: 0px; background-color: #E6EEF8;" class="pd3">
		<table width="100%"  id="datagrid1" fit="true" fitColumns="true"  pageList="[10,20,30]"  
			total="${pageInfo.totalResult}" pageNumber="${pageInfo.nowPage}" 
			 pageSize="${pageInfo.pageSize}" idField="id" border="true" rownumbers="false" singleSelect="true" pagination="true"
			 >
		
		
	</table>
	
	<div id="datagrid_toolbar" style="width: 100%">
				<div data-options="region:'center',border:false"
					 class="pd3">
						<div class="wu-toolbar-search">
						
						<label>名称：</label><input
							name="sp_name_search" id="sp_name_search" type="text"
							class="wu-obj-border" style="height: 20px;" /> 
						<label>所处位置：</label><input name="sp_location_search" id="sp_location_search"
							type="text" class="wu-obj-border" style="height: 20px;" /> 	
							 <a id="subm"
							href="javascript:;" class="easyui-linkbutton"
							iconCls="icon-search" onclick="searchInfo();">开始检索</a>
					</div>
					
				</div>
			</div>
	<div id="myDialog_view" title=" " style="width:600px;height: auto;" >
	<div   class="TableBlock" style="width: 100%;height100%; border: 0px;">
		<form id="form1_view" name="form1_view" class="form" method="post" >
			<input type="hidden" id="removeid_view" name="removeid_view"/>
			<input type="hidden" id="editid_view" name="editid_view"/>
			<table class="tableForm" style="width: 100%;height: 100%;">
				<tr>

					<th  class="TableData td_left" style="width: 20%;">名称：</th>
					<td class="TableData td_right"><label class="easyui-validatebox" name="sp_name_view" 
						id="sp_name_view"  style="width: 80%; height: 21px;" ></label></td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">所处位置：</th>
					<td class="TableData td_right"><label class="easyui-validatebox" name="sp_location_view" 
						id="sp_location_view"  style="width: 80%; height: 21px;" ></label></td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">价格：</th>
					<td class="TableData td_right"><label class="easyui-validatebox" name="sp_selling_price_view" 
						id="sp_selling_price_view"  style="width: 80%; height: 21px;" ></label></td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">备注：</th>
					<td class="TableData td_right">
					<label  id="sp_remark_view" name="sp_remark_view" style="width: 80%" cols="38" rows="7" class="easyui-validatebox validatebox-text"></label>
					
				</tr>
				
<!-- 				<tr> -->
<!-- 					<td colspan="2" style="text-align: center;"> -->
<!-- 										 <a href="javascript:void(0);" class="easyui-linkbutton" -->
<!-- 						iconCls="icon-save" onclick="saveData();">确定</a> <a -->
<!-- 						href="javascript:void(0);" class="easyui-linkbutton" -->
<!-- 						iconCls="icon-cancel" onclick="back();">取消</a> -->
<!-- 					</td> -->
<!-- 				</tr> -->
			</table>
			
		</form>
	</div>
	</div>
	</div>
	<div id="myDialog" title=" " style="width:1200px;height: auto;" >
	<div   class="TableBlock" style="width: 100%;height100%; border: 0px;">
		<form id="form1" name="form1" class="form" method="post" >
			<input type="hidden" id="removeid" name="removeid"/>
			<input type="hidden" id="editid" name="editid"/>
			<table class="tableForm" style="width: 100%;height: 100%;">
				<tr>

					<th  class="TableData td_left" style="width: 20%;">名称：</th>
					<td class="TableData td_right"><input class="easyui-validatebox" name="sp_name" 
						id="sp_name"  style="width: 80%; height: 21px;" ></input></td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">所处位置：</th>
					<td class="TableData td_right">
<!-- 					<input class="easyui-validatebox" name="sp_location"  -->
<!-- 						id="sp_location"  style="width: 80%; height: 21px;" ></input> -->
						<textarea  id="sp_location" name="sp_location" style="width: 80%" cols="38" rows="7" class="easyui-validatebox validatebox-text"></textarea>
						</td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">进价：</th>
					<td class="TableData td_right"><input class="easyui-validatebox" name="sp_purchase_price" 
						id="sp_purchase_price" type="text" style="width: 80%; height: 21px;" ></input>
<!-- 						<a href="javascript:;" class="easyui-linkbutton" -->
<!-- 						iconCls="icon-help"  onclick="mw();"><span id="mm" >详情</span></a> -->
						</td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">卖价：</th>
					<td class="TableData td_right"><input class="easyui-validatebox" name="sp_selling_price" 
						id="sp_selling_price"  style="width: 80%; height: 21px;" ></input></td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">序列号：</th>
					<td class="TableData td_right"><input class="easyui-validatebox" name="sp_serial_number" 
						id="sp_serial_number"  style="width: 80%; height: 21px;" ></input></td>
					
				</tr>
				<tr>

					<th  class="TableData td_left" style="width: 20%;">备注：</th>
					<td class="TableData td_right">
<!-- 					<textarea  id="sp_remark" name="sp_remark" style="width: 80%" cols="38" rows="7" class="easyui-validatebox validatebox-text"></textarea> -->
					<div id="beizhu_div" style="width: 80%; height: 200px;"></div>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align: center;">
										 <a href="javascript:void(0);" class="easyui-linkbutton"
						iconCls="icon-save" onclick="saveData();">确定</a> <a
						href="javascript:void(0);" class="easyui-linkbutton"
						iconCls="icon-cancel" onclick="back();">取消</a>
					</td>
				</tr>
			</table>
			
		</form>
	</div>
	</div>
	</div>
</div>	

</div>	
</body>
</html>