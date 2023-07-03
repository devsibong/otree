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
				let toastshow = new bootstrap.Toast(toast);
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
		let searchKeyword = document.getElementById('memberSerch').value;

		fetch('/douzone/teamrole/' + selectedWorkspaceId+'/search', {
			method: "POST",
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ searchKeyword: searchKeyword }),
		})
			.then(response => response.json())
			.then(data => {
				console.log(data);
				const toastshow = new bootstrap.Toast(toast);
				toastshow.show();
			})
			.catch(error => {
				console.log(error);
			});
	});

	let removeMemberIcons = document.getElementsByClassName('removeMemberIcon');
	Array.from(removeMemberIcons).forEach(function (icon) {
		icon.addEventListener('click', function (event) {
			event.preventDefault();
			let removeId = icon.id;
			fetch('/douzone/teamrole/' + selectedWorkspaceId, {
				method: "DELETE",
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({ removeId: removeId }),
			})
				.then(response => response.json())
				.then(data => {
					let card = icon.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
					card.classList.add('d-none');
					let toastshow = new bootstrap.Toast(toast);
					toastshow.show();
				})
				.catch(error => {
					console.log(error);
				});
		});
	});


});