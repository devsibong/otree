document.addEventListener('DOMContentLoaded', function () {
	let bsOffcanvas = new bootstrap.Offcanvas('#todoOffcanvas');
	let todoActive = 0;
	let toDoList = [];

	document.getElementById('todo').addEventListener('click', function (event) {
		event.preventDefault();
		document.getElementById('toDoBody').innerHTML = '';
		if (todoActive == 0) {
			this.classList.add('active');
			todoActive = 1;
			getToDoList();
		} else {
			this.classList.remove('active');
			todoActive = 0
		}
		bsOffcanvas.toggle();
	});

	// To Do List 할일 추가 이벤트함수
	document.getElementById("addToDoBtn").addEventListener("click", function (e) {
		e.preventDefault();

		let inputValue = document.getElementById("inputToDo").value;
		if (inputValue.trim().length < 1) {
			window.alert("할일을 입력해주세요");
		} else {
			let newToDoTxt = document.getElementById("inputToDo").value;
			makeToDoTag(newToDoTxt, false);
			let todoObj = {
				"checked": false,
				"txt": newToDoTxt
			}

			// toDoList 배열에 추가하고 LocalStorage에 담는다.					
			toDoList.push(todoObj);
			localStorage.setItem("toDoList", JSON.stringify(toDoList));
			document.getElementById("inputToDo").value = "";
		}

	})

	// 할일 LocalStorage에서 불러오기
	function getToDoList() {
		if (localStorage.getItem("toDoList") == null) {
			localStorage.setItem("toDoList", JSON.stringify(toDoList));
		} else {
			toDoList = JSON.parse(this.localStorage.getItem("toDoList"));
			toDoList.forEach((v) => { makeToDoTag(v.txt, v.checked) });
		}
	}

	document.getElementById("inputToDo").addEventListener("keyup", (e) => {
		if (e.key == "Enter") {
			e.preventDefault();
			document.getElementById("addToDoBtn").click();
		}
	})

	document.getElementById("addToDoBtn").addEventListener("keyup", (e) => {
		if (e.key == "Enter") {
			e.preventDefault();
			document.getElementById("addToDoBtn").click();
		}
	})
});

// toDoTag 태그 생성 함수 
function makeToDoTag(toDoTxt, checked) {
	let divTag = document.createElement("div");
	let labelTag = document.createElement("label");
	let inputTag = document.createElement("input");
	divTag.setAttribute("class", "form-check");
	divTag.setAttribute("id", "toDoOne");

	inputTag.setAttribute("class", "form-check-input");
	inputTag.setAttribute("type", "checkbox");
	inputTag.setAttribute("id", "toDoCheck");

	if (checked) {
		inputTag.setAttribute("checked", "checked");
	}

	divTag.appendChild(inputTag);

	labelTag.setAttribute("draggable", "true");
	labelTag.setAttribute("class", "form-check-label");
	labelTag.setAttribute("for", "toDoCheck");
	labelTag.innerText = toDoTxt;
	divTag.appendChild(labelTag);
	document.querySelector("#toDoBody").appendChild(divTag);	
	addEventToCheckBox();
}

// 이벤트 핸들러 등록
function addEventToCheckBox() {
	let formCheckElements = document.querySelectorAll(".form-check");
	formCheckElements.forEach(function (formCheckElement) {
		formCheckElement.addEventListener("click", function (e) {
			let checkbox = formCheckElement.querySelector("input[type='checkbox']");

			// 체크 상태 변경
			if (checkbox.checked) {
				checkbox.removeAttribute("checked");
			} else {
				checkbox.setAttribute("checked", "checked");
			}

			// 로컬스토리지에서 해당 요소에 접근하여 "checked" 속성 변경
			let toDoList = JSON.parse(localStorage.getItem("toDoList"));
			let index = Array.from(document.querySelectorAll("#toDoBody .form-check")).indexOf(formCheckElement);
			toDoList[index].checked = checkbox.checked;
			localStorage.setItem("toDoList", JSON.stringify(toDoList));
		});
	});
}
