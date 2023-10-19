<?php
// delete me:
$secret = "727f8c95dab6ddf2aa5b6ab53ceb7523276f1f80";
$pin = 1337;
$flag = "ACTCTF{f3b169637701236cfab5b7b58321085e}";
// ===

if (isset($_POST['id']) && isset($_POST['pin'])) {
    if (strcmp($secret, $_POST['id']) == 0 && strcmp($pin, $_POST['pin']) == 0) {
        echo "+==========================================+\n";
        echo "| " . $flag . " |\n";
        echo "+==========================================+\n";
    } else {
        echo "Pinjam dulu seratus!";
    }
}else{
    highlight_file("727f8c95dab6ddf2aa5b6ab53ceb7523276f1f80.php");
}
