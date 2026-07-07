package plutoproject.adventurekt.text.style

import net.kyori.adventure.audience.Audience
import plutoproject.adventurekt.text.ComponentKt
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickCallback
import net.kyori.adventure.text.event.ClickEvent
import java.net.URL

fun clickEvent(): WithoutStyle {
    return ClickEventWithoutStyle
}

fun openUrl(url: String): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.openUrl(url)) }
}

fun openUrl(url: URL): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.openUrl(url)) }
}

fun openFile(path: String): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.openFile(path)) }
}

fun runCommand(command: String): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.runCommand(command)) }
}

fun suggestCommand(command: String): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.suggestCommand(command)) }
}

fun changePage(page: Int): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.changePage(page)) }
}

fun changePage(page: String): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.changePage(page.toInt())) }
}

fun copyToClipboard(text: String): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.copyToClipboard(text)) }
}

fun callback(callback: (Audience) -> Unit): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.callback(callback)) }
}

fun callback(options: ClickCallback.Options, callback: (Audience) -> Unit): WithStyle {
    return ClickEventWithStyle { it.clickEvent(ClickEvent.callback(callback, options)) }
}

internal class ClickEventWithStyle(val apply: (Component) -> Component) : WithStyle {
    override fun with(
        holder: ComponentKt,
        original: Component
    ): Component {
        return apply(original)
    }
}

internal object ClickEventWithoutStyle : WithoutStyle {

    override fun without(
        holder: ComponentKt,
        original: Component
    ): Component {
        return original.clickEvent(null)
    }

}
