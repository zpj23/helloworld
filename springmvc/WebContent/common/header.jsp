<%@ page language="java"  pageEncoding="UTF-8"%>  <!-- errorPage="/error.jsp" -->

<%-- JSTL 标签 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%-- <%@ taglib prefix="mf" uri="/MyFramework-tags"%> --%>
<%-- 绝对路径 --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${ctx}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<style>
<!--
/* input {width:159px} */
-->
</style>
