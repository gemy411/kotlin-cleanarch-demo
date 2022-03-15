import kotlinx.coroutines.delay
import pokemoncreator.frameworksNdrivers.ui.UIComponent

suspend fun main() {
    val component = UIComponent()
    while(!component.workIsDone) {
        delay(1000L)
    }
}