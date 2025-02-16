import DOMHelper from './helpers/DOMHelper.js'
import Task from './components/Task.js'


DOMHelper.addElement(
    '#todo-tasks',
    Task.createTaskElement({ title: 'Exemplo de Tarefa', category: 'Trabalho' })
)
DOMHelper.addElement(
    '#doing-tasks',
    Task.createTaskElement({ title: 'Exemplo de Tarefa', category: 'Trabalho' })
)
DOMHelper.addElement(
    '#done-tasks',
    Task.createTaskElement({ title: 'Exemplo de Tarefa', category: 'Trabalho' })
)
