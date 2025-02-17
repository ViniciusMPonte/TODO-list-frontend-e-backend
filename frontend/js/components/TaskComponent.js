export default class TaskComponent {
    static createTaskCard(task) {
        return `
            <div class="column-tasks-item" data-task-id="${task.id}">
                <div class="task-priority">P${task.priorityLevel}</div>
                <div class="task-container">
                    <div class="task-title">${task.name}</div>
                    <div class="task-options">
                        <div class="task-category">${task.category}</div>
                        <div class="spacer"></div>
                        <div class="task-view"></div>
                        <div class="task-edit"></div>
                        <div class="task-delete"></div>
                    </div>
                </div>
            </div>
        `
    }
}
