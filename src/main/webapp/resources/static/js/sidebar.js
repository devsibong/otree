document.addEventListener("DOMContentLoaded", function () {
    const bsOffcanvas = new bootstrap.Offcanvas('#todoOffcanvas');
	document.getElementById("todo").addEventListener("click", function (event) {
		event.preventDefault();
        bsOffcanvas.toggle();
	});
});