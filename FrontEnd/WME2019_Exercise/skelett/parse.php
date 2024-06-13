<?php
class Parser
{
    public function parse($path)
    {
        $file = fgetcsv($path, 1024, ",");
        echo "<pre>";
        print_r($file);
        echo "<pre>";
    
    }    
}




?>