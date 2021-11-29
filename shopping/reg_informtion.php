<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
$useraccount=$_POST['account'];
$userpwd=$_POST['password'];
$name=$_POST['name'];
$sex=$_POST['sex'];
$age=$_POST['age'];
$email=$_POST['e-mail'];
$idcard=$_POST['idcard'];
$address=$_POST['address'];
class chkinput{
    var $account;
    var $pwd;
	var $name;
	var $sex;
	var $age;
	var $email;
	var $idcard;
	var $address;
   function chkinput($x,$y,$a,$b,$c,$d,$e,$f){
     $this->account=$x;
     $this->pwd=$y;
	   $this->name=$a;
	   $this->sex=$b;
	   $this->age=$c;
	   $this->email=$d;
	   $this->idcard=$e;
	   $this->address=$f;
    }

   function checkinput(){
     include("conn.php");
	 if($this->account==""||$this->pwd==""||$this->age==""||$this->name==""||$this->email==""|| $this->idcard==""||$this->address==""){
		 echo $this->address,"<script language='javascript'>alert('请将信息填写完整！');</script>";
         exit;
	 }
	 $sql1=mysqli_query($conn,"select * from user where account='".$this->account."'");
     $info1=mysqli_fetch_array($sql1);
	 if($info1==true){
		 echo "<script language='javascript'>alert('该手机号已被注册');history.back();</script>";
         exit;
	 }    
	 
	 $sql2=mysqli_query($conn,"select * from user where name='".$this->name."'");
     $info2=mysqli_fetch_array($sql2);
	 if($info2==true){
		 echo "<script language='javascript'>alert('该昵称已被使用');history.back();</script>";
         exit;
	 }  
	   
	 $sql="INSERT INTO user (account, password, name, sex, age, email, idcard, address,image) VALUES('".$this->account."','".$this->pwd."','".$this->name."','".$this->sex."',$this->age,'".$this->email."','".$this->idcard."','".$this->address."','1OIP-C.png')";
     mysqli_query($conn,$sql);
    

          echo "<script language='javascript'>alert('注册成功');</script>";
          header("location:index.php");
          exit;

      }    
   }
   $obj=new chkinput(trim($useraccount),trim($userpwd),trim($name),trim($sex),trim($age),trim($email),trim($idcard),trim($address));
    $obj->checkinput();
?>