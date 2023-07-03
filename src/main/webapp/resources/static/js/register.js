document.addEventListener("DOMContentLoaded", function () {
	document.getElementById("emailVerification").addEventListener("click", function () {
		event.preventDefault();
	});
	document.getElementById("emailConfirm").addEventListener("click", function (event) {
		event.preventDefault();
		if (emailValidation()==true) {
			let emailInput = document.getElementById("email");
			let emailValue = emailInput.value;
			showSpinner();

			fetch("/douzone/member/email", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({ email: emailValue }),
			})
				.then(response => response.json())
				.then(data => {
					let verificationArea = document.getElementById("verificationArea");
					verificationArea.classList.remove("d-none");
					hideSpinner();
					document.getElementById("emailVerification").addEventListener("click", function () {
						event.preventDefault();
						handleVerification(data);
					});
				})
				.catch(error => {
				});
		}
	});
});

function emailValidation() {
	let emailInput = document.getElementById("email");
	let emailValue = emailInput.value;
	let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	let emailErrorMessage = document.getElementById("emailErrorMessage");
	let result = "false";
	if (emailValue === "") {
		emailErrorMessage.textContent = "이메일을 입력해주세요.";
	} else if (!emailRegex.test(emailValue)) {
		emailErrorMessage.textContent = "올바른 이메일 형식이 아닙니다.";
	} else {
		emailErrorMessage.textContent = "";
		result = true;
	}
	return result;
}

function handleVerification(data) {
	let verificationInput = document.getElementById("verificationInput").value;
	if (data === verificationInput) {
		let emailVerificationButton = document.getElementById("emailVerification");
		emailVerificationButton.textContent = "인증 완료";
		emailVerificationButton.classList.add(disabled);
	}
}


function hideSpinner() {
	let spinner = document.getElementById('spinner');
	let spinnerText = document.getElementById('spinnerText');
	spinner.classList.add('d-none');
	spinnerText.classList.remove('d-none');
}
function showSpinner() {
	let spinner = document.getElementById('spinner');
	spinner.classList.remove('d-none');
	spinnerText.classList.add('d-none');
}