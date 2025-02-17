class TasksManager {

    tasks

    constructor(tasks) {
        this.tasks = tasks
    }

    addTask(task) {
        this.tasks.push(task)
    }

    removeTask(taskId) {
        this.tasks = this.tasks.filter(task => task.id !== taskId)
    }

    getTasks() {
        return this.tasks;
    }

    getTaskById(taskId) {
        return this.tasks.find(task => task.id == taskId)
    }

    updateTask(task) {
        const taskIndex = this.tasks.findIndex(existingTask => existingTask.id === task.id)
        this.tasks[taskIndex] = task
    }

    removeTaskById(taskId) {
        this.tasks = this.tasks.filter(task => task.id !== taskId)
    }
}

export default TasksManager;