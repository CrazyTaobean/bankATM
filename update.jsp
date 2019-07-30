<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>ATM机后台信息管理系统v1.0</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.js"></script>

    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/media.css">
    <link rel="stylesheet" href="assets/css/social.css">
    
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/minus.png">
    
 
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <!-- 顶栏 -->
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
                   <h1>ATM机后台信息管理系统<span>v1.0</span></h1>
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
                                <a href="http://localhost:8080/Final/changepage/login.jsp"><span class="entypo-user"></span>&#160;&#160; 退出账户</a>
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

    <!-- 侧栏  -->
    <div id="skin-select">
        <div id="logo">
         <h1>ATM机后台信息管理系统<span>v1.0</span></h1>
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
                   


                    
                </div>
            </div>
        </div>
    </div>
    <!-- END OF SIDE MENU -->



    <!--  PAPER WRAP -->
     <div class="wrap-fluid">
        <div class="container-fluid paper-wrap bevel tlbr">





            <!-- CONTENT -->
             <!--TITLE -->
            <div class="row">
                <div id="paper-top">
                    <div class="col-sm-3">
                        <h2 class="tittle-content-header">
                            <span class="entypo-doc-text"></span>
                            <span>首页
                            </span>
                        </h2>

                    </div>

                    <div class="col-sm-7">
                        <div class="devider-vertical visible-lg"></div>
                        <div class="tittle-middle-header">

                            


                        </div>

                    </div>
                    
                </div>
            </div>
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
                <li><a href="#" title="Sample page 1">修改用户</a>
                </li>
                
            </ul>

            <!-- END OF BREADCRUMB -->

            <!--CONTENT-->
            <form action="../update" method="post">
  <div align="center"><font size="6" face="黑体" ><strong>修改用户界面</strong></font>
<table>
<form action="update" method="post">
  	<table width="50%" border="2">
  	<tr>
  <td><font size="4">您需要修改的用户卡号：</font></td>
  <td><input type="text" name="ic"></td>
  </tr>
  
  <tr>
  <td><font size="4">用户卡号：</font></td>
  <td><input type="text" name="icno"></td>
  </tr>
  
  <tr>
  <td><font size="4">用户姓名：</font></td>
  <td><input type="text" name="name"></td>
  </tr>
  
  <tr>
  <td><font size="4">密码：</font></td>
  <td><input type="text" name="pwd"></td>
  </tr>
 
  <tr>
  <td><font size="4">电话号码：</font></td>
  <td><input type="text" name="mobile"></td>
  </tr>
  
  <tr>
  <td><font size="4">身份证号：</font></td>
  <td><input type="text" name="idcard"></td>
  </tr>
  
  <tr>
  <td><font size="4">账户余额：</font></td>
  <td><input type="text" name="balance"></td>
  </tr>
  
  <tr>
  <td colspan="2" align="center"><font size="2">
  <input type="submit" value="提交修改"></font>
  </td>
  </tr>
  </table>
  
 	 </table>
 	 </form>
                <!--  END OF BLOG CONTENT -->

                <!--  BLOG SIDE CONTENT -->
               
                <!--  END OF BLOG SIDE CONTENT -->
            </div>


            <!-- /END OF CONTENT -->



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

   




    <!-- MAIN EFFECT -->
    <script type="text/javascript" src="assets/js/preloader.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/js/app.js"></script>
    <script type="text/javascript" src="assets/js/load.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    <script src="assets/js/flatvideo/jquery.fitvids.js"></script>


    <script>
    // Basic FitVids Test
    $(".blog-list-nest").fitVids();
    // Custom selector and No-Double-Wrapping Prevention Test
    $(".blog-list-nest").fitVids({
        customSelector: "iframe[src^='http://socialcam.com']"
    });
    </script>









</body>

</html>
