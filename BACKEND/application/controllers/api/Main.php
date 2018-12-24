<?php

defined('BASEPATH') or exit('No direct script access allowed');

class Main extends BD_Controller
{
    function __construct()
    {
        // Construct the parent class
        parent::__construct();
        $this->auth();
    }
    
    public function test_post()
    {
       
        $theCredential = $this->user_data;
        $this->response($theCredential, 200); // OK (200) being the HTTP response code
    }

    public function index_get()
    {
        $response['status'] = 'ok';
        $this->response($response, 200);
    }
    
}
