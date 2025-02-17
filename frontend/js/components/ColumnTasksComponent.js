export default class ColumnTasksComponent {
    static COLUMN_IDENTIFIERS = [
        { title: 'A fazer', id: 'todo-tasks' },
        { title: 'Fazendo', id: 'doing-tasks' },
        { title: 'Feito', id: 'done-tasks' },
    ]

    static createColumnTasks() {
        let columnsHTML = ''

        ColumnTasksComponent.COLUMN_IDENTIFIERS.forEach((column) => {
            columnsHTML += `
            <div class="column-tasks">
                <div class="column-tasks-title">${column.title}</div>
                <div class="column-tasks-items" id="${column.id}"></div>
                <div class="column-tasks-add">Adicionar</div>
            </div>
            `
        })

        return columnsHTML
    }
}


