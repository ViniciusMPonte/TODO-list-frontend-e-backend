export default class Task {
    static createTaskElement(task) {
        return `
            <div class="column-tasks-item">
                <div class="task-priority">P1</div>
                <div class="task-container">
                    <div class="task-title">${task.title}</div>
                    <div class="task-options">
                        <div class="task-category">${task.category}</div>
                        <div class="spacer"></div>
                        <div class="task-view">v</div>
                        <div class="task-edit">e</div>
                        <div class="task-delete">d</div>
                    </div>
                </div>
            </div>
        `
    }
}
