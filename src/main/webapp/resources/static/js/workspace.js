document.addEventListener("DOMContentLoaded", function () {
	let toast = document.getElementById('liveToast');
	loadMembers();
});

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
		},
		error: function (error) {
			console.log(error);
		}
	});
}

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