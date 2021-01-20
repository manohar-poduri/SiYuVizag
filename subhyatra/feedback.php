<?php

	$data = $_REQUEST["placename"];
	$conn = mysqli_connect("localhost","root","","subhayatra");

	$qry = "insert into feedback (queries) values ('$data')";
	

	if(mysqli_query($conn,$qry)){
    echo 'success';
    //echo json_encode(array("result"=>$res));
   // array_push($res,array('Placename'=>"Success"));
	//	echo json_encode(array("result"=>$res));
  }
  else{
   // array_push($res,array('Placename'=>"Failure"));
	//	echo json_encode(array("result"=>$res));
		echo 'failure';
  }
  mysqli_close($conn);
?>

