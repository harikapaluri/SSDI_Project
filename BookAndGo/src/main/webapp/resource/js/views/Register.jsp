<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Register</title>
      
      <!-- Javascript Files -->      
      <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
      <script type="text/javascript" src="resource/js/controller/form.js"></script>    
      <script type="text/javascript" src="resource/js/angular-route.js"></script>
      <script src="resource/js/controller/Login.js"></script>
      
      <!-- Bootstrap Css -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      
      <style type="text/css">
  		background-color: lightblue;
      	.marginTop14 {
      		margin-top: 14px;
      	}
      </style>
</head>
<body>

 	<h2 align="center" class="text-primary">Book And Go</h2>
 
     <form method="post" ng-submit="onSubmit()">
     
     <div class="form-group">
       <label>Username:</label>
     	<input type="radio" name="userType" value="Customer" ng-model="type" class="form-control"> Customer<br>
		<input type="radio" name="userType" value="hotelManager" ng-model="type" class="form-control"> Hotel Manager
      </div>
     
      <div class="form-group">
       <label>Username:</label>
       <input type="text" name="username" ng-model="username" class="form-control" ng-minlength="4" ng-maxlength="10"/>
        <p ng-show="userForm.username.$error.minlength" class="help-block">Username is too short.</p>
  		<p ng-show="userForm.username.$error.maxlength" class="help-block">Username is too long.</p>
      </div>
      
      <div class="form-group">
       <label>Email address:</label>
       <input type="email" name="email" ng-model="email" class="form-control" />
       <p ng-show="userForm.email.$invalid && !userForm.email.$pristine" class="help-block">Enter a valid email.</p>
      </div>
      
      <div class="form-group">
       <label>Enter password:</label>
       <input type="password" name="password" ng-model="password" class="form-control" />
      </div>
      
      <div class="form-group">
       <label>Re-enter password:</label>
       <input type="password" name="repeat-password" ng-model="re-password" class="form-control" />
      </div>
      <div class="form-group" align="center">
       <input type="submit" name="submit" class="btn btn-primary" value="save" ng-click="showSaved()"/>
       <button class="btn btn-primary btn-link"  type="reset" ng-click="reset()">Clear</button>
      </div>
     </form>

</body>
</html>