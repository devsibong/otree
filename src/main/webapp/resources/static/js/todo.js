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
});