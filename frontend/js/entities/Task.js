class Task {
    STATUS = ['todo', 'doing', 'done']

    name
    description
    category
    priorityLevel
    statusIndex
    startDate = new Date()
    modificationDate
    finishDate

    constructor(
        name,
        description,
        category,
        priorityLevel,
        statusIndex,
        startDate,
        modificationDate,
        finishDate
    ) {
        this.name = name
        this.description = description
        this.category = category
        this.priorityLevel = priorityLevel
        this.statusIndex = statusIndex
        this.startDate = startDate || new Date()
        this.modificationDate = modificationDate || null
        this.finishDate = finishDate || null
    }

    static createNewTask(name, description, category, priorityLevel, statusIndex, startDate, modificationDate, finishDate) {
        return new Task(name, description, category, priorityLevel, statusIndex, startDate, modificationDate, finishDate)
    }
}

export default Task