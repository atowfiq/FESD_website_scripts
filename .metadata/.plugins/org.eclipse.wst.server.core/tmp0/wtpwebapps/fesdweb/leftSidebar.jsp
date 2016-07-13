<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style type="text/css">
    body,html{
		height: 100%;
	}

	/* remove outer padding */
	.main .row{
		padding: 0px;
		margin: 0px;
	}

	/*Remove rounded coners*/

	nav.sidebar.navbar {
		border-radius: 0px;
	}

	nav.sidebar, .main{
		-webkit-transition: margin 200ms ease-out;
	    -moz-transition: margin 200ms ease-out;
	    -o-transition: margin 200ms ease-out;
	    transition: margin 200ms ease-out;
	}

	/* Add gap to nav and right windows.*/
	.main{
		padding: 10px 10px 0 10px;
	}

	/* .....NavBar: Icon only with coloring/layout.....*/

	/*small/medium side display*/
	@media (min-width: 768px) {


		/*Allow main to be next to Nav*/
		.main{
			position: absolute;
			width: calc(100% - 40px); /*keeps 100% minus nav size*/
			margin-left: 40px;
			float: right;
		}

		/*lets nav bar to be showed on mouseover*/
		nav.sidebar:hover + .main{
			margin-left: 200px;
		}

		/*Center Brand*/
		nav.sidebar.navbar.sidebar>.container .navbar-brand, .navbar>.container-fluid .navbar-brand {
			margin-left: 0px;
		}
		/*Center Brand*/
		nav.sidebar .navbar-brand, nav.sidebar .navbar-header{
			text-align: center;
			width: 100%;
			margin-left: 0px;
		}

		/*Center Icons*/
		nav.sidebar a{
			padding-right: 13px;
		}

		/*adds border top to first nav box */
		nav.sidebar .navbar-nav > li:first-child{
			border-top: 1px #e5e5e5 solid;
		}

		/*adds border to bottom nav boxes*/
		nav.sidebar .navbar-nav > li{
			border-bottom: 1px #e5e5e5 solid;
		}

		/* Colors/style dropdown box*/
		nav.sidebar .navbar-nav .open .dropdown-menu {
			position: static;
			float: none;
			width: auto;
			margin-top: 0;
			background-color: transparent;
			border: 0;
			-webkit-box-shadow: none;
			box-shadow: none;
		}

		/*allows nav box to use 100% width*/
		nav.sidebar .navbar-collapse, nav.sidebar .container-fluid{
			padding: 0 0px 0 0px;
		}

		/*colors dropdown box text */
		.navbar-inverse .navbar-nav .open .dropdown-menu>li>a {
			color: #777;
		}

		/*gives sidebar width/height*/
		nav.sidebar{
			width: 200px;
			height: 100%;
			margin-left: -160px;
			float: left;
			z-index: 8000;
			margin-bottom: 0px;
			position: absolute;
			top:120px;
		}

		/*give sidebar 100% width;*/
		nav.sidebar li {
			width: 100%;
		}

		/* Move nav to full on mouse over*/
		nav.sidebar:hover{
			margin-left: 0px;
		}
		/*for hiden things when navbar hidden*/
		.forAnimate{
			opacity: 0;
		}
	}

	/* .....NavBar: Fully showing nav bar..... */

	@media (min-width: 1330px) {

		/*Allow main to be next to Nav*/
		.main{
			width: calc(100% - 200px); /*keeps 100% minus nav size*/
			margin-left: 200px;
		}

		/*Show all nav*/
		nav.sidebar{
			margin-left: 0px;
			float: left;
		}
		/*Show hidden items on nav*/
		nav.sidebar .forAnimate{
			opacity: 1;
		}
		#navigation{
        position: fixed;
    	}
	}
	

	nav.sidebar .navbar-nav .open .dropdown-menu>li>a:hover, nav.sidebar .navbar-nav .open .dropdown-menu>li>a:focus {
		color: #CCC;
		background-color: transparent;
	}

	nav:hover .forAnimate{
		opacity: 1;
	}
	section{
		padding-left: 15px;
	}
	
	.navbar{
		margin-bottom: 0px;
	}
</style>
<script src="">
function htmlbodyHeightUpdate(){
	var height3 = $( window ).height()
	var height1 = $('.nav').height()+50
	height2 = $('.main').height()
	if(height2 > height3){
		$('html').height(Math.max(height1,height3,height2)+10);
		$('body').height(Math.max(height1,height3,height2)+10);
	}
	else
	{
		$('html').height(Math.max(height1,height3,height2));
		$('body').height(Math.max(height1,height3,height2));
	}
	
}
$(document).ready(function () {
	htmlbodyHeightUpdate()
	$( window ).resize(function() {
		htmlbodyHeightUpdate()
	});
	$( window ).scroll(function() {
		height2 = $('.main').height()
			htmlbodyHeightUpdate()
	});
});
</script>



<header style="height:120px;" class="navbar navbar-bright  navbar-inverse" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
       <a style="margin-top:-20px; margin-left:-70px; " class="navbar-brand" href="#">
                    <img style="height:120px;width: 120px;" src="${pageContext.request.contextPath}/logo/f-orbital_logo.png" alt="">
                </a>
      <a style="font-size: 30px;" href="/" class="navbar-brand">f-Electron Database</a>
    </div>
    
    <div style="float: right; padding-top: 20px;">
    <span >
	<a style="padding-left: 10px;"  class="pull-right" href="">
	<img style="height:60px;width: 60px;" src="${pageContext.request.contextPath}/logo/upsala.png" alt="The University of New Mexico">
	</a>
	</span>


    <span >
	<a style="padding-left: 10px;"  class="pull-right" href="">
	<img style="height:60px;width: 160px;" src="${pageContext.request.contextPath}/logo/UNM.png" alt="The University of New Mexico">
	</a>
	</span>


    
    <span>
	<a  style="padding-right: 10px; padding-left: 10px;" class="pull-right" >
	<img style="height:60px;width: 120px;" src="${pageContext.request.contextPath}/logo/logo_nordita.jpg" >
	</a>
	</span>
	
    
            <span>

<a style="background: white; padding-right: 10px; "  class="pull-right" href="http://www.lanl.gov/">
	<img style="height:60px;width: 160px;" src="${pageContext.request.contextPath}/logo/LANL.png" >
	</a>
	</span>
	
	
	<span>
	<a  style="padding-right: 10px;" class="pull-right" >
	<img style="height:60px;width: 120px;" src="${pageContext.request.contextPath}/logo/IMS-logo-color.jpg" >
	</a>
	</span>
    
</div>
    
  </div>
</header>

 <nav class="navbar navbar-inverse sidebar " role="navigation">
    <div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<!-- <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div> -->
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
				<li ><a href="People.jsp">People<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
			
				<li ><a href="Paper.jsp">Paper<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a></li>
				<li ><a href="About.jsp">About<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-exclamation-sign "></span></a></li>
				<li ><a href="Help.jsp">Help<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-cloud "></span></a></li>
				
			<!-- 	<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Settings <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-cog"></span></a>
					<ul class="dropdown-menu forAnimate" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>--> -->
				
			</ul>
		</div>
	</div>
</nav>

