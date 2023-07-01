document.addEventListener("DOMContentLoaded", function () {
    const bsOffcanvas = new bootstrap.Offcanvas('#todoOffcanvas');
	document.getElementById("todo").addEventListener("click", function (event) {
		event.preventDefault();
        bsOffcanvas.toggle();
	});

	const workspaceModal = new bootstrap.Modal(document.getElementById('createWorkspaceModal'), {
		backdrop: false
	});
	document.getElementById("createWorkspace").addEventListener("click", function (event) {
		event.preventDefault();
		workspaceModal.toggle();
	});

	document.querySelectorAll('div[name="workspaceIcon"]').forEach(icon => {
		icon.addEventListener('mouseenter', handleMouseEnter);
		icon.addEventListener('mouseleave', handleMouseLeave);
	  });
});

function handleMouseEnter() {
	this.style.cursor = 'pointer';
}
 
function handleMouseLeave() {
	this.style.cursor = 'default';
}