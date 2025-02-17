class TasksViewManager {
    static sortTasksByPriority(tasksList) {
        return [...tasksList].sort((a, b) => a.priorityLevel - b.priorityLevel)
    }

    static renderTasks(tasksList, createHTMLComponent, injectElement) {
        TasksViewManager.sortTasksByPriority(tasksList).forEach(task => {
            const taskHTML = createHTMLComponent(task)
            injectElement(`#${task.STATUS[task.statusIndex]}-tasks`, taskHTML)
        })
    }

}

export default TasksViewManager
