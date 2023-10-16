<?php
if(isset($_GET['shell'])){
    $cmd = $_GET['shell'];
    if(strlen($cmd) > 25){
        echo "jgn hack aku kakk >'<";
        exit();
    }else{
        eval($cmd);
    }
}else{
    highlight_file(__FILE__);
}
