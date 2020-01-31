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
              m.controller("userinfo",function($scope,$http){
            	  
            	$scope.updateInfo = function(info)
            	{
            		$http.post("updation",info).then(function(resp){
            			if(resp.data==1)
            				{
            				alert("Details changed");
            				}
            			
            		});
            	}
            	$scope.menubar=function(){
            		$http.post("menulist").then(function(resp){
            			$scope.menuData=resp.data;
            		});        
      		    $http.post("fetching").then(function(resp)
      			{
      				$scope.userData=resp.data;
      			     
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
            border-radius: 20px;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
           font-size: 16px;
           margin: 4px 2px;
	cursor: pointer;
	width: 40%;
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
 
}
</style>
</head>
<body ng-app="newshunt">
	<div ng-controller="userinfo"  ng-init="menubar()">
		<div class="sidebar">
  			<a class="active" href="home"><b>NewsHunt</b></a>
 				 <div ng-repeat="y in menuData">
 				 	<a href="{{y.url}}" >{{y.name}}</a>
  				</div>
  		</div>
  <center>
<br> <br>
		<div class="card">			
			<div class="container"><br>
			<form>
				NAME: &nbsp;
				<input type="text" ng-model="userData.name">
				<br><br>
				PASSWORD: &nbsp;
				<input type="text" ng-model="userData.password">
				<br><br>
				EMAIL ID: &nbsp;
				<input type="text" ng-model="userData.email_id" disabled>
				<br><br>
				PHONE NO.: &nbsp;
				<input type="text" ng-model="userData.phno">
				<br><br>
				<div class="wrapper">
				<button class="button" ng-click="updateInfo(userData)">UPDATE</button>
				</div>
			</form>
			</div>
		<br> <br>
	</div>
</center>
</div>
</body>
</html>