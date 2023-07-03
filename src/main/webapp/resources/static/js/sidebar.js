document.addEventListener('DOMContentLoaded', function () {
    const bsOffcanvas = new bootstrap.Offcanvas('#todoOffcanvas');
	let todoActive = 0;
	document.getElementById('todo').addEventListener('click', function (event) {
		event.preventDefault();
		if(todoActive == 0) {
			this.classList.add('active');
			todoActive = 1;
		} else {
			this.classList.remove('active');
			todoActive = 0
		}
        bsOffcanvas.toggle();
	});

	const workspaceModal = new bootstrap.Modal(document.getElementById('createWorkspaceModal'), {
		backdrop: false
	});
	document.getElementById('createWorkspace').addEventListener('click', function (event) {
		event.preventDefault();
		workspaceModal.toggle();
	});

	document.querySelectorAll('div[name="workspaceIcon"]').forEach(icon => {
		icon.addEventListener('mouseenter', handleMouseEnter);
		icon.addEventListener('mouseleave', handleMouseLeave);
		icon.addEventListener('click', function() {
			let workspaceId = icon.id;
   			window.location.href = `/douzone/workspace/${workspaceId}`;
		});
	  });
});

function handleMouseEnter() {
	this.style.cursor = 'pointer';
}
 
function handleMouseLeave() {
	this.style.cursor = 'default';
}