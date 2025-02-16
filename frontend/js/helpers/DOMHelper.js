export default class DOMHelper {
    static addElement(selector, htmlString) {
        const container = document.querySelector(selector)
        if (!container) {
            console.error(`Element with selector "${selector}" not found.`)
            return
        }
        container.insertAdjacentHTML('beforeend', htmlString)
    }
}
