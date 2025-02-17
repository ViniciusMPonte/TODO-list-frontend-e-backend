import DOMHelper from './helpers/DOMHelper.js'
import TaskComponent from './components/TaskComponent.js'
import TasksViewManager from './services/TasksViewManager.js'
import mockTasks from './mocks/mockTasks.js'


TasksViewManager.renderTasks(mockTasks, TaskComponent.createTaskCard, DOMHelper.addElement)