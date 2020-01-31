
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
            		$http.post("menulist").then(function(response){
            			$scope.menuData=response.data;
            		});
            	}
            	$http({
    				url:"news",
      			method:"post",
       			}).then(function(res){
   					$scope.news = res.data;
   				});
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
</style>
</head>
<body ng-app="newshunt" >
<div ng-controller="menuInfo" ng-init="menuData()">
<div class="left"></div>
<div class="sidebar">
  <a class="active" href="home"><b>NewsHunt</b></a>
  <div ng-repeat="y in menuData">
  <a href="{{y.url}}" >{{y.name}}</a>
  </div>
  </div><br><br>
  <center>
  <div ng-repeat="x in news">
  <div class="card"  >	
			
			<div class="container"><br>
				<h2>
					<b>{{x.title}}</b><br><br>
					<font size="3"><a href="{{y.link}}" >{{x.link}}</font></a><br>
					<p>{{x.date}}</p><br>
					
				</h2><br><br>
			</div>
		</div>
		<br> <br>
	</div>
	</center>  
</body>
</html>
