document.addEventListener("DOMContentLoaded", function () {
	let memberOffcanvas = new bootstrap.Offcanvas('#memberOffcanvas');
	let toast = document.getElementById('liveToast');

	document.getElementById('modifyDescriptionIcon').addEventListener('click', function (event) {
		event.preventDefault();
		document.getElementById('modifyDescriptionIcon').classList.add('d-none');
		document.getElementById('modifyDescriptionConfirmIcon').classList.remove('d-none');
		let description = document.getElementById('workspaceDescription').textContent;
		document.getElementById('workspaceDescription').classList.add('d-none');
		document.getElementById('modifyDescription').classList.remove('d-none');
		document.getElementById('modifyDescription').value = description;
	});

	document.getElementById('modifyDescriptionConfirmIcon').addEventListener('click', function (event) {
		event.preventDefault();
		let changedDescription = document.getElementById('modifyDescription').value;
		fetch('/douzone/workspace/' + selectedWorkspaceId, {
			method: "PUT",
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ description: changedDescription }),
		})
			.then(response => response.json())
			.then(data => {
				document.getElementById('modifyDescription').classList.add('d-none');
				document.getElementById('workspaceDescription').textContent = changedDescription;
				document.getElementById('workspaceDescription').classList.remove('d-none');
				document.getElementById('modifyDescriptionConfirmIcon').classList.add('d-none');
				document.getElementById('modifyDescriptionIcon').classList.remove('d-none');
				const toastshow = new bootstrap.Toast(toast);
				toastshow.show();
			})
			.catch(error => {
				console.log(error);
			});
	});

	document.getElementById('addMemberIcon').addEventListener('click', function (event) {
		event.preventDefault();
		memberOffcanvas.toggle();
	});

	document.getElementById('memberSerch').addEventListener('keyup', function (event) {
		if (event.key === 'Enter') {
			let searchKeyword = document.getElementById('memberSerch').value;
			
			fetch('/douzone/workspace/' + selectedWorkspaceId, {
				method: "PUT",
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({ description: changedDescription }),
			})
				.then(response => response.json())
				.then(data => {
					document.getElementById('modifyDescription').classList.add('d-none');
					document.getElementById('workspaceDescription').textContent = changedDescription;
					document.getElementById('workspaceDescription').classList.remove('d-none');
					document.getElementById('modifyDescriptionConfirmIcon').classList.add('d-none');
					document.getElementById('modifyDescriptionIcon').classList.remove('d-none');
					const toastshow = new bootstrap.Toast(toast);
					toastshow.show();
				})
				.catch(error => {
					console.log(error);
				});
		}
	});




	
	

});