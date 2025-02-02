package ink.nostal.advkt

import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

fun test() {
    val text = component {
        defaults {
            with(rgb(1, 2, 3))
            with(italic())
        }

        provide(
            MiniMessage.builder()
                .strict(true)
                .build()
        )

        text("Hello world") with showText {
            text("Hover")
        } with hex("66ccff")
        newline()

        text("With color red!") with rgb(123, 144, 133) with bold() without italic()
        newline()

        text("Click me!") with callback {
            it.send {
                text("You just click a text!")
            }
        }

        empty() // this can do nothing, but I added it lol

        translatable("minecraft.enchantment.protection") // should be "Protection" under English (US)
        space()
        miniMessage("<gray>MiniMessage!</gray>")
        space()
        keybind("key.keyboard.space") // should be "空格" under Simplified Chinese

        component {
            provide {
                strict(false)
                tags(TagResolver.standard())
            }

            text("You can even 套娃 in the component")
        }
    }
}