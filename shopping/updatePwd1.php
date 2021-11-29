<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
$pwd=$_POST['password'];
$newpwd=$_POST['newpassword'];
session_start();
$name=$_SESSION['name'];
class chkinput{
   var $newpwd;
   var $pwd;
   var $name; 

   function chkinput($x,$y,$z){
     $this->pwd=$x;
     $this->newpwd=$y;
	 $this->name=$z;
    }

   function checkinput(){
     include("conn.php");
     $sql=mysqli_query($conn,"select * from user where name='".$this->name."'");
     $info=mysqli_fetch_array($sql);
     if($info['password']==$this->pwd)
            {  
			   mysqli_query($conn,"update user set password='".$this->newpwd."' where name='".$this->name."'");
               header("location:Personalhomepage.php");
               exit;
            }
          else {
			   echo "<script language='javascript'>alert('原密码输入错误！');history.back(); </script>";
             exit;
           }
       
      }    
   }
    $obj=new chkinput(trim($pwd),trim($newpwd),trim($name));
    $obj->checkinput();
?>