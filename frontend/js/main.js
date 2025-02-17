import DOMHelper from './helpers/DOMHelper.js'
import TaskComponent from './components/TaskComponent.js'
import ColumnTasksComponent from './components/ColumnTasksComponent.js'
import CRUDTaskComponent from './components/CRUDTaskComponent.js'
import TasksViewManager from './services/TasksViewManager.js'
import mockTasks from './mocks/mockTasks.js'
import Task from './entities/Task.js'
import NavigationController from './navigation/NavigationController.js'

let navigationController = new NavigationController({
    injectElement: DOMHelper.addElement,
    task: Task.createNewTask,
    renderTasks: TasksViewManager.renderTasks,
    columnTasksComponent: ColumnTasksComponent.createColumnTasks,
    taskComponent: TaskComponent.createTaskCard,
    createTaskFormComponent: CRUDTaskComponent.createTaskForm,
    tasksList: mockTasks,
})

navigationController.loadMain()
navigationController.loadCreateForm()
