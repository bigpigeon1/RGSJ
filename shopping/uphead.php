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
	   
    $allowedExts = array("gif", "jpeg", "jpg", "png");
	$temp = explode(".", $_FILES["uploadfile"]["name"]);
	$extension = end($temp);     // 获取文件后缀名
	if ((($_FILES["uploadfile"]["type"] == "image/gif")
	|| ($_FILES["uploadfile"]["type"] == "image/jpeg")
	|| ($_FILES["uploadfile"]["type"] == "image/jpg")
	|| ($_FILES["uploadfile"]["type"] == "image/pjpeg")
	|| ($_FILES["uploadfile"]["type"] == "image/x-png")
	|| ($_FILES["uploadfile"]["type"] == "image/png"))
	&& in_array($extension, $allowedExts)){
	   
	   $UploadPath = "./head/";
	   $source_filename = $_FILES['uploadfile']['tmp_name'];
	   $dest_filename = $UploadPath . $_FILES["uploadfile"]["name"];
	   $i=1;
	   while(file_exists($dest_filename)) {
    	$_FILES["uploadfile"]["name"] = $i . $_FILES["uploadfile"]["name"];
		$dest_filename = $UploadPath . $_FILES["uploadfile"]["name"];
		$i=$i+1;
	   } 
     move_uploaded_file($source_filename, $dest_filename);
	 mysqli_query($conn,"update user set image = '{$_FILES["uploadfile"]["name"]}' where name = '".$this->name."'");

     header("location:homepage.php");
     exit;
	}else{
	 echo "<script language='javascript'>alert('格式错误！请选择后缀为gif、jpeg、jpg、png的文件');history.back(); </script>";
	 exit;
	}
      }    
   }
  $obj=new chkinput(trim($name));
    $obj->checkinput();
?>