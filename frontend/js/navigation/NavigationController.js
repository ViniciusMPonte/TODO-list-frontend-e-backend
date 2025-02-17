class NavigationController {
    injectElement
    task
    renderTasks

    columnTasksComponent
    taskComponent
    createTaskFormComponent

    tasksList

    constructor({
        injectElement,
        task,
        renderTasks,
        columnTasksComponent,
        taskComponent,
        createTaskFormComponent,
        tasksList,
    }) {
        this.injectElement = injectElement
        this.task = task
        this.renderTasks = renderTasks
        this.columnTasksComponent = columnTasksComponent
        this.taskComponent = taskComponent
        this.createTaskFormComponent = createTaskFormComponent
        this.tasksList = tasksList
    }

    clear(selectorTag) {
        document.querySelector(selectorTag).innerHTML = ''
    }

    hidden(selectorTag) {
        document.querySelector(selectorTag).classList.add('hidden')
    }

    show(selectorTag) {
        document.querySelector(selectorTag).classList.remove('hidden')
    }

    loadMain() {
        this.injectElement('.tasks-container', this.columnTasksComponent())
        this.renderTasks(this.tasksList, this.taskComponent, this.injectElement)
        this.activeMainListener()
    }

    loadCreateForm() {
        this.clear('.create-task-container')
        this.injectElement(
            '.create-task-container',
            this.createTaskFormComponent()
        )
        this.activeCreateFormListener()
    }

    mainToCreate() {
        this.clear('.tasks-container')

        this.hidden('.tasks-container')
        this.show('.create-task-container')

        this.loadCreateForm()
    }

    createToMain() {
        this.clear('.create-task-container')
        this.clear('.tasks-container')

        this.hidden('.create-task-container')
        this.show('.tasks-container')

        this.loadMain()
    }

    activeCreateFormListener() {
        document
            .getElementById('createTaskButton')
            .addEventListener('click', () => {
                this.tasksList.push(
                    this.task(
                        document.getElementById('name').value,
                        document.getElementById('description').value,
                        document.getElementById('category').value,
                        Number(document.getElementById('priorityLevel').value),
                        Number(document.getElementById('statusIndex').value)
                    )
                )

                this.createToMain()
            })
    }

    activeMainListener() {
        const mainToCreate = this.mainToCreate.bind(this)
        document.querySelectorAll('.column-tasks-add').forEach((button) => {
            button.addEventListener('click', function (event) {
                mainToCreate()
            })
        })
    }
}

export default NavigationController
