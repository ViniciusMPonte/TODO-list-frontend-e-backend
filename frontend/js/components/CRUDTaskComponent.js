class CRUDTaskComponent {
    static createTaskForm() {
        return `
            <form id="create-task-form">
                <div class="form-group">
                    <label for="name">Nome:</label>
                    <input type="text" id="name" name="name" required />
                </div>

                <div class="form-group">
                    <label for="category">Categoria:</label>
                    <input type="text" id="category" name="category" required />
                </div>

                <div class="form-group">
                    <label for="description">Descrição:</label>
                    <textarea
                        id="description"
                        name="description"
                        rows="3"
                        required
                    ></textarea>
                </div>

                <div class="form-group">
                    <label for="priorityLevel">Prioridade:</label>
                    <select id="priorityLevel" name="priorityLevel" required>
                        <option value="">Selecione...</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="statusIndex">Status:</label>
                    <select id="statusIndex" name="statusIndex" required>
                        <option value="">Selecione...</option>
                        <option value="0">A fazer</option>
                        <option value="1">Fazendo</option>
                        <option value="2">Feito</option>
                    </select>
                </div>

                <button type="button" id="create-task-button">Criar tarefa</button>
                <button type="button" id="back-button">Voltar</button>
            </form>        
        `
    }

    static readTaskForm(task) {
        return `
            <form id="view-task-form" data-task-id="${task.id}">
                <div class="form-group">
                    <label for="name">Nome:</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        readonly
                        value="${task.name}"
                    />
                </div>

                <div class="form-group">
                    <label for="category">Categoria:</label>
                    <input
                        type="text"
                        id="category"
                        name="category"
                        readonly
                        value="${task.category}"
                    />
                </div>

                <div class="form-group">
                    <label for="description">Descrição:</label>
                    <textarea id="description" name="description" rows="3" readonly>${task.description}</textarea>
                </div>

                <div class="form-group">
                    <label for="priorityLevel">Prioridade:</label>
                    <select id="priorityLevel" name="priorityLevel" disabled>
                        <option value="">Selecione...</option>
                        <option value="1" ${task.priorityLevel == 1 ? 'selected': ''}>1</option>
                        <option value="2" ${task.priorityLevel == 2 ? 'selected': ''}>2</option>
                        <option value="3" ${task.priorityLevel == 3 ? 'selected': ''}>3</option>
                        <option value="4" ${task.priorityLevel == 4 ? 'selected': ''}>4</option>
                        <option value="5" ${task.priorityLevel == 5 ? 'selected': ''}>5</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="statusIndex">Status:</label>
                    <select id="statusIndex" name="statusIndex" disabled>
                        <option value="">Selecione...</option>
                        <option value="0" ${task.statusIndex == 0 ? 'selected': ''}>A fazer</option>
                        <option value="1" ${task.statusIndex == 1 ? 'selected': ''}>Fazendo</option>
                        <option value="2" ${task.statusIndex == 2 ? 'selected': ''}>Feito</option>
                    </select>
                </div>
                <button type="button" id="create-task-button" class="hidden" disabled>Criar tarefa</button>
                <button type="button" id="back-button">Voltar</button>
            </form>
        `
    }

    static editTaskForm(task) {
        return `
            <form id="edit-task-form" data-task-id="${task.id}">
                <div class="form-group">
                    <label for="name">Nome:</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value="${task.name}"
                    />
                </div>

                <div class="form-group">
                    <label for="category">Categoria:</label>
                    <input
                        type="text"
                        id="category"
                        name="category"
                        value="${task.category}"
                    />
                </div>

                <div class="form-group">
                    <label for="description">Descrição:</label>
                    <textarea id="description" name="description" rows="3">${task.description}</textarea>
                </div>

                <div class="form-group">
                    <label for="priorityLevel">Prioridade:</label>
                    <select id="priorityLevel" name="priorityLevel">
                        <option value="">Selecione...</option>
                        <option value="1" ${task.priorityLevel == 1 ? 'selected': ''}>1</option>
                        <option value="2" ${task.priorityLevel == 2 ? 'selected': ''}>2</option>
                        <option value="3" ${task.priorityLevel == 3 ? 'selected': ''}>3</option>
                        <option value="4" ${task.priorityLevel == 4 ? 'selected': ''}>4</option>
                        <option value="5" ${task.priorityLevel == 5 ? 'selected': ''}>5</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="statusIndex">Status:</label>
                    <select id="statusIndex" name="statusIndex">
                        <option value="">Selecione...</option>
                        <option value="0" ${task.statusIndex == 0 ? 'selected': ''}>A fazer</option>
                        <option value="1" ${task.statusIndex == 1 ? 'selected': ''}>Fazendo</option>
                        <option value="2" ${task.statusIndex == 2 ? 'selected': ''}>Feito</option>
                    </select>
                </div>
                <button type="button" id="edit-task-button">Editar tarefa</button>
                <button type="button" id="back-button">Voltar</button>
            </form>
        `
    }
}

export default CRUDTaskComponent
