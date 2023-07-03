document.addEventListener("DOMContentLoaded", function () {
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
					document.getElementById("emailVerification").addEventListener("click", function (event) {
						event.preventDefault();
						handleVerification(data);
					});
				})
				.catch(error => {
				});
		}
	});

	document.getElementById("register").addEventListener("click", function(event) {
		event.preventDefault();
		let password = document.getElementById("password").value;
		let passwordConfirm = document.getElementById("passwordConfirm").value;
		if(password==passwordConfirm) {
			document.getElementById("verificationPassword").classList.add("d-none");
			document.getElementById("registerForm").submit();
		} else {
			document.getElementById("verificationPassword").classList.remove("d-none");
			document.getElementById("pwVerificationMessage").textContent = "비밀번호가 다릅니다";
		}
	})
});

function emailValidation() {
	let emailInput = document.getElementById("email");
	let emailValue = emailInput.value;
	let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	let emailErrorMessage = document.getElementById("emailErrorMessage");
	let emailConfirmArea = document.getElementById("emailConfirmArea");
	let result = "false";
	if (emailValue === "") {
		emailConfirmArea.classList.remove("d-none");
		emailErrorMessage.textContent = "이메일을 입력해주세요.";
	} else if (!emailRegex.test(emailValue)) {
		emailConfirmArea.classList.remove("d-none");
		emailErrorMessage.textContent = "올바른 이메일 형식이 아닙니다.";
	} else {
		emailConfirmArea.classList.add("d-none");
		emailErrorMessage.textContent = "";
		result = true;
	}
	return result;
}

function handleVerification(data) {
	let verificationInput = document.getElementById("verificationInput").value;
	let verificationNumberArea = document.getElementById("verificationNumberArea");
	if (parseInt(data) == parseInt(verificationInput)) {
		verificationNumberArea.classList.remove("d-none");
		let emailVerificationButton = document.getElementById("emailVerification");
		emailVerificationButton.textContent = "완료됨";
		emailVerificationButton.setAttribute('disabled', '');
	} else {
		verificationNumberArea.classList.remove("d-none");
		document.getElementById("emailVerifyMessage").textContent("인증 번호를 올바르게 입력하세요.");
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