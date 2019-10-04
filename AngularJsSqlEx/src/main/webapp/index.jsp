<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>AngularJS</title>
      
      <!-- Javascript Files -->      
      <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
      <script type="text/javascript" src="resource/js/form.js"></script>    
           
      <!-- Bootstrap Css -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      
      <style type="text/css">
      	.marginTop14 {
      		margin-top: 14px;
      	}
      </style>
   </head>
   <body>
      <h2 align="center" class="text-primary">AngularJS Sql Example</h2>
      <div ng-app="myApp">
         <form ng-controller="EmployeeController" ng-submit="getData()">
            <p>
               <button id="formBtn" type="submit" class="btn btn-primary center-block marginTop14">Get Data from Db</button>
            </p>
           	<div id="empTblContainer" class="container" ng-show="empList.length">
           		<table id="empTbl" class="table table-bordered marginTop14">
              		<thead>
                 		<tr>
                    		<th>Id</th><th>Name</th><th>Email</th><th>Gender</th>
                 		</tr>
              		</thead>
              		<tbody>
                 		<tr ng-repeat="detail in empList">
                    		<td><span id="emp-id">{{detail.map.emp_id}}</span></td><td><span id="emp-name">{{detail.map.emp_name}}</span></td><td><span id="emp-email">{{detail.map.emp_email}}</span></td><td><span id="emp-gender">{{detail.map.emp_gender}}</span></td>
                 		</tr>
              		</tbody>
           		</table>
           	</div>    
           	<div id="errorTxt" ng-show="noEmpRecord.length" class="text-center text-danger marginTop14"><h5>No record found in the database!</h5></div>
         </form>
      </div>
   </body>
</html>