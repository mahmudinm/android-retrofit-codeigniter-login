<?php if(!defined('BASEPATH')) exit('No direct script allowed');

class M_user extends CI_Model {

	function get_user($q) {
		return $this->db->get_where('user',$q);
	}
	
}