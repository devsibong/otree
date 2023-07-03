document.addEventListener('DOMContentLoaded', function () {
	let toast = document.getElementById('liveToast');

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
		icon.addEventListener('click', function () {
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

