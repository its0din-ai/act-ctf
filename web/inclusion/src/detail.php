<?php
if(!isset($_GET["page"])) {
    highlight_file(__FILE__);
} else{
    $page = $_GET["page"];
    include($page);
}
