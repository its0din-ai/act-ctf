<?php
if (isset($_POST['id']) && isset($_POST['pin'])) {
    if (strcmp($secret, $_POST['id']) == 0 && strcmp($pin, $_POST['pin']) == 0) {
        echo "+==========================================+\n";
        echo "| " . $flag . " |";
        echo "+==========================================+\n";
    } else {
        echo "Pinjam dulu seratus!";
    }
}else{
    highlight_file("auth.php");
}
