function deleteAccount(id) {
	
	let ok = confirm('정말 탈퇴 합니까?');
	
	if (ok) {
		/* ok 누르면 컨트롤러로 이동하자 */
		location.href='DeleteAccountC?id=' + id;
	}	
}