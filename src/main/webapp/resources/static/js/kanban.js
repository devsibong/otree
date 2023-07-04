$(document).ready(function () {
	let taskOffcanvas = new bootstrap.Offcanvas('#taskOffcanvas');
	let toast = document.getElementById('liveToast');
	hideKanbanSpinner();
	getTaskList();
	// List 1
	$('#generated').sortable({
		group: 'list',
		animation: 200,
		ghostClass: 'ghost',
		onSort: function (evt) {
			let sortedElements = $('#generated').find('.card');
			sortedElements.each(function (index, element) {
				let taskId = $(element).find('[name="taskId"]').text();
				let taskSeq = index + 1;
				let statusId = 5;
				updateTask(taskId, taskSeq, statusId);
			});
		}
	});

	// List 2
	$('#processing').sortable({
		group: 'list',
		animation: 200,
		ghostClass: 'ghost',
		onSort: function (evt) {
			let sortedElements = $('#processing').find('.card');
			sortedElements.each(function (index, element) {
				let taskId = $(element).find('[name="taskId"]').text();
				let taskSeq = index + 1;
				let statusId = 6;
				updateTask(taskId, taskSeq, statusId);
			});
		}
	});

	// List 3
	$('#complete').sortable({
		group: 'list',
		animation: 200,
		ghostClass: 'ghost',
		onSort: function (evt) {
			let sortedElements = $('#complete').find('.card');
			sortedElements.each(function (index, element) {
				let taskId = $(element).find('[name="taskId"]').text();
				let taskSeq = index + 1;
				let statusId = 7;
				updateTask(taskId, taskSeq, statusId);
			});
		}
	});



	// Arrays of "data-id"
	$('#get-order').click(function () {
		var sort1 = $('#items-1').sortable('toArray');
		console.log(sort1);
		var sort2 = $('#items-2').sortable('toArray');
		console.log(sort2);
	});


	$('#plusMemberIcon').click(function (event) {
		event.preventDefault();
		taskOffcanvas.toggle();
	});

	$('#createTask').click(function (event) {
		event.preventDefault();
		showKanbanSpinner();
		let task = {
			workspaceId: selectedWorkspaceId,
			startDate: $('#startDate').val(),
			endDate: $('#endDate').val(),
			taskContent: $('#taskContent').val(),
			statusId: 5
		};

		$.ajax({
			type: 'POST',
			url: '/douzone/task',
			data: JSON.stringify(task),
			contentType: 'application/json',
			success: function (response) {
				hideKanbanSpinner()
				taskOffcanvas.toggle();
				let toastshow = new bootstrap.Toast(toast);
				toastshow.show();
				getTaskList();
			},
			error: function (error) {
				console.log(error);
			}
		});

	});
});

function getTaskList() {
	showKanbanSpinner();
	$.ajax({
		type: 'GET',
		url: '/douzone/task/list/' + selectedWorkspaceId,
		contentType: 'application/json',
		success: function (response) {
			$('#generated').empty();
			$('#processing').empty();
			$('#complete').empty();

			response.forEach(function (task) {
				let $card = $('#taskTemplate').clone();
				$card.removeClass('d-none');
				$card.find('[name="taskContent"]').text(task.taskContent);
				$card.find('[name="startDate"]').text(formatDate(task.startDate));
				$card.find('[name="endDate"]').text(formatDate(task.endDate));
				$card.find('[name="taskId"]').text(task.taskId);
				$card.find('[name="statusId"]').text(task.statusId);
				$card.find('[name="taskSeq"]').text(task.taskSeq);

				$card.on('click', function () {
                    toggleTaskDetail($card);
                });

				if (task.statusId === 5) {
					$('#generated').append($card);
				} else if (task.statusId === 6) {
					$('#processing').append($card);
				} else if (task.statusId === 7) {
					$('#complete').append($card);
				}
			});
			hideKanbanSpinner();
		},
		error: function (error) {
			console.log(error);
		}
	});
}

function formatDate(timestamp) {
	let date = new Date(timestamp);
	let year = date.getFullYear();
	let month = (date.getMonth() + 1).toString().padStart(2, '0');
	let day = date.getDate().toString().padStart(2, '0');
	return year + '-' + month + '-' + day;
}

function updateTask(taskId, taskSeq, statusId) {
	showKanbanSpinner();
	let data = {
		taskId: taskId,
		taskSeq: taskSeq,
		statusId: statusId
	};
	console.log(data);

	$.ajax({
		type: 'PUT',
		url: '/douzone/task/modify',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function (response) {
			hideKanbanSpinner();
		},
		error: function (error) {
			console.log(error);
			hideKanbanSpinner();
		},
	});
}

function toggleTaskDetail($card) {
    let taskContent = $card.find('[name="taskContent"]').text();
    let taskStart = $card.find('[name="startDate"]').text();
    let taskEnd = $card.find('[name="endDate"]').text();
    let taskId = $card.find('[name="taskId"]').text();

    $('#taskDetailOffcanvas [name="taskContent"]').text(taskContent);
    $('#taskDetailOffcanvas [name="taskStart"]').text('Start Date: ' + taskStart);
    $('#taskDetailOffcanvas [name="taskEnd"]').text('End Date: ' + taskEnd);

    $('#taskDetailOffcanvas #removeTask').off('click').on('click', function () {
        removeTask(taskId);
		$('#taskDetailOffcanvas').offcanvas('hide');
    });

    $('#taskDetailOffcanvas').offcanvas('show');
}

function removeTask(taskId) {
	showKanbanSpinner();
	let data = {
		taskId: taskId,
	};

	$.ajax({
		type: 'DELETE',
		url: '/douzone/task/'+taskId,
		contentType: 'application/json',
		success: function (response) {
			hideKanbanSpinner();
			getTaskList();
		},
		error: function (error) {
			console.log(error);
			hideKanbanSpinner();
		},
	});
}


function hideKanbanSpinner() {
	let kanbanSpinner = document.getElementById('kanbanSpinner');
	kanbanSpinner.style.display = 'none';
}
function showKanbanSpinner() {
	let kanbanSpinner = document.getElementById('kanbanSpinner');
	kanbanSpinner.style.display = 'block';
}