<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>IMUT_BANK ATM WelCome!!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>

    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">

    <link href="assets/css/icons-style.css" rel="stylesheet">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/minus.png">
<!--     <style type="text/css">
		a{
			color: blue;
		}
		a: hover {
			color: Red;
		}
	</style> -->
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <!-- TOP NAVBAR -->
    <nav role="navigation" class="navbar navbar-static-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="entypo-menu"></span>
                </button>
                <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
                    <span class="entypo-list-add"></span>
                </button>




                <div id="logo-mobile" class="visible-xs">
                   <h1>IMUT ATM<span>v2.2.7</span></h1>
                </div>

            </div>


            <!-- Collect the nav links, forms, and other content for toggling -->
            <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">

                    <li class="dropdown">

                       
                        <ul style="margin: 11px 0 0 9px;" role="menu" class="dropdown-menu dropdown-wrap">
                            
                          
                        </ul>
                    </li>
                    
                    <li><a href="#"><i data-toggle="tooltip" data-placement="bottom" title="Help" style="font-size:20px;" class="icon-help tooltitle"></i></a>
                    </li>

                </ul>
                <div id="nt-title-container" class="navbar-left running-text visible-lg">
                    

                    <ul id="digital-clock" class="digital">
                        <div id="time">
    <script>
        document.getElementById('time').innerHTML = new Date().toLocaleString()
                + ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
        setInterval(
                "document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
                1000);
    </script>
</div>
                    </ul>
                    <ul id="nt-title">
                        <li><i class="wi-day-lightning"></i>&#160;&#160;北京&#160;
                            <b>24°</b><i class="wi-Celsius"></i>&#160;; 
                        </li>
                        <li><i class="wi-day-lightning"></i>&#160;&#160;上海&#160;
                            <b>28°</b><i class="wi-Celsius"></i>&#160;;
                        </li>

                        <li><i class="wi-day-lightning"></i>&#160;&#160;内蒙古&#160;
                            <b>26°</b><i class="wi-Celsius"></i>&#160;;
                        </li>

                        <li><i class="wi-day-lightning"></i>&#160;&#160;海南&#160;
                            <b>31°</b><i class="wi-Celsius"></i>&#160;; 
                        </li>

                        <li><i class="wi-day-lightning"></i>&#160;&#160;四川&#160;
                            <b>29°</b><i class="wi-Celsius"></i>&#160;; 
                        </li>

                    </ul>
                </div>

                <ul style="margin-right:0;" class="nav navbar-nav navbar-right">
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" class="admin-pic img-circle" src="http://api.randomuser.me/portraits/thumb/men/10.jpg">欢迎您 <b class="caret"></b>
                        </a>
                        <ul style="margin-top:14px;" role="menu" class="dropdown-setting dropdown-menu">
                            <li>
                                <a href="#">
                                    <span class="entypo-user"></span>&#160;&#160;我的账户</a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="entypo-vcard"></span>&#160;&#160;账户设置</a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="entypo-lifebuoy"></span>&#160;&#160;帮助</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="/Final/changepage/login.jsp">
                                    <span class="entypo-user"></span>&#160;&#160; 退出账户</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="icon-gear"></span>&#160;&#160;背景颜色</a>
                        <ul role="menu" class="dropdown-setting dropdown-menu">

                            <li class="theme-bg">
                                <div id="button-bg"></div>
                                <div id="button-bg2"></div>
                                <div id="button-bg3"></div>
                                <div id="button-bg5"></div>
                                <div id="button-bg6"></div>
                                <div id="button-bg7"></div>
                                <div id="button-bg8"></div>
                                <div id="button-bg9"></div>
                                <div id="button-bg10"></div>
                                <div id="button-bg11"></div>
                                <div id="button-bg12"></div>
                                <div id="button-bg13"></div>
                            </li>
                        </ul>
                    </li>
                    
                </ul>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- /END OF TOP NAVBAR -->

    <!-- SIDE MENU -->
    <div id="skin-select">
        <div id="logo">
            <h1>IMUT ATM<span>v2.2.7</span></h1>
            </h1>
        </div>

        <a id="toggle">
            <span class="entypo-menu"></span>
        </a>
        <div class="dark">
            <form action="#">
                <span>
                    <input type="text" name="search" value="" class="search rounded id_search" placeholder="Search Menu..." autofocus="">
                </span>
            </form>
        </div>

        <div class="search-hover">
            <form id="demo-2">
                <input type="search" placeholder="Search Menu..." class="id_search">
            </form>
        </div>


        <div class="search-hover">
            <form id="demo-2">
                <input type="search" placeholder="Search Menu..." class="id_search">
            </form>
        </div>




        <div class="skin-part">
            <div id="tree-wrap">
                <div class="side-bar">
                    <ul class="topnav menu-left-nest">
                        

                        
                        
                        
                    </ul>

                    <ul class="topnav menu-left-nest">
                        

                        
                        

                       
<li>
                                    <a class="tooltip-tip2 ajax-load" href="/Final/changepage/UserIndex.jsp" title="Profile Page">
                                    <i class="icon-user"></i><span>用户信息</span></a>
                                </li>

                        

                        <li>
                            <a class="tooltip-tip" href="/Final/changepage/UserChangePwd.jsp" title="Extra Pages">
                                <i class="icon-lock"></i>
                                <span>修改密码</span>
                            </a>
                          
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="/Final/UserSerch?${QueryBalance}" title="Blank Page">
                                    <i class="icon-media-record"></i><span>查询余额</span></a>
                                </li>
                                
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="/Final/changepage/UserStore.jsp" title="Invoice">
                                    <i class="entypo-newspaper"></i><span>存款</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="/Final/changepage/UserFetch.jsp" title="Pricing Table">
                                    <i class="fontawesome-money"></i><span>取款</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="/Final/changepage/UserTransfer.jsp" title="Time Line">
                                    <i class="entypo-clock"></i><span>转账</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2" href="/Final/serchDetaile" title="404 Error Page">
                                    <i class="icon-preview"></i><span>交易明细</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2" href="/Final/changepage/login.jsp" title="login.jsp">
                                    <i class="icon-mail"></i><span>退卡</span></a>
                                </li>
                                
                         
                     

                        

                    </ul>

                    


                    
                </div>
            </div>
        </div>
    </div>
    <!-- END OF SIDE MENU -->



    <!--  PAPER WRAP -->
    <div class="wrap-fluid">
        <div class="container-fluid paper-wrap bevel tlbr">


            <!--/ TITLE -->

            <!-- BREADCRUMB -->
            <ul id="breadcrumb">
                <li>
                    <span class="entypo-home"></span>
                </li>
                <li><i class="fa fa-lg fa-angle-right"></i>
                </li>
                <li><a href="#" title="Sample page 1">首页</a>
                </li>
                <li><i class="fa fa-lg fa-angle-right"></i>
                </li>
                <li><a href="#" title="Sample page 1">交易明细</a>
                </li>
                
            </ul>

            <!-- END OF BREADCRUMB -->

            <div class="content-wrap">
                <div class="row">


                    <div class="col-sm-12">
                        <!-- BLANK PAGE-->

                        <h2 align="center"><b>IMUT BANK借记卡明细对账单</b></h2>
							<%
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
								request.setAttribute("date_time", df.format(new Date()));
							%>
							<h4 align="center">打印日期:${date_time }</h4>
                            <div class="body-nest" id="Blank_Page_Content">
									<div class="form_center">

                                    
                                    
               	</table> <table width="90%" border='2'>
		<tr align="center">
		<br><br>
			<th><font size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<th><font size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<th><font size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;货&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;币&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<th><font size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交&nbsp;&nbsp;易&nbsp;&nbsp;金&nbsp;&nbsp;额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<th><font size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;户&nbsp;&nbsp;余&nbsp;&nbsp;额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
		</tr>
		<c:forEach items="${RunMessage }" var="user">
			<tr>
				<td>${user.ICno }</td>
				<td>${user.RM_date }</td>
				<td>${user.RM_Currency }</td>
				<td>${user.RM_Balance }</td>
				<td>${user.RM_Rest }</td>
			</tr>
		</c:forEach>
	</table>                
         
                                </div>
                                
                                
                                
                                
                                
                            </div>
                        </div>
                    </div>
                    <!-- END OF BLANK PAGE -->


                </div>
<%-- ${requestScope.pageBean.pageNum == 1} --%>
<!-- <input hidden="true" name="pageNum" value="1"/> -->
<%-- <c:if test="${pageBean.pageNum==0}">
	${pageContext.request.contextPath}/serchDetaile?pageNum=1
</c:if> --%>
<div align="center">
<br/>
<br/>
<br/>
<!-- ---------------------------------------------------------------------------------------------------------- -->
<%-- 构建分页导航 --%>
            <p style="font-size:20px; color:gray">共有${pageBean.totalRecord}条数据，共${pageBean.totalPage}页，当前为${pageBean.pageNum}页</p>
            <br/>
            <div style="font-size: 17px; color: black">
            <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=1" style="font-color: green">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${pageBean.pageNum ==1}">
                <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${pageBean.pageNum+1}">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${pageBean.pageNum > 1 && pageBean.pageNum < pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">    
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${pageBean.pageNum+1}">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${pageBean.pageNum == pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${i}">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="${pageContext.request.contextPath}/serchDetaile?pageNum=${pageBean.totalPage}">尾页</a>
		</div>
                <!-- /END OF CONTENT -->
	<!-- ---------------------------------------------------------------------------------------------------------------- -->
</div>

                <!-- FOOTER -->
                <div class="footer-space"></div>
                <div id="footer">
                <div class="devider-footer-left"></div>
                <div class="time">
                    <p id="spanDate">
                    <p id="clock">
                </div>
                <div class="copyright">本网站基于百度查询开发 <a href="http://www.baidu.com/" title="百度" target="_blank">百度</a> All Rights Reserved</div>
                <div class="devider-footer"></div>

            </div>
                <!-- / END OF FOOTER -->


            </div>
        </div>
        <!--  END OF PAPER WRAP -->

        <!-- RIGHT SLIDER CONTENT -->
        <div class="sb-slidebar sb-right">
            <div class="right-wrapper">
                <div class="row">
                    <h3>
                        <span><i class="entypo-gauge"></i>&nbsp;&nbsp;MAIN WIDGET</span>
                    </h3>
                    <div class="col-sm-12">

                        <div class="widget-knob">
                            <span class="chart" style="position:relative" data-percent="86">
                                <span class="percent"></span>
                            </span>
                        </div>
                        <div class="widget-def">
                            <b>Distance traveled</b>
                            <br>
                            <i>86% to the check point</i>
                        </div>

                        <div class="widget-knob">
                            <span class="speed-car" style="position:relative" data-percent="60">
                                <span class="percent2"></span>
                            </span>
                        </div>
                        <div class="widget-def">
                            <b>The average speed</b>
                            <br>
                            <i>30KM/h avarage speed</i>
                        </div>


                        <div class="widget-knob">
                            <span class="overall" style="position:relative" data-percent="25">
                                <span class="percent3"></span>
                            </span>
                        </div>
                        <div class="widget-def">
                            <b>Overall result</b>
                            <br>
                            <i>30KM/h avarage Result</i>
                        </div>
                    </div>
                </div>
            </div>

            <div style="margin-top:0;" class="right-wrapper">
                <div class="row">
                    <h3>
                        <span><i class="entypo-chat"></i>&nbsp;&nbsp;CHAT</span>
                    </h3>
                    <div class="col-sm-12">
                        <span class="label label-warning label-chat">Online</span>
                        <ul class="chat">
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-circle" src="http://api.randomuser.me/portraits/thumb/men/20.jpg">
                                    </span><b>Dave Junior</b>
                                    <br><i>Last seen : 08:00 PM</i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-circle" src="http://api.randomuser.me/portraits/thumb/men/21.jpg">
                                    </span><b>Kenneth Lucas</b>
                                    <br><i>Last seen : 07:21 PM</i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-circle" src="http://api.randomuser.me/portraits/thumb/men/22.jpg">
                                    </span><b>Heidi Perez</b>
                                    <br><i>Last seen : 05:43 PM</i>
                                </a>
                            </li>


                        </ul>

                        <span class="label label-chat">Offline</span>
                        <ul class="chat">
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-offline img-circle" src="http://api.randomuser.me/portraits/thumb/men/23.jpg">
                                    </span><b>Dave Junior</b>
                                    <br><i>Last seen : 08:00 PM</i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-offline img-circle" src="http://api.randomuser.me/portraits/thumb/women/24.jpg">
                                    </span><b>Kenneth Lucas</b>
                                    <br><i>Last seen : 07:21 PM</i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-offline img-circle" src="http://api.randomuser.me/portraits/thumb/men/25.jpg">
                                    </span><b>Heidi Perez</b>
                                    <br><i>Last seen : 05:43 PM</i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-offline img-circle" src="http://api.randomuser.me/portraits/thumb/women/25.jpg">
                                    </span><b>Kenneth Lucas</b>
                                    <br><i>Last seen : 07:21 PM</i>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>
                                        <img alt="" class="img-chat img-offline img-circle" src="http://api.randomuser.me/portraits/thumb/men/26.jpg">
                                    </span><b>Heidi Perez</b>
                                    <br><i>Last seen : 05:43 PM</i>
                                </a>
                            </li>


                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- END OF RIGHT SLIDER CONTENT-->


        <!-- MAIN EFFECT -->
        <script type="text/javascript" src="assets/js/preloader.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.js"></script>
        <script type="text/javascript" src="assets/js/app.js"></script>
        <script type="text/javascript" src="assets/js/load.js"></script>
        <script type="text/javascript" src="assets/js/main.js"></script>


</div></body>

</html>
