class NavigationController {
    injectElement
    task
    renderTasks

    columnTasksComponent
    taskComponent
    CRUDComponents

    tasksList

    constructor({
        injectElement,
        task,
        renderTasks,
        columnTasksComponent,
        taskComponent,
        CRUDComponents,
        tasksList,
    }) {
        this.injectElement = injectElement
        this.task = task
        this.renderTasks = renderTasks
        this.columnTasksComponent = columnTasksComponent
        this.taskComponent = taskComponent
        this.CRUDComponents = CRUDComponents
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
        this.clear('.tasks-container')
        this.injectElement('.tasks-container', this.columnTasksComponent())
        this.renderTasks(
            this.tasksList.getTasks(),
            this.taskComponent,
            this.injectElement
        )
        this.activeMainListener()
    }

    loadCreateForm() {
        this.clear('.create-task-container')
        this.injectElement(
            '.create-task-container',
            this.CRUDComponents.createTaskForm()
        )
        this.activeCreateFormListener()
    }

    loadReadForm(task) {
        this.clear('.read-task-container')
        this.injectElement(
            '.read-task-container',
            this.CRUDComponents.readTaskForm(task)
        )
        this.activeReadFormListener()
    }

    loadEditForm(task) {
        this.clear('.edit-task-container')
        this.injectElement(
            '.edit-task-container',
            this.CRUDComponents.editTaskForm(task)
        )
        this.activeEditFormListener()
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

    mainToRead(task) {
        this.clear('.tasks-container')

        this.hidden('.tasks-container')
        this.show('.read-task-container')

        this.loadReadForm(task)
    }

    mainToEdit(task) {
        this.clear('.tasks-container')

        this.hidden('.tasks-container')
        this.show('.edit-task-container')

        this.loadEditForm(task)
    }

    readToMain() {
        this.clear('.read-task-container')

        this.hidden('.read-task-container')
        this.show('.tasks-container')

        this.loadMain()
    }

    editToMain() {
        this.clear('.edit-task-container')

        this.hidden('.edit-task-container')
        this.show('.tasks-container')

        this.loadMain()
    }

    activeMainListener() {
        const mainToCreate = this.mainToCreate.bind(this)
        const tasksList = this.tasksList
        const mainToRead = this.mainToRead.bind(this)
        const mainToEdit = this.mainToEdit.bind(this)
        const loadMain = this.loadMain.bind(this)

        document.querySelectorAll('.column-tasks-add').forEach((button) => {
            button.addEventListener('click', function (event) {
                mainToCreate()
            })
        })

        document.querySelectorAll('.task-view').forEach((button) => {
            button.addEventListener('click', (event) => {
                const parentItem = event.target.closest('.column-tasks-item')
                if (parentItem) {
                    const taskId = Number(parentItem.dataset.taskId)
                    mainToRead(tasksList.getTaskById(taskId))
                }
            })
        })

        document.querySelectorAll('.task-edit').forEach((button) => {
            button.addEventListener('click', (event) => {
                const parentItem = event.target.closest('.column-tasks-item')
                if (parentItem) {
                    const taskId = Number(parentItem.dataset.taskId)
                    mainToEdit(tasksList.getTaskById(taskId))
                }
            })
        })

        document.querySelectorAll('.task-delete').forEach((button) => {
            button.addEventListener('click', (event) => {
                const parentItem = event.target.closest('.column-tasks-item')
                if (parentItem) {
                    const taskId = Number(parentItem.dataset.taskId)
                    tasksList.removeTaskById(taskId)
                    loadMain()
                }
            })
        })
    }

    activeCreateFormListener() {
        document
            .getElementById('create-task-button')
            .addEventListener('click', () => {
                const form = document.querySelector('#create-task-form')
                if (!form.checkValidity()) {

                    if (!document.getElementById('name').checkValidity()) {
                        document.getElementById('name').reportValidity()
                    }

                    if (!document.getElementById('description').checkValidity()) {
                        document.getElementById('description').reportValidity()
                    }

                    if (!document.getElementById('category').checkValidity()) {
                        document.getElementById('category').reportValidity()
                    }

                    if (!document.getElementById('priorityLevel').checkValidity()) {
                        document.getElementById('priorityLevel').reportValidity()
                    }

                    if (!document.getElementById('statusIndex').checkValidity()) {
                        document.getElementById('statusIndex').reportValidity()
                    }

                    return
                }
                this.tasksList
                    .getTasks()
                    .push(
                        this.task(
                            document.getElementById('name').value,
                            document.getElementById('description').value,
                            document.getElementById('category').value,
                            Number(
                                document.getElementById('priorityLevel').value
                            ),
                            Number(document.getElementById('statusIndex').value)
                        )
                    )

                this.createToMain()
            })

        document.getElementById('back-button').addEventListener('click', () => {
            this.createToMain()
        })
    }

    activeReadFormListener() {
        document.getElementById('back-button').addEventListener('click', () => {
            this.readToMain()
        })
    }

    activeEditFormListener() {
        document
            .getElementById('edit-task-button')
            .addEventListener('click', () => {
                const task = this.tasksList.getTaskById(
                    Number(
                        document.getElementById('edit-task-form').dataset.taskId
                    )
                )

                task.name = document.querySelector(
                    '#edit-task-form #name'
                ).value
                task.description = document.querySelector(
                    '#edit-task-form #description'
                ).value
                task.category = document.querySelector(
                    '#edit-task-form #category'
                ).value
                task.priorityLevel = Number(
                    document.querySelector('#edit-task-form #priorityLevel')
                        .value
                )
                task.statusIndex = Number(
                    document.querySelector('#edit-task-form #statusIndex').value
                )

                this.editToMain()
            })

        document.getElementById('back-button').addEventListener('click', () => {
            this.editToMain()
        })
    }
}

export default NavigationController
