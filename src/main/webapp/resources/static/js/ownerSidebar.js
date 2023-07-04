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

	document.getElementById('modifyWorkspaceName').addEventListener('click', function (event) {
		event.preventDefault();
		this.classList.add('d-none');
		let workspaceNameArea = document.getElementById('workspaceName');
		let workspaceName = workspaceNameArea.textContent;
		document.getElementById('workspaceNameInput').classList.remove('d-none');
		document.getElementById('workspaceNameInput').value = workspaceName;
		document.getElementById('workspaceName').classList.add('d-none');
		document.getElementById('workspaceNameModify').classList.remove('d-none');
	});

	document.getElementById('workspaceNameModify').addEventListener('click', function (event) {
		event.preventDefault();
		let changedWorkspaceName = document.getElementById('workspaceNameInput').value;
		fetch('/douzone/workspace/' + selectedWorkspaceId, {
			method: "PUT",
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ workspaceName: changedWorkspaceName }),
		})
			.then(response => response.json())
			.then(data => {
				document.getElementById('workspaceNameInput').classList.add('d-none');
				document.getElementById('workspaceName').textContent = changedWorkspaceName;
				document.getElementById('workspaceName').classList.remove('d-none');
				document.getElementById('workspaceNameModify').classList.add('d-none');
				document.getElementById('modifyWorkspaceName').classList.remove('d-none');
				let toastshow = new bootstrap.Toast(toast);
				toastshow.show();
			})
			.catch(error => {
				console.log(error);
			});
	});
});




function handleMouseEnter() {
	this.style.cursor = 'pointer';
}

function handleMouseLeave() {
	this.style.cursor = 'default';
}

