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
			hideSpinner();
		})
		.catch(error => {
			console.error("Error:", error);
			hideSpinner();
		});
}
  
  function updateUserInfo(name, email) {
	document.getElementById("userName").textContent = name;
	document.getElementById("email").textContent = email;
  }
  
  function hideSpinner() {
	let spinner = document.getElementById('spinner');
	spinner.style.display = 'none';
  }
  function showSpinner() {
	let spinner = document.getElementById('spinner');
	spinner.style.display = 'block';
  }
  