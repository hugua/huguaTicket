<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/buy.js"></script>
</head>
<body>
<div class="header">
		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.do">主页</a></li>
					</ul>
				</div>
					<div class="account_desc">
						<ul>

							<li><a href="#">个人信息</a></li>
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
	  	</div>
  	  		<div class="wrap">
				<div class="header_top">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt="" /></a>
					</div>
						<div class="header_top_right">

							  <div class="search_box">
					     		<form>
					     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
					     		</form>
					     	</div>
						 <div class="clear"></div>
					</div>
						  <script type="text/javascript">
								function DropDown(el) {
									this.dd = el;
									this.initEvents();
								}
								DropDown.prototype = {
									initEvents : function() {
										var obj = this;
					
										obj.dd.on('click', function(event){
											$(this).toggleClass('active');
											event.stopPropagation();
										});	
									}
								}
					
								$(function() {
					
									var dd = new DropDown( $('#dd') );
					
									$(document).click(function() {
										// all dropdowns
										$('.wrapper-dropdown-2').removeClass('active');
									});
					
								});
					    </script>
			   <div class="clear"></div>
  		    </div>     				
   		</div>
   </div>
   <div class="main">
   	 <div class="wrap">
   	 	<div class="content_top">
    		<div class="clear"></div>
    	</div>
   	 	<div class="section group">
				<div class="cont-desc span_1_of_2">
				  <div class="product-details">				
					<div class="grid images_3_of_2">
						<img src="images/preview.jpg" alt="" />
				  </div>
				<div class="desc span_3_of_2">
					<h2 class="filmname">${film.name}</h2>
					<p>${film.desc}</p>					
					<div class="price">
						<p>Price: <span>50元</span></p>
					</div>
					<div class="available">
						<ul>
						  <li><span>导演:</span> &nbsp; 	Andy Cheng</li>
						  <li><span>主演:</span> &nbsp; 	小古巴·戈丁 Cuba Gooding Jr.<br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;詹姆斯·伍兹 James Woods<br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;安吉·哈蒙 Angie Harmon<br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;彼得·凯奥特 Peter Coyote<br></li>
						  <li><span>剩余票数:</span>&nbsp; <span class="number" style="font-size:30px">${film.number}</span></li>
						  <input type="text" style="display: none" value="${film.id }" class="id">
					    </ul>
					</div>
				<div class="share-desc">
					<div class="button"><span><a class="buy" onClick="buy()">立即抢购</a></span></div>					
					<div class="clear"></div>
				</div>

			</div>
			<div class="clear"></div>
		  </div>
   </div>
			
        </div>
   <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>

</body>
</html>

