<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
        <script>
              var m = angular.module("newshunt",[]);
              m.controller("userInfo",function($scope , $http ,$window){
            	  
            	$scope.saveInfo = function(){
            		da={email_id:$scope.email_id , password:$scope.password}
            	    $http({
            	    		url:"loginUserInfo",
            	    		method:'POST',
            	    		data:da
            	    		}).then(function(response)
            	    		{
            	    		if(response.data==1)
            	    		{
            	    		
            	    		   $window.location.href= "home";
            	    		}
            	    		else if(response.data==2)
            	    		{
            	    		   $window.location.href= "adminMenu";
            	    		}
            	    	    else
            	    		{
            	    		alert("Incorrect email or password");
            	    		}
            	
            	    	
            	    });	
            	} 	  
              });  
        </script>
		<style>
			.button
			{
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
  }
			.input
			{
			background-color: #D3D3D3;
			border-radius: 15px;
			padding: 10px 20px;
			text-align: center;
			font-size:17;
			}
			.table
			{
			border-style:outset;
			border-radius:12px;
			height:550px;
			width:400px;
			padding: 90px 130px;
			background-color:white;
			}
			body
			{
				background-image:linear-gradient(#ff9380,white);
			}
			.size
			{
				font-size:19;
				
			}
			h1
			{
			
			font-size:35;
			text-align:center;
			text-decoration:underline;
			font-family:serif;
			}
		</style>
	</head>
		<body ng-app="newshunt">
		<div ng-controller="userInfo">
		<center>
		<br><br><br><br><br><br>
		<table  class="table">
		<tr>
		<td>
		
		
			<h1>LOGIN</h1>
				
					<b class="size">Email Id</b><br><input type="email" placeholder="Enter Email" class="input" ng-model="email_id" required/><br><br>
					<b class="size">Password</b><br><input type="password" placeholder="Enter Password" class="input" ng-model="password" required/><br><br><br><br>
					<button name="signIn" class="button" ng-click="saveInfo()"/>Get Started</button>
				
				<br><br>
				Don't Have an Account ? &nbsp;
				<a href="signup">SignUp</a>
				</center>
			</td></tr>
		</table></div>
		</body>
</html>
					