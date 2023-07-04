document.addEventListener('DOMContentLoaded', function () {
	let bsOffcanvas = new bootstrap.Offcanvas('#todoOffcanvas');
	let todoActive = 0;
	
	document.getElementById('todo').addEventListener('click', function (event) {
		event.preventDefault();
		if (todoActive == 0) {
			this.classList.add('active');
			todoActive = 1;
		} else {
			this.classList.remove('active');
			todoActive = 0
		}
		bsOffcanvas.toggle();
	});

	document.getElementById('addToDoBtn').addEventListener('click', function (event) {
		//event.preventDefault();
		let inputText = document.getElementById('inputToDo').value();
		let toDoBody = document.getElementById('toDoBody');
		let toDoTag = document.createElement('p');
		toDoTag.innerText = inputText;
		toDoBody.appendChild(toDoTag)
	})
});
/*

document.addEventListener('DOMContentLoaded', function() {
  var addToDoBtn = document.getElementById('addToDoBtn');
  addToDoBtn.addEventListener('click', function() {
    var inputText = document.querySelector('input[type="text"]').value;
    var pTag = document.createElement('p');
    pTag.textContent = inputText;
    var toDoBody = document.getElementById('toDoBody');
    toDoBody.appendChild(pTag);
  });
});

*/