<html>
	<head>
		<title>Signup</title>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
        <script>
              var m = angular.module("newshunt",[]);
              m.controller("userInfo",function($scope , $http){
            	  
            	$scope.saveInfo = function(){
            		
            		data = {name:$scope.name , email_id:$scope.email_id , password:$scope.password , cpassword:$scope.cpassword ,phno:$scope.phno};
            	    $http.post("saveUserInfo",data).then(function(response){
            	    	if(response.data==1)
            	    	  alert("record inserted");
            	    	else
            	    		 alert("record is already present");
            	    	if(response.data.password!=response.data.cpassword)
            	    		("Incorrect Password");
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
		<table class="table">	
		
		<tr>
		<td>	
		<h1>Create Account</h1>
					<b class="size">Name</b><br>
					<form>
					<input type="text" placeholder="Enter Name" class="input" ng-model="name"/>
					<br><br>
					<b class="size">Email Id</b><br>
					<input type="text" placeholder="Enter Email" class="input" ng-model="email_id"/><br><br>
					<b class="size">Password</b><br><input type="password" placeholder="Enter Password" class="input" ng-model="password"/><br><br>
					<b class="size">Confirm Password</b><br>
					<input type="password" placeholder="Confirm Password" class="input" ng-model="cpassword"/><br><br>
					<b class="size"></b><br>
					<input type="number" placeholder="Enter Phone No." class="input" ng-model="phno"/>
					<br><br>
					<input type="checkbox" checked>I have read & agree to all the <a href="#">terms and Conditions</a></input>
					<br><br><br><br>
					<button type="button" class="button" ng-click="saveInfo()">SIGN UP</button>
                    </form>
				
				<br><br>
				Already have an Account.
				<a href="http://localhost:8085/newshunt/">SIGN IN</a>
				
			</td></tr>
		</table></center></div>
		</body>
</html>
					
	