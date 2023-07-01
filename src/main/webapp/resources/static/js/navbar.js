document.addEventListener("DOMContentLoaded", function () {
	const myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
		backdrop: false
	});
	document.getElementById("userProfile").addEventListener("click", function (event) {
		event.preventDefault();
		myModal.toggle();
	});
	document.getElementById("logout").addEventListener("click", function (event) {
		event.preventDefault();
		window.location.href = `/douzone/member/logout`;
	});


});