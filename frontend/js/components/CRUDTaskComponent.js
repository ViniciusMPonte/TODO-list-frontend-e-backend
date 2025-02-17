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

                <button type="button" id="createTaskButton">Criar tarefa</button>
            </form>        
        `
    }


}

export default CRUDTaskComponent;