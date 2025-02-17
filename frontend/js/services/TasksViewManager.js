class TasksViewManager {
    static sortTasksByPriority(tasksList) {
        return [...tasksList].sort((a, b) => a.priorityLevel - b.priorityLevel)
    }

    static renderTasks(tasksList, createHTMLComponent, elementInjector) {
        this.sortTasksByPriority(tasksList).forEach(task => {
            const taskHTML = createHTMLComponent(task)
            elementInjector(`#${task.STATUS[task.statusIndex]}-tasks`, taskHTML)
        })
    }

}

export default TasksViewManager
