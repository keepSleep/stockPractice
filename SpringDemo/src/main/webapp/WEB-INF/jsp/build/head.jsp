<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.mainmenu_tabs a {
    border: 0px solid #f00;
    float: left;
    display: block;
    height: 37px;
    text-decoration: none;
}
</style>

<nav class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="navbar-header">
		<!-- 功能巡覽列按鈕 開始 -->
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar" style="background-color: lightblue">
				<span class="sr-only">Toggle navigation</span>
				<!-- 三條線 開始 -->
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<!-- 三條線 結束 -->
			</button>
	</div>
	<div id="navbar" class="navbar-collapse collapse" >
		<ul class="nav navbar-nav">
			<li class='mainmenu_tabs'><a href='${pageContext.servletContext.contextPath}/index.jsp'>首頁</a></li>
		</ul>
		<ul class="nav navbar-nav">	
			<li class='mainmenu_tabs'><a href='${pageContext.servletContext.contextPath}/table/list'>查詢個股</a></li>
		</ul>
		<ul class="nav navbar-nav">
			<li class='mainmenu_tabs'><a href='${pageContext.servletContext.contextPath}/Calendar/index'>行事曆</a></li>
		</ul>
	</div>
</nav>






