document.addEventListener("DOMContentLoaded", function () {
	const myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
		backdrop: false
	});
	document.getElementById("userProfile").addEventListener("click", function (event) {
		event.preventDefault();
		myModal.toggle();
		fetchUserInfo();
	});
	document.getElementById("logout").addEventListener("click", function (event) {
		event.preventDefault();
		window.location.href = `/douzone/member/logout`;
	});
});

function fetchUserInfo() {
	fetch("/douzone/member")
		.then(response => response.json())
		.then(data => {
			updateUserInfo(data.name, data.email);
		})
		.catch(error => {
			console.error("Error:", error);
		});
}
  
  function updateUserInfo(name, email) {
	document.getElementById("userName").textContent = name;
	document.getElementById("email").textContent = email;
  }