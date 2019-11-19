<?php

if($_SERVER[‘REQUEST_METHOD’] == ‘POST’){

$uplaodedImage = $_POST[‘image_string’];

$filename = $_POST[‘filename’];

$success = file_put_contents($filename, base64_decode($uplaodedImage));

if(!$success){
echo json_encode(array(‘success’ => ‘0’), JSON_PRETTY_PRINT);
}
else{
echo json_encode(array(‘success’ => ‘1’), JSON_PRETTY_PRINT);
}
}

?>