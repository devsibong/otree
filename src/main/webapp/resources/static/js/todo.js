document.addEventListener('DOMContentLoaded', function () {
	let bsOffcanvas = new bootstrap.Offcanvas('#todoOffcanvas');
	let todoActive = 0;
	

	document.getElementById("todoInputShow").addEventListener("click", function () {
		let todoInput = document.getElementById("todoInput");
		const isHidden = todoInput.classList.contains("d-none");

		if (isHidden) {
			todoInput.classList.remove("d-none");
			todoInput.classList.add("d-flex");
		} else {
			todoInput.classList.remove("d-flex");
			todoInput.classList.add("d-none");
		}
	});

	document.getElementById('todo').addEventListener('click', function (event) {
		event.preventDefault();

		if (todoActive == 0) {
			this.classList.add('active');
			todoActive = 1;
			getToDoList();
			displayTodo();
		} else {
			this.classList.remove('active');
			todoActive = 0
		}
		bsOffcanvas.toggle();
	});

	document.getElementById("addToDoBtn").addEventListener("click", function (e) {
		e.preventDefault();
		let inputValue = document.getElementById("inputToDo").value;
		if (inputValue.trim().length < 1) {
			window.alert("할일을 입력해주세요");
		} else {
			let newToDoTxt = document.getElementById("inputToDo").value;
			let todoObj = {
				"id": localStorage.getItem("currentId"),
				"checked": false,
				"txt": newToDoTxt
			};
			toDoList = JSON.parse(localStorage.getItem("toDoList"));
			toDoList.push(todoObj);
			localStorage.setItem("toDoList", JSON.stringify(toDoList));
			document.getElementById("inputToDo").value = "";
			localStorage.getItem("toDoList")
			let newId = localStorage.getItem("currentId")+1;
			localStorage.setItem("currentId", newId);
			displayTodo();
		}
	});

	document.getElementById('removeCompleteTask').addEventListener('click',function(e) {
		e.preventDefault();
		removeCompletedTasks();
		displayTodo();


	})

});

function makeToDoTag(toDoTxt, checked, id) {
	let divTag = document.createElement("div");
	let labelTag = document.createElement("label");
	let inputTag = document.createElement("input");
	divTag.setAttribute("class", "form-check");
	divTag.setAttribute("id", id);

	inputTag.setAttribute("class", "form-check-input");
	inputTag.setAttribute("type", "checkbox");
	inputTag.setAttribute("id", id); // Use the same id for checkbox

	if (checked) {
		inputTag.setAttribute("checked", "checked");
		let offcanvasFooter = document.getElementById("offcanvasFooter");
		divTag.appendChild(inputTag);
		labelTag.setAttribute("draggable", "true");
		labelTag.setAttribute("class", "form-check-label");
		labelTag.setAttribute("for", "toDoCheck");
		labelTag.innerText = toDoTxt;
		divTag.appendChild(labelTag);
		offcanvasFooter.appendChild(divTag);
	} else {
		divTag.appendChild(inputTag);
		labelTag.setAttribute("draggable", "true");
		labelTag.setAttribute("class", "form-check-label");
		labelTag.setAttribute("for", "toDoCheck");
		labelTag.innerText = toDoTxt;
		divTag.appendChild(labelTag);
		let offcanvasBody = document.getElementById("toDoBody");
		offcanvasBody.appendChild(divTag);
	}
	
}


function addEventToCheckBox() {
	let formCheckElements = document.querySelectorAll(".form-check");
	formCheckElements.forEach(function (formCheckElement) {
		formCheckElement.addEventListener("click", function (e) {
			e.preventDefault();
			let id = formCheckElement.getAttribute("id");
			let toDoList = JSON.parse(localStorage.getItem("toDoList"));
			toDoList.forEach(function (item) {
				if (item.id.toString() === id) {
					item.checked = !item.checked;
				}
			});
			localStorage.setItem("toDoList", JSON.stringify(toDoList));
			displayTodo();
		});
	});
}


function getToDoList() {
	let toDoList = [];
	if (localStorage.getItem("toDoList") == null) {
		localStorage.setItem("toDoList", JSON.stringify(toDoList));
		localStorage.setItem("currentId", 1);
	} else {
		toDoList = JSON.parse(localStorage.getItem("toDoList"));
	}
	return toDoList;
}

function displayTodo() {
	document.getElementById("toDoBody").innerHTML = "";
	document.getElementById("offcanvasFooter").innerHTML = "";
	let toDoList = JSON.parse(localStorage.getItem("toDoList"));
	toDoList.forEach(function (item) {
		makeToDoTag(item.txt, item.checked, item.id);
	});
	addEventToCheckBox();
}

function removeCompletedTasks() {
	let toDoList = getToDoList();
	if (toDoList) {
	  toDoList = toDoList.filter(function(task) {
		return !task.checked;
	  });
	  localStorage.setItem('toDoList', JSON.stringify(toDoList));
	}
  }
  