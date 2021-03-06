<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
        <script>
              var m = angular.module("newshunt",[]);
              m.controller("menuInfo",function($scope , $http){
            	  
            	$scope.menuData = function()
            	{
            		$http.post("amenu").then(function(response){
            			$scope.menuData=response.data;
            		});
            		$http.post("userlistcount").then(function(response){
            			$scope.adminmenuData=response.data;
            		});
            		$http.post("channellistcount").then(function(response){
            			$scope.channelcount=response.data;
            		});
            		$http.post("subchannellistcount").then(function(response){
            			$scope.subchannelcount=response.data;
            		});
            		
            	}
              });
              </script>
<style>

		.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	border-radius: 5px;
	background: #f1f1f1;
	height: 300px;
	width: 700px;
	text-align: center;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

img {
	border-radius: 5px 5px 0 0;
	height: 175px;
	width: 150px;
	float: left;
	margin: 10px;
}

.container {
	padding: 2px 16px;
}

.button {
	background-color: #f44336;
	color:white;
            padding: 10px 15px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
	top: 50%;
}

.wrapper {
	text-align: center;
}

body
{
				background-image:linear-gradient(#ff9380,white);
				margin: 0;
  				font-family: "Lato", sans-serif;
}
	.sidebar {
 					 margin: 0;
  padding: 0;
  width: 300px;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

.sidebar a {
  display: block;
  color: black;
  padding: 16px;
  text-decoration: none;
}
 
.sidebar a.active {
 
  color: Black;
  background-color: grey;
  
}

.sidebar a:hover:not(.active) {
  background-color: tomato;
  color: white;
}

div.content {
  margin-left: 200px;
  padding: 10px 160px;
  height: 1200px;
}

@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}

@media screen and (max-width: 400px) {
  .sidebar a {
    text-align: center;
    float: none;
  }
.left
{
left:200px;
background-color:white;} 
}
.input
		{
			background-color: #D3D3D3;
			border-radius: 15px;
			padding: 10px 20px;
			font-size:17;
		}
		.table
		{
			border-style:groove;
			border-radius:12px;
			height:650px;
			width:550px;
			padding: 90px 130px;
			margin: 0px ;
			vertical-align: top;
			background-color:white;
		}
			
		.size
			{
				font-size:19;
				
			}
		body
		{
		background-image:linear-gradient(#ff9380,white);
		background-repeat:no-repeat;
			}
		h1
			{
			
			font-size:35;
			text-align:center;
			text-decoration:underline;
			font-family:serif;
			}
			table, th , td 
            {
                border: 2px solid grey;
                border-collapse: collapse;
                padding: 5px;
                background-color:#f1f1f1;
            }
</style>
</head>
<body ng-app="newshunt" >
<div ng-controller="menuInfo" ng-init="menuData()">
<div class="sidebar">
  <a class="active" href="home"><b>NewsHunt</b></a>
  <div ng-repeat="x in menuData">
  <a href="{{x.url}}" >{{x.menuname}}</a>
  </div></div>
 <br><br>
  <center>	
			
			<table>
			<tr>
					<td><b>Total No of users</td><td>{{adminmenuData}}</td><br></b></tr>
			<tr>
					<td><b>Total No of Channels</td><td>{{channelcount}}</td><br></b><br></tr>
		     <tr>
					<td><b>Total No of Suscribed Channels</td><td>{{subchannelcount}}</td><br></b><br></tr>
			<tr>
					<td><b>Total No of UnsubscribedChannels</td><td>{{channelcount-subchannelcount}}</td><br></b><br></tr>
		</table><br> <br>
		</center> 
	</div>
	 
</body>
</html>
