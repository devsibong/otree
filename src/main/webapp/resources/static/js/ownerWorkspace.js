document.addEventListener("DOMContentLoaded", function () {
	let memberOffcanvas = new bootstrap.Offcanvas('#memberOffcanvas');
	let toast = document.getElementById('liveToast');
	loadMembers();

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
		if (searchKeyword != null && searchKeyword != "") {
			fetch('/douzone/teamrole/' + selectedWorkspaceId + '/search', {
				method: "POST",
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({ searchKeyword: searchKeyword }),
			})
				.then(response => response.json())
				.then(data => {
					document.getElementById("resultArea").innerHTML = "";
					let parsedData = JSON.parse(data.data);
					let exampleCard = document.querySelector("[name='memberCard']");
					parsedData.forEach(member => {
						let newCard = exampleCard.cloneNode(true);

						newCard.classList.remove('d-none');
						newCard.querySelector("[name='memberName']").textContent = member.name;
						newCard.querySelector("[name='memberEmail']").textContent = member.email;
						newCard.querySelector("[name='memberId']").id = member.userId;

						let plusMemberIcon = newCard.querySelector("#plusMemberIcon");

						plusMemberIcon.addEventListener("click", function () {
							let memberId = newCard.querySelector("[name='memberId']").id;
							fetch('/douzone/teamrole/' + selectedWorkspaceId, {
								method: "POST",
								headers: {
									'Content-Type': 'application/json',
								},
								body: JSON.stringify({ userId: memberId }),
							})
								.then(response => response.json())
								.then(data => {
									newCard.style.display = 'none';
									let toastshow = new bootstrap.Toast(toast);
									toastshow.show();
									loadMembers();
								})
								.catch(error => {
									console.log(error);
								});
						});
						let resultArea = document.getElementById("resultArea");
						resultArea.appendChild(newCard);
					});
				})
				.catch(error => {
					console.log(error);
				});



		}

	});




});

function addMemberCard(member, isOwner) {
	let card = document.querySelector('#memberTemplate').cloneNode(true);
	console.log(isOwner);
	card.classList.remove('d-none');
	card.querySelector('[name="memberName"]').textContent = member.name;
	card.querySelector('[name="memberEmail"]').textContent = member.email;
	card.querySelector('[name="memberId"]').textContent = member.userId;
	let ownerBadge = card.querySelector('[name="ownerBadge"]');
	if (isOwner === true) {
		ownerBadge.classList.remove('d-none');
	} else {
		ownerBadge.classList.add('d-none');
	}
	document.querySelector('#memberList').appendChild(card);
}

function loadMembers() {
    document.querySelector('#memberList').innerHTML = '';
    $.ajax({
        type: 'GET',
        url: '/douzone/teamrole/' + selectedWorkspaceId,
        contentType: 'application/json',
        success: function (response) {
            let owner = response.owner;
            let memberList = response.memberList;
            addMemberCard(owner, true);
            memberList.forEach(function (member) {
                addMemberCard(member, false);
            });
            addRemoveMemberListeners();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function addRemoveMemberListeners() {
    let removeMemberIcons = document.getElementsByClassName('removeMemberIcon');
    Array.from(removeMemberIcons).forEach(function (icon) {
        icon.addEventListener('click', function (event) {
            event.preventDefault();
            let removeId = icon.closest('.card').querySelector('[name="memberId"]').textContent;
            fetch('/douzone/teamrole/' + selectedWorkspaceId, {
                method: "DELETE",
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ removeId: removeId }),
            })
                .then(response => response.json())
                .then(data => {
					loadMembers();
					let toast = document.getElementById('liveToast');
                    let toastshow = new bootstrap.Toast(toast);
                    toastshow.show();
                })
                .catch(error => {
                    console.log(error);
                });
        });
    });
}
