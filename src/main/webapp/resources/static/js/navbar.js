document.addEventListener("DOMContentLoaded", function () {

	document.getElementById("userProfile").addEventListener("click", function (event) {
		event.preventDefault();
		let myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
			backdrop: false
		});
		myModal.show();
	});
});
