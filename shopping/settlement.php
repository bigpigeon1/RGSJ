 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
session_start();
$name=$_SESSION['name'];

class chkinput{

   var $name;
	
   function chkinput($y){

	 $this->name=$y;
    }

   function checkinput(){
     include("conn.php");
	 $sql=mysqli_query($conn,"select * from bask where name = '".$this->name."'");
	 while($info=mysqli_fetch_array($sql)){
		 if($info['isselect']==1){
			mysqli_query($conn,"delete from bask where name = '".$this->name."' and tid = '{$info['tid']}'");
			$sql1=mysqli_query($conn,"select * from item where tid='{$info['tid']}'");
     		$info1=mysqli_fetch_array($sql1);
	
			mysqli_query($conn,"INSERT INTO records (username, itemname, stime, price, attribute, shopname) VALUES('{$info['name']}','{$info1['name']}','{$info1['stime']}','{$info1['price']}','{$info1['attribute']}','{$info1['shopname']}')");	
			
			mysqli_query($conn,"DELETE FROM item WHERE tid='{$info['tid']}'");
		 }
	 }

     header("location:buybask.php");
     exit;

      }    
   }
  $obj=new chkinput(trim($name));
    $obj->checkinput();
