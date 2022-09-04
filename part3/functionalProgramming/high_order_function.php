<?php
$twice = function($f, $v) {
   return $f($f($v));
};

$f = function($v) {
   return $v + 3;
};

echo($twice($f, 7));
